package com.moa.web.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moa.web.entity.FreeBoardComment;
import com.moa.web.service.FreeBoardCommentService;

@RestController
@RequestMapping("/restBoard")
public class RestFreeBoardController {
	
	@Autowired
	private FreeBoardCommentService fbdCmtService;
	
	@PostMapping("/cmtList")
	public List<FreeBoardComment> cmtList(int id) throws Exception{
		System.out.println("리스트 출력");
		return fbdCmtService.cmtList(id);
	}
	
	@PostMapping("/insertCmt")
	public Map<String,Object> insertCmt(FreeBoardComment freeBoardCmt) throws Exception{
		Map<String,Object> result = new HashMap<>();
		System.out.println("인서트중");
		
		try {
			fbdCmtService.insertCmt(freeBoardCmt);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		
		return result;
	}
}
