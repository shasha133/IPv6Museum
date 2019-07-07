package museum.controller;

import museum.entity.Activity;
import museum.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/ActivityIntroduction")
public class ActivityIntroductionController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("/find")
    public String find(HttpServletRequest req) throws IOException {
        int  activityId = Integer.parseInt(req.getParameter("title"));//获取获取“展馆活动”页面发来的 activity_id
        Activity activity = activityService.find(activityId);//通过activity_id查询活动内容
        req.setAttribute("activity", activity);

        return "activityIntroduction";//返回页面
    }
}
