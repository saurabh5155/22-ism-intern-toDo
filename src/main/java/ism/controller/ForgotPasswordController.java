package ism.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.UserBean;
import ism.dao.UserDao;

public class ForgotPasswordController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String Que = request.getParameter("que");
		String answer = request.getParameter("answer");
		
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.forgotPassword(email, Que, answer);
		
//		System.out.println(userBean.getEmail());
		RequestDispatcher rd = null;
		if(userBean!=null) {
			request.setAttribute("email", userBean.getEmail());
			rd = request.getRequestDispatcher("ForgotPasswordEnterPassword.jsp");
		}else {
			rd = request.getRequestDispatcher("ForgotPassword.jsp");
		}
		rd.forward(request, response);
	}

}
