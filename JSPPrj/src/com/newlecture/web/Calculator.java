package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		String exp = "0";

		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>CalcPage</title>");
		out.write("</head>");
		out.write("	<style>");
		out.write("		input {");
		out.write("			width: 50px;");
		out.write("			height: 50px;}");
		out.write("		.output {");
		out.write("			height: 50px;");
		out.write("			background:  #e9e9e9;");
		out.write("			font-size: 40px;");
		out.write("			font-weight: bold;");
		out.write("			text-align: right;");
		out.write("			padding: 0px 10px;}");
		out.write("		.op {");
		out.write("			font-size: 20px;}");
		out.write("	</style>");
		out.write("<body>");
		out.write("	<form method=\"post\">");
		out.write("		<table>");
		out.write("			<tr>");
		out.printf("				<td class=\"output\" colspan=\"4\">%s</td>", exp);
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("			<td><input type=\"submit\" value=\"CE\" name=\"operator\"></td>");
		out.write("				<td><input type=\"submit\" value=\"C\" name=\"operator\"></td>");
		out.write("				<td><input type=\"submit\" value=\"бь\" name=\"operator\"></td>");
		out.write("				<td><input type=\"submit\" value=\"/\" name=\"operator\" class=\"op\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" value=\"7\" name=\"value\"></td>");
		out.write("				<td><input type=\"submit\" value=\"8\" name=\"value\"></td>");
		out.write("				<td><input type=\"submit\" value=\"9\" name=\"value\"></td>");
		out.write("				<td><input type=\"submit\" value=\"*\" name=\"operator\" class=\"op\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" value=\"4\" name=\"value\"></td>");
		out.write("				<td><input type=\"submit\" value=\"5\" name=\"value\"></td>");
		out.write("				<td><input type=\"submit\" value=\"6\" name=\"value\"></td>");
		out.write("				<td><input type=\"submit\" value=\"гн\" name=\"operator\" class=\"op\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\" value=\"1\" name=\"value\"></td>");
		out.write("				<td><input type=\"submit\" value=\"2\" name=\"value\"></td>");
		out.write("				<td><input type=\"submit\" value=\"3\" name=\"value\"></td>");
		out.write("				<td><input type=\"submit\" value=\"гл\" name=\"operator\" class=\"op\"></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td></td>");
		out.write("				<td><input type=\"submit\" value=\"0\" name=\"value\"></td>");
		out.write("				<td><input type=\"submit\" value=\".\" name=\"dot\"></td>");
		out.write("				<td><input type=\"submit\" value=\"=\" name=\"operator\" class=\"op\"></td>");
		out.write("			</tr>");
		out.write("		</table>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		String value = request.getParameter("value");
		String operater = request.getParameter("operater");
		String dot = request.getParameter("dot");
		String exp = "";

		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}

		if (operater != null && operater.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (operater != null && operater.equals("C")) {
			exp = "";
		} else {
			exp += (value == null) ? "" : value;
			exp += (operater == null) ? "" : operater;
			exp += (dot == null) ? "" : dot;
		}

		Cookie expCookie = new Cookie("exp", exp);
		if (operater != null && operater.equals("C"))
			expCookie.setMaxAge(0);

		expCookie.setPath("/calculator");
		response.addCookie(expCookie);
		response.sendRedirect("calculator");

	}
}