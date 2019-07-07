package museum.service;

import museum.entity.Comment;
import museum.entity.Page;
import museum.entity.Reply;

import java.util.List;

public interface CommentService {
    public void delete(Integer commentId);
    public void deleteReply(Integer replyId) ;
    public List<Comment> find();
    public List<Reply> findReply(Integer commentId);

    public List<Reply> findR();
    public Comment Find(Integer commentId);
    public void update(Comment comment);
    public void saveR(Reply reply);

    public Page findPageData(int p, int size);
    public List<Comment> findBy(String commentId, String commentTime);
}
