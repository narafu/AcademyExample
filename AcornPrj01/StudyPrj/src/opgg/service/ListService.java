package opgg.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import opgg.entity.RankingList;

public class ListService {

	public List<RankingList> getRankingList() throws ClassNotFoundException, SQLException {

		List<RankingList> list = new ArrayList();

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM (SELECT ROWNUM RANK, R.* FROM (SELECT * FROM RANKING ORDER BY SALES DESC) R) WHERE RANK BETWEEN 1 AND 10";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {

			RankingList rankingList = new RankingList(rs.getString("ITEM"), rs.getInt("SALES"), rs.getString("GRADE"),
					rs.getString("MFG"), rs.getString("CODE"), rs.getInt("rank"));

			list.add(rankingList);

		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	public List<RankingList> getItemList(String mfg) throws ClassNotFoundException, SQLException {

		List<RankingList> list = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM (SELECT ROWNUM RANK, R.* FROM (SELECT * FROM RANKING WHERE MFG = ? ORDER BY SALES DESC) R) WHERE RANK BETWEEN 1 AND 10";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, mfg);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {

			RankingList mfglist = new RankingList(rs.getString("ITEM"), rs.getInt("SALES"), rs.getString("GRADE"),
					rs.getString("MFG"), rs.getString("CODE"), rs.getInt("rank"));

			list.add(mfglist);

		}

		rs.close();
		st.close();
		con.close();
		
		return list;

	}

}
