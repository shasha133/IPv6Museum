package museum.controller;

import museum.util.PathUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/image")
public class ImageController {
    //点击图片获得到原图
    @RequestMapping(value = "showImg")
    public void ShowImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String imgFile = request.getParameter("path");
        imgFile = imgFile.replace("*", "\\");//文件名
        String path = PathUtil.getImgBasePath();//这里是存放图片的文件夹地址
        /* 插入图片信息 */
        FileInputStream fileIs = null;
        try {
            fileIs = new FileInputStream(path + imgFile);
        } catch (Exception e) {
            return;
        }
        int i = fileIs.available(); //得到文件大小
        byte data[] = new byte[i];
        fileIs.read(data);  //读数据
        response.setContentType("image/*"); //设置返回的文件类型
        OutputStream outStream = response.getOutputStream(); //得到向客户端输出二进制数据的对象
        outStream.write(data);  //输出数据
        outStream.flush();
        outStream.close();
        fileIs.close();
    }
    

    /**
     * 返回斜杠拼接的字符串
     *
     * @param args
     * @return
     */
    public static String mergeStringWithSeparator(String... args) {
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg);
            sb.append(File.separator);
        }

        return sb.substring(0, sb.length() - 1).toString();
    }
}
