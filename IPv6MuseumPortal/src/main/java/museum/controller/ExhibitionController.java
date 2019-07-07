package museum.controller;

import museum.entity.AccessExhibit;
import museum.entity.Exhibits;
import museum.service.ExhibitionService;
import museum.service.ExhibitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Exhibition")
public class ExhibitionController {

    @Autowired
    private ExhibitionService exhibitionService;

    @Autowired
    ExhibitsService exhibitsService;

    @RequestMapping("/show")
    public String show(HttpServletRequest req) throws IOException {
        return "hallExhibits";
    }

    @RequestMapping("/exhibitsRecommended")
    public String exhibitsRecommended(HttpServletRequest req) throws IOException {
        return "exhibitsRecommended";
    }


    @RequestMapping("/pathRecommond")
    public String pathRecommond(HttpServletRequest req) throws IOException {
        return "pathRecommond";
    }

    @RequestMapping("/recommended")
    public String recommended(HttpServletRequest req) throws IOException {
        String pageLast = req.getParameter("pageLast");
        String pageNext = req.getParameter("pageNext");
        String recommendedType = "Exhibits_upvote";
        recommendedType = req.getParameter("type");

        int curPage = 1;
        List<Exhibits> exhibitsList = exhibitionService.findPageDataRecommended(1, 8, recommendedType);

        //求最大页数
        List<Exhibits> allActivity = exhibitionService.findAll();
        int maxPage = allActivity.size() / 8 + (allActivity.size() % 8 > 0 ? 1 : 0);
        if (pageLast != null && pageNext == null) {
            if (Integer.parseInt(pageLast) != 1) {
                exhibitsList = exhibitionService.findPageDataRecommended((Integer.parseInt(pageLast) - 2) * 8, 8, recommendedType);
                curPage = Integer.parseInt(pageLast) - 1;
            }
        } else if (pageLast == null && pageNext != null) {
            if (Integer.parseInt(pageNext) == maxPage) {
                exhibitsList = exhibitionService.findPageDataRecommended((Integer.parseInt(pageNext) - 1) * 8, 8, recommendedType);
                curPage = maxPage;
            } else {
                exhibitsList = exhibitionService.findPageDataRecommended(Integer.parseInt(pageNext) * 8, 8, recommendedType);
                curPage = Integer.parseInt(pageNext) + 1;
            }
        }
        req.setAttribute("exhibitsList", exhibitsList);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("curPage", curPage);
        return "recommonded";
    }


    @RequestMapping("/hall")
    public String hall(HttpServletRequest req) throws IOException {
        String pageLast = req.getParameter("pageLast");
        String pageNext = req.getParameter("pageNext");
        String hallIdString = req.getParameter("hallId");
        if (hallIdString == null) {
            hallIdString = "1";
        }

        int hallId = Integer.parseInt(hallIdString);


        int curPage = 1;
        List<Exhibits> exhibitsList = exhibitionService.findPageDataHall(1, 8, hallId);

        //求最大页数
        List<Exhibits> allActivity = exhibitionService.findAll();
        int maxPage = allActivity.size() / 8 + (allActivity.size() % 8 > 0 ? 1 : 0);


        if (pageLast != null && pageNext == null) {
            if (Integer.parseInt(pageLast) != 1) {
                exhibitsList = exhibitionService.findPageDataHall((Integer.parseInt(pageLast) - 2) * 8, 8, hallId);
                curPage = Integer.parseInt(pageLast) - 1;
            }
        } else if (pageLast == null && pageNext != null) {
            if (Integer.parseInt(pageNext) == maxPage) {
                exhibitsList = exhibitionService.findPageDataHall((Integer.parseInt(pageNext) - 1) * 8, 8, hallId);
                curPage = maxPage;
            } else {
                exhibitsList = exhibitionService.findPageDataHall(Integer.parseInt(pageNext) * 8, 8, hallId);
                curPage = Integer.parseInt(pageNext) + 1;
            }
        }
        req.setAttribute("exhibitsList", exhibitsList);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("curPage", curPage);
        return "CollectionClassify";
    }


    @RequestMapping("/find")
    public String find(HttpServletRequest req) throws IOException {

        List<Exhibits> exhibitionHallOne = exhibitionService.find(1);
        List<Exhibits> exhibitionHallTwo = exhibitionService.find(2);
        List<Exhibits> exhibitionHallThree = exhibitionService.find(3);
        List<Exhibits> exhibitionHallFour = exhibitionService.find(4);
        List<Exhibits> exhibitionHallFive = exhibitionService.find(5);
        List<Exhibits> exhibitionHallSix = exhibitionService.find(6);

        req.setAttribute("exhibitionHallOne", exhibitionHallOne);
        req.setAttribute("exhibitionHallTwo", exhibitionHallTwo);
        req.setAttribute("exhibitionHallThree", exhibitionHallThree);
        req.setAttribute("exhibitionHallFour", exhibitionHallFour);
        req.setAttribute("exhibitionHallFive", exhibitionHallFive);
        req.setAttribute("exhibitionHallSix", exhibitionHallSix);

        return "ExhabitionHall";
    }

    @RequestMapping("/introduction")
    public String introduction(HttpServletRequest req) throws IOException {
        int exhibitsId = Integer.parseInt(req.getParameter("exhibitsId"));//获取展品id
        AccessExhibit accessExhibit=new AccessExhibit();
        accessExhibit.setUserId(String.valueOf(req.getSession().getAttribute("User_Id")));
        accessExhibit.setExhibitsId(exhibitsId);
        Exhibits exhibits=exhibitsService.findById(accessExhibit);
        req.setAttribute("exhibits", exhibits);//将查询到的内容放入Request发送给页面
        return "exhibitIntroduction";//发回页面
    }

}