package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id_ = request.getParameter("id");
		int id = Integer.parseInt(id_);

		Notice n = null;
		NoticeService service = new NoticeService();
		try {

			n = service.getNotice(id); // model: 출력할 데이터

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List list = new ArrayList();
		list.add(3);
		list.add("Hello");
		request.setAttribute("list", list);

//		response.sendRedirect("");
		request.setAttribute("n", n);
//		request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);

		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("notice.detail", request, response);

	}
}
