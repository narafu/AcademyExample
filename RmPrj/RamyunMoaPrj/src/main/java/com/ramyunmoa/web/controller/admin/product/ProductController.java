package com.ramyunmoa.web.controller.admin.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ramyunmoa.web.dao.product.ProductDao;
import com.ramyunmoa.web.entity.product.ProductView;

@Controller("adminProductMainController")
@RequestMapping("/admin/product/")
public class ProductController {

	@Autowired
	ProductDao productDao;

	@GetMapping("main")
	public String list(@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "m", defaultValue = "") String mfr,
			@RequestParam(name = "s", defaultValue = "") String search,
			@RequestParam(name = "c", defaultValue = "") String cup, Model model) {

		try {

			List<ProductView> list = productDao.getProductList(page, mfr, search, cup);
			model.addAttribute("list", list);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "admin.product.main";
	}

	@GetMapping("reg")
	public String reg() {

		return "admin.product.reg";
	}

	@PostMapping("reg")
	public String reg(ProductView productView, MultipartFile file, HttpServletRequest request) throws IOException {

		try {

			String path = request.getServletContext().getRealPath("/resource/images/prod-img/");

			File file1 = new File(path);
			if (!file1.exists()) {
				file1.mkdir();
			}

			path += file.getOriginalFilename();

			InputStream is = file.getInputStream();
			FileOutputStream fos = new FileOutputStream(path);

			byte[] buf = new byte[1024];
			int len = 1024;
			while ((len = is.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}

			productDao.insertProduct(productView, path);
//			productDao.insertNutrition(productView);
			productDao.insertMfr(productView);
			productDao.insertSales(productView);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:reg";
	}

	@GetMapping("update")
	public String update(@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "m", defaultValue = "") String mfr,
			@RequestParam(name = "s", defaultValue = "") String search,
			@RequestParam(name = "c", defaultValue = "") String cup, Model model) {

		try {

			List<ProductView> list = productDao.getProductAdminList(page, mfr, search, cup);
			model.addAttribute("list", list);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "admin.product.update";
	}

	@PostMapping("update")
	public String update(ProductView productView, MultipartFile file, HttpServletRequest request) throws IOException {

		try {

			String path = request.getServletContext().getRealPath("/resource/images/prod-img/");

			File file1 = new File(path);
			if (!file1.exists()) {
				file1.mkdir();
			}

			path += file.getOriginalFilename();

			InputStream is = file.getInputStream();
			FileOutputStream fos = new FileOutputStream(path);

			byte[] buf = new byte[1024];
			int len = 1024;

			while ((len = is.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}

			productDao.updateProduct(productView, path);

			productDao.updateNatrium(productView);
			productDao.updateCarbohydrate(productView);
			productDao.updateSugars(productView);
			productDao.updateFat(productView);
			productDao.updateTransfat(productView);
			productDao.updateSaturatedFat(productView);
			productDao.updateCholesterol(productView);
			productDao.updateProtein(productView);

			productDao.updateMfr(productView);
			productDao.updateSales(productView);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:update";
	}

	@GetMapping("del")
	public String del(@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "m", defaultValue = "") String mfr,
			@RequestParam(name = "s", defaultValue = "") String search,
			@RequestParam(name = "c", defaultValue = "") String cup, Model model) {

		try {

			List<ProductView> list = productDao.getProductAdminList(page, mfr, search, cup);
			model.addAttribute("list", list);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "admin.product.del";
	}

	@PostMapping
	public String del(int id) {

		try {

			productDao.delProduct(id);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:del";
	}

}
