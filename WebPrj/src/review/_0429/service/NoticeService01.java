package review._0429.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import review._0429.entity.Notice01;
import review._0429.entity.NoticeView01;

public class NoticeService01 {

	public Notice01 getNotice(String id) throws SQLException, ClassNotFoundException {

		Notice01 notice = null;

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {

			notice = new Notice01(rs.getString("ID"), rs.getString("TITLE"), rs.getString("CONTENT"),
					rs.getDate("REGDATE"), rs.getInt("HIT"), rs.getString("FILES"), rs.getBoolean("PUB"));

		}

		return notice;
	}

	public List<NoticeView01> getNoticeList() throws SQLException, ClassNotFoundException {

		List<NoticeView01> list = new ArrayList();

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE_VIEW WHERE NUM BETWEEN 1 AND 10";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		



		while (rs.next()) {

			NoticeView01 noticeView = new NoticeView01(rs.getString("ID"), rs.getString("TITLE"), rs.getString("CONTENT"),
					rs.getDate("REGDATE"), rs.getInt("HIT"), rs.getString("FILES"), rs.getBoolean("PUB"),
					rs.getInt("NUM"), rs.getString("NAME"), rs.getString("BOSS_NAME"));

			list.add(noticeView);
		}

		return list;

	}

}
