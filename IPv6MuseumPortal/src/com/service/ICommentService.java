package com.service;

import java.util.List;

import com.museum.domain.Comment;
import com.museum.domain.News;
import com.museum.domain.Page;
import com.museum.domain.Reply;


public interface ICommentService {
	public void delete(Integer commentId);
	public void deleteReply(Integer replyId) ;
	public List<Comment> find();
	public List<Reply> find(Integer commentId);

	public List<Reply> findR();
	public Comment Find(Integer commentId);
	public void update(Comment comment);
	public void saveR(Reply reply);
	
	public Page findPageData(int p,int size);
	public List<Comment> findBy(String commentId, String commentTime);
}
