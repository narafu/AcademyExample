package com.ramyunmoa.web.entity.admin.board;

import java.sql.Date;

public class BoardAdminView extends BoardAdmin {

//	private int id;
//	private String title;
//	private String content;
//	private int likes;
//	private int hit;
	private Date regdate;
//	private int pub;
//	private String writerId;
	private String nickname;
	private int count;

	public BoardAdminView() {
		// TODO Auto-generated constructor stub
	}

	public BoardAdminView(Date regdate, String nickname, int count) {
		super();
		this.regdate = regdate;
		this.nickname = nickname;
		this.count = count;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ReviewNoticeView [regdate=" + regdate + ", nickname=" + nickname + ", count=" + count + "]";
	}

}
