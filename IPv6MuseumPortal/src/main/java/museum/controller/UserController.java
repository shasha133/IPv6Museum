package museum.controller;

import museum.entity.Activity;
import museum.entity.Exhibits;
import museum.entity.News;
import museum.entity.User;
import museum.service.ActivityService;
import museum.service.ExhibitsService;
import museum.service.NewsService;
import museum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ExhibitsService exhibitsService;

    /**
     * @param userId   是邮箱名字
     * @param password
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/toIndex")
    public String find(String userId, String password, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();
        if (userId == null || userService.find(userId) == null) {
            req.setAttribute("error", "1");
            return "front/login";
        }
        user = userService.find(userId);
        if (user.getUserPassword().equals(password) && user.getUserRoot().equals("max")) {
            req.getSession().setAttribute("User_Id", userId);
            req.getSession().setAttribute("User_root", "max");
            return loginToIndex(req);
        } else if (user.getUserPassword().equals(password) && user.getUserRoot().equals("min")) {
            req.getSession().setAttribute("User_Id", req.getParameter("username"));
            req.getSession().setAttribute("User_root", "min");
            return loginToIndex(req);
        } else {
            req.setAttribute("error", "1");
            return "front/login";
        }
    }


    public String loginToIndex(HttpServletRequest req) throws IOException {
        List<News> newsList = newsService.find();          //首页新闻
        List<Activity> activityList = activityService.find(); //首页最新活动
        List<Exhibits> exhibitsList = exhibitsService.findFour(); //首页经典藏品

        req.setAttribute("newsList", newsList);
        req.setAttribute("activityList", activityList);
        req.setAttribute("exhibitsList", exhibitsList);
        return "index";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest req) throws IOException {
        List<News> newsList = newsService.find();          //首页新闻
        List<Activity> activityList = activityService.find(); //首页最新活动
        List<Exhibits> exhibitsList = exhibitsService.findFour(); //首页经典藏品

        req.setAttribute("newsList", newsList);
        req.setAttribute("activityList", activityList);
        req.setAttribute("exhibitsList", exhibitsList);
        return "index";
    }
}























