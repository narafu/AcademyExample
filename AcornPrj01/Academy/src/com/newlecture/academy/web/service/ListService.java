package com.newlecture.academy.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.academy.web.entity.List;

public class ListService {

	public List insertList(List list) throws ClassNotFoundException, SQLException {

		int result = 0;
		List li = null;

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "INSERT INTO List(title, regMemberId) VALUES(?, ?)";
		String sql1 = "SELECT * FROM List WHERE regMemberId = ? ORDER BY REGDATE DESC LIMIT 1";

		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		ResultSet rs1 = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "newlecture", "111");

			con.setAutoCommit(false); /* false */

			st = con.prepareStatement(sql);
			st.setString(1, list.getTitle());
			st.setString(2, "dino");
			result = st.executeUpdate(); /* auto commit -> false */

			st1 = con.prepareStatement(sql1);
			st1.setString(1, "dino");
			rs1 = st1.executeQuery(); /* auto commit -> false */

			if (rs1.next()) {
				li = new List(rs1.getInt("id"), rs1.getString("title"), rs1.getDate("regDate"),
						rs1.getString("regMemberId"));
			}

			/* ���� ���� �����͸� �ٷ� �������� ���ؼ� commit���� ������ lock�� �Ǵ�. */
			con.commit(); /* commit - manual */

			con.close();
			st.close();
			st1.close();
			rs1.close();

		} catch (SQLException e) { /* �����ͺ��̽� ���� ���� */

			try {
				if (con != null) {
					con.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			throw e;

		} catch (Exception e) { /* �׹��� �ٸ� ���� */

			throw new ClassNotFoundException();

		} finally {

			try {
				// commit�� �̷������ �ʾƼ� ���� ������ ��� �ݾ��ֱ� ���ؼ�
				if (st != null) {
					st.close();
				}
				st1.close();
				rs1.close();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		return li;

	}
}