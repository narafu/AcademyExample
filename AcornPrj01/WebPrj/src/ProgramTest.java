import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.web.entity.Notice;

public class ProgramTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Notice notice = null;

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM Notice WHERE id = 10";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			notice = new Notice(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("writerId"));
		}

		System.out.println(notice);
		
		rs.close();
		st.close();
		con.close();

	}

}
