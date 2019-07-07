package museum.controller.admin;

import museum.entity.*;
import museum.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Controller
@RequestMapping("/Exhibits")
public class ExhibitsController {
    @Autowired
    private ExhibitsService exhibitsService;
    @Autowired
    ExhibitionService exhibitionService;
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
    @RequestMapping("/list")
    public String findList(String p, String size, HttpServletRequest req, HttpServletResponse resp) throws Exception{
        List<Exhibits> ExhibitsList;
        Page pp=exhibitsService.findPageData(Integer.parseInt(p),Integer.parseInt(size));
        ExhibitsList=pp.getList();
        req.setAttribute("page",pp.getP());
        req.setAttribute("maxPage",pp.getMaxPage());
        req.setAttribute("list", ExhibitsList);
        return "admin/exhibits";
    }

    @RequestMapping("/hall")
    public String hall(String page,String size,int hallId,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        int p=Integer.parseInt(page);
        int s=Integer.parseInt(size);


        List<Hall> hL=exhibitionService.findH();
        req.setAttribute("hL", hL);
        List<Exhibits> eL=exhibitsService.find();
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
        req.setAttribute("page", p);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("hallId", hallId);
        req.setAttribute("eL", eL);
        return "admin/HallExhibits";
    }

//    @RequestMapping("/findBy")
//    public String findBy(String page,String size,String Material,String Dynasty,String Apply,String Value,String exhibitsName,HttpServletRequest req,HttpServletResponse resp) throws Exception{
//        resp.setCharacterEncoding("utf-8");
//        req.setCharacterEncoding("utf-8");
//        int p=Integer.parseInt(page);
//        int s=Integer.parseInt(size);
//        if(exhibitsName==null){
//            exhibitsName="default";
//        }
//        List<Exhibits> SearchList=exhibitsService.findBy(Material,Dynasty,Apply,Value,exhibitsName);
//        int countList=SearchList.size();
//        int maxPage=(int) Math.ceil((countList*1.0/s));
//        if(p>maxPage) p=maxPage;
//        if(p<1)p=1;
//        int startIndext = 0;
//        int stopIndext = 0;
//        startIndext=(p-1)*s;
//        if((startIndext+5)>countList){
//            stopIndext=countList;
//        }else{
//
//            stopIndext=startIndext+5;
//        }
//        req.setAttribute("page", p);
//        req.setAttribute("maxPage", maxPage);
//        req.setAttribute("Material", Material);
//        req.setAttribute("Dynasty", Dynasty);
//        req.setAttribute("Apply", Apply);
//        req.setAttribute("Value", Value);
//        req.setAttribute("exhibitsName", exhibitsName);
//        req.setAttribute("SearchList", SearchList.subList(startIndext, stopIndext));
//
//        return "admin/Exhibits/Search";
//    }

    @RequestMapping("/findById")
    public String findById(Integer exhibitsId,String type,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        AccessExhibit accessExhibit=new AccessExhibit();
        accessExhibit.setUserId(String.valueOf(req.getSession().getAttribute("User_Id")));
        accessExhibit.setExhibitsId(exhibitsId);
        Exhibits exhibits=exhibitsService.findById(accessExhibit);
        req.setAttribute("exhibits", exhibits);
        if(type.equals("1")){
            return "admin/Exhibits/ExhibitsInfo";
        }else{
            return "admin/Exhibits/Exhibitsupdate";

        }
    }
    @RequestMapping("/save")
    public String save(Integer exhibitsId,Exhibits exhibits,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
//        exhibits.setApply(exhibitsService.finda(applyId));
//        exhibits.setDynasty(exhibitsService.findd(dynastyId));
//        exhibits.setValue(exhibitsService.findv(valueId));
//        exhibits.setMaterial(exhibitsService.finm(materialId));
//        exhibits.setReligion(exhibitsService.findr(religionId));
//        exhibits.setState(exhibitsService.finds(stateId));
//        exhibits.setNation(exhibitsService.findn(nationId));
//        exhibits.setHall(exhibitsService.findh(hallId));
        exhibitsService.save(exhibits);
        req.setAttribute("exhibits", exhibits);
        return "admin/Exhibits/up";
    }
    @RequestMapping("/update")
    public String update(int materialId,int dynastyId,int applyId,int valueId
            ,int religionId,int stateId,int nationId,int hallId,Exhibits exhibits){
        exhibitsService.update(exhibits);
        return "redirect:/Exhibits/count.do";
    }

    @RequestMapping("/delete")
    public String delete(int[] id){
        for(int i:id){
            System.out.println(i);
            exhibitsService.delete(i);
        }
        return "redirect:/Exhibits/count.do";
    }
    @RequestMapping("/saveinfo")
    public String saveinfo(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
        return "admin/ExhibitsSave";
    }

    @RequestMapping("/count")
    public String count(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        List<Exhibits> eL=exhibitsService.find();
        List<Collect> cL=collectservice.find();
        List<Comment> coL=commentservice.find();
        List<User> uL=userservice.find();
        List<News> nL=newservice.find();
        List<Record> recL=recordservice.find();
        List<Activity> aL=activityservice.find();
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
            if(E.getHall().getHallId()==1){
                e1=e1+1;
            }
            if(E.getHall().getHallId()==2){
                e2=e2+1;
            }
            if(E.getHall().getHallId()==3){
                e3=e3+1;
            }
            if(E.getHall().getHallId()==4){
                e4=e4+1;
            }
            if(E.getHall().getHallId()==5){
                e5=e5+1;
            }
            if(E.getHall().getHallId()==6){
                e6=e6+1;
            }
            if(E.getState().getStateId()==1){
                m1=m1+1;
            }
            if(E.getState().getStateId()==2){
                m2=m2+1;
            }
            if(E.getValue().getValueId()==1){
                l1=l1+1;
            }
            if(E.getValue().getValueId()==2){
                l2=l2+1;
            }
            if(E.getValue().getValueId()==3){
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
        return "admin/index";
    }

    @RequestMapping("/Count")
    public String Count(HttpServletRequest req,HttpServletResponse resp,String User_Id,String User_root) throws UnsupportedEncodingException{
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        System.out.println(User_root);
        req.getSession().setAttribute("User_Id", User_Id);
        req.getSession().setAttribute("User_root", User_root);
        return "redirect:/Exhibits/count.do";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder bin){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor cust = new CustomDateEditor(sdf,true);
        bin.registerCustomEditor(Date.class,cust);
    }
}
