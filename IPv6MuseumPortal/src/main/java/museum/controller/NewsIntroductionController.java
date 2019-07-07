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
@RequestMapping("/newsIntroduction")
public class NewsIntroductionController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("/find")
    public String find(HttpServletRequest req) {
        int newsId = Integer.parseInt(req.getParameter("title"));
        News news = newsService.find(newsId);
        req.setAttribute("news", news);
        return "newsIntroduction";
    }
}
