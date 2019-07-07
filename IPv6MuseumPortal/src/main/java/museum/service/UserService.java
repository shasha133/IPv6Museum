package museum.service;

import museum.entity.Page;
import museum.entity.User;

import java.util.List;

public interface UserService {
    public void save(User user);
    public void deleteUser(String userId);
    public void update(User user);
    public List<User> find();
    public User find(String userId);


    public List<User> findBy(String str,String str1);

    public Page findPageData(int p, int size);
}
