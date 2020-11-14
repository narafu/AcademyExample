package com.ramyunmoa.web.dao.admin.board;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ramyunmoa.web.entity.admin.board.BoardAdmin;
import com.ramyunmoa.web.entity.admin.board.BoardAdminView;
import com.ramyunmoa.web.entity.admin.board.ReportAdminView;

@Mapper
public interface ReviewAdminDao {

	@Select("SELECT count(id) count FROM Review WHERE regdate > #{startDate} AND regdate < #{endDate}")
	public int countReview(String startDate, String endDate) throws ClassNotFoundException, SQLException;

	@Select("SELECT count(id) count FROM ReviewCmt WHERE regdate > #{startDate} AND regdate < #{endDate}")
	public int countReviewCmt(String startDate, String endDate) throws ClassNotFoundException, SQLException;

	@Select("SELECT count(id) count FROM ReviewReport WHERE regdate > #{startDate} AND regdate < #{endDate}")
	public int countReviewReport(String startDate, String endDate) throws ClassNotFoundException, SQLException;

	@Select("SELECT * FROM ReviewDetailView WHERE regdate > #{startDate} AND regdate < #{endDate} AND ${field} LIKE '%${search}%' ORDER BY regdate DESC LIMIT #{page}, #{line}")
	public List<BoardAdminView> getReviewList(int page, String startDate, String endDate, String field, String search,
			int line) throws SQLException, ClassNotFoundException;

	@Select("SELECT * FROM ReviewDetailView WHERE id = #{id}")
	public BoardAdminView getReview(int id) throws SQLException, ClassNotFoundException;

	@Select("SELECT * FROM ReviewBoardNotice WHERE regdate > #{startDate} AND regdate < #{endDate} AND ${field} LIKE '%${search}%' ORDER BY regdate DESC LIMIT #{page}, #{line}")
	public List<BoardAdminView> getReviewNoticeList(int page, String startDate, String endDate, String field,
			String search, int line) throws SQLException, ClassNotFoundException;

	@Select("SELECT * FROM ReviewBoardNotice WHERE id = #{id}")
	public BoardAdminView getNotice(int id) throws SQLException, ClassNotFoundException;

	@Select("SELECT COUNT(id) count FROM ReviewDetailView")
	public int getReviewCount(String startDate, String endDate, String field, String search)
			throws SQLException, ClassNotFoundException;

	@Insert("INSERT INTO ReviewBoardNotice(writerId, title, content) VALUES(#{writerId}, #{title}, #{content})")
	public void insertNotice(BoardAdminView reviewNoticeView) throws SQLException, ClassNotFoundException;

	@Update("UPDATE ReviewBoardNotice SET title = #{title}, content = #{content} WHERE id = #{id}")
	public void updateNotice(BoardAdmin reviewNotice) throws SQLException, ClassNotFoundException;

	@Delete("DELETE FROM ReviewBoardNotice WHERE id = #{id}")
	public void delNotice(int id) throws SQLException, ClassNotFoundException;

	@Select("SELECT * FROM ReviewReportView WHERE regdate > #{startDate} AND regdate < #{endDate} AND ${field} LIKE '%${search}%' ORDER BY regdate DESC LIMIT #{page}, #{line}")
	public List<ReportAdminView> getReportList(int page, String startDate, String endDate, String field, String search,
			int line) throws SQLException, ClassNotFoundException;

	@Select("SELECT COUNT(id) count FROM ReviewReportView")
	public int getReportCount(String startDate, String endDate, String field, String search)
			throws SQLException, ClassNotFoundException;

	@Select("SELECT * FROM ReviewReportView WHERE reportId = #{id}")
	public ReportAdminView getReport(int id) throws SQLException, ClassNotFoundException;
}
