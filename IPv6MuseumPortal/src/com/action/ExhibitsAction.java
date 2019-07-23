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
import java.util.Iterator;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.museum.domain.Activity;
import com.museum.domain.ActivityType;
import com.museum.domain.Apply;
import com.museum.domain.Collect;
import com.museum.domain.Comment;
import com.museum.domain.Dynasty;
import com.museum.domain.Exhibits;
import com.museum.domain.Hall;
import com.museum.domain.Material;
import com.museum.domain.Nation;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.domain.Record;
import com.museum.domain.Religion;
import com.museum.domain.Reply;
import com.museum.domain.State;
import com.museum.domain.User;
import com.museum.domain.Value;
import com.museum.domain.pageList;
import com.service.IActivityService1;
import com.service.ICollectService1;
import com.service.ICommentService;
import com.service.IExhibitsService1;
import com.service.INewsService1;
import com.service.IRecordService;
import com.service.IUserService1;
import com.service.impl.ExhibitsService1Impl;




@Controller
@RequestMapping("/Exhibits")
public class ExhibitsAction {
	@Autowired
	private IExhibitsService1 service;
	@Autowired
	private IUserService1 userservice;
	@Autowired
	private IRecordService recordservice;
	@Autowired
	private INewsService1 newservice;
	@Autowired
	private IActivityService1 activityservice;
	@Autowired
	private ICollectService1 collectservice;
	@Autowired
	private ICommentService commentservice;
	
	
	@RequestMapping("/list")
	public String findList(String p,String size,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");

			List<Exhibits> ExhibitsList;
			Page pp=service.findPageData(Integer.parseInt(p),Integer.parseInt(size));
			ExhibitsList=pp.getList();
			List<Apply> aL=service.findA();
			List<Dynasty> dL=service.findD();
			List<Material> mL=service.findM();
			List<Value> vL=service.findV();
			req.setAttribute("aL", aL);
			req.setAttribute("dL", dL);
			req.setAttribute("mL", mL);
			req.setAttribute("vL", vL);
			req.setAttribute("page",pp.getP());
			req.setAttribute("maxPage",pp.getMaxPage());
			req.setAttribute("list", ExhibitsList);
			return "admin/Exhibits/exhibits";	
		
	}
	@RequestMapping("/findBy")
	public String findBy(String page,String size,String Material,String Dynasty,String Apply,String Value,String exhibitsName,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		int p=Integer.parseInt(page);
		int s=Integer.parseInt(size);
		List<Apply> aL=service.findA();
		List<Dynasty> dL=service.findD();
		List<Material> mL=service.findM();
		List<Value> vL=service.findV();
		req.setAttribute("aL", aL);
		req.setAttribute("dL", dL);
		req.setAttribute("mL", mL);
		req.setAttribute("vL", vL);
		if(exhibitsName==null){
			exhibitsName="default";
		}
	
		List<Exhibits> SearchList=service.findBy(Material,Dynasty,Apply,Value,exhibitsName);
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
    	req.setAttribute("Material", Material);
    	req.setAttribute("Dynasty", Dynasty);
    	req.setAttribute("Apply", Apply);
    	req.setAttribute("Value", Value);
    	req.setAttribute("exhibitsName", exhibitsName);
		req.setAttribute("SearchList", SearchList.subList(startIndext, stopIndext));
		
			return "admin/Exhibits/Search";
	}
	@RequestMapping("/findById")
	public String findById(Integer exhibitsId,String type,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");

	    Exhibits exhibits=service.find(exhibitsId);
	 
	    List<Apply> aL=service.findA();
		List<Dynasty> dL=service.findD();
		List<Material> mL=service.findM();
		List<Value> vL=service.findV();
		req.setAttribute("aL", aL);
		req.setAttribute("dL", dL);
		req.setAttribute("mL", mL);
		req.setAttribute("vL", vL);
		List<Religion> rL=service.findR();
		List<Hall> hL=service.findH();
		List<State> sL=service.findS();
		List<Nation> nL=service.findN();
			req.setAttribute("rL", rL);
			req.setAttribute("hL", hL);
			req.setAttribute("sL", sL);
			req.setAttribute("nL", nL);
		req.setAttribute("exhibits", exhibits);
			if(type.equals("1")){
				return "admin/Exhibits/ExhibitsInfo";	
			}else{
				return "admin/Exhibits/Exhibitsupdate";
	
			}
	}
	@RequestMapping("/save")
	public String save(Integer materialId,Integer dynastyId,Integer applyId,Integer valueId
			,Integer religionId,Integer stateId,Integer nationId,Integer hallId,Exhibits exhibits,HttpServletRequest req,HttpServletResponse resp) throws Exception{ 
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		exhibits.setApply(service.finda(applyId));
		exhibits.setDynasty(service.findd(dynastyId));
		exhibits.setValue(service.findv(valueId));
		exhibits.setMaterial(service.finm(materialId));
		exhibits.setReligion(service.findr(religionId));
		exhibits.setState(service.finds(stateId));
		exhibits.setNation(service.findn(nationId));
		exhibits.setHall(service.findh(hallId)); 
		service.save(exhibits);
		req.setAttribute("exhibits", exhibits);
		return "admin/Exhibits/up";
	}
	@RequestMapping("/update")
	public String update(int materialId,int dynastyId,int applyId,int valueId
			,int religionId,int stateId,int nationId,int hallId,Exhibits exhibits){	
			exhibits.setApply(service.finda(applyId));
			exhibits.setDynasty(service.findd(dynastyId));
			exhibits.setValue(service.findv(valueId));
			exhibits.setMaterial(service.finm(materialId));
			exhibits.setReligion(service.findr(religionId));
			exhibits.setState(service.finds(stateId));
			exhibits.setNation(service.findn(nationId));
			exhibits.setHall(service.findh(hallId));
			service.update(exhibits);
			return "redirect:/Exhibits/count.do";	
	}
	
	@RequestMapping("/up")
	public String up(String id,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Integer  eid=Integer.valueOf(id);
		Exhibits ex=service.find(eid);
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
		System.out.println(nImage);
		ex.setExhibitsImagecut(nImage);
		ex.setExhibitsImagefull(nImage);
		service.update(ex);
		return "redirect:/Exhibits/count.do";
	}
	
	@RequestMapping("/delete")
	public String delete(int[] id){
		for(int i:id){
			System.out.println(i);
		service.delete(i);
		}
		return "redirect:/Exhibits/count.do";
	}
	@RequestMapping("/saveinfo")
	public String saveinfo(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
	    List<Apply> aL=service.findA();
		List<Dynasty> dL=service.findD();
		List<Material> mL=service.findM();
		List<Value> vL=service.findV();
		req.setAttribute("aL", aL);
		req.setAttribute("dL", dL);
		req.setAttribute("mL", mL);
		req.setAttribute("vL", vL);
		List<Religion> rL=service.findR();
		List<Hall> hL=service.findH();
		List<State> sL=service.findS();
		List<Nation> nL=service.findN();
		req.setAttribute("rL", rL);
		req.setAttribute("hL", hL);
		req.setAttribute("sL", sL);
		req.setAttribute("nL", nL);
		return "admin/Exhibits/ExhibitsSave";
	}
	@RequestMapping("/hall")
	public String hall(String page,String size,int hallId,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		int p=Integer.parseInt(page);
		int s=Integer.parseInt(size);
		
		
		List<Hall> hL=service.findH();
		req.setAttribute("hL", hL);
		List<Exhibits> eL=service.find();
		Iterator<Exhibits> it = eL.iterator();
		while(it.hasNext()){
		    Exhibits x = it.next();
		    if(x.getHall().getHallId()!=hallId){
		        it.remove();
		    }
		}
		int countList=eL.size();
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
    	req.setAttribute("hallId", hallId);

		req.setAttribute("eL", eL);
		return "admin/Exhibits/HallExhibits";
	}
	
	@RequestMapping("/count")
	public String count(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
			List<Exhibits> eL=service.find();
			List<Collect> cL=collectservice.find();
			List<Comment> coL=commentservice.find();
			List<User> uL=userservice.find();
			List<News> nL=newservice.find();
			List<Record> recL=recordservice.find();
			List<Activity> aL=activityservice.find();
			List<Reply>	repL=commentservice.findR();
			int e,e1 = 0,e2 = 0,e3 = 0,e4=0,e5=0,e6=0;//展品 1,2,3展廳 
			int u,uc = 0,urc = 0;//用戶 普通用戶  管理員
			int ac,nc;//活動  新聞
			int l1 = 0,l2 = 0,l3 = 0;//1,2,3級文物
			int m1 = 0,m2 = 0;//可移動 不可移動
			int Cc,Rc;//收藏 瀏覽
			int rc,cc;//回復 評論
			e=eL.size();
			u=uL.size();
			ac=aL.size();
			nc=nL.size();
			Cc=cL.size();
			Rc=recL.size();
			rc=repL.size();
			cc=coL.size();
			
			for(User U : uL){
				if("min".equals(U.getUserRoot())){
					uc=uc+1;
				}
				if("max".equals(U.getUserRoot())){
					urc=urc+1;
				}
			}
			for(Exhibits E : eL){
				if(E.getHall().getHallId()==1){
					e1=e1+1;
				}
				if(E.getHall().getHallId()==2){
					e2=e2+1;
				}
				if(E.getHall().getHallId()==3){
					e3=e3+1;
				}
				if(E.getHall().getHallId()==4){
					e4=e4+1;
				}
				if(E.getHall().getHallId()==5){
					e5=e5+1;
				}
				if(E.getHall().getHallId()==6){
					e6=e6+1;
				}
				if(E.getState().getStateId()==1){
					m1=m1+1;
				}
				if(E.getState().getStateId()==2){
					m2=m2+1;
				}
				if(E.getValue().getValueId()==1){
					l1=l1+1;
				}
				if(E.getValue().getValueId()==2){
					l2=l2+1;
				}
				if(E.getValue().getValueId()==3){
					l3=l3+1;
				}
			}
			
			List<Integer> list = new ArrayList<Integer>();
			list.add(e);
			list.add(e1);
			list.add(e2);
			list.add(e3);
			list.add(u);
			list.add(uc);
			list.add(urc); 
			list.add(ac);
			list.add(nc);
			list.add(l1);
			list.add(l2);
			list.add(l3);
			list.add(m1);
			list.add(m2);
			list.add(Cc);
			list.add(Rc);
			list.add(rc);
			list.add(cc);
			list.add(e4);
			list.add(e5);
			list.add(e6);
			req.setAttribute("list", list); 
			List<Value> vL=service.findV(); 
			req.setAttribute("vL", vL); 
			List<Hall> hL=service.findH();  
			req.setAttribute("hL", hL); 
		return "admin/index";
	}

	@RequestMapping("/Count")
	public String Count(HttpServletRequest req,HttpServletResponse resp,String USer_id,String User_root) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
			System.out.println(User_root);
			req.getSession().setAttribute("User_id", USer_id);
			req.getSession().setAttribute("User_root", User_root);
		return "redirect:/Exhibits/count.do";
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin){
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	         CustomDateEditor cust = new CustomDateEditor(sdf,true);
	         bin.registerCustomEditor(Date.class,cust);
	}
}
