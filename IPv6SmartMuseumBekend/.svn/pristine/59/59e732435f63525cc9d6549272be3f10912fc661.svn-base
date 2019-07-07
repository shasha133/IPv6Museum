package com.IPv6Museum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.IPv6Museum.service.FeatureService;
import com.google.gson.Gson;

/**
 * 根据不同的请求类型，返回响应的展品编号集
 * 1——年代    2——价值 
 * 3——青铜器       4——瓷器     5——玉器
 * @author tian
 *
 */
public class GetSuggestedExhibitsController extends HttpServlet{
	
	private FeatureService featureService = new FeatureService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		
		String para = request.getParameter("request_id");
		int request_id = Integer.parseInt(para);
		
		List<String> idList = new ArrayList<String>();
		
		switch (request_id) {
		// 年代
		case 1:
			idList = featureService.getByYears();
			break;
		// 价值
		case 2:
			idList = featureService.getByValue();
			break;
		// 3——青铜器
		case 3:
			idList = featureService.getBronzeware();
			break;
		// 4——瓷器
		case 4:
			idList = featureService.getChinaware();
			break;
		// 5——玉器
		case 5:
			idList = featureService.getJadeware();
			break;	
		default:
			break;
		}
		
		PrintWriter writer=response.getWriter();
		writer.write(new Gson().toJson(idList));
		writer.flush();
	}
}
