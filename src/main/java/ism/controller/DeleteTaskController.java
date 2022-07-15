package ism.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.dao.TaskDao;

public class DeleteTaskController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int taskId =Integer.parseInt( request.getParameter("taskId"));
		
		TaskDao taskDao = new TaskDao();
		boolean flag = taskDao.deleteTask(taskId);
		
		response.sendRedirect("ListTaskController");
	}

}
