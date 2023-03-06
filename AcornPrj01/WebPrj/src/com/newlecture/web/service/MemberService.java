package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Member;

public class MemberService {

	public List<Member> getMemberList(int page) throws ClassNotFoundException, SQLException {
		List<Member> list = new ArrayList<>();

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM Member ORDER BY REGDATE DESC LIMIT ?, 5";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, (page - 1) * 5);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Member member = new Member(rs.getInt("id"), rs.getString("uid"), rs.getString("name"), rs.getString("pwd"),
					rs.getDate("regDate"), rs.getString("gender"), rs.getString("birthday"), rs.getString("phone"),
					rs.getString("email"), rs.getInt("age"));

			list.add(member);
		}

		return list;
	}

	public int insertMember(Member member) throws ClassNotFoundException, SQLException {

		int result = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "INSERT INTO Member(uid, pwd, name, gender, birthday, phone, email) VALUES(?,?,?,?,?,?,?)";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, member.getUid());
		st.setString(2, member.getPwd());
		st.setString(3, member.getName());
		st.setString(4, member.getGender());
		st.setString(5, member.getBirthday());
		st.setString(6, member.getPhone());
		st.setString(7, member.getEmail());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	public int getMemberCount() throws ClassNotFoundException, SQLException {

		int count = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT COUNT(ID) count FROM `Member`";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			count = rs.getInt("count");
		}

		rs.close();
		st.close();
		con.close();

		return count;
	}

	public boolean isValid(String uid, String pwd) throws ClassNotFoundException, SQLException {

		Member member = null;

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM Member WHERE uid = ?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, uid);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			member = new Member(rs.getInt("id"), rs.getString("uid"), rs.getString("pwd"));
		}

		rs.close();
		st.close();
		con.close();

		if (member == null) {
			return false;
		} else if (!member.getPwd().equals(pwd)) {
			return false;
		}

		return true;
	}

	public String getRoleByUserId(String uid) throws ClassNotFoundException, SQLException {

		String roleName = null;

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT type FROM Member WHERE uid = ?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, uid);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			roleName = rs.getString("type");
		}

		rs.close();
		st.close();
		con.close();

		return roleName;
	}

}
