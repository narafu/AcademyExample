package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/study03")
public class Study03 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String var1_ = req.getParameter("var");
		String op1 = req.getParameter("op");
		int result = 0;

		int var1 = Integer.parseInt(var1_);

		if (op1.equals("=")) {

			int x = (Integer) req.getServletContext().getAttribute("var2");
			int y = var1;
			String op3 = (String) req.getServletContext().getAttribute("op2");

			if (op3.contentEquals("+"))
				result = x + y;
			else
				result = x - y;
			resp.getWriter().println("result is " + result);

		} else {

			req.getServletContext().setAttribute("var2", var1);
			req.getServletContext().setAttribute("op2", op1);
			resp.getWriter().println(var1 + op1);

		}

	}

}
