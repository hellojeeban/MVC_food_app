package com.jsp.foodapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.UserDao;
import com.jsp.foodapp.dto.User;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/addUser")
	public ModelAndView addUser() {
		ModelAndView mav = new ModelAndView("adduserform");
		User u = new User();
		mav.addObject("user", u);
		return mav;
	}
	
	@RequestMapping("/saveuser")
	public ModelAndView saveUser(@ModelAttribute("user") User u) {
		ModelAndView mav = new ModelAndView("adminoption");
		userDao.saveUser(u);
		mav.addObject("msg", "User Saved Successfully");
		return mav;
	}
	
	@RequestMapping("/validateform")
	public ModelAndView validateForm() {
		ModelAndView mav = new ModelAndView("userValidate");
		return mav;
	}
	
	@RequestMapping("/uservalidate")
	public ModelAndView login(HttpServletRequest request) {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User u = userDao.findUser(email, password);
		System.out.println(u);
		if (u != null) {
			ModelAndView mav = new ModelAndView("useroption");
			HttpSession hs = request.getSession();
			hs.setAttribute("user", u);
			mav.addObject("msg", "Welcome "+u.getName());
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("userValiadte");
			mav.addObject("msg", "Invalid");
			return mav;
		}

	}
}
