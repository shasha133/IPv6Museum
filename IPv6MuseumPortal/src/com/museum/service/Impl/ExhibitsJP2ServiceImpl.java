package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IExhibitsJP2Dao;
import com.museum.domain.Exhibits;
import com.museum.service.IExhibitsJP2Service;

@Service
@Transactional
public class ExhibitsJP2ServiceImpl implements IExhibitsJP2Service {

	@Autowired
	private IExhibitsJP2Dao dao;
	public void delete(Integer rid) {
		
	}

	public Exhibits find(Exhibits n) {
		return null;
	}

	public List<Exhibits> find() {
		return dao.find();
	}

	public void save(Exhibits n) {
		
	}

	public void update(Exhibits r) {
		
	}

}
