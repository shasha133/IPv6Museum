package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.domain.Record;
import com.museum.dao.ICangPin2Dao;
import com.museum.domain.Comment;
import com.museum.domain.Exhibits;
import com.museum.domain.Reply;
import com.museum.domain.User;
import com.museum.service.ICangPin2Service;

@Service
@Transactional
public class CangPin2Service implements ICangPin2Service {

	@Autowired
	private ICangPin2Dao dao;
	public void delete(Integer rid) {
	}
	public Exhibits find(Exhibits n) {
		return null;
	}
	public List<Exhibits> find(String str) {
		return dao.find(str);
	}
	public void save(Record n) {
		dao.save(n);
	}
	public void save2(Comment c) {
		dao.save2(c);
	}
	public void update(int r,String str) {
		dao.update(r,str);
	}
	public List<User> find2(String str) {
		return dao.find2(str);
	}
	@Override
	public List<Comment> find3(String str) {
		return dao.find3(str);
	}
	public List<Exhibits> find4(String str) {
		return dao.find4(str);
	}
	public Reply findReply(Integer r) {
		return dao.findReply(r);
	}

}
