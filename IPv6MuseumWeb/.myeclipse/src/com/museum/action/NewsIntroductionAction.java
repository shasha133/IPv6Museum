package com.museum.action;

//新闻具体内容

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.News;
import com.museum.service.INewsIService;



@Controller
@RequestMapping("/newsIntroduction")
public class NewsIntroductionAction {
	
	@Autowired
	private INewsIService service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		req.setCharacterEncoding("GBK");
		String str = req.getParameter("title");
		
		List<News> list = service.find(str);
		
		req.setAttribute("list", list);
		
		return "news";
	};
	
}
