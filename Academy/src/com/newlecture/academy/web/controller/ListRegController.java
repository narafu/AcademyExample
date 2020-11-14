package com.newlecture.academy.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newlecture.academy.web.entity.List;
import com.newlecture.academy.web.service.ListService;

@WebServlet("/reg")
public class ListRegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("UTF-8");		
//		String title_ = request.getParameter("t");
//	    System.out.println(title_);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		InputStream is = request.getInputStream();

		Scanner scan = new Scanner(is, "UTF-8");
		String line = scan.nextLine();
		// json 문자열을 통째로 받아온다

//		Gson gson = new Gson();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		List list = gson.fromJson(line, List.class);

		ListService service = new ListService();
		List li = null;

		try {

			li = service.insertList(list);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); /* response.sendRedirect("/error?n=404"); */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String resultJson = gson.toJson(li);
		response.getWriter().write(resultJson);

	}
}