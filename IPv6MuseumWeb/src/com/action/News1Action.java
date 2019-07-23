package com.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.News;
import com.museum.domain.Page;
import com.service.INewsService1;
import com.service.IUserService1;



@Controller
@RequestMapping("/news")
public class News1Action {
	@Autowired
	private INewsService1 service;
	@RequestMapping("/list")
	public String findList(String p,String size,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		List<News> NewsList;
		Page pp=service.findPageData(Integer.parseInt(p),Integer.parseInt(size));
		NewsList=pp.getList();
		req.setAttribute("page",pp.getP());
		req.setAttribute("maxPage",pp.getMaxPage());
		req.setAttribute("list", NewsList);
		return "admin/News/news";
	}
	@RequestMapping("/findBy")
	public String findBy(String page,String size,String newsId,String newstime,String newstitle,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		int p=Integer.parseInt(page);
		int s=Integer.parseInt(size);
		if(newsId==null){
			newsId="default";
		}
		if(newstime==null){
			newstime="default";
		}
		if(newstitle==null){
			newstitle="default";
		}
		List<News> SearchList=service.findBy(newstitle, newstime, newsId);
		int countList=SearchList.size();
		int maxPage=(int) Math.ceil((countList*1.0/s));
		if(p>maxPage) p=maxPage;
		if(p<1)p=1;
		int startIndext = 0;
        int stopIndext = 0;
        startIndext=(p-1)*s;
        if((startIndext+5)>countList){
        	stopIndext=countList;
        }else{
        	
        	stopIndext=startIndext+5;
        }
        req.setAttribute("page", p);
    	req.setAttribute("maxPage", maxPage);
        req.setAttribute("newsId", newsId);
    	req.setAttribute("newstime", newstime);
    	req.setAttribute("newstitle", newstitle);
		req.setAttribute("SearchList", SearchList.subList(startIndext, stopIndext));
		return "admin/News/NewsSearch";
	}
	@RequestMapping("/findById")
	public String findById(Integer NewsId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		News news=service.find(NewsId);
		req.setAttribute("news", news);
		System.out.println(news.toString());
		return "admin/News/NewsUpdate";
	}
	
	@RequestMapping("/up")
	public String up(Integer id,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		News news=service.find(id);
		
		String nImage = null;
		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		String path = req.getRealPath("/images/����ͼƬ");
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
					nImage = "\\mymuseum\\images\\����ͼƬ\\"+filename;//�����µ����ݿ�ͷ������
					
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
		news.setNewsImage(nImage);
		service.update(news);
		return "redirect:/Exhibits/count.do";
	}
	
	@RequestMapping("/save")
	public String save(News news,HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		service.save(news);
		News ne=service.find(service.find().size()-1);
		req.setAttribute("news", ne);
		return "admin/News/up";
	}
	@RequestMapping("/update")
	public String update(News news){
		service.update(news);
		return "redirect:/Exhibits/count.do";
	}
	@RequestMapping("/delete")
	public String delete(int[] id){
		for(int i:id){
			service.delete(i);
			
		}
		return "redirect:/Exhibits/count.do";
	}
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin){
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	         CustomDateEditor cust = new CustomDateEditor(sdf,true);
	         bin.registerCustomEditor(Date.class,cust);
	}
}
