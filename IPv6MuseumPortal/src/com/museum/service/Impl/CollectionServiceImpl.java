package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.ICollection;
import com.museum.domain.Collect;
import com.museum.domain.Exhibits;
import com.museum.domain.User;
import com.museum.service.IcollectionService;

@Service
@Transactional
public class CollectionServiceImpl implements IcollectionService{
	@Autowired
	private ICollection dao;
	public void delete(Integer collectId) {
		dao.delete(collectId);
	}
 
	public List<Collect> find(String userId) {
		// TODO Auto-generated method stub
		return dao.find(userId);
	}
 
	public Exhibits finde(int exhibitsId) {
		// TODO Auto-generated method stub
		return dao.finde(exhibitsId);
	}
 
	public void save(Collect collect) {
		// TODO Auto-generated method stub
		dao.save(collect);
	}
 
	public void update(Exhibits exhibits) {
		// TODO Auto-generated method stub
		dao.update(exhibits);
	}

	@Override
	public User findu(String userId) {
		// TODO Auto-generated method stub
		return dao.findu(userId);
	}



}
