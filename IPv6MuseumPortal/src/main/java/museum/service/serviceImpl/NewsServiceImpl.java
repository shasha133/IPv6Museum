package museum.service.serviceImpl;

import museum.dao.NewsDao;
import museum.entity.Activity;
import museum.entity.News;
import museum.entity.News;
import museum.entity.Page;
import museum.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> find() {
        return newsDao.find();
    }

    @Override
    public News find(int newsId) {
        return newsDao.findById(newsId);
    }


    @Override
    public List<News> findAll() {
        return newsDao.findAll();
    }

    @Override
    public List<News> findThreeNews() {
        return newsDao.findThreeNews();
    }

    @Override
    public List<News> findPageData(int start, int size) {
        return newsDao.findPageData(start,size);
    }

    @Override
    public Page findPageDataOne(int p, int size) {
        int rowCount=newsDao.getRowCount();
        Page page=new Page(p, rowCount, size);
        List<News> list=findPageData(page.getStartLine(), page.getSize());
        page.setList(list);
        return page;
    }

    @Override
    public void save(News n) {
        newsDao.save(n);
    }

    @Override
    public void delete(Integer rid) {
        newsDao.delete(rid);
    }

    @Override
    public void update(News r) {
        newsDao.update(r);
    }

   
}
