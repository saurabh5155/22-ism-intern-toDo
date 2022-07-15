package ism.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ism.bean.TaskBean;
import ism.dao.TaskDao;

public class ListTaskController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		TaskDao taskDao = new TaskDao();
		ArrayList<TaskBean> task=	taskDao.listTasks(userId);
		request.setAttribute("task", task);
		
		
		
		request.getRequestDispatcher("ListTask.jsp").forward(request, response);
	}

}
