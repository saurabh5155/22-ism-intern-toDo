package ism.filter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EndDateSetFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Todo -> filter -> EndDateSetFilter -> destroy()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String endDate = request.getParameter("endDate");

		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();   
		String date =	dtf.format(now);
		String date1[] = date.split("-");
		String endDate1[] = endDate.split("-");
		boolean flag = false;
		for (int i = 0; i < date1.length; i++) {
			System.out.println(date1[i]);
			System.out.println(endDate1[i]);
			if(Integer.parseInt(date1[i])<=Integer.parseInt(endDate1[i])) {
//				chain.doFilter(request, response);
				flag = true;
			}else {
//				request.setAttribute("gratterDate", "Please Enter Valid Date");
//				request.getRequestDispatcher("AddTask.jsp").forward(request, response);
				flag = false;
				break;
			}
		}
		if(flag) {
			chain.doFilter(request, response);
		}else {
			request.setAttribute("gratterDate", "Please Enter Valid Date");
			request.getRequestDispatcher("AddTask.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Todo -> filter -> EndDateSetFilter -> init()");
	}

}
