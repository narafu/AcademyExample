package com.ramyunmoa.web.entity.admin.board;

public class MainCount {

	private int countReview;
	private int countReviewCmt;
	private int countReviewReport;

	public MainCount() {
		// TODO Auto-generated constructor stub
	}

	public MainCount(int countReview, int countReviewCmt, int countReviewReport) {
		super();
		this.countReview = countReview;
		this.countReviewCmt = countReviewCmt;
		this.countReviewReport = countReviewReport;
	}

	public int getCountReview() {
		return countReview;
	}

	public void setCountReview(int countReview) {
		this.countReview = countReview;
	}

	public int getCountReviewCmt() {
		return countReviewCmt;
	}

	public void setCountReviewCmt(int countReviewCmt) {
		this.countReviewCmt = countReviewCmt;
	}

	public int getCountReviewReport() {
		return countReviewReport;
	}

	public void setCountReviewReport(int countReviewReport) {
		this.countReviewReport = countReviewReport;
	}

	@Override
	public String toString() {
		return "MainCount [countReview=" + countReview + ", countReviewCmt=" + countReviewCmt + ", countReviewReport="
				+ countReviewReport + "]";
	}

}
