package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/study04")
public class Study04 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String var_ = req.getParameter("var");
		String op_ = req.getParameter("op");

		int var = 0;
		int result = 0;

		if (var_ != null && !var_.equals(""))
			var = Integer.parseInt(var_);

		if (op_.equals("=")) {

			int x = (Integer) req.getSession().getAttribute("var");
			int y = var;
			String op = (String) req.getSession().getAttribute("op");

			if (op.equals("+"))
				result = x + y;
			else if (op.equals("-")) {
				result = x - y;
			}

			resp.getWriter().println(result);

		} else {

			req.getSession().setAttribute("var", var);
			req.getSession().setAttribute("op", op_);

			resp.getWriter().println(var + op_);

		}

	}

}
