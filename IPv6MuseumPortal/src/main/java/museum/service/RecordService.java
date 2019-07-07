package museum.service;

import museum.entity.Page;
import museum.entity.Record;

import java.util.List;

public interface RecordService {
    public void delete(Integer recordId);
    public List<Record> find();
    public Record find(Integer recordId);
    public List<Record> findBy(String str,String str1);
    public void deleteUser(String userId);
    public Page findPageData(int p, int size);
}
