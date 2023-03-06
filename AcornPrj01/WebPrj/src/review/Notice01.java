package review;

import java.sql.Date;

public class Notice01 {

	private String id;
	private String title;
	private String content;
	private Date regdate;
	private Number hit;

	public Notice01() {
		// TODO Auto-generated constructor stub
	}

	public Notice01(String id, String title, String content, Date regdate, Number hit) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Number getHit() {
		return hit;
	}

	public void setHit(Number hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "NoticeRe [id=" + id + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", hit="
				+ hit + "]";
	}

}
