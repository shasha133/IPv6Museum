package museum.controller.admin;

import museum.entity.Advice;
import museum.entity.Comment;
import museum.entity.Page;
import museum.entity.Reply;
import museum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class ACommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/list")
    public String findList(String p, String size, HttpServletRequest req, HttpServletResponse resp) throws Exception{
        List<Comment> CommentList;
        Page pp=commentService.findPageData(Integer.parseInt(p),Integer.parseInt(size));
        CommentList=pp.getList();
        req.setAttribute("page",pp.getP());
        req.setAttribute("maxPage",pp.getMaxPage());
        req.setAttribute("list", CommentList);
        return "admin/Comment";
    }

    @RequestMapping("/findBy")
    public String findBy(String page,String size,String type,String commentId,String commentTime,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        int p=Integer.parseInt(page);
        int s=Integer.parseInt(size);
        if(commentId==null){
            commentId="default";
        }
        if(commentTime==null){
            commentTime="default";
        }
        List<Comment> SearchList=commentService.findBy(commentId, commentTime);
        int countList=SearchList.size();
        int maxPage=(int) Math.ceil((countList*1.0/s));
        if(p>maxPage) p=maxPage;
        if(p<1)p=1;
        int startIndext = 0;
        int stopIndext = 0;
        startIndext=(p-1)*s;
        if((startIndext+5)>countList){
            stopIndext=countList;
        }else{

            stopIndext=startIndext+5;
        }
        req.setAttribute("page", p);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("commentTime", commentTime);
        req.setAttribute("commentId", commentId);
        req.setAttribute("SearchList", SearchList.subList(startIndext, stopIndext));
        return "admin/CommentSearch";
    }

    //未实现
    @RequestMapping("/findById")
    public String findById(Integer commentId,String id,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        Comment comment=commentService.Find(commentId);
        if(comment.getCommentState()==0){
            comment.setCommentState(1);
            Advice advice=new Advice();
            advice.setAdviceCheckState("未查看");
            advice.setCommentId(commentId);
            advice.setAdviceState("未通过");
        }else{
            comment.setCommentState(0);
            Advice advice=new Advice();
            advice.setAdviceCheckState("未查看");
            advice.setCommentId(commentId);
            advice.setAdviceState("通过");
        }
        return "redirect:/comment/list?p=1&size=5";
    }
    @RequestMapping("/reply")
    public void reply(Integer commentId,Reply reply,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        reply.setComment(commentService.Find(commentId));
        reply.setFromUid(String.valueOf(req.getSession().getAttribute("User_Id")));
        reply.setToUid(commentService.Find(commentId).getFromUid());
        reply.setReplyTime(new Date());
        commentService.saveR(reply);
    }

    //进行回复
    @RequestMapping("/replySkip")
    public String replySkip(Integer commentId,HttpServletRequest req,HttpServletResponse resp){
        List<Reply> rL = commentService.findReply(commentId);
        req.setAttribute("comment", commentService.Find(commentId).getCommentContent());
        req.setAttribute("replyList", rL);
        req.setAttribute("commentId", commentId);
        return "admin/CommentReply";
    }


    @InitBinder
    public void initBinder(ServletRequestDataBinder bin){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor cust = new CustomDateEditor(sdf,true);
        bin.registerCustomEditor(Date.class,cust);
    }
}
