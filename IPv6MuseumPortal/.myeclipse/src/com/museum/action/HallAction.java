package com.museum.action;

//’πÃ¸œÍ«È

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Hall;
import com.museum.service.IHallService;



@Controller
@RequestMapping("/Hall")
public class HallAction {
	
	@Autowired
	private IHallService service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		
		List<Hall> list = service.find();
		
		req.setAttribute("list", list);
		
		return "zhanTXQ";
	};
	
}
