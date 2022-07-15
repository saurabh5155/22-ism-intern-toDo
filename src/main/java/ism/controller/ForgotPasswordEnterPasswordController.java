package ism.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.UserBean;
import ism.dao.UserDao;

public class ForgotPasswordEnterPasswordController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(email);
		System.out.println(password);
		UserDao userDao = new UserDao();
		boolean flag=userDao.updatePassword(email,password);
		if(flag=true) {
		request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
