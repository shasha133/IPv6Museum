package com.museum.service;

import java.util.List;

import com.museum.domain.Collect;
import com.museum.domain.Exhibits;
import com.museum.domain.User;

public interface IcollectionService {
	public void save(Collect collect);
	public List<Collect> find(String userId);
	public void delete(Integer collectId);
	public void update(Exhibits exhibits);
	public Exhibits finde(int exhibitsId);
	public User findu(String userid);
}
