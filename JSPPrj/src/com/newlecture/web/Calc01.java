package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc01")
public class Calc01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8");

		String[] num_ = request.getParameterValues("num");
		String calc = request.getParameter("calc");

		int result = 0;

		switch (calc) {

		case "µ¡¼À":
			for (int i = 0; i < num_.length; i++)
				result += Integer.parseInt(num_[i]);
			break;
		case "»¬¼À":
			for (int i = 0; i < num_.length; i++)
				result -= Integer.parseInt(num_[i]);
			break;

		}

		response.getWriter().println(result);

	}

}
