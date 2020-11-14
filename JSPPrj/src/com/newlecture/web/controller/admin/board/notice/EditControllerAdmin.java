package com.newlecture.web.controller.admin.board.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/edit")
public class EditControllerAdmin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		NoticeService service = new NoticeService();
		try {

			Notice n = service.getNotice(id);
			req.setAttribute("n", n);
			req.getRequestDispatcher("/WEB-INF/view/admin/board/notice/edit.jsp").forward(req, resp);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		NoticeService service = new NoticeService();
		Notice notice = new Notice(id, title, content);

		try {

			int result = service.updateNotice(notice);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect("detail?id=" + id);

	}
}
