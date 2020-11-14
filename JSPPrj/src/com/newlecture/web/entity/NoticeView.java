package com.newlecture.web.entity;

import java.sql.Date;

public class NoticeView extends Notice {

	private int cmtCount;

	public NoticeView(int id, String title, String writerId, String content, Date regdate, int hit, String files,
			int pub, int cmtCount) {
		super(id, title, writerId, content, regdate, hit, files, pub);
		this.cmtCount = cmtCount;
	}

	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

	@Override
	public String toString() {
		return "NoticeView [cmtCount=" + cmtCount + ", toString()=" + super.toString() + "]";
	}

}
