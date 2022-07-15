package ism.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SignupFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Todo -> filter -> SignupFilter() -> destroy() ");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String Que = request.getParameter("que");
		String answer = request.getParameter("answer");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Todo -> filter -> SignupFilter() -> init()");
	}

}
