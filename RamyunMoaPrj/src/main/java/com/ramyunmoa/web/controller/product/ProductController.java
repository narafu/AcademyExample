package com.ramyunmoa.web.controller.product;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramyunmoa.web.entity.product.ProductView;
import com.ramyunmoa.web.service.product.ProductService;

@Controller
@RequestMapping("/product/")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "m", defaultValue = "") String mfr,
			@RequestParam(name = "s", defaultValue = "") String search,
			@RequestParam(name = "c", defaultValue = "") String cup, Model model) {

		try {

			List<ProductView> list = productService.getProductList(page, mfr, search, cup);
			model.addAttribute("list", list);
			List<ProductView> rank = productService.getProductRank(page, mfr, search, cup);
			model.addAttribute("rank", rank);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "product.list";
	}

	@GetMapping("list-data")
	public String listData(@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "m", defaultValue = "") String mfr,
			@RequestParam(name = "s", defaultValue = "") String search,
			@RequestParam(name = "c", defaultValue = "") String cup, @RequestBody ProductView productView) {

		try {
			
			List<ProductView> list = productService.getProductList(page, mfr, search, cup);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}
	
	@GetMapping("detail")
	public String detail() {
		return "";
	}

}
