package com.museum.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.domain.Record;
import com.museum.domain.Activity;
import com.museum.domain.ActivityType;
import com.museum.domain.Comment;
import com.museum.domain.Exhibits;
import com.museum.domain.Reply;
import com.museum.domain.User;
import com.museum.service.IActivityService;
import com.museum.service.ICangPin2Service;

//这是第二种显示藏品的方式，与CangPin2Action不同之处在于，这里查询到的展品通过iframe标签显示，并且展品都可以评论

@Controller
@RequestMapping("/cangPin3")
public class CangPin3Action {
	
	@Autowired
	private ICangPin2Service service;
	private String zzz;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req,HttpServletResponse response,String text,String xxx) throws Exception{
		req.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String zzz = (String)req.getSession().getAttribute("User_id");
		if(zzz!=null){
			String str = zzz;//获取展品id
		}else{
			String str = "1";
		}
		
		List<Exhibits> list = service.find(zzz);//查询
		List<User> list2 = service.find2(xxx);
		
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();//格式化日期
		
		User user = new User();
		for(User u : list2){
			user = u;
		}
		
		//每进一次展品信息展示页面，增加一条浏览记录
		
		
		//当提交评论之后，评论表增加一条数据
		Comment comment = new Comment();
		comment.setCommentTime(date);
		comment.setFromUid(xxx);
		comment.setTopicType(1);
		comment.setTopicId(Integer.parseInt(zzz));
		comment.setCommentContent(text);
		comment.setCommentState(1);
		
		if(!text.equals("")){
			service.save2(comment);//增加一条评论
		}
		
		
		List<Comment> list3 = service.find3(zzz);
		Map<Comment, Reply> map = new HashMap();
		
		List<Reply> list5 = null;
		for(Comment e : list3){
				map.put(e,service.findReply(e.getCommentId()));
		}
		
		//查询内容放入Request
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		req.setAttribute("list5", map);
		
		return "cangPin3";//返回页面
	};
	
	
	@RequestMapping("/find2")
	public String find2(HttpServletRequest req,String title,String text,String zzz) throws Exception{
req.setCharacterEncoding("UTF-8");
		
		String xxx = (String)req.getSession().getAttribute("User_id");

		if(zzz!=null){
			zzz = zzz;//获取展品id
		}else{
			zzz = "1";
		}
		
		List<Exhibits> list = service.find(zzz);//查询
		List<User> list2 = service.find2(xxx);
		List<Comment> list3 = service.find3(zzz);
		
		User user = new User();
		for(User u : list2){
			user = u;
		}
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();//格式化日期
		
		Record record = new Record();
		record.setRecordExhibitId(Integer.parseInt(zzz));
		record.setRecordTime(date);
		record.setUser(user);
		
		Map<Comment, Reply> map = new HashMap();
		
		List<Reply> list5 = null;
		for(Comment e : list3){
				map.put(e,service.findReply(e.getCommentId()));
		}
		
		service.save(record);//在浏览记录表增加一条浏览记录
		service.update(1,zzz);//在展品表里给浏览次数+1
		
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		req.setAttribute("list5", map);
		
		return "cangPin3";//返回页面
		
	}
	


	public String getZzz() {
		return zzz;
	}


	public void setZzz(String zzz) {
		this.zzz = zzz;
	}


	//根据输入框中的展品名查询展品信息
	//User Exhibits Comment
	@RequestMapping("/find3")
	public String find3(HttpServletRequest req,String ExhibitsName) throws IOException{
		req.setCharacterEncoding("utf-8");
		String xxx = (String)req.getSession().getAttribute("User_id");
		String str2 = null;//展品 Id
		String str = null;
		if(ExhibitsName!= null){
			str = ExhibitsName;//获取展品名
		}
		
		List<Exhibits> list4 = service.find4(str);//查询
		for(Exhibits e : list4){
			str2 = String.valueOf(e.getExhibitsId());
		}
		if(list4.size()==0){
			return "404";
		}
		
		List<User> list2 = service.find2(xxx);
		List<Comment> list3 = service.find3(str2);
		
		User user = new User();
		for(User u : list2){
			user = u;
		}
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();//格式化日期
		
		Record record = new Record();
		record.setRecordExhibitId(Integer.parseInt(str2));
		record.setRecordTime(date);
		record.setUser(user);
		
		
		service.save(record);//在浏览记录表增加一条浏览记录
		service.update(1,str2);//在展品表里给浏览次数+1
		
		req.setAttribute("list", list4);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		
		return "cangPin3";//返回页面
		
	}
		
		
	
}
