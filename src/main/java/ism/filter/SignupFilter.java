package ism.filter;

import java.io.IOException;

import javax.naming.ldap.Rdn;
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
		
		boolean isError=false;
		
		
			if(firstName==null || firstName.trim().length()==0) {
				request.setAttribute("firstNameError", "Please Enter Firstname");
				isError=true;
			}else {			
				request.setAttribute("firstNameValue", firstName);
			}
			
			if(lastName == null || lastName.trim().length()==0) {
				request.setAttribute("lastNameError", "Please enter lastname");
				isError=true;
			}else {
				request.setAttribute("lastNameValue", lastName);	
			}
			
			if(email==null||email.trim().length()==0) {
				request.setAttribute("emailError", "Please enter email");
				isError=true;
			}else {
				request.setAttribute("emailValue", email);
			}
			
			if(gender==null||gender.trim().length()==0) {
				request.setAttribute("genderError", "Please enter gender");
				isError=true;
			}else {
				request.setAttribute("genderValue", gender);
			}
			
			if(password == null|| password.trim().length()==0) {
				request.setAttribute("passwordError", "Please enter password");
				isError=true;
			}else {
				request.setAttribute("passwordValue", password);
			}
		

			if(Que==null || Que.trim().length()==0) {
				request.setAttribute("QueError", "Please Enter Que");
				isError=true;
			}else {			
				request.setAttribute("QueValue", Que);
			}
			

			if(answer==null || answer.trim().length()==0) {
				request.setAttribute("answerError", "Please Enter ans");
				isError=true;
			}else {			
				request.setAttribute("answerValue", answer);
			}
		if(isError) {
			System.out.println("SignupFilter");
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Todo -> filter -> SignupFilter() -> init()");
	}

}
