package com.museum.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Activity;
import com.museum.domain.Page;
import com.museum.service.IAct2Service;
import com.museum.service.IActService;

//��action���� չ�ݻ �е�������:1��չ�ݻ��ǰ�������»;2���·��б��е����л

@Controller
@RequestMapping("/activity")
public class ActivityAction {
	
	@Autowired
	private IActService service;
	@Autowired
	private IAct2Service service2;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		
		req.setCharacterEncoding("GBK");
		String str = req.getParameter("page");
		String str2 = req.getParameter("page2");
		
		List<Activity> list = service.find(); 
		Page pp = null;
		Page ppp = null;
		pp = service2.findPageData(1,5);//�����з�ҳ������ֻչʾ
		
		//ͨ��ҳ�洫�������ݣ��жϽ��С���һҳ�����ǡ���һҳ����������չʾ��ҳ��
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
		
		//��ҳ�淢�����ݿ��в�ѯ��������
		req.setAttribute("list", list);
		req.setAttribute("list2", ppp.getList());
		req.setAttribute("maxPage",ppp.getMaxPage());
		req.setAttribute("page", ppp.getP());
		
		return "zhanTHD";
		
		
	}
}
