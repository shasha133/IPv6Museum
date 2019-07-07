package museum.controller;

import museum.entity.User;
import museum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

@Controller
@RequestMapping("/front")
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("error", "2");
        return "front/login";
    }

    @RequestMapping("/intoForget")
    public String intoForget(HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("error", "2");
        return "front/forget";
    }

    @RequestMapping("/registerStart")
    public String registerStart(HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("error", "2");
        return "front/register";
    }

    /**
     * 接受注册信息，并向邮箱发出验证信息。
     * @param user
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/register")
    public String saveUser(User user, HttpServletRequest req, HttpServletResponse resp){
        if(userService.find(user.getUserId())!=null){
            req.setAttribute("error1","1");
            return "front/register";
        }else{
            try{
                //发送方
                String MyId="yxg19960215@163.com";
                String Mypassword="a124578369";

                Properties props = new Properties();
                props.setProperty("mail.transport.protocol", "smtp");
                props.setProperty("mail.host","smtp.163.com");
                props.setProperty("mail.smtp.auth","true");

                Session session=Session.getInstance(props);
                MimeMessage msg = new MimeMessage(session);
                Address address = new InternetAddress("yxg19960215@163.com");

                //发送方和接收方
                msg.setFrom(address);
                msg.setRecipients(Message.RecipientType.TO,user.getUserId());
                msg.setSubject("用户注册");
                String str="您在网站上注册的信息为：\r\n" +
                        "账号："+user.getUserId()+"\r\n"+
                        "用户名为："+user.getUserName()+"\r\n"+
                        "密码为："+user.getUserPassword()+"\r\n"+
                        "点击下面链接激活账号，请尽快激活！ \r\n"+
                        "\"http://192.168.43.140:8082/front/saveUser?userId="+user.getUserId()
                        +"&userName="+user.getUserName()+
                        "&userPassword="+user.getUserPassword()
                        ;

                msg.setText(str);
                msg.saveChanges();
                Transport ts=session.getTransport();
                ts.connect(MyId, Mypassword);
                ts.sendMessage(msg, msg.getAllRecipients());
                ts.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            return "front/login";
        }
    }

    /**
     * 邮箱确认，然后把用户信息保存进数据库
     * @param user
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/saveUser")
    public String skip(User user,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        user.setUserImage("/resourcesOne/images/headPortrait.jpg");
        user.setUserRoot("min");
        userService.save(user);
        return "front/login";
    }

    /**
     * 密码忘记，通过邮箱显示密码
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/forget")
    public String forget(String userId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
        if(userId==null||userService.find(userId)==null){
            req.setAttribute("error","1");
            return "front/forget";
        }
        try{
            User user=new User();
            user=userService.find(userId);
            String MyId="yxg19960215@163.com";
            String Mypassword="a124578369";

            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host","smtp.163.com");
            props.setProperty("mail.smtp.auth","true");

            Session session=Session.getInstance(props);
            MimeMessage msg = new MimeMessage(session);
            Address address = new  InternetAddress("yxg19960215@163.com");
            msg.setFrom(address);
            msg.setRecipients(Message.RecipientType.TO,userId);

            msg.setSubject("忘记密码");
            String str="您在网站注册的信息为：\r\n" +
                    "账号："+user.getUserId()+"\r\n"+
                    "用户名为："+user.getUserName()+"\r\n"+
                    "密码为："+user.getUserPassword()+"\r\n"+
                    "点击链接返回登录界面   \"http://192.168.42.243:8080/front/login"
                    ;
            msg.setText(str);
            msg.saveChanges();
            Transport ts=session.getTransport();
            ts.connect(MyId, Mypassword);
            ts.sendMessage(msg, msg.getAllRecipients());
            ts.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/front/login";
    }

}
