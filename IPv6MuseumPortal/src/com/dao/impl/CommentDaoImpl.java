package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ICommentDao;
import com.museum.domain.Activity;
import com.museum.domain.Comment;
import com.museum.domain.News;
import com.museum.domain.Reply;



@Repository
public class CommentDaoImpl implements ICommentDao{
	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return  sf.getCurrentSession();
		
	}
	public void delete(Integer commentId) {
		Comment comment=(Comment) getSession().get(Comment.class,commentId);
		getSession().delete(comment);
	}

	public List<Comment> find() {
		return getSession().createQuery("FROM Comment").list();
	}

	public List<Reply> find(Integer commentId) {
		 String hql = "from Reply where Comment_id=? ";  
		 Query query = getSession().createQuery(hql);
		 query.setInteger(0,commentId);  

		  List<Reply> list = query.list();  
		return list;
	}


	public List<Comment> find(int StratLine, int size) { 
		Query q= getSession().createQuery("FROM Comment");
		q.setFirstResult(StratLine);
		q.setMaxResults(size);
		return q.list();
	}
	public int getRowCount() { 
		long x=(Long) getSession().createQuery("SELECT COUNT(*) FROM Comment").uniqueResult();
		return (int) x;
	}

	public List<Comment> findBy(String str, String str1) {
		  String hql = "from Comment where  commentId=? or commentTime=? ";  
		  Query query = getSession().createQuery(hql);
		  query.setString(0, str);  
		  query.setString(1, str1);  
		  List<Comment> list = query.list();  
		  return list; 
	}
	public void deleteReply(Integer replyId) {
		Reply reply=(Reply) getSession().get(Reply.class,replyId);
		getSession().delete(reply);
	}
	public List<Reply> findR() { 
		return getSession().createQuery("FROM Reply").list();
	}
	public Comment Find(Integer commentId) {
		// TODO Auto-generated method stub
		return (Comment) getSession().get(Comment.class, commentId);
	}
	public void update(Comment comment) {
		
		getSession().update(comment);
	}
	public void saveR(Reply reply) {
		getSession().save(reply);
	}

}
