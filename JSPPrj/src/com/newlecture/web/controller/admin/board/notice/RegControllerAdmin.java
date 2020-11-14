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
		/* location = "/tmp", // 일정량이 넘어서는 경우 디스크를 사용하여 임시저장소로 사용할 위치 : 절대경로를 써야한다. */
		fileSizeThreshold = 1024 * 1024, // 전송하는 크기가 1MB를 넘어가면, location으로
		maxFileSize = 1024 * 1024 * 50, // 파일 하나의 크기 제한(50MB)
		maxRequestSize = 1024 * 1024 * 50 * 5 // 전체 파일 크기 제한(250MB)
/* 이 설정만 하면 데이터가 전달된다. */
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

		Part filePart = req.getPart("file"); /* 파일 받아오기 */
		String fileName = filePart.getSubmittedFileName(); /* 파일 이름 받아오기 */
		
		InputStream fis = filePart.getInputStream(); /* 입력받기 위한 버퍼 */
		String realPath = req.getServletContext().getRealPath("/upload"); /* 파일 물리적 저장경로 얻기 */
		String filepath = realPath + File.separator /* 경로구분기호 */ + fileName;
		FileOutputStream fos = new FileOutputStream(filepath); 

//		int b;
//		while ((b = fis.read()) != -1) { /* 데이터를 byte단위로 읽고, 다 읽으면 -1을 반환한다. */
//			fos.write(b); /* 1바이트씩 읽는다. */
//		}

		byte[] buf = new byte[1024];
		int size;
		while ((size = fis.read(buf)) != -1) {
			/* fos.write(buf); */ /* 1024바이트 크기만큼 읽는다. */
			fos.write(buf, 0, size); /* 0부터 size만큼 읽는다. */
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
