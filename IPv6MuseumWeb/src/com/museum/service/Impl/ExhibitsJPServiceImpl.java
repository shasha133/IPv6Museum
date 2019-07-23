package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IExhibitsJPDao;
import com.museum.domain.Exhibits;
import com.museum.service.IExhibitsJPService;

@Service
@Transactional
public class ExhibitsJPServiceImpl implements IExhibitsJPService {

	@Autowired
	private IExhibitsJPDao dao;
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
