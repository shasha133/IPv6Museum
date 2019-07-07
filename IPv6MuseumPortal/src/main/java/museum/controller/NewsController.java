package museum.controller;

import museum.entity.News;
import museum.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @RequestMapping("/find")
    public String find(HttpServletRequest req) throws IOException {
        String pageLast = req.getParameter("pageLast");
        String pageNext = req.getParameter("pageNext");
        int curPage = 1;
        List<News> newsList = newsService.findPageData(1, 5);
        List<News> threeNewsList = newsService.findThreeNews();

        //求最大页数
        List<News> allNews = newsService.findAll();
        int maxPage = allNews.size() / 5 + (allNews.size() % 5 > 0 ? 1 : 0);


        if (pageLast != null && pageNext == null) {
            if (Integer.parseInt(pageLast) != 1) {
                newsList = newsService.findPageData((Integer.parseInt(pageLast) - 2) * 5, 5);
                curPage = Integer.parseInt(pageLast) - 1;
            }
        } else if (pageLast == null && pageNext != null) {
            if (Integer.parseInt(pageNext) == maxPage) {
                newsList = newsService.findPageData((Integer.parseInt(pageNext) - 1) * 5, 5);
                curPage = maxPage;
            } else {
                newsList = newsService.findPageData(Integer.parseInt(pageNext) * 5, 5);
                curPage = Integer.parseInt(pageNext) + 1;
            }
        }

        req.setAttribute("threeNewsList", threeNewsList);
        req.setAttribute("newsList", newsList);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("curPage", curPage);
        return "exhabitionNews";
    }
}
