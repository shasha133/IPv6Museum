package com.museum.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Exhibits;
import com.museum.service.ICangPin2Service;

//获取请求，并展示一个展品的所有信息

@Controller
@RequestMapping("/cangPin2")
public class CangPin2Action {
	
	@Autowired
	private ICangPin2Service service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		req.setCharacterEncoding("GBK");
		String str = req.getParameter("ExhibitsId");//获取展品id
		
		List<Exhibits> list = service.find(str);//通过展品id查询展品信息
		
		req.setAttribute("list", list);//将查询到的内容放入Request发送给页面
		
		return "cangPin";//发回页面
	};
	
}
