package com.ramyunmoa.web.controller.admin.board.review;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramyunmoa.web.entity.admin.board.BoardAdminView;
import com.ramyunmoa.web.entity.admin.board.ReportAdminView;
import com.ramyunmoa.web.service.admin.board.ReviewAdminService;

@Controller("adminReviewReportController")
@RequestMapping("/admin/board/review/report/")
public class ReportController {

	@Autowired
	private ReviewAdminService reviewAdminService;

	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "sd", defaultValue = "1900-01-01") String startDate,
			@RequestParam(name = "ed", defaultValue = "") String endDate,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "s", defaultValue = "") String search, Model model) {

		SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String endDate_ = temp.format(time);
		int line = 10;

		if (endDate.equals(""))
			endDate = endDate_;

		try {

			List<ReportAdminView> list = reviewAdminService.getReportList(page, startDate, endDate, field, search,
					line);
			int count = reviewAdminService.getReportCount(startDate, endDate, field, search);
			model.addAttribute("list", list);
			model.addAttribute("count", count);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "admin.board.review.report.list";
	}

//	@PostMapping("list")
//	public String list(@RequestParam(name = "pubId", defaultValue = "") int[] pubIds,
//			@RequestParam(name = "delId", defaultValue = "") int[] delIds, String btn) {
//
//		switch (btn) {
//		case "공개":
//			try {
//				reviewNoticeDao.pubNoticeAll(pubIds);
//			} catch (ClassNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			break;
//		case "삭제":
//			try {
//				reviewNoticeDao.delNoticeAll(delIds);
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		}
//
//		return "redirect:list";
//	}

	@GetMapping("{reportId}")
	public String detail(@PathVariable("reportId") int id, Model model) {

		try {

			ReportAdminView reportNoticeView = reviewAdminService.getReport(id);
			model.addAttribute("n", reportNoticeView);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "admin.board.review.report.detail";
	}

}
