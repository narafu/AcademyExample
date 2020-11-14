package opgg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opgg.entity.RankingList;
import opgg.service.ListService;

@WebServlet("/opgg")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<RankingList> list = null;
		String mfg = req.getParameter("mfg");
		
		ListService service = new ListService();
		
		try {
			list = service.getItemList(mfg);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("list", list);
		req.getRequestDispatcher("/opgg/opgg.jsp").forward(req, resp);

	}

}
