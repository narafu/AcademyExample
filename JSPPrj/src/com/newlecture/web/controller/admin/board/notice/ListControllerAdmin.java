package com.newlecture.web.controller.admin.board.notice;

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

@WebServlet("/admin/board/notice/list")
public class ListControllerAdmin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String field = "title";
		String query = "";
		int page = 1;

		String field_ = req.getParameter("f");
		if (field_ != null && !field_.equals("")) {
			field = field_;
		}

		String query_ = req.getParameter("q");
		if (query_ != null) {
			query = query_;
		}

		String page_ = req.getParameter("p");
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		NoticeService service = new NoticeService();

		try {

			List<NoticeView> list = service.getNoticeViewList(field, query, page);
			int count = service.getNoticeCount(field, query);
			req.setAttribute("list", list);
			req.setAttribute("count", count);
			req.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp").forward(req, resp);

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

		int[] openIds = null;
		int[] delIds = null;
		NoticeService service = new NoticeService();

		String[] openIds_ = req.getParameterValues("openId");
		if (openIds_ != null) {
			openIds = new int[openIds_.length];
			for (int i = 0; i < openIds_.length; i++) {
				openIds[i] = Integer.parseInt(openIds_[i]);
			}
		}

		String[] delIds_ = req.getParameterValues("delId");
		if (delIds_ != null) {
			delIds = new int[delIds_.length];
			for (int i = 0; i < delIds_.length; i++) {
				delIds[i] = Integer.parseInt(delIds_[i]);
			}
		}

		String cmd = req.getParameter("cmd");

		try {
			switch (cmd) {
			case "ÀÏ°ý°ø°³":
				int resultPub = service.pubNoticeAll(openIds);
				break;
			case "ÀÏ°ý»èÁ¦":
				int resultDel = service.removeNoticeAll(delIds);
				break;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect("list");

	}

}
