package museum.controller;

import museum.entity.Exhibits;
import museum.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/collections")
public class CollectionController {
    @Autowired
    ExhibitionService exhibitionService;

    @RequestMapping("/getCollections")
    public String getCollections(HttpServletRequest req){
        return "Collections";
    }

    @RequestMapping("/find")
    public String find(HttpServletRequest req) throws IOException {
        String pageLast = req.getParameter("pageLast");
        String pageNext = req.getParameter("pageNext");
        String materialIdString=req.getParameter("materialId");
        if(materialIdString==null){
            materialIdString = "1";
        }

        int materialId=Integer.parseInt(materialIdString);


        int curPage = 1;
        List<Exhibits> exhibitsList = exhibitionService.findPageData(1, 8,materialId);

        //求最大页数
        List<Exhibits> allActivity = exhibitionService.findAll();
        int maxPage = allActivity.size() / 8 + (allActivity.size() % 8 > 0 ? 1 : 0);


        if (pageLast != null && pageNext == null) {
            if (Integer.parseInt(pageLast) != 1) {
                exhibitsList = exhibitionService.findPageData((Integer.parseInt(pageLast) - 2) * 8, 8,materialId);
                curPage = Integer.parseInt(pageLast) - 1;
            }
        } else if (pageLast == null && pageNext != null) {
            if (Integer.parseInt(pageNext) == maxPage) {
                exhibitsList = exhibitionService.findPageData((Integer.parseInt(pageNext) - 1) * 8, 8,materialId);
                curPage = maxPage;
            } else {
                exhibitsList = exhibitionService.findPageData(Integer.parseInt(pageNext) * 8, 8,materialId);
                curPage = Integer.parseInt(pageNext) + 1;
            }
        }
        req.setAttribute("exhibitsList", exhibitsList);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("curPage", curPage);
        return "CollectionClassify";
    }
}
