package com.newlecture.web.entity;

import java.util.Date;

public class Notice {

	private int id;
	private String title;
	private String writerId;
	private String content;
	private Date regdate;
	private int hit;
	private String files;
	private boolean pub;

	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int id, String title, String writerId) {

		this.id = id;
		this.title = title;
		this.writerId = writerId;
	}

	public Notice(int id, String title, String writerId, String content, Date regdate, int hit, String files,
			boolean pub) {
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
		this.pub = pub;
	}

	public boolean getPub() {
		return pub;
	}
//	boolean 자료형을 자동으로 getter 추가하면 is로 되기에,
//	EL을 쓰기 위해서 get으로 수정해야한다.

	public void setPub(boolean pub) {
		this.pub = pub;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", writerId=" + writerId + ", content=" + content
				+ ", regdate=" + regdate + ", hit=" + hit + ", files=" + files + ", pub=" + pub + "]";
	}
//	객체를 문자열로 변환해주는 역할
//	toString()이 없다면 식별자를 출력한다.

}