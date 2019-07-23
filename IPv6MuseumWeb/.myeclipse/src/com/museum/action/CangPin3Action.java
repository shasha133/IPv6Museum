package com.museum.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.museum.domain.User;
import com.museum.service.IActivityService;
import com.museum.service.ICangPin2Service;

//这是第二种显示藏品的方式，与CangPin2Action不同之处在于，这里查询到的展品通过iframe标签显示，并且展品都可以评论

@Controller
@RequestMapping("/cangPin3")
public class CangPin3Action {
	
	@Autowired
	private ICangPin2Service service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req,String text,String xxx) throws IOException{
		req.setCharacterEncoding("UTF-8");
		String str = req.getParameter("ExhibitsId");//获取展品id
		
		System.out.println(text);
		
		if(xxx!=null){
			str = xxx;
		}
		
		List<Exhibits> list = service.find(str);//查询
		List<User> list2 = service.find2(str);
		List<Comment> list3 = service.find3(str);
		
		
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();//格式化日期
		
		User user = new User();
		user = list2.get(0);//目前的user只能是对该Exhibits有评论的User,等岳旭光做好登陆后可以获取实时User
		
		//每进一次展品信息展示页面，增加一条浏览记录
		Record record = new Record();
		record.setRecordExhibitId(Integer.parseInt(str));
		record.setRecordTime(date);
		record.setUser(user);
		
		//当提交评论之后，评论表增加一条数据
		Comment comment = new Comment();
		comment.setCommentTime(date);
		comment.setFromUid(user.getUserId());
		comment.setTopicType(1);
		comment.setTopicId(Integer.parseInt(str));
		comment.setCommentContent(text);
		
		if(text!=null){
			service.save2(comment);//增加一条评论
		}else{
			System.out.println("false");
		}
		
		service.save(record);//在浏览记录表增加一条浏览记录
		service.update(1,str);//在展品表里给浏览次数+1
		
		//查询内容放入Request
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		
		return "cangPin3";//返回页面
	};
	
}
