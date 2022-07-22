package ism.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import ism.dao.UserDao;

public class DublicateEmailFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Todo -> filter -> DublicateEmailFilter -> destroy()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String email = request.getParameter("email");

		UserDao userDao = new UserDao();
		boolean flag = userDao.emailValidation(email);
		
		System.out.println("flag"+flag);
		if(flag==true) {
			chain.doFilter(request, response);
		}else {
			request.setAttribute("dublicateEmail", "This email is already exist");
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Todo -> filter -> DublicateEmailFilter -> init()");
	}

}
