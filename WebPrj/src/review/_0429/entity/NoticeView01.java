package review._0429.entity;

import java.sql.Date;

public class NoticeView01 extends Notice01 {

	private int num;
	private String name;
	private String bossName;

	public NoticeView01() {
		// TODO Auto-generated constructor stub
	}

	public NoticeView01(String id, String title, String content, Date regdate, int hit, String files, boolean pub, int num,
			String name, String bossName) {

		super(id, title, content, regdate, hit, files, pub);
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
		return "NoticeView01 [num=" + num + ", name=" + name + ", bossName=" + bossName + ", toString()="
				+ super.toString() + "]";
	}

}
