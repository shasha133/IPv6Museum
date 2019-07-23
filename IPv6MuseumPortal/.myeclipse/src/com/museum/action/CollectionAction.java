package com.museum.action;

//我的 ——> 个人主页 ——> 我的收藏

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
import com.museum.service.ICollService;
import com.museum.service.IGCWW2Service;
import com.museum.service.IGCWWService;
import com.museum.service.ITJService;

@Controller
@RequestMapping("/myCollection")
public class CollectionAction {

	
	
	@Autowired
	private ICollService service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		
		req.setCharacterEncoding("GBK");
		String str = req.getParameter("type");
		String page = req.getParameter("page");
		String page2 = req.getParameter("page2");
		Page pp = null;
		Page ppp = null;
		
		if(str == null || str.hashCode() == 97){
			str = "Exhibits_upvote";
		}else{
			str = "Exhibits_browse";
		}
		
		pp = (Page) service.findPageData(1,6,str);
		
		if(page==null && page2==null){
			ppp = pp;
		}else if(page!=null && page2==null){
			if(Integer.parseInt(page)==1){
				ppp = pp;
			}else{
				ppp = (Page) service.findPageData(Integer.parseInt(page)-1,6,str);
			}
		}else if(page==null && page2!=null){
			if(Integer.parseInt(page2)==pp.getMaxPage()){
				ppp = (Page) service.findPageData(Integer.parseInt(page2),6,str);
			}else{
				ppp = (Page) service.findPageData(Integer.parseInt(page2)+1,6,str);
			}
		}
		
		req.setAttribute("list", ppp.getList());
		req.setAttribute("maxPage", ppp.getMaxPage());
		req.setAttribute("numPage", ppp.getP());
		
		return "myCollection";
	}
	
	
}
