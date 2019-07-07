package museum.service.serviceImpl;

import museum.dao.RecordDao;
import museum.entity.Page;
import museum.entity.Record;
import museum.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao dao;
    public void delete(Integer recordId) {
        dao.delete(recordId);
    }

    public List<Record> find() {
        return dao.find();
    }

    public Record find(Integer recordId) {
        return dao.find(recordId);
    }

    public List<Record> findBy(String str, String str1) {
        return dao.findBy(str, str1);
    }

    public Page findPageData(int p, int size) {
        int rowCount=dao.getRowCount();
        Page page=new Page(p, rowCount, size);
        List<Record> list=dao.find(page.getStartLine(), page.getSize());
        page.setList(list);
        return page;
    }

    public void deleteUser(String userId) {
        dao.deleteUser(userId);
    }
}
