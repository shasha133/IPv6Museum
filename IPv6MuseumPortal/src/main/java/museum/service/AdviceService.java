package museum.service;

import museum.entity.Advice;

public interface AdviceService {
    public void save(Advice advice);
    public void delete(Integer adviceId);
}
