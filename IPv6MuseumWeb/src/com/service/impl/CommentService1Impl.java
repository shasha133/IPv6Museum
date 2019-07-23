package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IActivity1Dao;
import com.dao.ICommentDao;
import com.museum.domain.Activity;
import com.museum.domain.Comment;
import com.museum.domain.Page;
import com.museum.domain.Reply;
import com.service.ICommentService;




@Service
@Transactional
public class CommentService1Impl implements ICommentService {
	@Autowired
	private ICommentDao dao;
	
	public void delete(Integer commentId) {
		dao.delete(commentId);
	}

	public List<Comment> find() {
		return dao.find();
	}

	public List<Reply> find(Integer commentId) {
		return dao.find(commentId);
	}

	public List<Comment> findBy(String commentId, String commenttime) {
		return dao.findBy(commentId, commenttime);
	}

	public Page findPageData(int p, int size) {
		int rowCount=dao.getRowCount();
		Page page=new Page(p, rowCount, size);
		List<Comment> list=dao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

	public void deleteReply(Integer replyId) {
		dao.deleteReply(replyId);
		
	}

	public List<Reply> findR() {
 
		return dao.findR();
	}

	public Comment Find(Integer commentId) {
		// TODO Auto-generated method stub
		return dao.Find(commentId);
	}

	public void update(Comment comment) {
		// TODO Auto-generated method stub
		dao.update(comment);
	}

	public void saveR(Reply reply) {
		dao.saveR(reply);
	}


}
