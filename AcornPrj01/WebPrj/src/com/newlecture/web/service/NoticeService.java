package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class NoticeService {

	public List<NoticeView> getNoticeList(int page) throws SQLException, ClassNotFoundException {

		List<NoticeView> list = new ArrayList<>();

//		String url = "jdbc:oracle:thin:@192.168.0.79:1521/xepdb1";
//		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM `Notice` ORDER BY regdate DESC LIMIT 10 OFFSET ?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, 10 * (page - 1));
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			NoticeView noticeView = new NoticeView(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("writerId"),
					rs.getDate("REGDATE"), rs.getInt("HIT"), rs.getString("FILES"),
//					rs.getString("WRITER_NAME"),
//					rs.getInt("CMT_COUNT"), 
					rs.getBoolean("PUB"));

			list.add(noticeView);

		}

		rs.close();
		st.close();
		con.close();

		return list;

	}

	public Notice getNotice(int id) throws ClassNotFoundException, SQLException {

		Notice notice = null;

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM Notice WHERE id = ?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			notice = new Notice(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("writerId"),
					rs.getString("CONTENT"), rs.getDate("REGDATE"), rs.getInt("HIT"), rs.getString("FILES"),
					rs.getBoolean("PUB"));
		}

		rs.close();
		st.close();
		con.close();

		return notice;

	}

	public int insertNotice(Notice notice) throws ClassNotFoundException, SQLException {

		int result = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "INSERT INTO Notice(writerId, title, content, files) VALUES(?,?,?,?)";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getWriterId());
		st.setString(2, notice.getTitle());
		st.setString(3, notice.getContent());
		st.setString(4, notice.getFiles());
		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	public int updateNotice(Notice notice) throws SQLException, ClassNotFoundException {

		int result = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "UPDATE Notice SET title = ?, content = ? WHERE id = ?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		st.setInt(3, notice.getId());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	public int deleteNotice(int id) throws SQLException, ClassNotFoundException {

		int result = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "DELETE FROM Notice WHERE id = ?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, id);

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

}
