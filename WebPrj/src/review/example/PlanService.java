package review.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanService {

	public List<Plan> getPlanList() throws ClassNotFoundException, SQLException {

		List<Plan> list = new ArrayList<Plan>();

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM PLAN";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {

			Plan plan = new Plan(rs.getInt("NUM"), rs.getString("SUBJECT"), rs.getString("DAY"), rs.getDate("DATE"), rs.getString("CONTENT"), rs.getString("ORDINAL"));
			list.add(plan);
		}

		rs.close();
		st.close();
		con.close();
		
		return list;

	}


}
