package com.moa.web.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/free")
public class FreeController {

	@GetMapping("/list")
	public String list() {

		return "board.free.list";
	}
	
	@GetMapping("/reg")
	public String reg() {

		return "board.free.reg";
	}


}
