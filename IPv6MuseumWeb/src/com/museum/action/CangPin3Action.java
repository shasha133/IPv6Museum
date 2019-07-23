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

//���ǵڶ�����ʾ��Ʒ�ķ�ʽ����CangPin2Action��֮ͬ�����ڣ������ѯ����չƷͨ��iframe��ǩ��ʾ������չƷ����������

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
			String str = zzz;//��ȡչƷid
		}else{
			String str = "1";
		}
		
		List<Exhibits> list = service.find(zzz);//��ѯ
		List<User> list2 = service.find2(xxx);
		
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();//��ʽ������
		
		User user = new User();
		for(User u : list2){
			user = u;
		}
		
		//ÿ��һ��չƷ��Ϣչʾҳ�棬����һ�������¼
		
		
		//���ύ����֮�����۱�����һ������
		Comment comment = new Comment();
		comment.setCommentTime(date);
		comment.setFromUid(xxx);
		comment.setTopicType(1);
		comment.setTopicId(Integer.parseInt(zzz));
		comment.setCommentContent(text);
		comment.setCommentState(1);
		
		if(!text.equals("")){
			service.save2(comment);//����һ������
		}
		
		
		List<Comment> list3 = service.find3(zzz);
		Map<Comment, Reply> map = new HashMap();
		
		List<Reply> list5 = null;
		for(Comment e : list3){
				map.put(e,service.findReply(e.getCommentId()));
		}
		
		//��ѯ���ݷ���Request
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		req.setAttribute("list5", map);
		
		return "cangPin3";//����ҳ��
	};
	
	
	@RequestMapping("/find2")
	public String find2(HttpServletRequest req,String title,String text,String zzz) throws Exception{
req.setCharacterEncoding("UTF-8");
		
		String xxx = (String)req.getSession().getAttribute("User_id");

		if(zzz!=null){
			zzz = zzz;//��ȡչƷid
		}else{
			zzz = "1";
		}
		
		List<Exhibits> list = service.find(zzz);//��ѯ
		List<User> list2 = service.find2(xxx);
		List<Comment> list3 = service.find3(zzz);
		
		User user = new User();
		for(User u : list2){
			user = u;
		}
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();//��ʽ������
		
		Record record = new Record();
		record.setRecordExhibitId(Integer.parseInt(zzz));
		record.setRecordTime(date);
		record.setUser(user);
		
		Map<Comment, Reply> map = new HashMap();
		
		List<Reply> list5 = null;
		for(Comment e : list3){
				map.put(e,service.findReply(e.getCommentId()));
		}
		
		service.save(record);//�������¼������һ�������¼
		service.update(1,zzz);//��չƷ������������+1
		
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		req.setAttribute("list5", map);
		
		return "cangPin3";//����ҳ��
		
	}
	


	public String getZzz() {
		return zzz;
	}


	public void setZzz(String zzz) {
		this.zzz = zzz;
	}


	//����������е�չƷ����ѯչƷ��Ϣ
	//User Exhibits Comment
	@RequestMapping("/find3")
	public String find3(HttpServletRequest req,String ExhibitsName) throws IOException{
		req.setCharacterEncoding("utf-8");
		String xxx = (String)req.getSession().getAttribute("User_id");
		String str2 = null;//չƷ Id
		String str = null;
		if(ExhibitsName!= null){
			str = ExhibitsName;//��ȡչƷ��
		}
		
		List<Exhibits> list4 = service.find4(str);//��ѯ
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
		DateFormat df = DateFormat.getDateTimeInstance();//��ʽ������
		
		Record record = new Record();
		record.setRecordExhibitId(Integer.parseInt(str2));
		record.setRecordTime(date);
		record.setUser(user);
		
		
		service.save(record);//�������¼������һ�������¼
		service.update(1,str2);//��չƷ������������+1
		
		req.setAttribute("list", list4);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		
		return "cangPin3";//����ҳ��
		
	}
		
		
	
}
