package museum.service.serviceImpl;

import museum.dao.UserDao;
import museum.entity.Page;
import museum.entity.User;
import museum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public void save(User user) {
        userDao.save(user);
    }
    @Override
    public void deleteUser(String userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> find() {
        return userDao.findAll();
    }

    @Override
    public User find(String userId) {
        return userDao.find(userId);
    }

    @Override
    public List<User> findBy(String userId, String userName) {
        return userDao.findBy(userId,userName);
    }

    @Override
    public Page findPageData(int p, int size) {
        int rowCount=userDao.getRowCount();
        Page page=new Page(p, rowCount, size);
        List<User> list=userDao.findPageData(page.getStartLine(), page.getSize());
        page.setList(list);
        return page;
    }
}
