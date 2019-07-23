package com.museum.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Exhibits;
import com.museum.service.IExhibitsJP2Service;
import com.museum.service.IExhibitsJP3Service;
import com.museum.service.IExhibitsJPService;

//��ѯ���޴��������ļ�չƷ��չʾ���ݲؾ�Ʒ

@Controller
@RequestMapping("/guanCJP")
public class CangPinAction {
	
	@Autowired
	private IExhibitsJPService service;
	@Autowired
	private IExhibitsJP2Service service2;
	@Autowired
	private IExhibitsJP3Service service3;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		
		//��ѯ����
		List<Exhibits> list = service.find();
		List<Exhibits> list2 = service2.find();
		List<Exhibits> list3 = service3.find();
		
		//��ѯ�������ݷ���Request
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		
		return "guanCJP";
	};
	
}