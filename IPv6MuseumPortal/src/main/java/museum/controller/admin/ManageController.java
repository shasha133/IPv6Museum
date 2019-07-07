package museum.controller.admin;

import museum.entity.*;
import museum.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    private ExhibitionService exhibitionService;
    @Autowired
    private UserService userservice;
    @Autowired
    private RecordService recordservice;
    @Autowired
    private NewsService newservice;
    @Autowired
    private ActivityService activityservice;
    @Autowired
    private CollectService collectservice;
    @Autowired
    private CommentService commentservice;
    
    @RequestMapping("/count")
    public String count(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        List<Exhibits> eL=exhibitionService.findAll();
        List<Collect> cL=collectservice.find();
        List<Comment> coL=commentservice.find();
        List<User> uL=userservice.find();
        List<News> nL=newservice.find();
        List<Record> recL=recordservice.find();
        List<Activity> aL=activityservice.findAll();
        List<Reply>	repL=commentservice.findR();
        int e,e1 = 0,e2 = 0,e3 = 0,e4=0,e5=0,e6=0;
        int u,uc = 0,urc = 0;
        int ac,nc;
        int l1 = 0,l2 = 0,l3 = 0;
        int m1 = 0,m2 = 0;
        int Cc,Rc;
        int rc,cc;
        e=eL.size();
        u=uL.size();
        ac=aL.size();
        nc=nL.size();
        Cc=cL.size();
        Rc=recL.size();
        rc=repL.size();
        cc=coL.size();

        for(User U : uL){
            if("min".equals(U.getUserRoot())){
                uc=uc+1;
            }
            if("max".equals(U.getUserRoot())){
                urc=urc+1;
            }
        }
        for(Exhibits E : eL){
            if(E.getHallId()==1){
                e1=e1+1;
            }
            if(E.getHallId()==2){
                e2=e2+1;
            }
            if(E.getHallId()==3){
                e3=e3+1;
            }
            if(E.getHallId()==4){
                e4=e4+1;
            }
            if(E.getHallId()==5){
                e5=e5+1;
            }
            if(E.getHallId()==6){
                e6=e6+1;
            }
            if(E.getStateId()==1){
                m1=m1+1;
            }
            if(E.getStateId()==2){
                m2=m2+1;
            }
            if(E.getValueId()==1){
                l1=l1+1;
            }
            if(E.getValueId()==2){
                l2=l2+1;
            }
            if(E.getValueId()==3){
                l3=l3+1;
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(e);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(u);
        list.add(uc);
        list.add(urc);
        list.add(ac);
        list.add(nc);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(m1);
        list.add(m2);
        list.add(Cc);
        list.add(Rc);
        list.add(rc);
        list.add(cc);
        list.add(e4);
        list.add(e5);
        list.add(e6);
        req.setAttribute("list", list);
        List<Hall> hL=exhibitionService.findH();
        req.setAttribute("hL", hL);
        return "admin/index";
    }


    @RequestMapping("/list")
    public String findList(String p,String size,HttpServletRequest req,HttpServletResponse resp) throws Exception{

        List<Exhibits> ExhibitsList;
        Page pp=exhibitionService.findPageDataFive(Integer.parseInt(p),Integer.parseInt(size));
        ExhibitsList=pp.getList();
        req.setAttribute("page",pp.getP());
        req.setAttribute("maxPage",pp.getMaxPage());
        req.setAttribute("list", ExhibitsList);
        return "admin/exhibits";

    }

    @RequestMapping("/findBy")
    public String findBy(String page,String size,String Material,String Dynasty,String Apply,String Value,String exhibitsName,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        int p=Integer.parseInt(page);
        int s=Integer.parseInt(size);
        if(exhibitsName==null){
            exhibitsName="default";
        }

        List<Exhibits> SearchList=exhibitionService.findBy(Material,Dynasty,Apply,Value,exhibitsName);
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
        req.setAttribute("page", p);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("Material", Material);
        req.setAttribute("Dynasty", Dynasty);
        req.setAttribute("Apply", Apply);
        req.setAttribute("Value", Value);
        req.setAttribute("exhibitsName", exhibitsName);
        req.setAttribute("SearchList", SearchList.subList(startIndext, stopIndext));

        return "admin/ExhibitsSearch";
    }

    @RequestMapping("/findById")
    public String findById(Integer exhibitsId,String type,HttpServletRequest req,HttpServletResponse resp){
        AccessExhibit accessExhibit=new AccessExhibit();
        accessExhibit.setExhibitsId(exhibitsId);
        accessExhibit.setUserId(String.valueOf(req.getSession().getAttribute("User_Id")));
        Exhibits exhibits=exhibitionService.findById(accessExhibit);
        req.setAttribute("exhibits", exhibits);
        if(type.equals("1")){
            return "admin/ExhibitsInfo";
        }else{
            return "admin/Exhibitsupdate";

        }
    }

    @RequestMapping("/hall")
    public String hall(String page,String size,int hallId,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{

        int p=Integer.parseInt(page);
        int s=Integer.parseInt(size);


        List<Hall> hL=exhibitionService.findH();
        req.setAttribute("hL", hL);
        List<Exhibits> eL=exhibitionService.findAll();
        Iterator<Exhibits> it = eL.iterator();
        while(it.hasNext()){
            Exhibits x = it.next();
            if(x.getHallId()!=hallId){
                it.remove();
            }
        }
        int countList=eL.size();
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
        req.setAttribute("page", p);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("hallId", hallId);

        req.setAttribute("eL", eL);
        return "admin/HallExhibits";
    }


}
