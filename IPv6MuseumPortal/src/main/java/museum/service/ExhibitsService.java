package museum.service;

import museum.entity.AccessExhibit;
import museum.entity.Exhibits;
import museum.entity.Page;

import java.util.List;

public interface  ExhibitsService {
    public void save(Exhibits n);
    public Exhibits findExhibits(int  exhibitsId);
    public void delete(Integer rid);
    public void update(Exhibits r);
    public List<Exhibits> findFour();
    public List<Exhibits> find();
    Page findPageData(int p, int size);
    public Exhibits findById(AccessExhibit accessExhibit);
}
