package museum.controller;

import museum.entity.User;
import museum.service.UserService;
import museum.util.PathUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private UserService userService;

    @RequestMapping("/information")
    public String show(HttpServletRequest req) throws IOException {
        return "information";
    }

    @RequestMapping("/personInformation")
    public String find(HttpServletRequest req) throws IOException{
        String User_Id = (String)req.getSession().getAttribute("User_Id");//这个action的str暂且为User_Id
        User user = userService.find(User_Id);
        req.setAttribute("user", user);
        return "personInformation";
    }

    @RequestMapping("/changeImage")
    public String find2(HttpServletRequest req, String uid, HttpServletResponse response) {
        User user = userService.find((String) req.getSession().getAttribute("User_Id"));
        String nImage = null;
        // 获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 获取文件需要上传到的路径
        String path = PathUtil.getImgBasePath()+"\\imagecut"+"\\person";
        factory.setRepository(new File(path));
        // 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
        factory.setSizeThreshold(1024 * 1024);
        // 高水平的API文件上传处理
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            // 可以上传多个文件
            List<FileItem> list = (List<FileItem>) upload.parseRequest(req);
            for (FileItem item : list) {
                // 获取表单的属性名字
                String name = item.getFieldName();
                // 如果获取的 表单信息是普通的 文本 信息
                if (item.isFormField()) {
                    // 获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
                    String value = item.getString();
                    req.setAttribute(name, value);
                } else {// 对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
                    /**
                     * 以下三步，主要获取 上传文件的名字
                     */
                    // 获取路径名
                    String value = item.getName();
                    // 索引到最后一个反斜杠
                    int start = value.lastIndexOf("\\");
                    // 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
                    String filename = value.substring(start + 1);
                    nImage = "\\imagecut\\person\\"+filename;//创建新的数据库头像名字

                    OutputStream out = new FileOutputStream(new File(path,
                            filename));
                    InputStream in = item.getInputStream();
                    int length = 0;
                    byte[] buf = new byte[1024];
                    System.out.println("获取上传文件的总共的容量：" + item.getSize());
                    // in.read(buf) 每次读到的数据存放在 buf 数组中
                    while ((length = in.read(buf)) != -1) {
                        // 在 buf 数组中 取出数据 写到 （输出流）磁盘上
                        out.write(buf, 0, length);
                    }
                    in.close();
                    out.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setUserImage(nImage);
        userService.update(user);
        req.getSession().setAttribute("User_image", user.getUserImage());
        return "information";
    }

}
