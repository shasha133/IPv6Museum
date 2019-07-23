package com.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.museum.domain.Activity;
import com.museum.domain.ActivityType;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.domain.User;
import com.service.ICollectService1;
import com.service.IRecordService;
import com.service.IUserService1;



@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private IUserService1 service;
	
	@Autowired
	private ICollectService1 service1;
	
	@Autowired
	private IRecordService service2;
	
	@RequestMapping("/login")
	public String find(String username,String password,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		
		User user=new User();
		if(username==null||service.find(username)==null){
			req.setAttribute("error","1");
			return "front/login";
		}
		user=service.find(username);
		if(user.getUserPassword().equals(password)&&user.getUserRoot().equals("max")){ 
			req.getSession().setAttribute("User_Id", req.getParameter("username"));
			req.getSession().setAttribute("User_root","max");
			return "redirect:http://[2001:da8:270:2021::71]:8082/mymuseum/News/set.do?User_Id="+username+"&User_root=max";
		}else if(user.getUserPassword().equals(password)&&user.getUserRoot().equals("min")){ 
			req.getSession().setAttribute("User_Id", req.getParameter("username"));
			req.getSession().setAttribute("User_root","min");
			return "redirect:http://[2001:da8:270:2021::71]:8082/mymuseum/News/set.do?User_Id="+username+"&User_root=min";
		}else{
			req.setAttribute("error","1");
			return "front/login";
		}
	}
	@RequestMapping("/saveUser")
	public String saveUser(User user,HttpServletRequest req,HttpServletResponse resp){
		if(service.find(user.getUserId())!=null){
			req.setAttribute("error1","1");
			return "front/signUP";
		}else{
		
			
			try{
				String MyId="yxg19960215@163.com";
				String Mypassword="a124578369";
				
				Properties props = new Properties();
				props.setProperty("mail.transport.protocol", "smtp");
				props.setProperty("mail.host","smtp.163.com");
				props.setProperty("mail.smtp.auth","true");
				
				Session session=Session.getInstance(props);
				
				MimeMessage msg = new MimeMessage(session);
				
				Address address = new  InternetAddress("yxg19960215@163.com");
				msg.setFrom(address);
				
				msg.setRecipients(Message.RecipientType.TO,user.getUserId());
				
				msg.setSubject("用户注册");
				String str="您在网站注册的信息为：\r\n" +
						"账号："+user.getUserId()+"\r\n"+
						"用户名为："+user.getUserName()+"\r\n"+
						"密码为："+user.getUserPassword()+"\r\n"+
						"点击下面链接激活账号，请尽快激活！ \r\n"+
						"\"http://[2001:da8:270:2021::71]:8082/mymuseum/user/saveskip.do?userId="+user.getUserId()
						+"&userName="+user.getUserName()+
						"&userPassword="+user.getUserPassword()
					
						;

				msg.setText(str);
				
				
				msg.saveChanges();
				
				Transport ts=session.getTransport();
				
				ts.connect(MyId, Mypassword);
				ts.sendMessage(msg, msg.getAllRecipients());
				
				ts.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			
			return "front/skip";
		}
		
	}
	@RequestMapping("/saveskip")
	public String skip(User user,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		user.setUserImage("mymuseum/images/021.jpg");
		user.setUserRoot("min");
		service.save(user);
		return "front/login";
	}
	@RequestMapping("/findBy")
	public String findBy(String page,String size,String userId,String userName,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		int p=Integer.parseInt(page);
		int s=Integer.parseInt(size);
		if(userName==null){
			userId="default";
		}
		if(userName==null){
			userName="default";
		}
		List<User> SearchList=service.findBy(userId, userName);
		int countList=SearchList.size();
		int maxPage=(int) Math.ceil((countList*1.0/s));
		if(p>maxPage) p=maxPage;
		if(p<1)p=1;
		int startIndext = 0;
        int stopIndext = 0;
        startIndext=(p-1)*s;
        if((startIndext+5)>countList){
        	stopIndext=countList;
        }else{
        	
        	stopIndext=startIndext+5;
        }
        req.setAttribute("page", p);
    	req.setAttribute("maxPage", maxPage);
        req.setAttribute("userId", userId);
    	req.setAttribute("userName", userName);
		req.setAttribute("SearchList", SearchList.subList(startIndext, stopIndext));
		return "admin/User/UserSearch";
	}
	
	@RequestMapping("/list")
	public String findList(String p,String size,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		List<User> UsersList;
		Page pp=service.findPageData(Integer.parseInt(p),Integer.parseInt(size));
		UsersList=pp.getList();
		req.setAttribute("page",pp.getP());
		req.setAttribute("maxPage",pp.getMaxPage());
		req.setAttribute("list", UsersList);
		return "admin/User/User";
	}
	@RequestMapping("/findById")
	public String findById(String userId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		User user=service.find(userId);
		req.setAttribute("user", user);
		return "admin/User/UserUpdate";		
	}
	@RequestMapping("/forget")
	public String forget(String userId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8"); 
		if(userId==null||service.find(userId)==null){
			req.setAttribute("error","1");
			return "front/forget";
		}
		try{
		User user=new User();
		user=service.find(userId);
		String MyId="yxg19960215@163.com";
		String Mypassword="a124578369";
		
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host","smtp.163.com");
		props.setProperty("mail.smtp.auth","true");
		
		Session session=Session.getInstance(props);
		
		MimeMessage msg = new MimeMessage(session);
		
		Address address = new  InternetAddress("yxg19960215@163.com");
		msg.setFrom(address);
		
		msg.setRecipients(Message.RecipientType.TO,userId);
		
		msg.setSubject("忘记密码");
		String str="您在网站注册的信息为：\r\n" +
				"账号："+user.getUserId()+"\r\n"+
				"用户名为："+user.getUserName()+"\r\n"+
				"密码为："+user.getUserPassword()+"\r\n"+
				"点击链接返回登录界面   \"http://[2001:da8:270:2021::71]:8082/mymuseum/Front/login.do"
				;
		msg.setText(str);
		
		
		msg.saveChanges();
		
		Transport ts=session.getTransport();
		
		ts.connect(MyId, Mypassword);
		ts.sendMessage(msg, msg.getAllRecipients());
		
		ts.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/Front/login.do";
	}
	
	@RequestMapping("/update")
	public String update(String userId,String userRoot){
		User user=service.find(userId);
		user.setUserRoot(userRoot);
		System.out.println(user.getUserId());
			service.update(user);
			return "redirect:/Exhibits/count.do";
		}
	
	@RequestMapping("/delete")
	public String delete(String[] id){

			
		for(String i:id){
			service1.deleteUser(i);
			service2.deleteUser(i);
			service.delete(i);
			
		}
		return "redirect:/Exhibits/count.do";
	}
}
