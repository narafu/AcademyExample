package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id_ = req.getParameter("id");
		int id = Integer.parseInt(id_);

		NoticeService service = new NoticeService();
		Notice n = null;
		Notice prev = null;
		Notice next = null;

		try {
			n = service.getNotice(id);
			prev = service.getPrevNotice(id);
			next = service.getNextNotice(id);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("n", n);
		req.setAttribute("prev", prev);
		req.setAttribute("next", next);
		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);

	}

}
