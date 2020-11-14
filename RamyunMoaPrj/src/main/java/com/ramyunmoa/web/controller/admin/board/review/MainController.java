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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramyunmoa.web.entity.admin.board.MainCount;
import com.ramyunmoa.web.entity.admin.board.BoardAdminView;
import com.ramyunmoa.web.service.admin.board.ReviewAdminService;

@Controller("adminReviewMainController")
@RequestMapping("/admin/board/review/main/")
public class MainController {

	@Autowired
	private ReviewAdminService reviewAdminService;

	@GetMapping("list")
	public String list(@RequestParam(name = "sd", defaultValue = "1900-01-01") String startDate,
			@RequestParam(name = "ed", defaultValue = "") String endDate,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "s", defaultValue = "") String search, Model model) {

		int page = 1;
		SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String endDate_ = temp.format(time);
		int line = 3;

		if (endDate.equals(""))
			endDate = endDate_;

		try {

			MainCount mainCount = reviewAdminService.getMainCount(startDate, endDate);
			model.addAttribute("c", mainCount);
			List<BoardAdminView> list = reviewAdminService.getReviewList(page, startDate, endDate, field,
					search, line);
			model.addAttribute("list", list);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}

		return "admin.board.review.main.list";
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

		return "admin.board.review.main.detail";
	}

}
