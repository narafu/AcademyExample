package review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NoticeService04 {

	public List<NoticeView> getNoticeList() throws ClassNotFoundException, SQLException {

		List<NoticeView> list = new ArrayList<>();
		int index = 0;

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE_VIEW WHERE NUM BETWEEN 11 AND 20";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {

			NoticeView noticeView = new NoticeView(rs.getInt("NUM"), rs.getString("ID"), rs.getString("NAME"),
					rs.getString("BOSS_NAME"), rs.getString("TITLE"), rs.getString("CONTENT"), rs.getDate("REGDATE"),
					rs.getInt("HIT"));

			list.add(noticeView);

		}

		return list;
	}

}
