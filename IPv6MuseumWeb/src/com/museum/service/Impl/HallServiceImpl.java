package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IHallDao;
import com.museum.domain.Hall;
import com.museum.service.IHallService;


@Service
@Transactional
public class HallServiceImpl implements IHallService {

	@Autowired
	private IHallDao dao;
	
	public void delete(Integer rid) {
		
	}

	public Hall find(Hall n) {
		return null;
	}

	public List<Hall> find() {
		return dao.find();
	}

	public void save(Hall n) {
		
	}

	public void update(Hall r) {
		
	}

}
