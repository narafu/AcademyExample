package review._0429.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review._0429.entity.NoticeView01;
import review._0429.service.NoticeService01;

@WebServlet("/review/_0429/controller/list01")
public class ListController01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<NoticeView01> list = new ArrayList();

		NoticeService01 service = new NoticeService01();
		try {
			list = service.getNoticeList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("list", list);
		req.getRequestDispatcher("/review/0429/list01.jsp").forward(req, resp);

	}

}
