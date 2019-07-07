package museum.dao;

import museum.entity.AccessExhibit;
import museum.entity.Exhibits;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExhibitsDao {
    public int  getRowCount();
    public List<Exhibits> findFour();
    public List<Exhibits> find(int hallId);
    public Exhibits findById(@Param("accessExhibit") AccessExhibit accessExhibit);

    public Exhibits findExhibits(int exhibitsId);
    public List<Exhibits> findAll();
    public List<Exhibits> findPageData(@Param("start")int start, @Param("size")int size, @Param("materiaId")int materiaId);

    public List<Exhibits> findPageDataFive(@Param("start")int start, @Param("size")int size);

    public List<Exhibits> findPageDataHall(@Param("start")int start, @Param("size")int size, @Param("hallId")int hallId);

    public List<Exhibits> findPageDataRecommended(@Param("start")int start, @Param("size")int size, @Param("type")String type);

    public List<Exhibits> findBy(@Param("Material")String str, @Param("Dynasty")String str1,@Param("Apply") String str2, @Param("Value")String str3, @Param("exhibitsName")String str4);
}
