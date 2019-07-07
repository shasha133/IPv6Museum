package museum.dao;

import museum.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {
    public User find(String userId);
    public List<User> findAll();
    public void save(User user);

    public int getRowCount();

    List<User> findPageData(@Param("startLine")int startLine, @Param("size") int size);
    List<User> findBy(@Param("userId")String userId, @Param("userName") String userName);


    public void update(@Param("user")User user);
    public void deleteUser(@Param("userId") String userId);


}
