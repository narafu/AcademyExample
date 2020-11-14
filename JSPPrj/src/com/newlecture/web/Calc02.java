package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc02")
public class Calc02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8");
		ServletContext application = request.getServletContext();
		PrintWriter out = response.getWriter();

		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");

		int v = 0;
		int result = 0;

		if (v_ != null && !v_.equals(""))
			v = Integer.parseInt(v_);

		if (op.equals("=")) {

			int x = (Integer) application.getAttribute("value");
			int y = v;
			String operator = (String) application.getAttribute("op");

			if (operator.equals("+"))
				result = x + y;
			else
				result = x - y;

			out.println(result);

		} else {
			application.setAttribute("value", v);
			application.setAttribute("op", op);
		}

//		void setAttribute(String name, Object value)
		// 지정된 이름으로 객체를 설정
//		Object getAttribute(String name)
		// 지정된 이름으로 객체를 반환
//		void invalidate()
		// 세션에서 사용되는 객체들을 바로 해제

	}

}
