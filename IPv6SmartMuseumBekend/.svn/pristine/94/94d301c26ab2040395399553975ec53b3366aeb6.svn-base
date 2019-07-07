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

import com.IPv6Museum.model.News;
import com.IPv6Museum.service.NewsService;
import com.google.gson.Gson;

/**
 * 根据给定的新闻编号，返回相应的新闻信息
 * 参数：新闻编号
 * 返回：新闻标题，新闻正文
 * @author 
 *
 */
//getNewsController
public class GetNewsController extends HttpServlet {

	private NewsService newsService = new NewsService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("UTF-8");
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		resp.setContentType("application/json");
		
		String para = req.getParameter("news_id");
		News news = new News();
		news=newsService.getNews(Integer.parseInt(para));
//		System.out.println("news:"+news.getNews_context());
		
		List<Map<String, Object>> listresult=new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("news_title", news.getNews_title());
		map.put("news_context", news.getNews_context());
		listresult.add(map);
		
		PrintWriter writer = resp.getWriter();
		writer.write(new Gson().toJson(map));
		writer.flush();			

	}
}
