package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/study01")
public class Study01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		String[] num_ = req.getParameterValues("num");
		String calc = req.getParameter("calc");
		int result = 0;

		for (int i = 0; i < num_.length; i++) {
			result += Integer.parseInt(num_[i]);
		}

		out.print(result);

	}

}
