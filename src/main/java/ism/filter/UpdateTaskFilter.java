package ism.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateTaskFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("Todo -> filter -> UpdateTaskFilter -> destroy()");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String name = request.getParameter("taskName");
		String description = request.getParameter("taskDescription");
		String priority = request.getParameter("prority");
		String status = "pending";
		String endDate = request.getParameter("endDate");
		
		boolean isError=false;
	
		
		if(name == null|| name.trim().length()==0) {
			request.setAttribute("taskNameError", "Please enter Task Name");
			isError=true;
		}else {
			request.setAttribute("taskNameValue", name);
		}
		
		if(description == null|| description.trim().length()==0) {
			request.setAttribute("taskDescriptionError", "Please enter Task Description");
			isError=true;
		}else {
			request.setAttribute("taskDescriptionValue", description);
		}
		
		if(priority == null|| priority.trim().length()==0) {
			request.setAttribute("priorityError", "Please enter Priority");
			isError=true;
		}else {
			request.setAttribute("priorityValue", priority);
		}
		
		if(endDate == null|| endDate.trim().length()==0) {
			request.setAttribute("endDateError", "Please enter End Date");
			isError=true;
		}else {
			request.setAttribute("endDateValue", endDate);
		}
		
		if(isError) {
			request.setAttribute("InvalidUser", "Please Enter every detail");
			request.getRequestDispatcher("UpdateTaskUseingTaskId.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) {
		System.out.println("Todo -> filter -> UpdateTaskFilter -> init()");
	}

}
