package museum.controller.admin;

import museum.entity.Page;
import museum.entity.User;
import museum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/adminuser")
public class AUserController {
    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public String findList(String p, String size, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<User> UsersList;
        Page pp = userService.findPageData(Integer.parseInt(p), Integer.parseInt(size));
        UsersList = pp.getList();
        req.setAttribute("page", pp.getP());
        req.setAttribute("maxPage", pp.getMaxPage());
        req.setAttribute("list", UsersList);
        return "admin/user";
    }


    @RequestMapping("/findBy")
    public String findBy(String page, String size, String userId, String userName, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int p = Integer.parseInt(page);
        int s = Integer.parseInt(size);
        if (null == userName && userName == null) {
            return findList("1","5",req,resp);
        }
        List<User> searchList = userService.findBy(userId, userName);
        int countList = searchList.size();
        int maxPage = (int) Math.ceil((countList * 1.0 / s));
        if (p > maxPage) p = maxPage;
        if (p < 1) p = 1;
        int startIndext = 0;
        int stopIndext = 0;
        startIndext = (p - 1) * s;
        if ((startIndext + 5) > countList) {
            stopIndext = countList;
        } else {

            stopIndext = startIndext + 5;
        }
        req.setAttribute("page", p);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("userId", userId);
        req.setAttribute("userName", userName);
        req.setAttribute("searchList", searchList.subList(startIndext, stopIndext));
        return "admin/usersearch";
    }

    @RequestMapping("/findById")
    public String findById(String userId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        User user=userService.find(userId);
        req.setAttribute("user", user);
        return "admin/UserUpdate";
    }

    @RequestMapping("/update")
    public String update(User user,HttpServletRequest req){
        System.out.println(req.getCharacterEncoding());
        String name=req.getParameter("userName");
        userService.update(user);
        return "redirect:/manage/count";
    }

    @RequestMapping("/delete")
    public String delete(String[] id){
        for(String i:id){
            userService.deleteUser(i);
        }
        return "redirect:/manage/count";
    }
}
