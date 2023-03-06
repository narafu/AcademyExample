package review._0429.entity;

import java.sql.Date;

public class Notice01 {

	private String id;
	private String title;
	private String content;
	private Date regdate;
	private int hit;
	private String files;
	private boolean pub;

	public Notice01() {
		// TODO Auto-generated constructor stub
	}

	public Notice01(String id, String title, String content, Date regdate, int hit, String files, boolean pub) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
		this.pub = pub;
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

	public boolean isPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}

	@Override
	public String toString() {
		return "Notice01 [id=" + id + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", hit="
				+ hit + ", files=" + files + ", pub=" + pub + "]";
	}

}
