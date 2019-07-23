package com.museum.service;

import java.util.List;

import com.museum.domain.Exhibits;

public interface IExhibitsJPService {
	public void save(Exhibits n);
	public Exhibits find(Exhibits n);
	public void delete(Integer rid);
	public void update(Exhibits r);
	public List<Exhibits> find();
}
