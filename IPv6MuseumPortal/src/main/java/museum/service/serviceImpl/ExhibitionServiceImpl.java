package museum.service.serviceImpl;

import museum.dao.ExhibitsDao;
import museum.dao.HallDao;
import museum.entity.AccessExhibit;
import museum.entity.Exhibits;
import museum.entity.Hall;
import museum.entity.Page;
import museum.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExhibitionServiceImpl implements ExhibitionService {
    @Autowired
    ExhibitsDao  exhibitsDao;

    @Autowired
    HallDao hallDao;

    @Override
    public void save(Exhibits n) {

    }

    @Override
    public Exhibits findById( AccessExhibit accessExhibit) {
        return exhibitsDao.findById(accessExhibit);
    }



    @Override
    public void delete(Integer rid) {

    }

    @Override
    public void update(Exhibits r) {

    }


    @Override
    public List<Exhibits> find(int hallId) {
        return exhibitsDao.find(hallId);
    }

    @Override
    public List<Exhibits> findAll() {
        return exhibitsDao.findAll();
    }

    @Override
    public List<Exhibits> findPageDataHall(int start, int size, int hallId) {
        return exhibitsDao.findPageDataHall(start,size,hallId);
    }

    @Override
    public List<Exhibits> findPageData(int start, int size, int materiaId) {
        return exhibitsDao.findPageData(start,size,materiaId);
    }

    @Override
    public Page findPageDataFive(int p, int size) {

        int rowCount=exhibitsDao.getRowCount();
        Page page=new Page(p, rowCount, size);
        List<Exhibits> list=exhibitsDao.findPageDataFive(page.getStartLine(), page.getSize());
        page.setList(list);
        return page;
    }

    @Override
    public List<Exhibits> findPageDataRecommended(int start, int size, String type) {
        return exhibitsDao.findPageDataRecommended(start,size,type);
    }

    @Override
    public List<Hall> findH() {
        return hallDao.find();
    }

    @Override
    public List<Exhibits> findBy(String str, String str1, String str2,
                                 String str3, String str4) {

        return exhibitsDao.findBy(str, str1, str2, str3,str4);
    }


}
