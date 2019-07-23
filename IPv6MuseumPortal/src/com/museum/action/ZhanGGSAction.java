package com.museum.action;

//’πÃ¸œÍ«È

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Exhibits;
import com.museum.domain.Hall;
import com.museum.service.IHallService;
import com.museum.service.IZhanGGSService;



@Controller
@RequestMapping("/ZhanGGS")
public class ZhanGGSAction {
	
	@Autowired
	private IZhanGGSService service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		
		List<Exhibits> list1 = service.find1();
		List<Exhibits> list2 = service.find2();
		List<Exhibits> list3 = service.find3();
		List<Exhibits> list4 = service.find4();
		List<Exhibits> list5 = service.find5();
		List<Exhibits> list6 = service.find6();
		
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		req.setAttribute("list4", list4);
		req.setAttribute("list5", list5);
		req.setAttribute("list6", list6);
		
		return "zhanGGS";
	};
	
}
