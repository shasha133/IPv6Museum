package museum.dao;

import museum.entity.Comment;
import museum.entity.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {
    public void delete(Integer commentId);
    public void deleteReply(Integer replyId);
    public List<Comment> find();
    public List<Reply> findReply(@Param("commentId")Integer commentId);
    public List<Reply> findR();
    public List<Comment> findBy(@Param("commentId")String commentId, @Param("commenttime")String commenttime);
    public Comment Find(@Param("commentId")Integer commentId);
    public void update(Comment comment);
    public void saveR(@Param("reply")Reply reply);

    public int getRowCount();
    public List<Comment> find(@Param("startLine") int stratLine, @Param("size")int size);
}
