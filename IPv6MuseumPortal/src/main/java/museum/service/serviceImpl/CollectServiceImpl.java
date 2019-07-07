package museum.service.serviceImpl;

import museum.dao.CollectDao;
import museum.entity.Collect;
import museum.entity.Page;
import museum.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectDao dao;

    public List<Collect> find() {
        return dao.find();
    }

    public Collect find(Collect collectId) {
        return dao.find(collectId);
    }

    public void delete(Integer collectId) {
        dao.delete(collectId);
    }

    public List<Collect> findBy(String str, String str1) {
        return dao.findBy(str, str1);
    }

    public Page findPageData(int p, int size) {
        int rowCount = dao.getRowCount();
        Page page = new Page(p, rowCount, size);
        List<Collect> list = dao.find(page.getStartLine(), page.getSize());
        page.setList(list);
        return page;
    }

    public void deleteUser(String UserId) {
        dao.deleteUser(UserId);

    }


}

