package com.museum.action;

//首页信息

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.service.IActivityService;
import com.museum.service.IExhibitsService;
import com.museum.service.INewsService;
import com.museum.service.IUserService;
import com.museum.domain.Activity;
import com.museum.domain.Exhibits;
import com.museum.domain.News;
import com.museum.domain.User;



@Controller
@RequestMapping("/News")
public class NewsAction {
	
	@Autowired
	private INewsService service;
	@Autowired
	private IActivityService service2;
	@Autowired
	private IExhibitsService service3;
	@Autowired
	private IUserService service4;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		
		List<News> list = service.find();  //首页新闻
		List<Activity> list2 = service2.find();//首页最新活动
		List<Exhibits> list3 = service3.find();//首页经典藏品

		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		
		return "index";
		
	};
	@RequestMapping("/set")
	public String set(HttpServletRequest req) throws IOException{
		req.setCharacterEncoding("utf-8");
		
		
		req.getSession().setAttribute("User_id",req.getParameter("User_Id"));
		req.getSession().setAttribute("User_root",req.getParameter("User_root"));
		
		String str = String.valueOf(req.getSession().getAttribute("User_id"));
		
		List<User> e = service4.find(str);
		User eee = new User();
		for(User ee : e){
			eee = ee;
		}
		req.getSession().setAttribute("User_image",eee.getUserImage());
		
		
		return "redirect:/News/find.do";
		
	};
}
