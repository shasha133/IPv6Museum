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

//���ǵڶ�����ʾ��Ʒ�ķ�ʽ����CangPin2Action��֮ͬ�����ڣ������ѯ����չƷͨ��iframe��ǩ��ʾ������չƷ����������

@Controller
@RequestMapping("/cangPin3")
public class CangPin3Action {
	
	@Autowired
	private ICangPin2Service service;
	
	@RequestMapping("/find")
	public String find(HttpServletRequest req,String text,String xxx) throws IOException{
		req.setCharacterEncoding("UTF-8");
		String str = req.getParameter("ExhibitsId");//��ȡչƷid
		
		System.out.println(text);
		
		if(xxx!=null){
			str = xxx;
		}
		
		List<Exhibits> list = service.find(str);//��ѯ
		List<User> list2 = service.find2(str);
		List<Comment> list3 = service.find3(str);
		
		
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();//��ʽ������
		
		User user = new User();
		user = list2.get(0);//Ŀǰ��userֻ���ǶԸ�Exhibits�����۵�User,����������õ�½����Ի�ȡʵʱUser
		
		//ÿ��һ��չƷ��Ϣչʾҳ�棬����һ�������¼
		Record record = new Record();
		record.setRecordExhibitId(Integer.parseInt(str));
		record.setRecordTime(date);
		record.setUser(user);
		
		//���ύ����֮�����۱�����һ������
		Comment comment = new Comment();
		comment.setCommentTime(date);
		comment.setFromUid(user.getUserId());
		comment.setTopicType(1);
		comment.setTopicId(Integer.parseInt(str));
		comment.setCommentContent(text);
		
		if(text!=null){
			service.save2(comment);//����һ������
		}else{
			System.out.println("false");
		}
		
		service.save(record);//�������¼������һ�������¼
		service.update(1,str);//��չƷ������������+1
		
		//��ѯ���ݷ���Request
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		
		return "cangPin3";//����ҳ��
	};
	
}
