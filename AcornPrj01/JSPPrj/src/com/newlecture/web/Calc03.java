package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc03")
public class Calc03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");

		int v = 0;
		int result = 0;

		if (v_ != null && !v_.equals(""))
			v = Integer.parseInt(v_);

		if (op.equals("=")) {

			int x = (Integer) session.getAttribute("value");
			int y = v;
			String operator = (String) session.getAttribute("op");

			if (operator.equals("+"))
				result = x + y;
			else
				result = x - y;

			out.println(result);

		} else {
			session.setAttribute("value", v);
			session.setAttribute("op", op);
		}

	}

}
