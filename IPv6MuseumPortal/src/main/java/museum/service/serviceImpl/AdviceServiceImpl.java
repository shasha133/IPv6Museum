package museum.service.serviceImpl;

import museum.dao.AdviceDao;
import museum.entity.Advice;
import museum.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdviceServiceImpl implements AdviceService {
    @Autowired
    AdviceDao adviceDao;
    @Override
    public void save(Advice advice) {
        adviceDao.save(advice);
    }

    @Override
    public void delete(Integer adviceId) {
        adviceDao.delete(adviceId);
    }
}
