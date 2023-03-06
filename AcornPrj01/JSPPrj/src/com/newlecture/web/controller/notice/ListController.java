package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		NoticeService service = new NoticeService();
		List<NoticeView> list;
		int count;

		String field_ = req.getParameter("f");
		String field = "title";
		if (field_ != null && !field_.equals("")) {
			field = field_;
		}

		String query_ = req.getParameter("q");
		String query = "";
		if (query_ != null) {
			query = query_;
		}

		String page_ = req.getParameter("p");
		int page = 1;
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		try {
			list = service.getNoticeViewList(field, query, page);
			count = service.getNoticeCount(field, query);

			req.setAttribute("list", list);
			req.setAttribute("count", count);
			req.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(req, resp);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
