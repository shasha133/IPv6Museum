package com.museum.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.dao.IHallDao;
import com.museum.dao.IZhanGGSDao;
import com.museum.domain.Exhibits;
import com.museum.domain.Hall;
import com.museum.service.IHallService;
import com.museum.service.IZhanGGSService;


@Service
@Transactional
public class ZhanGGSServiceImpl implements IZhanGGSService {

	@Autowired
	private IZhanGGSDao dao;

	public void delete(Integer rid) {
	}
	public Exhibits find(Exhibits n) {
		return null;
	}
	public List<Exhibits> find1() {
		return dao.find1();
	}
	public List<Exhibits> find2() {
		return dao.find2();
	}
	public List<Exhibits> find3() {
		return dao.find3();
	}
	public List<Exhibits> find4() {
		return dao.find4();
	}
	public List<Exhibits> find5() {
		return dao.find5();
	}
	public List<Exhibits> find6() {
		return dao.find6();
	}
	public void save(Exhibits n) {
	}
	public void update(Exhibits r) {
	}
	
}
