package com.museum.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Activity;
import com.museum.service.IActivityIService;
import com.museum.service.INewsIService;

//��action��ȡ��չ�ݻ��ҳ������󣬲�ѯ����ʾһ����ľ�������

@Controller
@RequestMapping("/ActivityIntroduction")
public class ActivityIntroductionAction {
	
	@Autowired
	private IActivityIService service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req) throws IOException{
		req.setCharacterEncoding("GBK");
		String str = req.getParameter("title");//��ȡ��ȡ��չ�ݻ��ҳ�淢���� activity_id
		List<Activity> list = service.find(str);//ͨ��activity_id��ѯ�����
		
		req.setAttribute("list", list);
		
		return "activity";//����ҳ��
	};
	
}
