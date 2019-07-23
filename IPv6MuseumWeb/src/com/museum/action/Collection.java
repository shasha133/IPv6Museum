package com.museum.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.dao.Impl.ExhibitsDaoImpl;
import com.museum.domain.Collect;
import com.museum.domain.Exhibits;
import com.museum.service.IExhibitsJPService;
import com.museum.service.IcollectionService;

@Controller
@RequestMapping("/collection")
public class Collection {
	@Autowired
	private IcollectionService service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		
		//查询数据
		String str = (String)req.getSession().getAttribute("User_id");
		System.out.println(str);
		System.out.println(str);
		System.out.println(str);
		System.out.println(str);
		List<Collect> list = service.find(str);
		List<Exhibits> EL=new ArrayList<Exhibits>();
		for(Collect c : list){
			EL.add(service.finde(c.getCollectExhibitId()));
			
		}
		//查询到的数据放入Request
		req.setAttribute("list", EL);
		
		return "myCollection";
	};
	
	@RequestMapping("/save")
	public String save(HttpServletRequest req,String userid,int exhibitsId) throws IOException{
		List<Collect> list = service.find(userid);
		boolean bool=true;
		for(Collect c : list){
			if(c.getUser().getUserId().equals(userid)&&c.getCollectExhibitId().equals(exhibitsId)){
				bool=false;
			}
		}
		if(bool){
			Collect collect=new Collect();
			collect.setCollectExhibitId(exhibitsId);
			collect.setCollectTime(new Date());
			collect.setUser(service.findu(userid));
			Exhibits e=service.finde(exhibitsId);
			e.setExhibitsCherish(e.getExhibitsCherish()+1);
			service.update(e);
			service.save(collect);
			}
	    list = service.find(userid);
		List<Exhibits> EL=new ArrayList<Exhibits>();
		for(Collect c : list){
			EL.add(service.finde(c.getCollectExhibitId()));
			
		}
		//查询到的数据放入Request
		req.setAttribute("list", EL);
		return "myCollection";
	};
	
	
	
}
