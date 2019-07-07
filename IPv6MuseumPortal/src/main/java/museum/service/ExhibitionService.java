package museum.service;

import museum.entity.AccessExhibit;
import museum.entity.Exhibits;
import museum.entity.Hall;
import museum.entity.Page;

import java.util.List;

public interface ExhibitionService {
        public void save(Exhibits n);
        public Exhibits findById( AccessExhibit accessExhibit);
        public void delete(Integer rid);
        public void update(Exhibits r);
        public List<Exhibits> find(int hallId);

        public List<Exhibits> findAll();

        public List<Exhibits> findPageDataHall(int start, int size,int materiaId);
        public List<Exhibits> findPageData(int start, int size,int materiaId);

        public Page findPageDataFive(int start, int size);
        public List<Exhibits> findPageDataRecommended(int start, int size,String type);
        public List<Hall> findH();

        public List<Exhibits> findBy(String str, String str1, String str2, String str3, String str4);
        
        
}
