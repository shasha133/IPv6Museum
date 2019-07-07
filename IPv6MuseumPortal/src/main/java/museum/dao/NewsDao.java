package museum.dao;

import museum.entity.News;
import museum.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsDao {
    public List<News> find();
    public int getRowCount();
    public News findById(@Param("newsId")int newsId);
    public List<News> findAll();
    public List<News> findThreeNews();
    public List<News> findPageData(@Param("start")int start, @Param("size")int size);
    public void delete(@Param("newsId") Integer rid);
    public void save(@Param("news") News news);
    public void update(@Param("news") News news);

}
