package com.museum.action;

//��ҳ��Ϣ

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.service.IActivityService;
import com.museum.service.IExhibitsService;
import com.museum.service.INewsService;
import com.museum.domain.Activity;
import com.museum.domain.Exhibits;
import com.museum.domain.News;



@Controller
@RequestMapping("/News")
public class NewsAction {
	
	@Autowired
	private INewsService service;
	@Autowired
	private IActivityService service2;
	@Autowired
	private IExhibitsService service3;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		
		List<News> list = service.find();  //��ҳ����
		List<Activity> list2 = service2.find();//��ҳ���»
		List<Exhibits> list3 = service3.find();//��ҳ�����Ʒ
		
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		
		return "index";
		
	};
	
}
