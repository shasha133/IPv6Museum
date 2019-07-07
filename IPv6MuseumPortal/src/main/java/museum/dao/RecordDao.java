package museum.dao;

import museum.entity.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordDao {
    public void delete(Integer recordId);
    public List<Record> find(@Param("startLine")int startLine, @Param("size") int size);
    public List<Record> find();
    public Record find(Integer recordId);
    public List<Record> findBy(@Param("ExhibitId") String ExhibitId, @Param("UserId") String UserId);
    public void deleteUser(String userId);
    public int getRowCount();
    public void insert(@Param("record") Record record);

}
