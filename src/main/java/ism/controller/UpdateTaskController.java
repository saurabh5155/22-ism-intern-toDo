package ism.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.TaskBean;
import ism.dao.TaskDao;

public class UpdateTaskController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int taskId =Integer.parseInt( request.getParameter("taskId"));
		
		TaskDao taskDao = new TaskDao();
		TaskBean taskBean = taskDao.updateTaskUseingTaskId(taskId);
		
		request.setAttribute("taskBean", taskBean);
		request.setAttribute("taskId", taskId);
		request.getRequestDispatcher("UpdateTaskUseingTaskId.jsp").forward(request, response);
	}

}
