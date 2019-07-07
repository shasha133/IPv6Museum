package museum.service.serviceImpl;

import museum.dao.CommentDao;
import museum.entity.Comment;
import museum.entity.Page;
import museum.entity.Reply;
import museum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentserviceImpl implements CommentService {
    @Autowired
    private CommentDao dao;

    public void delete(Integer commentId) {
        dao.delete(commentId);
    }

    public List<Comment> find() {
        return dao.find();
    }

    public List<Reply> findReply(Integer commentId) {
        return dao.findReply(commentId);
    }

    public List<Comment> findBy(String commentId, String commenttime) {
        return dao.findBy(commentId, commenttime);
    }

    public Page findPageData(int p, int size) {
        int rowCount=dao.getRowCount();
        Page page=new Page(p, rowCount, size);
        List<Comment> list=dao.find(page.getStartLine(), page.getSize());
        page.setList(list);
        return page;
    }

    public void deleteReply(Integer replyId) {
        dao.deleteReply(replyId);

    }

    public List<Reply> findR() {

        return dao.findR();
    }

    public Comment Find(Integer commentId) {
        // TODO Auto-generated method stub
        return dao.Find(commentId);
    }

    public void update(Comment comment) {
        // TODO Auto-generated method stub
        dao.update(comment);
    }

    public void saveR(Reply reply) {
        dao.saveR(reply);
    }

}
