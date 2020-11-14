package review.example;

import java.sql.Date;

public class Plan {

	private int num;
	private String subject;
	private String day;
	private Date date;
	private String content;
	private String ordinal;

	public Plan() {
		// TODO Auto-generated constructor stub
	}

	public Plan(int num, String subject, String day, Date date, String content, String ordinal) {
		super();
		this.num = num;
		this.subject = subject;
		this.day = day;
		this.date = date;
		this.content = content;
		this.ordinal = ordinal;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(String ordinal) {
		this.ordinal = ordinal;
	}

	@Override
	public String toString() {
		return "Plan [num=" + num + ", subject=" + subject + ", day=" + day + ", date=" + date + ", content=" + content
				+ ", ordinal=" + ordinal + "]";
	}

}
