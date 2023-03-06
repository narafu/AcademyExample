package com.newlecture.web.controller.admin.board.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@MultipartConfig(
		/* location = "/tmp", // �������� �Ѿ�� ��� ��ũ�� ����Ͽ� �ӽ�����ҷ� ����� ��ġ : �����θ� ����Ѵ�. */
		fileSizeThreshold = 1024 * 1024, // �����ϴ� ũ�Ⱑ 1MB�� �Ѿ��, location����
		maxFileSize = 1024 * 1024 * 50, // ���� �ϳ��� ũ�� ����(50MB)
		maxRequestSize = 1024 * 1024 * 50 * 5 // ��ü ���� ũ�� ����(250MB)
/* �� ������ �ϸ� �����Ͱ� ���޵ȴ�. */
)
@WebServlet("/admin/board/notice/reg")
public class RegControllerAdmin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writerId = "news";

		Part filePart = req.getPart("file"); /* ���� �޾ƿ��� */
		String fileName = filePart.getSubmittedFileName(); /* ���� �̸� �޾ƿ��� */
		
		InputStream fis = filePart.getInputStream(); /* �Է¹ޱ� ���� ���� */
		String realPath = req.getServletContext().getRealPath("/upload"); /* ���� ������ ������ ��� */
		String filepath = realPath + File.separator /* ��α��б�ȣ */ + fileName;
		FileOutputStream fos = new FileOutputStream(filepath); 

//		int b;
//		while ((b = fis.read()) != -1) { /* �����͸� byte������ �а�, �� ������ -1�� ��ȯ�Ѵ�. */
//			fos.write(b); /* 1����Ʈ�� �д´�. */
//		}

		byte[] buf = new byte[1024];
		int size;
		while ((size = fis.read(buf)) != -1) {
			/* fos.write(buf); */ /* 1024����Ʈ ũ�⸸ŭ �д´�. */
			fos.write(buf, 0, size); /* 0���� size��ŭ �д´�. */
		}

		Notice notice = new Notice(title, content, writerId);
		NoticeService service = new NoticeService();
		try {
			int result = service.insertNotice(notice);
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
