package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Ex01_Index extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int count = 10;
		
		// �ΰ� ����  ex) /hello?c=3 -> 3�� ���
		String count_ = req.getParameter("cnt");
		if(count_ != null && !count_.equals(""))
			count = Integer.parseInt(count_);
		
		resp.setCharacterEncoding("UTF-8"); // "UTF-8 ���ڵ����� ������."
		resp.setContentType("text/html; charset = UTF-8");
		// "������ Ÿ���� �������̴�."
		// "UTF-8�� �о�~"
		
		PrintWriter out = resp.getWriter();
		
		for (int i = 0; i < count; i++)
			out.println("�ȳ� World <br>"); // '?'�� ������ ���� �۾�, '��' ���� �۾��� �ٸ� ����ڵ�� ���� ��
		
		out.println("<a href=\"hello.html\">��û������</a>");
		
		// Http�� 2���� ���: Get, Post
		
	
	}
}