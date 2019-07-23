package com.museum.action;

//我的 ——> 个人主页 ——> 浏览记录

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.User;
import com.museum.service.ImyInService;

@Controller
@RequestMapping("/myInformation")
public class MyInformationAction {

	
	
	@Autowired
	private ImyInService service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		
		req.setCharacterEncoding("GBK");
		String str = (String)req.getSession().getAttribute("User_id");//这个action的str暂且为user_id
		
		List<User> list = service.find(str);
		
		req.setAttribute("list", list);
		
		return "myInformation";
	}
	
	
}
