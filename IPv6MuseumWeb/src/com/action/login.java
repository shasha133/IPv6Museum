package com.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Front")
public class login {
	@RequestMapping("/login")
	public String login(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		req.setAttribute("error", "2");
		return "front/login";
	}
}
