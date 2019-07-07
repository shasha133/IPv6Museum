package museum.service.serviceImpl;

import museum.dao.ActivityDao;
import museum.entity.Activity;
import museum.entity.Page;
import museum.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityDao activityDao;

    @Override
    public void save(Activity n) {
        activityDao.save(n);
    }

    @Override
    public List<Activity> find() {
        return activityDao.find();
    }

    @Override
    public Activity find(int activityId) {
        return activityDao.findById(activityId);
    }


    @Override
    public List<Activity> findAll() {
        return activityDao.findAll();
    }

    @Override
    public void delete(Integer rid) {
        activityDao.delete(rid);
    }

    @Override
    public void update(Activity r) {
        activityDao.update(r);
    }

    @Override
    public void updateImage(Activity r) {
        activityDao.updateImage(r);
    }

    @Override
    public List<Activity> findThreeActivity() {
        return activityDao.findThreeActivity();
    }

    @Override
    public List<Activity> findPageData(int start, int size) {
        return activityDao.findPageData(start,size);
    }

    @Override
    public Page findPageDataOne(int p, int size, String type) {
        int rowCount=activityDao.getRowCount();
        Page page=new Page(p, rowCount, size);
        List<Activity> list=activityDao.findPageDataOne(page.getStartLine(), page.getSize(),type);
        page.setList(list);
        return page;
    }//根据page进行分页操作
}
