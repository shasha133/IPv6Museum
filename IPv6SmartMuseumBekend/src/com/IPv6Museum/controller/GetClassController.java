package com.IPv6Museum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.IPv6Museum.model.Classification;
import com.IPv6Museum.service.ClassificationService;
import com.google.gson.Gson;

public class GetClassController extends HttpServlet {
	
	private ClassificationService classificationService=new ClassificationService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setContentType("application/json");
		List<Map<String, Object>> listresult=new ArrayList<>();		
		List<Classification> listClassification=classificationService.listClassification();
		
		for (int i = 0; i <listClassification.size(); i++) {
			Map<String, Object> map=new HashMap<>();
			map.put("classification_id", listClassification.get(i).getClassification_id());
			map.put("classification_name",listClassification.get(i).getClassification_name());
			listresult.add(map);
		}
		
		PrintWriter writer=resp.getWriter();
		writer.write(new Gson().toJson(listresult));
		writer.flush();
//		writer.println("成功");
	
	}

}
