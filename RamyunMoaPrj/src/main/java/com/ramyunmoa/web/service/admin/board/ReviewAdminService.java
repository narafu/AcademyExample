package com.ramyunmoa.web.service.admin.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramyunmoa.web.dao.admin.board.ReviewAdminDao;
import com.ramyunmoa.web.entity.admin.board.BoardAdmin;
import com.ramyunmoa.web.entity.admin.board.BoardAdminView;
import com.ramyunmoa.web.entity.admin.board.MainCount;
import com.ramyunmoa.web.entity.admin.board.ReportAdminView;

@Service
public class ReviewAdminService {

	@Autowired
	ReviewAdminDao reviewAdminDao;

	public MainCount getMainCount(String startDate, String endDate) throws ClassNotFoundException, SQLException {

		int countReview = reviewAdminDao.countReview(startDate, endDate);
		int countReviewCmt = reviewAdminDao.countReviewCmt(startDate, endDate);
		int countReviewReport = reviewAdminDao.countReviewReport(startDate, endDate);

		MainCount mainCount = new MainCount(countReview, countReviewCmt, countReviewReport);

		return mainCount;

	}

	public List<BoardAdminView> getReviewList(int page, String startDate, String endDate, String field, String search,
			int line) throws ClassNotFoundException, SQLException {
		page = (page - 1) * line;
		return reviewAdminDao.getReviewList(page, startDate, endDate, field, search, line);
	}

	public BoardAdminView getReview(int id) throws ClassNotFoundException, SQLException {
		return reviewAdminDao.getReview(id);
	}

	public List<BoardAdminView> getReviewNoticeList(int page, String startDate, String endDate, String field,
			String search, int line) throws ClassNotFoundException, SQLException {
		page = (page - 1) * line;
		return reviewAdminDao.getReviewNoticeList(page, startDate, endDate, field, search, line);
	}

	public BoardAdminView getNotice(int id) throws ClassNotFoundException, SQLException {
		return reviewAdminDao.getNotice(id);

	}

	public int getReviewCount(String startDate, String endDate, String field, String search)
			throws ClassNotFoundException, SQLException {
		return reviewAdminDao.getReviewCount(startDate, endDate, field, search);
	}

	public void insertNotice(BoardAdminView reviewNoticeView) throws ClassNotFoundException, SQLException {
		reviewAdminDao.insertNotice(reviewNoticeView);
	}

	public void updateNotice(BoardAdmin reviewNotice) throws ClassNotFoundException, SQLException {
		reviewAdminDao.updateNotice(reviewNotice);
	}

	public void delNotice(int id) throws ClassNotFoundException, SQLException {
		reviewAdminDao.delNotice(id);
	}

	public List<ReportAdminView> getReportList(int page, String startDate, String endDate, String field, String search,
			int line) throws ClassNotFoundException, SQLException {
		page = (page - 1) * line;
		return reviewAdminDao.getReportList(page, startDate, endDate, field, search, line);
	}

	public int getReportCount(String startDate, String endDate, String field, String search)
			throws ClassNotFoundException, SQLException {
		return reviewAdminDao.getReportCount(startDate, endDate, field, search);
	}

	public ReportAdminView getReport(int id) throws ClassNotFoundException, SQLException {
		return reviewAdminDao.getReport(id);
	}

}
