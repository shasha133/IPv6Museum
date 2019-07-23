package com.dao;

import java.util.List;

import com.museum.domain.Comment;
import com.museum.domain.News;
import com.museum.domain.Reply;



public interface ICommentDao {
	public void delete(Integer commentId);
	public void deleteReply(Integer replyId);
	public List<Comment> find();
	public List<Reply> find(Integer commentId);
	public List<Reply> findR();
	public List<Comment> findBy(String str,String str1);
	public Comment Find(Integer commentId);
	public void update(Comment comment);
	public void saveR(Reply reply);
	
	public int getRowCount();
	public List<Comment> find(int StratLine,int size);
}
