package com.newlecture.web.entity;

import java.util.Date;

public class NoticeView extends Notice {

	private String writerName;
	private int cmtCount;

	public NoticeView() {
	}

	// SELECT�� ���� �����ε� ������
	public NoticeView(int id, String title, String writerId,
//			String content,
			Date regdate, int hit, String files, boolean pub) {

		super(id, title, writerId, null, regdate, hit, files, pub);
		this.writerName = writerName;
		this.cmtCount = cmtCount;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

	@Override
	public String toString() {
		return "NoticeView [writerName=" + writerName + ", cmtCount=" + cmtCount + ", toString()=" + super.toString()
				+ "]";
	}


}
