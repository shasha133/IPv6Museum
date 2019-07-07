package museum.aop;

import museum.dao.RecordDao;
import museum.entity.AccessExhibit;
import museum.entity.Record;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Browser {
    @Autowired
    RecordDao recordDao;

    @Pointcut("execution(* museum.dao.ExhibitsDao.findById(museum.entity.AccessExhibit))"+
            "&&args(accessExhibit)")
    public void findExhibitById(AccessExhibit accessExhibit){}

    @Before("findExhibitById(accessExhibit)")
    public void exeQueryErrorLog(AccessExhibit accessExhibit){
        Record record=new Record();
        record.setRecordExhibitId(accessExhibit.getExhibitsId());

        record.setUserId(accessExhibit.getUserId());
        recordDao.insert(record);
    }
}
