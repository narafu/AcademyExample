package com.newlecture.web.controller.admin.member.student;

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

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

@WebServlet("/admin/member/student/list")
public class ListContorollerMember extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 1;
		String page_ = request.getParameter("p");
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		MemberService service = new MemberService();

		try {

			List<Member> list = service.getMemberList(page);
			int count = service.getMemberCount();

			request.setAttribute("list", list);
			request.setAttribute("count", count);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("admin.member.student.list", request, response);

	}

}
