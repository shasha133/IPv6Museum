package museum.dao;

import museum.entity.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityDao {
    public List<Activity> find();
    public Activity findById(@Param("activityId")int activityId);
    public List<Activity> findAll();
    public List<Activity> findThreeActivity();
    public List<Activity> findPageData(@Param("start")int start, @Param("size")int size);
    public List<Activity> findPageDataOne(@Param("start")int start, @Param("size")int size,@Param("type") String type);
    public int getRowCount();
    public void update(@Param("activity")Activity r);
    public void save(@Param("activity")Activity r);
    public void delete(@Param("activityId") int r);
    public void updateImage(@Param("activity")Activity r);

}
