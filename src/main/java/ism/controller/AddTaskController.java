package ism.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ism.bean.TaskBean;
import ism.dao.TaskDao;

public class AddTaskController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("taskName");
		String description = request.getParameter("taskDescription");
		String priority = request.getParameter("prority");
		String status = "pending";
		String endDate = request.getParameter("endDate");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();   
		
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		
		
		TaskBean taskBean = new TaskBean();
		taskBean.setTaskName(name);
		taskBean.setTaskDescription(description);
		taskBean.setPrority(priority);
		taskBean.setStatus(status);
		taskBean.setStartDate(dtf.format(now));
		taskBean.setEndDate(endDate);
		taskBean.setUserid(userId);
		
		TaskDao taskDao = new TaskDao();
		taskDao.addTask(taskBean);
		
		response.sendRedirect("AddTask.jsp");
	}

}
