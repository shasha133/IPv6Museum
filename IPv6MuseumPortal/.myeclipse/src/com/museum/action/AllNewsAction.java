package com.museum.action;

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
import com.museum.service.IAllNews2Service;
import com.museum.service.IAllNewsService;
import com.museum.service.INewsService;

//此action包含 展馆新闻 中的两部分:1、展馆活动的前三个最新新闻;2、下方列表中的所有新闻

@Controller
@RequestMapping("/allNews")
public class AllNewsAction {
	
	@Autowired
	private IAllNewsService service;
	@Autowired
	private IAllNews2Service service2;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		//不点击‘上一页’或‘下一页’,req.getParameter("page") 就位空值
		//据此，可以通过判断，进入不同的service，获取不同的页面数据
		req.setCharacterEncoding("GBK");
		String str = req.getParameter("page");
		String str2 = req.getParameter("page2");
		
		List<News> list = service.find(); 
		Page pp = null;
		Page ppp = null;
		pp = service2.findPageData(1,5);//不进行翻页操作，只展示
		
		//通过页面传来的数据，判断进行“上一页”还是“下一页”操作，并展示到页面
		if(str==null && str2==null){
			ppp = pp;
		}else if(str!=null && str2==null){
			if(Integer.parseInt(str)==1){
				ppp = pp;
			}else{
				ppp = service2.findPageData(Integer.parseInt(str)-1,5);
			}
		}else if(str==null && str2!=null){
			if(Integer.parseInt(str2)==pp.getMaxPage()){
				ppp = service2.findPageData(Integer.parseInt(str2),5);
			}else{
				ppp = service2.findPageData(Integer.parseInt(str2)+1,5);
			}
		}
		
		req.setAttribute("list", list);
		req.setAttribute("list2", ppp.getList());
		req.setAttribute("maxPage",ppp.getMaxPage());
		req.setAttribute("page", ppp.getP());
		
		return "zhanGXW";
		
	};
	
}
