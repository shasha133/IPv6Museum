package com.museum.action;

//我的 ——> 个人主页 ——> 浏览记录

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Activity;
import com.museum.domain.Exhibits;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.service.IGCWW2Service;
import com.museum.service.IGCWWService;
import com.museum.service.ITJService;
import com.museum.service.ImyselfService;

@Controller
@RequestMapping("/myself")
public class myselfAction {

	
	
	@Autowired
	private ImyselfService service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		
		req.setCharacterEncoding("GBK");
		String str = (String)req.getSession().getAttribute("User_id");//这个action的str暂且为user_id
		String page = req.getParameter("page");
		String page2 = req.getParameter("page2");
		Page pp = null;
		Page ppp = null;
		
		if(str == null){
			str = "1";
		}else{
			str = "1";
		}
		
		pp = (Page) service.findPageData(1,8,str);
		
		if(page==null && page2==null){
			ppp = pp;
		}else if(page!=null && page2==null){
			if(Integer.parseInt(page)==1){
				ppp = pp;
			}else{
				ppp = (Page) service.findPageData(Integer.parseInt(page)-1,8,str);
			}
		}else if(page==null && page2!=null){
			if(Integer.parseInt(page2)==pp.getMaxPage()){
				ppp = (Page) service.findPageData(Integer.parseInt(page2),8,str);
			}else{
				ppp = (Page) service.findPageData(Integer.parseInt(page2)+1,8,str);
			}
		}
		
		req.setAttribute("list", ppp.getList());
		req.setAttribute("maxPage", ppp.getMaxPage());
		req.setAttribute("numPage", ppp.getP());
		
		return "myself";
	}
	
	
}
