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

//��action���� չ������ �е�������:1��չ�ݻ��ǰ������������;2���·��б��е���������

@Controller
@RequestMapping("/allNews")
public class AllNewsAction {
	
	@Autowired
	private IAllNewsService service;
	@Autowired
	private IAllNews2Service service2;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		//���������һҳ������һҳ��,req.getParameter("page") ��λ��ֵ
		//�ݴˣ�����ͨ���жϣ����벻ͬ��service����ȡ��ͬ��ҳ������
		req.setCharacterEncoding("GBK");
		String str = req.getParameter("page");
		String str2 = req.getParameter("page2");
		
		List<News> list = service.find(); 
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
		
		req.setAttribute("list", list);
		req.setAttribute("list2", ppp.getList());
		req.setAttribute("maxPage",ppp.getMaxPage());
		req.setAttribute("page", ppp.getP());
		
		return "zhanGXW";
		
	};
	
}