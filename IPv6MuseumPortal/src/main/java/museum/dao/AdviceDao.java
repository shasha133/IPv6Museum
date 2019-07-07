package museum.dao;

import museum.entity.Advice;

public interface AdviceDao {
    public void delete(Integer adviceId);
    public void save(Advice advice);
}
