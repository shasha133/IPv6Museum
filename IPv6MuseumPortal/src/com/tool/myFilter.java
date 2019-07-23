package com.tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class myFilter extends HttpServlet implements Filter {
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		    HttpServletResponse response = (HttpServletResponse) arg1;    
	        HttpServletRequest request=(HttpServletRequest)arg0;  
	        HttpSession session = request.getSession(true);    
	        String usercode =null;
	        String userroot =null;
	        usercode = (String) session.getAttribute("User_Id");
	        userroot = (String) session.getAttribute("User_root");
	        String url=request.getRequestURI();  
	        if((usercode==null && userroot=="min" )|| usercode.equals(""))  
	        {  
	            //�жϻ�ȡ��·����Ϊ���Ҳ��Ƿ��ʵ�¼ҳ���ִ�е�¼����ʱ��ת  
	            if(url!=null && !url.equals("") && url.indexOf("admin")>0)  
	            {  
	                response.sendRedirect("http://localhost:8088/Museum/Front/login.do");  
	                return ;  
	            }             
	        }  
	            //��ͨ����֤���û����ʼ���  
	            arg2.doFilter(arg0, arg1);  
	            return;  
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
