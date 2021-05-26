package com.bookstore.controller.admin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    
    public AdminLoginFilter() {
    }

	
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		HttpSession session=httpServletRequest.getSession(false);
		
		boolean loggedIn=session!=null && session.getAttribute("useremail")!=null;
		String loginURI=httpServletRequest.getContextPath() + "/admin/login";
		boolean loginRequest=httpServletRequest.getRequestURI().equals(loginURI);
		boolean loginPage=httpServletRequest.getRequestURI().endsWith("login.jsp");

		if(loggedIn &&( loginRequest || loginPage))
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response);
		}
		else if(loggedIn || loginRequest)
		{
			System.out.println("user login");
			chain.doFilter(request, response);
		}
		else
		{
			System.out.println("user not login");

			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
