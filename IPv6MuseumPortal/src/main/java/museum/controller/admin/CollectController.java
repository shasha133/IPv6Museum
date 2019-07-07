package museum.controller.admin;


import museum.entity.Collect;
import museum.entity.Exhibits;
import museum.entity.Page;
import museum.service.CollectService;
import museum.service.ExhibitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/Collect")
public class CollectController {
    @Autowired
    private CollectService collectService;
    @Autowired
    private ExhibitsService exhibitsService;
    @RequestMapping("/list")
    public String findList(String p,String size,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        List<Collect> CollectList;
        Page pp=collectService.findPageData(Integer.parseInt(p),Integer.parseInt(size));
        CollectList=pp.getList();
        req.setAttribute("page",pp.getP());
        req.setAttribute("maxPage",pp.getMaxPage());
        req.setAttribute("list", CollectList);

        return "admin/Collect/Search";
    }

    @RequestMapping("/Exlist")
    public String findExList(String p,String size,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        List<Exhibits> ExhibitsList;
        Page pp=exhibitsService.findPageData(Integer.parseInt(p),Integer.parseInt(size));
        ExhibitsList=pp.getList();
        req.setAttribute("page",pp.getP());
        req.setAttribute("maxPage",pp.getMaxPage());
        req.setAttribute("list", ExhibitsList);
        return "admin/Collect";
    }

    @RequestMapping("/findBy")
    public String findBy(String page,String size,String UserId,String ExhibitId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        int p=Integer.parseInt(page);
        int s=Integer.parseInt(size);
        if (null == UserId && ExhibitId == null) {
            return findExList("1","5",req,resp);
        }
        List<Collect> SearchList=collectService.findBy(ExhibitId,UserId);
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
        req.setAttribute("UserId", UserId);
        req.setAttribute("ExhibitId",ExhibitId);
        req.setAttribute("page", p);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("SearchList", SearchList.subList(startIndext, stopIndext));
        return "admin/collectSearch";
    }

    @RequestMapping("/delete")
    public String delete(int[] id){
        for(int i:id){
            collectService.delete(i);
        }
        return "redirect:/manage/count.do";
    }
}

