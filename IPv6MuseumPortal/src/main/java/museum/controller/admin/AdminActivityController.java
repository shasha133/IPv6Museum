package museum.controller.admin;

import museum.entity.Activity;
import museum.entity.ActivityType;
import museum.entity.News;
import museum.entity.Page;
import museum.service.ActivityService;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/Activity")//url映射到类
public class AdminActivityController {

    @Autowired
    private ActivityService activityService;//自动注入Service层

    @RequestMapping("/list")//url映射到方法
    public String findList(String p, String size, HttpServletRequest req, String type, HttpServletResponse resp) throws Exception {
        if ("1".equals(type)) {
            List<Activity> ActivityList;
            Page pp = activityService.findPageDataOne(Integer.parseInt(p), Integer.parseInt(size), type);//获取分页page
            ActivityList = pp.getList();
            req.setAttribute("type", type);
            req.setAttribute("page", pp.getP());
            req.setAttribute("maxPage", pp.getMaxPage());
            req.setAttribute("list", ActivityList);
            return "admin/Activity";    //根据配置文件拼接.jsp跳转
        } else {
            List<Activity> ActivityList;
            Page pp = activityService.findPageDataOne(Integer.parseInt(p), Integer.parseInt(size), type);
            ActivityList = pp.getList();
            req.setAttribute("type", type);
            req.setAttribute("page", pp.getP());
            req.setAttribute("maxPage", pp.getMaxPage());
            req.setAttribute("list", ActivityList);
            return "admin/Lecture";
        }

    }

    @RequestMapping("/top")
    public String top(Integer activityId,HttpServletRequest req,HttpServletResponse resp){
        Activity activity=activityService.find(activityId);
        ActivityType at=new ActivityType();
        at.setActivityTypeId(activity.getActivityTypeId());
        at.setActivityTypeName(activity.getActivityTitle());
        if("1".equals(activity.getActivityTop())){
            activity.setActivityTop(0);
        }else{
            activity.setActivityTop(1);
        }
        activity.setActivityType(at);
        activityService.update(activity);
        return "redirect:/Activity/list?p=1&size=5&type=1";
    }

    @RequestMapping("/findById")
    public String findById(Integer activityId,String type,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        Activity activity=activityService.find(activityId);
        req.setAttribute("activity", activity);
        if("1".equals(type)){
            return "admin/ActivityUpdate";
        }else{
            return "admin/LectureUpdate";
        }

    }

    @RequestMapping("/update")
    public String update(Activity activity,String type){
        ActivityType at=new ActivityType();
        if("1".equals(type)){
            at.setActivityTypeId(1);
            at.setActivityTypeName("展厅活动");
            activity.setActivityType(at);
            activityService.update(activity);
            return "redirect:/manage/count";
        }else{
            at.setActivityTypeId(2);
            at.setActivityTypeName("专题讲座");
            activity.setActivityType(at);
            activityService.update(activity);
            return "redirect:/manage/count";
        }
    }

    @RequestMapping("/save")
    public String save(Activity activity,String type,HttpServletRequest req,HttpServletResponse resp){
        ActivityType at=new ActivityType();
        if("1".equals(type)){
            at.setActivityTypeId(1);
            at.setActivityTypeName("展厅活动");
            activity.setActivityType(at);
            activityService.save(activity);
        }else{
            at.setActivityTypeId(2);
            at.setActivityTypeName("专题讲座");
            activity.setActivityType(at);
            activityService.save(activity);
        }
        Activity activityNew=activityService.findAll().get(activityService.findAll().size()-1);
        req.setAttribute("activityNew",activityNew);

        return "/admin/ActivityUp";
    }

    @RequestMapping("/saveActivity")
    public String saveActivity(Activity activity,String type,HttpServletRequest req,HttpServletResponse resp){
        return "/admin/saveActivity";
    }

    @RequestMapping("/delete")
    public String delete(int[] id){
        for(int i:id){
            activityService.delete(i);
        }
        return "/admin/saveActivity";   //根据页面返回选中的项进行批量删除操作
    }

    @RequestMapping("/ReleaseActivity")
    public String ReleaseActivity(){
        return "/admin/ReleaseActivity";   //根据页面返回选中的项进行批量删除操作
    }

    @RequestMapping("/up")
    public String up(Integer id, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Activity activity = activityService.find(id);
        String nImage = null;
        // 获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 获取文件需要上传到的路径
        String path = PathUtil.getImgBasePath()+"\\imagecut"+"\\activity";
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
                    nImage = "\\imagecut\\activity\\" + filename;//创建新的数据库头像名字

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
        activity.setActivityImage(nImage);
        activityService.updateImage(activity);
        return "redirect:/manage/count";
    }
}
