package museum.controller.admin;
import museum.entity.News;
import museum.entity.Page;
import museum.service.NewsService;
import museum.util.PathUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/news")
public class AdminNewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/list")
    public String findList(String p, String size, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<News> NewsList;
        Page pp = newsService.findPageDataOne(Integer.parseInt(p), Integer.parseInt(size));
        NewsList = pp.getList();
        req.setAttribute("page", pp.getP());
        req.setAttribute("maxPage", pp.getMaxPage());
        req.setAttribute("list", NewsList);
        return "admin/news";
    }

//    @RequestMapping("/findBy")
//    public String findBy(String page, String size, String newsId, String newstime, String newstitle, HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        resp.setCharacterEncoding("utf-8");
//        req.setCharacterEncoding("utf-8");
//        int p = Integer.parseInt(page);
//        int s = Integer.parseInt(size);
//        if (newsId == null) {
//            newsId = "default";
//        }
//        if (newstime == null) {
//            newstime = "default";
//        }
//        if (newstitle == null) {
//            newstitle = "default";
//        }
//        List<News> SearchList = newsService.findBy(newstitle, newstime, newsId);
//        int countList = SearchList.size();
//        int maxPage = (int) Math.ceil((countList * 1.0 / s));
//        if (p > maxPage) p = maxPage;
//        if (p < 1) p = 1;
//        int startIndext = 0;
//        int stopIndext = 0;
//        startIndext = (p - 1) * s;
//        if ((startIndext + 5) > countList) {
//            stopIndext = countList;
//        } else {
//
//            stopIndext = startIndext + 5;
//        }
//        req.setAttribute("page", p);
//        req.setAttribute("maxPage", maxPage);
//        req.setAttribute("newsId", newsId);
//        req.setAttribute("newstime", newstime);
//        req.setAttribute("newstitle", newstitle);
//        req.setAttribute("SearchList", SearchList.subList(startIndext, stopIndext));
//        return "admin/News/NewsSearch";
//    }

    @RequestMapping("/findById")
    public String findById(Integer NewsId, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        News news = newsService.find(NewsId);
        req.setAttribute("news", news);
        return "admin/newsUpdate";
    }

    @RequestMapping("/up")
    public String up(Integer id, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        News news = newsService.find(id);
        String nImage = null;
        // 获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 获取文件需要上传到的路径
        String path = PathUtil.getImgBasePath()+"\\imagecut"+"\\newspictures";
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
                    nImage = "\\imagecut\\newspictures\\" + filename;//创建新的数据库头像名字

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
        news.setNewsImage(nImage);
        newsService.update(news);
        return "redirect:/manage/count";
    }

    @RequestMapping("/save")
    public String save(News news, HttpServletRequest req) {
        newsService.save(news);
        News ne =newsService.find().get(newsService.find().size()-1);
        req.setAttribute("ne", ne);
        return "admin/newsUp";
    }

    @RequestMapping("/saveNews")
    public String saveNews(News news, HttpServletRequest req)  {
        return "admin/saveNews";
    }

    @RequestMapping("/update")
    public String update(News news) {
        newsService.update(news);
        return "redirect:/manage/count";
    }

    @RequestMapping("/delete")
    public String delete(int[] id) {
        for (int i : id) {
            newsService.delete(i);

        }
        return "redirect:/manage/count";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor cust = new CustomDateEditor(sdf, true);
        bin.registerCustomEditor(Date.class, cust);
    }
}


