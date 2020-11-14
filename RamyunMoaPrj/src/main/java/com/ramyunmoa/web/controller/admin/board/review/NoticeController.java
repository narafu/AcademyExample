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

import com.ramyunmoa.web.entity.admin.board.BoardAdmin;
import com.ramyunmoa.web.entity.admin.board.BoardAdminView;
import com.ramyunmoa.web.service.admin.board.ReviewAdminService;

@Controller("adminReviewNoticeController")
@RequestMapping("/admin/board/review/notice/")
public class NoticeController {

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

			List<BoardAdminView> list = reviewAdminService.getReviewNoticeList(page, startDate, endDate, field, search,
					line);
			model.addAttribute("list", list);
			int count = reviewAdminService.getReviewCount(startDate, endDate, field, search);
			model.addAttribute("count", count);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "admin.board.review.notice.list";
	}

	@GetMapping("{id}")
	public String detail(@PathVariable("id") int id, Model model) {

		try {

			BoardAdminView reviewNoticeView = reviewAdminService.getNotice(id);
			model.addAttribute("n", reviewNoticeView);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "admin.board.review.notice.detail";
	}

	@GetMapping("reg")
	public String reg(Model model) {

		SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String now = temp.format(time);

		model.addAttribute("now", now);

		return "admin.board.review.notice.reg";
	}

	@PostMapping("reg")
	public String reg(BoardAdminView reviewNoticeView) {

		try {

			reviewAdminService.insertNotice(reviewNoticeView);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:list";
	}

	@GetMapping("update")
	public String update(int id, Model model) {

		try {

			BoardAdminView reviewNoticeView = reviewAdminService.getNotice(id);
			model.addAttribute("n", reviewNoticeView);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "admin.board.review.notice.update";
	}

	@PostMapping("update")
	public String update(BoardAdmin reviewNotice) {

		try {

			reviewAdminService.updateNotice(reviewNotice);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:list";
	}

	@GetMapping("del")
	public String del(int id) {

		try {

			reviewAdminService.delNotice(id);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:list";
	}

}
