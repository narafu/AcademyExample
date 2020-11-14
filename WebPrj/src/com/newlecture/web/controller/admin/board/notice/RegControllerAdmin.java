package com.newlecture.web.controller.admin.board.notice;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, // �ӽõ����� - "1mb�� ������ ��ũ�� �־��"
		maxFileSize = 100 * 1024 * 1024, maxRequestSize = 300 * 1024 * 1024 // byte ����
)

@WebServlet("/admin/board/notice/reg")
public class RegControllerAdmin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
//		container.render("admin.board.notice.reg", request, response);

		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("UTF-8");
		response.setCharacterEncoding("text/html; charset=utf-8");

		String writerId = "test";
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String fileNames = "";
		Collection<Part> parts = request.getParts();

		for (Part part : parts) {

			String fileName = "";
			String name = part.getName(); // key ��

			if (!name.equals("file"))
				continue;

			// ���ε��� ���� �����ϱ�

//		Part part = request.getPart("file"); /* �������� ��� */
			fileName = part.getSubmittedFileName();
			// fileName = request.getPart("file").getSubmittedFileName();

			// �����->�ý���(����)���
			String path = request.getServletContext().getRealPath("/upload");
			path += File.separator + fileName;
			part.write(path);
			fileNames += fileName;
			fileNames += ",";
		}

		fileNames = fileNames.substring(0, fileNames.length() - 1);

		// ������ ���
		Notice notice = new Notice();
		notice.setWriterId(writerId);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setFiles(fileNames);

		NoticeService service = new NoticeService();

		try {

			service.insertNotice(notice);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("list");
	}

}
