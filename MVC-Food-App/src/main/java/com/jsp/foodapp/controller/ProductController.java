package com.jsp.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.ProductDao;
import com.jsp.foodapp.dto.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;

	@RequestMapping("/addproduct")
	public ModelAndView addproduct() {
		ModelAndView mav = new ModelAndView("addproduct");
		Product p = new Product();
		mav.addObject("products", p);
		return mav;
	}

	@RequestMapping("/saveproduct")
	public ModelAndView addProduct(@ModelAttribute("products") Product p) {
		ModelAndView mav = new ModelAndView("adminoption");
		productDao.saveProduct(p);
		return mav;
	}

	@RequestMapping("/viewproduct")
	public ModelAndView viewProduct() {
		ModelAndView mav = new ModelAndView("displayproduct");
		List<Product> products = productDao.fetchAllProduct();
		mav.addObject("allproducts", products);
		return mav;
	}

	@RequestMapping("/update")
	public ModelAndView updateProduct(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView("updateproduct");
		Product product = productDao.findProductById(id);
		mav.addObject("productinfo", product);
		return mav;
	}

	@RequestMapping("/updateProduct")
	public ModelAndView updateProduct(@ModelAttribute("roductinfo") Product p) {
		ModelAndView mav = new ModelAndView("redirect:/viewproduct");
		productDao.updateProduct(p);
		mav.addObject("msg", "Updated Sucessful!");
		return mav;
	}
	
	@RequestMapping("/deleteproduct")
	public ModelAndView deleteProduct(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/viewproduct");
		productDao.deleteProduct(id);
		mav.addObject("msg", "Deleted Sucessful!");
		return mav;
	}
	
	@RequestMapping("/viewallproduct")
	public ModelAndView viewAllProduct() {
		ModelAndView mav = new ModelAndView("displayallproduct");
		List<Product> products = productDao.fetchAllProduct();
		mav.addObject("allproducts", products);
		return mav;
	}
}
