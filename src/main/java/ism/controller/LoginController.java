package ism.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ism.bean.UserBean;
import ism.dao.UserDao;

public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.login(email, password);
		
		RequestDispatcher rd = null;
		if(userBean!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userBean.getUserId());;
			
			Cookie cookieEmail = new Cookie("email", userBean.getEmail());
			Cookie cookiePassword = new Cookie("passwrd", userBean.getPassword());
			
			response.addCookie(cookieEmail);
			response.addCookie(cookiePassword);
			
			rd = request.getRequestDispatcher("Home.jsp");
		}else {
			request.setAttribute("InvalidUser", "Invalide email or password");
			rd = request.getRequestDispatcher("Login.jsp");
		}
		rd.forward(request, response);
	}

}
