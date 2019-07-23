package com.museum.service;

import java.util.List;

import com.museum.domain.Exhibits;

public interface IZhanGGSService {
	public void save(Exhibits n);
	public Exhibits find(Exhibits n);
	public void delete(Integer rid);
	public void update(Exhibits r);
	public List<Exhibits> find1();
	public List<Exhibits> find2();
	public List<Exhibits> find3();
	public List<Exhibits> find4();
	public List<Exhibits> find5();
	public List<Exhibits> find6();
}
