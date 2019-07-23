package com.museum.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Activity;
import com.museum.service.IActivityIService;
import com.museum.service.INewsIService;

//此action获取“展馆活动”页面的请求，查询并显示一条活动的具体内容

@Controller
@RequestMapping("/ActivityIntroduction")
public class ActivityIntroductionAction {
	
	@Autowired
	private IActivityIService service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		req.setCharacterEncoding("GBK");
		String str = req.getParameter("title");//获取获取“展馆活动”页面发来的 activity_id
		List<Activity> list = service.find(str);//通过activity_id查询活动内容
		
		req.setAttribute("list", list);
		
		return "activity";//返回页面
	};
	
}
