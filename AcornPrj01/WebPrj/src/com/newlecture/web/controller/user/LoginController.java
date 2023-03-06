package com.newlecture.web.controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.newlecture.web.service.MemberService;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("member.login", request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// ����ڰ� �������� ID, PW Ȯ��

		String uid = request.getParameter("username");
		String pwd = request.getParameter("password");
		MemberService memberService = new MemberService();

		try {

			if (memberService.isValid(uid, pwd) == false) {
				String msg = "<script>" + "alert('���̵� �Ǵ� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.');" + "location.href='login';" + "</script>";
				// response.sendRedirect("login?e=1");
				response.getWriter().println(msg);

			} else {

				// request.getServletContext();
				HttpSession session = request.getSession();
				session.setAttribute("uid", uid);
				
				MemberService service = new MemberService();
				String role = service.getRoleByUserId(uid);
				session.setAttribute("role", role);
				
				String returnURL = request.getParameter("returnURL");

				if (returnURL != null && !returnURL.equals(""))
					response.sendRedirect(returnURL);
				else
					response.sendRedirect("../index");

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
