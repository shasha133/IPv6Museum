package museum.service.serviceImpl;

import museum.dao.ExhibitsDao;
import museum.entity.AccessExhibit;
import museum.entity.Exhibits;
import museum.entity.Page;
import museum.service.ExhibitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitsServiceImpl implements ExhibitsService {
    @Autowired
    private ExhibitsDao exhibitsDao;

    @Override
    public void save(Exhibits n) {

    }

    @Override
    public Exhibits findExhibits(int  exhibitsId) {
        return exhibitsDao.findExhibits(exhibitsId);
    }

    @Override
    public void delete(Integer rid) {

    }


    @Override
    public void update(Exhibits r) {

    }

    @Override
    public List<Exhibits> findFour() {
        return exhibitsDao.findFour();
    }

    @Override
    public List<Exhibits> find() {
        return exhibitsDao.findAll();
    }

    @Override
    public Exhibits findById(AccessExhibit accessExhibit) {
        return exhibitsDao.findById(accessExhibit);
    }


    @Override
    public Page findPageData(int p, int size) {
        int rowCount=exhibitsDao.getRowCount();
        Page page=new Page(p, rowCount, size);
        List<Exhibits> list=exhibitsDao.findPageDataFive(page.getStartLine(), page.getSize());
        page.setList(list);
        return page;
    }
}
