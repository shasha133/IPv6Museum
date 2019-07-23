package com.museum.service;

import java.util.List;

import com.museum.domain.Comment;
import com.museum.domain.Exhibits;
import com.museum.domain.User;

public interface IMyCommentService {
	public void save(User n);
	public User find(User n);
	public void delete(Integer rid);
	public void update(User r);
	public List<Comment> find(String str);
	public Exhibits findExhibits(Integer topicId);
}
