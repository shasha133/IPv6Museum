package museum.service;

import museum.entity.Activity;
import museum.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityService {
    public void save(Activity n);
    //给index首页用的用与查最新到活动
    public List<Activity> find();
    //根据id查活动
    public Activity find(int activityId);
    public List<Activity> findAll();
    public void delete(Integer rid);
    public void update(Activity r);
    public List<Activity> findThreeActivity();
    public List<Activity> findPageData(int start, int size);
    public Page findPageDataOne(int p, int size, String type);
    public void updateImage(Activity r);
}
