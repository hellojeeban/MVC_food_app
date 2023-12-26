package com.jsp.foodapp.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.AdminDao;
import com.jsp.foodapp.dto.Admin;

@Controller
public class AdminController {
	@Autowired
	AdminDao adminDao;

	@RequestMapping("/addadmin")
	public ModelAndView m1() {
		ModelAndView mav = new ModelAndView("adminlogin");
		Admin a = new Admin();
		a.setEmail("admin@gmail.com");
		a.setPassword("admin");
		adminDao.saveAdmin(a);
		return mav;
	}

	@RequestMapping("/validate")
	public ModelAndView login(HttpServletRequest request) {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Admin a = adminDao.findAdmin(email, password);
		System.out.println(a);
		if (a != null) {
			return new ModelAndView("adminoption");
		} else {
			ModelAndView mav = new ModelAndView("adminlogin");
			mav.addObject("msg", "Invalid");
			return mav;
		}

	}
}
