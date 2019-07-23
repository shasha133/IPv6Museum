package com.museum.action;

//’πÃ¸œÍ«È

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Comment;
import com.museum.domain.Exhibits;
import com.museum.domain.Hall;
import com.museum.domain.Reply;
import com.museum.domain.User;
import com.museum.service.IHallService;
import com.museum.service.IMyCommentService;



@Controller
@RequestMapping("/MyComment")
public class MyCommentAction {
	
	@Autowired
	private IMyCommentService service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		req.setCharacterEncoding("GBK");
		String str =(String) req.getSession().getAttribute("User_id");
		List<Comment> list = service.find(str);
		
		req.setAttribute("list", list);
		
		return "myComment";
	};
	
}
