package com.museum.service;

import java.util.List;

import com.museum.domain.Comment;
import com.museum.domain.Record;
import com.museum.domain.Exhibits;
import com.museum.domain.User;

public interface ICangPin2Service {
	public void save(Record record);
	public void save2(Comment comment);
	public Exhibits find(Exhibits n);
	public void delete(Integer rid);
	public void update(int r,String str);
	public List<Exhibits> find(String str);
	public List<User> find2(String str);
	public List<Comment> find3(String str);
}
