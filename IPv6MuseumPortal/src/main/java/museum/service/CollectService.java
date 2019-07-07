package museum.service;

import museum.entity.Collect;
import museum.entity.Page;

import java.util.List;

public interface CollectService {
    public void delete(Integer collectId);
    public List<Collect> find();
    public Collect find(Collect collectId);

    public void deleteUser(String UserId);
    public List<Collect> findBy(String str,String str1);

    public Page findPageData(int p, int size);
}
