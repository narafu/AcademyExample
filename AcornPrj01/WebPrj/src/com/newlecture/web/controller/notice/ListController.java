package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 1;
		String page_ = request.getParameter("p");

		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		NoticeService service = new NoticeService();

		try {

			List<NoticeView> list = service.getNoticeList(page);

			request.setAttribute("list", list);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		request.getRequestDispatcher("/notice/list.jsp").forward(request, response);

		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("notice.list", request, response);

	}

}
