package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Apply;
import com.museum.domain.Dynasty;
import com.museum.domain.Exhibits;
import com.museum.domain.Material;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.domain.Record;
import com.museum.domain.Value;
import com.service.IExhibitsService1;
import com.service.INewsService1;
import com.service.IRecordService;



@Controller
@RequestMapping("/Record")
public class RecordAction {
	@Autowired
	private IRecordService service;
	@Autowired
	private IExhibitsService1 service1;
	@RequestMapping("/list")
	public String findList(String p,String size,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		List<Record> RecordList;
		Page pp=service.findPageData(Integer.parseInt(p),Integer.parseInt(size));
		RecordList=pp.getList();
		req.setAttribute("page",pp.getP());
		req.setAttribute("maxPage",pp.getMaxPage());
		req.setAttribute("list", RecordList);

		return "admin/Record/Record";
	}
	
	@RequestMapping("/Exlist")
	public String findExList(String p,String size,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");

			List<Exhibits> ExhibitsList;
			Page pp=service1.findPageData(Integer.parseInt(p),Integer.parseInt(size));
			ExhibitsList=pp.getList();
			List<Apply> aL=service1.findA();
			List<Dynasty> dL=service1.findD();
			List<Material> mL=service1.findM();
			List<Value> vL=service1.findV();
			req.setAttribute("aL", aL);
			req.setAttribute("dL", dL);
			req.setAttribute("mL", mL);
			req.setAttribute("vL", vL);
			req.setAttribute("page",pp.getP());
			req.setAttribute("maxPage",pp.getMaxPage());
			req.setAttribute("list", ExhibitsList);
			return "admin/Record/Record";	
		
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
		List<Record> SearchList=service.findBy(ExhibitId,UserId);
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
			return "admin/Record/Search";
	}
	@RequestMapping("/delete")
	public String delete(int[] id){
		for(int i:id){
		service1.updateR(i);	
		service.delete(i);
		}
		return "redirect:/Exhibits/count.do";
	}
	
}
