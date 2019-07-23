package com.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.museum.domain.Activity;
import com.museum.domain.ActivityType;
import com.museum.domain.Advice;
import com.museum.domain.Comment;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.domain.Reply;
import com.museum.domain.User;
import com.museum.domain.pageList;
import com.service.IActivityService1;
import com.service.IAdviceService;
import com.service.ICommentService;
import com.service.INewsService1;
import com.service.IUserService1;



@Controller
@RequestMapping("/comment")
public class CommentAction {
	@Autowired
	private ICommentService service;
	@Autowired
	private IAdviceService service1;
	@RequestMapping("/list")
	public String findList(String p,String size,HttpServletRequest req,HttpServletResponse resp) throws Exception{
			resp.setCharacterEncoding("utf-8");
			req.setCharacterEncoding("utf-8");
			List<Comment> CommentList;
			Page pp=service.findPageData(Integer.parseInt(p),Integer.parseInt(size));
			CommentList=pp.getList();
			req.setAttribute("page",pp.getP());
			req.setAttribute("maxPage",pp.getMaxPage());
			req.setAttribute("list", CommentList);
			return "admin/Comment/Comment";		
	}
	@RequestMapping("/findBy")
	public String findBy(String page,String size,String type,String commentId,String commentTime,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		int p=Integer.parseInt(page);
		int s=Integer.parseInt(size);
		if(commentId==null){
			commentId="default";
		}
		if(commentTime==null){
			commentTime="default";
		}
		List<Comment> SearchList=service.findBy(commentId, commentTime);
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
    	req.setAttribute("commentTime", commentTime);
    	req.setAttribute("commentId", commentId);
		req.setAttribute("SearchList", SearchList.subList(startIndext, stopIndext));
			return "admin/Comment/CommentSearch";
	}
	@RequestMapping("/findById")
	public String findById(Integer commentId,String id,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		Comment comment=service.Find(commentId);
		if(comment.getCommentState()==0){
			comment.setCommentState(1);
			Advice advice=new Advice();
			advice.setAdviceCheckState("未查看");
			advice.setCommentId(commentId);
			advice.setAdviceState("未通过");
			service1.save(advice);
		}else{
			comment.setCommentState(0);
			Advice advice=new Advice();
			advice.setAdviceCheckState("未查看");
			advice.setCommentId(commentId);
			advice.setAdviceState("通过");
			service1.save(advice);
		}
		service.update(comment);
		return "redirect:/comment/list.do?p=1&size=5";		
	}
	@RequestMapping("/reply")
	public String reply(Integer commentId,Reply reply,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		reply.setComment(service.Find(commentId));
		reply.setFromUid(String.valueOf(req.getSession().getAttribute("User_id")));
		reply.setToUid(service.Find(commentId).getFromUid());
		reply.setReplyTime(new Date());
		service.saveR(reply);
		return "redirect:/Exhibits/count.do";
	}
	@RequestMapping("/replySkip")
	public String replySkip(Integer commentId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		List<Reply> rL = service.find(commentId);
		req.setAttribute("comment", service.Find(commentId).getCommentContent());
		req.setAttribute("replyList", rL);
		req.setAttribute("commentId", commentId);
		return "admin/Comment/CommentReply";
	}
	@RequestMapping("/delete")
	public String delete(int[] id){
		for(int i:id){
			List<Reply> list=service.find(i);
			for(Reply reply : list){
				service.deleteReply(reply.getReplyId());
			}
		service.delete(i);
		}
		return "redirect:/Exhibits/count.do";
	}
	@RequestMapping("/deleteReply")
	public String deleteReply(int[] id){
		for(int i:id){
		service.deleteReply(i);
		}
		return "redirect:/Exhibits/count.do";
	}
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin){
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	         CustomDateEditor cust = new CustomDateEditor(sdf,true);
	         bin.registerCustomEditor(Date.class,cust);
	}
}
