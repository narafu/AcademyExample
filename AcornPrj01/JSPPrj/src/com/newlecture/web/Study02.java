package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.jfr.ContentType;

@WebServlet("/study02")
public class Study02 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = resp.getWriter();
		
		String[] num_ = req.getParameterValues("num");
		String op = req.getParameter("op");
		int result = 0;

		switch (op) {

		case "+":
			for (int i = 0; i < num_.length; i++)
				result += Integer.parseInt(num_[i]);
			break;
		case "-":
			for (int i = 0; i < num_.length; i++)
				result -= Integer.parseInt(num_[i]);
			break;

		}


		out.write("<!DOCTYPE html>");
		out.write("	<html>");
		out.write("	<head>");
		out.write("	<meta charset=\"UTF-8\">");
		out.write("	<title>Insert title here</title>");
		out.write("	</head>");
		out.write("	<body>");
		out.write("		<form action=\"study02\" method=\"post\">");
		out.write("			<fieldset>");
		out.write("				<legend>계산프로그램</legend>");
		out.write("				<input type=\"text\" name=\"num\">");
		out.write("               <input type=\"text\" name=\"num\">");
		out.write("               <input type=\"text\" name=\"num\">");
		out.write("               <input type=\"submit\" value=\"+\" name=\"op\">");
		out.write("				<input type=\"submit\" value=\"-\" name=\"op\">");
		out.println(result);
		out.write("			</fieldset>");
		out.write("		</form>");
		out.write("	</body>");
		out.write("	</html>");

	}
}
