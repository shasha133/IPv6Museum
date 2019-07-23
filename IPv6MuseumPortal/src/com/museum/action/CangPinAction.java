package com.museum.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Exhibits;
import com.museum.service.IExhibitsJP2Service;
import com.museum.service.IExhibitsJP3Service;
import com.museum.service.IExhibitsJPService;

//查询点赞次数最多的四件展品，展示到馆藏精品

@Controller
@RequestMapping("/guanCJP")
public class CangPinAction {
	
	@Autowired
	private IExhibitsJPService service;
	@Autowired
	private IExhibitsJP2Service service2;
	@Autowired
	private IExhibitsJP3Service service3;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		
		//查询数据
		List<Exhibits> list = service.find();
		List<Exhibits> list2 = service2.find();
		List<Exhibits> list3 = service3.find();
		
		//查询到的数据放入Request
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		
		return "guanCJP";
	};
	
}