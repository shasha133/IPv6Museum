package com.IPv6Museum.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.IPv6Museum.dao.NewsDao;
import com.IPv6Museum.model.News;

public class NewsService {

	private NewsDao newsDao = new NewsDao();

	public List<News> getNewsTitleByThree() {

		List<News> list = newsDao.ListNews();
		List<News> listres = new ArrayList<>();
		int k = list.size();
		int l, m, n;
		Random random = new Random();

		do {
			l = random.nextInt(k);
			m = random.nextInt(k);
			n = random.nextInt(k);
		} while ((l == m) || (l == n) || (m == n));

		listres.add(list.get(l));
		listres.add(list.get(m));
		listres.add(list.get(n));

		return listres;
	}

	public News getNews(int news_id) {

		News news = newsDao.GetNewsByNews_id(news_id);

		return news;
	}

}
