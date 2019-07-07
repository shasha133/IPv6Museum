package museum.controller;

import museum.entity.Exhibits;
import museum.service.ExhibitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/exhibitionBoutique")
public class ExhibitionBoutiqueController {
    @Autowired
    ExhibitsService exhibitsService;

    @RequestMapping("/find")
    public String find(HttpServletRequest req) throws IOException {
        //查询数据
        List<Exhibits> exhibitsList = exhibitsService.findFour();
        //查询到的数据放入Request
        req.setAttribute("exhibitsList", exhibitsList);
        return "exhibitionBoutique";
    }
}
