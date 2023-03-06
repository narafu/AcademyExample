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
		
		// 부가 질의  ex) /hello?c=3 -> 3번 출력
		String count_ = req.getParameter("cnt");
		if(count_ != null && !count_.equals(""))
			count = Integer.parseInt(count_);
		
		resp.setCharacterEncoding("UTF-8"); // "UTF-8 인코딩으로 보낸다."
		resp.setContentType("text/html; charset = UTF-8");
		// "컨텐츠 타입이 웹문서이다."
		// "UTF-8로 읽어~"
		
		PrintWriter out = resp.getWriter();
		
		for (int i = 0; i < count; i++)
			out.println("안녕 World <br>"); // '?'는 완전히 깨진 글씨, '뿯' 등의 글씨는 다른 언어코드로 읽은 것
		
		out.println("<a href=\"hello.html\">요청페이지</a>");
		
		// Http의 2가지 방식: Get, Post
		
	
	}
}