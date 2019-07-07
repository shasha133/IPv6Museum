package museum.dao;

import museum.entity.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectDao {
    public void delete(Integer collectId);
    public List<Collect> find();
    public Collect find(Collect collectId);
    public void deleteUser(String UserId);

    public List<Collect> findBy(@Param("ExhibitId") String str, @Param("UserId") String str1);

    public int getRowCount();
    public List<Collect> find(int StratLine, int size);
}
