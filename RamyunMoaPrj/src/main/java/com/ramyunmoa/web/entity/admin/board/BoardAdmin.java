package com.ramyunmoa.web.entity.admin.board;

public class BoardAdmin {

	private int id;
	private String title;
	private String content;
	private int likes;
	private int hit;
	private int pub;
	private String writerId;

	public BoardAdmin() {
		// TODO Auto-generated constructor stub
	}

	public BoardAdmin(int id, String title, String content, int likes, int hit, int pub, String writerId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.likes = likes;
		this.hit = hit;
		this.pub = pub;
		this.writerId = writerId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getPub() {
		return pub;
	}

	public void setPub(int pub) {
		this.pub = pub;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	@Override
	public String toString() {
		return "ReviewNotice [id=" + id + ", title=" + title + ", content=" + content + ", likes=" + likes + ", hit="
				+ hit + ", pub=" + pub + ", writerId=" + writerId + "]";
	}

}
