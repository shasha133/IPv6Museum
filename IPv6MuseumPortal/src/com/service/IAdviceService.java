package com.service;

import com.museum.domain.Advice;

public interface IAdviceService {
	public void save(Advice advice);
	public void delete(Integer adviceId);
}
