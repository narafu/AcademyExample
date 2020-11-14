package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc04")
public class Calc04 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
		String v_ = request.getParameter("v");
		String op = request.getParameter("op");

		int v = 0;
		int result = 0;

		if (v_ != null && !v_.equals(""))
			v = Integer.parseInt(v_);

		if (op.equals("=")) {

			int x = 0;
			for (Cookie c : cookies) {
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}

			int y = v;
			String operator = null;
			for (Cookie c : cookies) {
				if (c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}

			if (operator.equals("+"))
				result = x + y;
			else
				result = x - y;

			out.println(result);

		} else {

			Cookie valueCookie = new Cookie("value", String.valueOf(v)); // cookie는 문자열만 가질 수 있다.
			Cookie opCookie = new Cookie("op", op);

			// 클라이언트에게 전달
			valueCookie.setPath("/calc04"); // 쿠키 가져오는 조건 설정 ex) ("/") : 경우 모든 경우
			opCookie.setPath("/calc04");
			
			valueCookie.setMaxAge(60*60); // 몇초 동안 쿠키를 유지할지 ex) 24*60*60 : 1day
			
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc04.html");

		}
		
	}

}
