package com.museum.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Exhibits;
import com.museum.service.ICangPin2Service;

//��ȡ���󣬲�չʾһ��չƷ��������Ϣ

@Controller
@RequestMapping("/cangPin2")
public class CangPin2Action {
	
	@Autowired
	private ICangPin2Service service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		req.setCharacterEncoding("GBK");
		String str = req.getParameter("ExhibitsId");//��ȡչƷid
		
		List<Exhibits> list = service.find(str);//ͨ��չƷid��ѯչƷ��Ϣ
		
		req.setAttribute("list", list);//����ѯ�������ݷ���Request���͸�ҳ��
		
		return "cangPin";//����ҳ��
	};
	
}
