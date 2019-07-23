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
@RequestMapping("/Activity")//urlӳ�䵽��
public class Activity1Action {
	@Autowired
	private IActivityService1 service;//�Զ�ע��Service��
	@RequestMapping("/list")//urlӳ�䵽����
	public String findList(String p,String size,HttpServletRequest req,String type,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		if("1".equals(type)){
			List<Activity> ActivityList;
			Page pp=service.findPageData(Integer.parseInt(p),Integer.parseInt(size),type);//��ȡ��ҳpage
			ActivityList=pp.getList();
			req.setAttribute("type",type);
			req.setAttribute("page",pp.getP());
			req.setAttribute("maxPage",pp.getMaxPage());
			req.setAttribute("list", ActivityList);
			return "admin/Activity/Activity";	//���������ļ�ƴ��.jsp��ת
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
		int maxPage=(int) Math.ceil((countList*1.0/s)); //������
		if(p>maxPage) p=maxPage;             			//��ѯ��
		if(p<1)p=1;										//���
		int startIndext = 0;							//����
        int stopIndext = 0;								//��ҳ
        startIndext=(p-1)*s;							//����	
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
			at.setActivityTypeName("չ���");
			activity.setActivityType(at);
			
			activity.setActivityTop(0);
			
			service.save(activity);
			
		}else{
			at.setActivityTypeId(2);
			at.setActivityTypeName("ר�⽲��");
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
			at.setActivityTypeName("չ���");
			activity.setActivityType(at);
			
			activity.setActivityTop(0);
			
			service.update(activity);
			return "redirect:/Exhibits/count.do";
		}else{
			at.setActivityTypeId(2);
			at.setActivityTypeName("ר�⽲��");
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
		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		String path = req.getRealPath("/images");
		factory.setRepository(new File(path));
		// ���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
		factory.setSizeThreshold(1024 * 1024);
		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = (List<FileItem>) upload.parseRequest(req);
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();
				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {
					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
					String value = item.getString();
					req.setAttribute(name, value);
				} else {// �Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ
					/**
					 * ������������Ҫ��ȡ �ϴ��ļ�������
					 */
					// ��ȡ·����
					String value = item.getName();
					// ���������һ����б��
					int start = value.lastIndexOf("\\");
					// ��ȡ �ϴ��ļ��� �ַ������֣���1�� ȥ����б�ܣ�
					String filename = value.substring(start + 1);
					nImage = "\\mymuseum\\images\\"+filename;//�����µ����ݿ�ͷ������
					
					OutputStream out = new FileOutputStream(new File(path,
							filename));
					InputStream in = item.getInputStream();
					int length = 0;
					byte[] buf = new byte[1024];
					System.out.println("��ȡ�ϴ��ļ����ܹ���������" + item.getSize());
					// in.read(buf) ÿ�ζ��������ݴ���� buf ������
					while ((length = in.read(buf)) != -1) {
						// �� buf ������ ȡ������ д�� ���������������
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
		return "redirect:/Exhibits/count.do";   //����ҳ�淵��ѡ�е����������ɾ������
	}
	
	
	@RequestMapping("/delete")
	public String delete(int[] id){
		for(int i:id){
			System.out.println(i);
		service.delete(i);
		}						
		return "redirect:/Exhibits/count.do";   //����ҳ�淵��ѡ�е����������ɾ������
	}
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin){
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	         CustomDateEditor cust = new CustomDateEditor(sdf,true);
	         bin.registerCustomEditor(Date.class,cust);
	}//��Date���ͽ��и�ʽ��
}
