package museum.controller;

import museum.entity.Activity;
import museum.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("/find")
    public String find(HttpServletRequest req) throws IOException {
        String pageLast = req.getParameter("pageLast");
        String pageNext = req.getParameter("pageNext");
        int curPage=1;
        List<Activity> activityList=activityService.findPageData(1,5);
        List<Activity> threeActivityList = activityService.findThreeActivity();

        //求最大页数
        List<Activity> allActivity=activityService.findAll();
        int maxPage=allActivity.size()/5+(allActivity.size()%5>0?1:0);


        if(pageLast!=null && pageNext==null){
            if(Integer.parseInt(pageLast)!=1){
                activityList = activityService.findPageData((Integer.parseInt(pageLast)-2)*5,5);
                curPage=Integer.parseInt(pageLast)-1;
            }
        }else if(pageLast==null && pageNext!=null){
            if(Integer.parseInt(pageNext)==maxPage){
                activityList = activityService.findPageData((Integer.parseInt(pageNext)-1)*5,5);
                curPage=maxPage;
            }else{
                activityList = activityService.findPageData(Integer.parseInt(pageNext)*5,5);
                curPage=Integer.parseInt(pageNext)+1;
            }
        }

        req.setAttribute("threeActivityList", threeActivityList);
        req.setAttribute("activityList", activityList);
        req.setAttribute("maxPage",maxPage);
        req.setAttribute("curPage",curPage);
        return "exhabitionActivity";
    }
}

