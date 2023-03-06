package review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberService01 {

	public List<Member01> getMemberList() throws SQLException, ClassNotFoundException {

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, M.* FROM MEMBER M) WHERE NUM BETWEEN 11 AND 20";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		List<Member01> list = new ArrayList<>();
		int index = 0;

		while (rs.next()) {

			Member01 member = new Member01(rs.getString("id"), rs.getInt("pwd"), rs.getString("name"),
					rs.getDate("birthday"), rs.getString("boss_id"));

			list.add(member);

		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

}
