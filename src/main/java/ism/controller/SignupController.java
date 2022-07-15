package ism.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.UserBean;
import ism.dao.UserDao;

public class SignupController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String Que = request.getParameter("que");
		String answer = request.getParameter("answer");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserBean userBean = new UserBean();
		userBean.setFirstname(firstName);
		userBean.setLastName(lastName);
		userBean.setGender(gender);
		userBean.setAnswer(answer);
		userBean.setQue(Que);
		userBean.setEmail(email);
		userBean.setPassword(password);
		
		UserDao userDao = new UserDao();
		userDao.addUser(userBean);
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);;
	}

}
