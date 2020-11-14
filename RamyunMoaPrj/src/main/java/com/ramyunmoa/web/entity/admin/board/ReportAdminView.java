package com.ramyunmoa.web.entity.admin.board;

import java.util.Date;

public class ReportAdminView extends BoardAdmin {

	private int reportId;
	private String reportTitle;
	private String reportContent;
	private Date reportRegdate;
	private int reportReviewId;
	private String reportNickname;
//	private int id;
//	private String title;
//	private String content;
//	private int likes;
//	private int hit;
	private String img;
	private Date regdate;
	private int productId;
//	private String writerId;
	private int gradeId;
	private String nickname;

	public ReportAdminView() {
		// TODO Auto-generated constructor stub
	}

	public ReportAdminView(int reportId, String reportTitle, String reportContent, Date reportRegdate,
			int reportReviewId, String reportNickname, String img, Date regdate, int productId, int gradeId,
			String nickname) {
		super();
		this.reportId = reportId;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.reportRegdate = reportRegdate;
		this.reportReviewId = reportReviewId;
		this.reportNickname = reportNickname;
		this.img = img;
		this.regdate = regdate;
		this.productId = productId;
		this.gradeId = gradeId;
		this.nickname = nickname;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public Date getReportRegdate() {
		return reportRegdate;
	}

	public void setReportRegdate(Date reportRegdate) {
		this.reportRegdate = reportRegdate;
	}

	public int getReportReviewId() {
		return reportReviewId;
	}

	public void setReportReviewId(int reportReviewId) {
		this.reportReviewId = reportReviewId;
	}

	public String getReportNickname() {
		return reportNickname;
	}

	public void setReportNickname(String reportNickname) {
		this.reportNickname = reportNickname;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "ReportAdminView [reportId=" + reportId + ", reportTitle=" + reportTitle + ", reportContent="
				+ reportContent + ", reportRegdate=" + reportRegdate + ", reportReviewId=" + reportReviewId
				+ ", reportNickname=" + reportNickname + ", img=" + img + ", regdate=" + regdate + ", productId="
				+ productId + ", gradeId=" + gradeId + ", nickname=" + nickname + ", toString()=" + super.toString()
				+ "]";
	}

}
