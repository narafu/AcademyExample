package review;

import java.sql.Date;

public class NoticeView extends Notice03 {

	private int num;
	private String name;
	private String bossName;

	public NoticeView() {
		// TODO Auto-generated constructor stub
	}

	public NoticeView(int num, String id, String name, String bossName, String title, String content, Date regdate,
			int hit) {
		super(id, title, content, regdate, hit);

		this.num = num;
		this.name = name;
		this.bossName = bossName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

	@Override
	public String toString() {
		return "NoticeView [num=" + num + ", name=" + name + ", bossName=" + bossName + ", toString()="
				+ super.toString() + "]";
	}

}
