package com.IPv6Museum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.IPv6Museum.model.News;
import com.IPv6Museum.service.NewsService;
import com.google.gson.Gson;

/**
 * 随机选择三条新闻信息
 * 返回：news_id， news_title， news_imgpath， news_abstract
 *
 */
@SuppressWarnings("serial")
public class GetNewsTitleController extends HttpServlet {
	private NewsService newsService=new NewsService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setContentType("application/json");
		List<Map<String, Object>> listresult=new ArrayList<>();//存放三个map，用来返回json数据
		
		List<News> listnews=newsService.getNewsTitleByThree();//生成三个新闻
		for (int i = 0; i <listnews.size(); i++) {
			Map<String, Object> map=new HashMap<>();//存放每个json对象的键值对
			map.put("news_id", listnews.get(i).getNews_id());
			map.put("news_title", listnews.get(i).getNews_title());
			String ip=Inet4Address.getLocalHost().getHostAddress();
			String url="http://"+ip+":8080"+"/IPv6Museum"+listnews.get(i).getNews_imgpath();
			map.put("news_imgpath", url);
			map.put("news_abstract", listnews.get(i).getNews_abstract());
			listresult.add(map);
		}
		
		PrintWriter writer=resp.getWriter();
		writer.write(new Gson().toJson(listresult));
		writer.flush();
		
	
	}
}
