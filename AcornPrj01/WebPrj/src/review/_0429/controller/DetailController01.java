package review._0429.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review._0429.entity.Notice01;
import review._0429.service.NoticeService01;

@WebServlet("/review/_0429/controller/detail01")
public class DetailController01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Notice01 n = null;
		NoticeService01 service = new NoticeService01();
		
		String id = req.getParameter("id");

		try {
			n = service.getNotice(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("n", n);
		req.getRequestDispatcher("/review/0429/detail01.jsp").forward(req, resp);

	}
}
