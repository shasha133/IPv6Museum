package com.museum.dao;

import java.util.List;

import com.museum.domain.Comment;
import com.museum.domain.Record;
import com.museum.domain.Exhibits;
import com.museum.domain.Reply;
import com.museum.domain.User;

public interface ICangPin2Dao {
	public void save(Record n);
	public void save2(Comment c);
	public Exhibits find(Integer n);
	public void delete(Integer rid);
	public void update(int r,String str);
	public List<Exhibits> find(String str);
	public List<User> find2(String str);
	public List<Comment> find3(String str);
	public Reply findReply(Integer r);
	public List<Exhibits> find4(String str);
}