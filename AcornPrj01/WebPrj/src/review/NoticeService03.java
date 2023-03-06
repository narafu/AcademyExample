package review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NoticeService03 {

	public List<Notice03> getNoticeList() throws ClassNotFoundException, SQLException {

		List<Notice03> list = new ArrayList<>();
		int index = 0;

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, N.* FROM NOTICE N) WHERE NUM BETWEEN 11 AND 20";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {

			Notice03 notice = new Notice03(rs.getString("id"), rs.getString("title"), rs.getString("content"),
					rs.getDate("regdate"), rs.getInt("hit"));

			list.add(notice);
		}

		return list;
	}

}
