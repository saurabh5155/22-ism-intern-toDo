package ism.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("Todo -> filter -> LoginFilter -> destroy()");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean isError=false;
		
		
		if(password == null|| password.trim().length()==0) {
			request.setAttribute("passwordError", "Please enter password");
			isError=true;
		}else {
			request.setAttribute("passwordValue", password);
		}
		
		if(email==null||email.trim().length()==0) {
			request.setAttribute("emailError", "Please enter email");
			isError=true;
		}else {
			request.setAttribute("emailValue", email);
		}
		
		if(isError) {
			System.out.println("LoginFilter");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Todo -> filter -> LoginFilter -> init()");
	}

}
