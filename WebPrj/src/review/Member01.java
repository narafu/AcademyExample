package review;

import java.sql.Date;

public class Member01 {

	private String id;
	private int pwd;
	private String name;
	private Date birthday;
	private String boss_id;

	public Member01() {
		// TODO Auto-generated constructor stub
	}

	public Member01(String id, int pwd, String name, Date birthday, String boss_id) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.boss_id = boss_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBoss_id() {
		return boss_id;
	}

	public void setBoss_id(String boss_id) {
		this.boss_id = boss_id;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", birthday=" + birthday + ", boss_id="
				+ boss_id + "]";
	}

}
