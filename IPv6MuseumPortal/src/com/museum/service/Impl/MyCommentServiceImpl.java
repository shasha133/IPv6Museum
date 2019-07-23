package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IHallDao;
import com.museum.dao.IMyCommentDao;
import com.museum.domain.Comment;
import com.museum.domain.Exhibits;
import com.museum.domain.Hall;
import com.museum.domain.User;
import com.museum.service.IHallService;
import com.museum.service.IMyCommentService;


@Service
@Transactional
public class MyCommentServiceImpl implements IMyCommentService {

	@Autowired
	private IMyCommentDao dao;

	public void delete(Integer rid) {
	}
	public User find(User n) {
		return null;
	}
	public List<Comment> find(String str) {
		return dao.find(str);
	}
	public void save(User n) {
	}
	public void update(User r) {
	}
	public Exhibits findExhibits(Integer topicId) {
		return dao.findExhibits(topicId);
	}
	
	
}
