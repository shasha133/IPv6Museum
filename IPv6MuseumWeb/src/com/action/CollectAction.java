package com.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.museum.domain.Apply;
import com.museum.domain.Collect;
import com.museum.domain.Dynasty;
import com.museum.domain.Exhibits;
import com.museum.domain.Material;
import com.museum.domain.Page;
import com.museum.domain.Record;
import com.museum.domain.User;
import com.museum.domain.Value;
import com.service.ICollectService1;
import com.service.IExhibitsService1;
import com.service.IRecordService;
import com.service.IUserService1;



@Controller
@RequestMapping("Collect")
public class CollectAction {
	@Autowired
	private ICollectService1 service;
	@Autowired
	private IExhibitsService1 service1;
	@RequestMapping("/list")
	public String findList(String p,String size,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		List<Collect> CollectList;
		Page pp=service.findPageData(Integer.parseInt(p),Integer.parseInt(size));
		CollectList=pp.getList();
		req.setAttribute("page",pp.getP());
		req.setAttribute("maxPage",pp.getMaxPage());
		req.setAttribute("list", CollectList);

		return "admin/Collect/Search";
	}
	
	@RequestMapping("/Exlist")
	public String findExList(String p,String size,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");

			List<Exhibits> ExhibitsList;
			Page pp=service1.findPageData(Integer.parseInt(p),Integer.parseInt(size));
			ExhibitsList=pp.getList();
			req.setAttribute("page",pp.getP());
			req.setAttribute("maxPage",pp.getMaxPage());
			req.setAttribute("list", ExhibitsList);
			return "admin/Collect/Collect";	
		
	}
	
	@RequestMapping("/findBy")
	public String findBy(String page,String size,String UserId,String ExhibitId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		int p=Integer.parseInt(page);
		int s=Integer.parseInt(size);
		if(UserId==null){
			UserId="default";
		}
		if(ExhibitId==null){
			ExhibitId="default";
		}
		List<Collect> SearchList=service.findBy(ExhibitId,UserId);
		int countList=SearchList.size();
		int maxPage=(int) Math.ceil((countList*1.0/s));
		if(p>maxPage) p=maxPage;
		if(p<1)p=1;
		int startIndext = 0;
        int stopIndext = 0;
        startIndext=(p-1)*s;
        if((startIndext+5)>countList){
        	stopIndext=countList;
        }else{
        	
        	stopIndext=startIndext+5;
        }
    	req.setAttribute("UserId", UserId);
    	req.setAttribute("ExhibitId",ExhibitId);
    	req.setAttribute("page", p);
    	req.setAttribute("maxPage", maxPage);
		req.setAttribute("SearchList", SearchList.subList(startIndext, stopIndext));
			return "admin/Collect/Search";
	}
	@RequestMapping("/delete")
	public String delete(int[] id){
		for(int i:id){
		service1.updateC(i);	
		service.delete(i);
		}
		return "redirect:/Exhibits/count.do";
	}
}
