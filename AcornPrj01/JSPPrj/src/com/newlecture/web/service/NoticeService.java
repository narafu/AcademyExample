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

//	public List<Notice> getNoticeList() throws ClassNotFoundException, SQLException {
//
//		return getNoticeList("title", "", 1);
//	}
//
//	public List<Notice> getNoticeList(int page) throws ClassNotFoundException, SQLException {
//
//		return getNoticeList("title", "", page);
//	}

	public List<NoticeView> getNoticeViewList(String field, String query, int page)
			throws ClassNotFoundException, SQLException {

		ArrayList<NoticeView> list = new ArrayList();
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, N.* FROM (SELECT * FROM NOTICE_VIEW WHERE " + field
				+ " LIKE ? ORDER BY REGDATE DESC) N) WHERE NUM BETWEEN ? AND ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, "%" + query + "%");
		ps.setInt(2, (page - 1) * 10 + 1);
		ps.setInt(3, (page - 1) * 10 + 10);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			NoticeView noticeView = new NoticeView(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("WRITER_ID"),
					rs.getString("CONTENT"), rs.getDate("REGDATE"), rs.getInt("HIT"), rs.getString("FILES"),
					rs.getInt("PUB"), rs.getInt("CMT_COUNT"));
			list.add(noticeView);
		}

		rs.close();
		ps.close();
		con.close();

		return list;
	}

//	public int getNoticeCount() throws ClassNotFoundException, SQLException {
//
//		return getNoticeCount("title", "");
//	}

	public int getNoticeCount(String field, String query) throws ClassNotFoundException, SQLException {

		int count = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE WHERE " + field + " LIKE ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, "%" + query + "%");

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			count = rs.getInt("COUNT");
		}

		rs.close();
		ps.close();
		con.close();

		return count;
	}

	public Notice getNotice(int id) throws ClassNotFoundException, SQLException {

		Notice notice = null;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			notice = new Notice(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("WRITER_ID"),
					rs.getString("CONTENT"), rs.getDate("REGDATE"), rs.getInt("HIT"), rs.getString("FILES"),
					rs.getInt("PUB"));
		}

		rs.close();
		ps.close();
		con.close();

		return notice;
	}

	public Notice getNextNotice(int id) throws ClassNotFoundException, SQLException {

		Notice next = null;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT ID, TITLE FROM (SELECT * FROM NOTICE WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID = ?) ORDER BY REGDATE ASC) WHERE ROWNUM = 1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			next = new Notice(rs.getInt("ID"), rs.getString("TITLE"));
		}

		rs.close();
		ps.close();
		con.close();

		return next;
	}

	public Notice getPrevNotice(int id) throws ClassNotFoundException, SQLException {

		Notice prev = null;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT ID, TITLE FROM (SELECT * FROM NOTICE WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID = ?) ORDER BY REGDATE DESC) WHERE ROWNUM = 1";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			prev = new Notice(rs.getInt("ID"), rs.getString("TITLE"));
		}

		rs.close();
		ps.close();
		con.close();

		return prev;
	}

	public int removeNoticeAll(int[] ids) throws ClassNotFoundException, SQLException {

		String param = "";
		for (int i = 0; i < ids.length; i++) {
			param += ids[i];
			if (i < ids.length - 1) {
				param += ", ";
			}
		}

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE NOTICE WHERE ID IN ( " + param + " )";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		int result = st.executeUpdate();

		return result;
	}

	public int pubNoticeAll(int[] ids) throws ClassNotFoundException, SQLException {

		String param = "";
		for (int i = 0; i < ids.length; i++) {
			param += ids[i];
			if (i < ids.length - 1) {
				param += ", ";
			}
		}

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "UPDATE NOTICE SET PUB = 1 WHERE ID IN ( " + param + " )";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		int result = st.executeUpdate();

		return result;
	}

	public int insertNotice(Notice notice) throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO NOTICE(ID, TITLE, CONTENT, WRITER_ID) VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?)";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement rs = con.prepareStatement(sql);
		rs.setString(1, notice.getTitle());
		rs.setString(2, notice.getContent());
		rs.setString(3, notice.getWriterId());

		int result = rs.executeUpdate();

		return result;
	}

	public int updateNotice(Notice notice) throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "UPDATE NOTICE SET TITLE = ?, CONTENT = ? WHERE ID = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		st.setInt(3, notice.getId());
		int result = st.executeUpdate();

		return result;
	}

	public int deleteNotice(int id) throws SQLException, ClassNotFoundException {

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE NOTICE WHERE ID = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		int result = st.executeUpdate();

		return result;
	}

	public List<Notice> getNoticeNewestList() {
		return null;
	}

}
