package com.IPv6Museum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.IPv6Museum.model.Exhibits;
import com.IPv6Museum.model.Exhibitsinfo;
import com.IPv6Museum.service.ExhibitsService;
import com.google.gson.Gson;

/**
 * 根据给定的展品编号，返回相应的展品信息
 * 参数：展品编号
 * 返回：展品名称，图片链接，语音讲解链接，文字讲解内容
 * @author tian
 *
 */
public class GetMediaController extends HttpServlet{
	
	private ExhibitsService exhibitsService = new ExhibitsService();
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		
		String para = request.getParameter("exhibits_id");
		int exhibits_id = Integer.parseInt(para);

		//获取展品相关的信息
		List<Exhibitsinfo> Exhibitsinfo_list = exhibitsService.getExhibitsinfos(exhibits_id);
		List<Exhibits> Exhibits_list = exhibitsService.getExhibits(exhibits_id);
		
		String ip=Inet4Address.getLocalHost().getHostAddress();
		String img_url="http://"+ip+":8082"+"/IPv6Museum"+Exhibitsinfo_list.
				get(0).getExhibitsinfo_imgfull();
		String voice_url = "http://"+ip+":8082"+"/IPv6Museum"+Exhibitsinfo_list.
				get(0).getExhibitsinfo_voice();
		
		//以map的形式存储将要返回的值：展品名称，图片链接，语音讲解链接，文字讲解内容
		Map<String, Object> map=new HashMap<>();//存放每个json对象的键值对
		map.put("Exhibits_name", Exhibits_list.get(0).getExhibits_name());
		map.put("Exhibitsinfo_imgfull", img_url);
		map.put("exhibitsinfo_voice", voice_url);
		map.put("Exhibitsinfo_intro", Exhibitsinfo_list.get(0).getExhibitsinfo_intro());
		
		PrintWriter writer=response.getWriter();
		writer.write(new Gson().toJson(map));
		writer.flush();
	}
}
