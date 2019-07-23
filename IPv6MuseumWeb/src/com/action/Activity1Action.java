package com.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.museum.domain.Activity;
import com.museum.domain.ActivityType;
import com.museum.domain.Exhibits;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.domain.User;
import com.museum.domain.pageList;
import com.service.IActivityService1;
import com.service.INewsService1;
import com.service.IUserService1;



@Controller
@RequestMapping("/Activity")//url映射到类
public class Activity1Action {
	@Autowired
	private IActivityService1 service;//自动注入Service层
	@RequestMapping("/list")//url映射到方法
	public String findList(String p,String size,HttpServletRequest req,String type,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		if("1".equals(type)){
			List<Activity> ActivityList;
			Page pp=service.findPageData(Integer.parseInt(p),Integer.parseInt(size),type);//获取分页page
			ActivityList=pp.getList();
			req.setAttribute("type",type);
			req.setAttribute("page",pp.getP());
			req.setAttribute("maxPage",pp.getMaxPage());
			req.setAttribute("list", ActivityList);
			return "admin/Activity/Activity";	//根据配置文件拼接.jsp跳转
		}else{
			List<Activity> ActivityList;
			Page pp=service.findPageData(Integer.parseInt(p),Integer.parseInt(size),type);
			ActivityList=pp.getList();
			req.setAttribute("type",type);
			req.setAttribute("page",pp.getP());
			req.setAttribute("maxPage",pp.getMaxPage());
			req.setAttribute("list", ActivityList);
			return "admin/Lecture/Lecture";	
		}
		
	}
	@RequestMapping("/findBy")
	public String findBy(String page,String size,String type,String activitytitle,String activitytime,String activityId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		int p=Integer.parseInt(page);
		int s=Integer.parseInt(size);
		if(activityId==null){
			activityId="default";
		}
		if(activitytime==null){
			activitytime="default";
		}
		if(activitytitle==null){
			activitytitle="default";
		}
		List<Activity> SearchList=service.findBy(activitytitle, activitytime, activityId,type);
		int countList=SearchList.size();
		int maxPage=(int) Math.ceil((countList*1.0/s)); //按条件
		if(p>maxPage) p=maxPage;             			//查询的
		if(p<1)p=1;										//结果
		int startIndext = 0;							//进行
        int stopIndext = 0;								//分页
        startIndext=(p-1)*s;							//操作	
        if((startIndext+5)>countList){					//
        	stopIndext=countList;						//
        }else{
        	
        	stopIndext=startIndext+5;					//
        }
    	req.setAttribute("page", p);
    	req.setAttribute("maxPage", maxPage);
    	req.setAttribute("activitytitle", activitytitle);
    	req.setAttribute("activitytime", activitytime);
    	req.setAttribute("activityId", activityId);
		req.setAttribute("SearchList", SearchList.subList(startIndext, stopIndext));
		
		if("1".equals(type)){
			return "admin/Activity/ActivitySearch";
		}else{
			
			return "admin/Lecture/LectureSearch";
		}
	}
	@RequestMapping("/findById")
	public String findById(Integer activityId,String type,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		Activity activity=service.find(activityId);
		req.setAttribute("activity", activity);
		if("1".equals(type)){
			return "admin/Activity/ActivityUpdate";
		}else{
			
			return "admin/Lecture/LectureUpdate";
		}
			
	}
	@RequestMapping("/top")
	public String top(Integer activityId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		Activity activity=service.find(activityId);
		if(activity.getActivityTop()==0){
		activity.setActivityTop(1);
		}else{
			activity.setActivityTop(0);
		}
		service.update(activity);
		return "redirect:/Activity/list.do?p=1&size=5&type=1";

			
	}
	
	@RequestMapping("/save")
	public String save(Activity activity,String type,HttpServletRequest req,HttpServletResponse resp){
		ActivityType at=new ActivityType();
		if("1".equals(type)){
			at.setActivityTypeId(1);
			at.setActivityTypeName("展厅活动");
			activity.setActivityType(at);
			
			activity.setActivityTop(0);
			
			service.save(activity);
			
		}else{
			at.setActivityTypeId(2);
			at.setActivityTypeName("专题讲座");
			activity.setActivityType(at);
			service.save(activity);
		}
		Activity a=service.find().get(service.find().size()-1);
		req.setAttribute("activity", a);
		return "admin/Activity/up";
	}
	@RequestMapping("/update")
	public String update(Activity activity,String type){
		ActivityType at=new ActivityType();
		if("1".equals(type)){
			at.setActivityTypeId(1);
			at.setActivityTypeName("展厅活动");
			activity.setActivityType(at);
			
			activity.setActivityTop(0);
			
			service.update(activity);
			return "redirect:/Exhibits/count.do";
		}else{
			at.setActivityTypeId(2);
			at.setActivityTypeName("专题讲座");
			activity.setActivityType(at);
			service.update(activity);
			return "redirect:/Exhibits/count.do";
		}
		
	}
	
	@RequestMapping("/up")
	public String up(String aId,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println(aId);
		Integer ai=Integer.valueOf(aId);
		Activity ac=service.find(ai);
		String nImage = null;
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		String path = req.getRealPath("/images");
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
					nImage = "\\mymuseum\\images\\"+filename;//创建新的数据库头像名字
					
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
		ac.setActivityImage(nImage);
		service.update(ac);			
		return "redirect:/Exhibits/count.do";   //根据页面返回选中的项进行批量删除操作
	}
	
	
	@RequestMapping("/delete")
	public String delete(int[] id){
		for(int i:id){
			System.out.println(i);
		service.delete(i);
		}						
		return "redirect:/Exhibits/count.do";   //根据页面返回选中的项进行批量删除操作
	}
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin){
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	         CustomDateEditor cust = new CustomDateEditor(sdf,true);
	         bin.registerCustomEditor(Date.class,cust);
	}//对Date类型进行格式化
}
