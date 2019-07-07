package museum.service;

import museum.entity.News;
import museum.entity.News;
import museum.entity.Page;

import java.util.List;

public interface NewsService {
    public void save(News n);
    public List<News> find();
    //根据id查活动
    public News find(int activityId);
    public List<News> findAll();
    public void delete(Integer rid);
    public void update(News r);
    public List<News> findThreeNews();
    public List<News> findPageData(int start, int size);
    public Page findPageDataOne(int p, int size);
    
}
