package com.jsp.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.UserDao;
import com.jsp.foodapp.dto.FoodOrder;
import com.jsp.foodapp.dto.Item;
import com.jsp.foodapp.dto.User;

@Controller
public class FoodOrderController {
	@Autowired
	UserDao dao;

	@RequestMapping("/addfoodOrder")
	public ModelAndView addFoodOrder() {
		ModelAndView mav = new ModelAndView("addfoodorder");
		FoodOrder foodOrder = new FoodOrder();
		mav.addObject("foodOrder", foodOrder);
		return mav;
	}

	@RequestMapping("/savefoodorder")
	public ModelAndView saveFoodOrder(@ModelAttribute("foodorder") FoodOrder order, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/viewallproduct");

		session.setAttribute("foodorder", order);
		return mav;
	}

	@RequestMapping("/savefoodorders")
	public ModelAndView saveFoodOrders(HttpSession session) {
		User user = (User) session.getAttribute("user");
		FoodOrder foodOrder = (FoodOrder) session.getAttribute("foodorder");
		double sum = 0;
		List<FoodOrder> orders = user.getFoodOrder();
		if (orders != null) {
			
			orders.add(foodOrder);
			
			sum = 0;
			List<Item> items = foodOrder.getItem();
			for (Item i : items) {
				sum += i.getCost();
			}

			foodOrder.setTotalcost(sum);
			
			user.setFoodOrder(orders);
			foodOrder.setUser(user);
			
		} else {
			List<FoodOrder> order1 = new ArrayList<FoodOrder>();
			order1.add(foodOrder);

			sum = 0;
			List<Item> items = foodOrder.getItem();
			for (Item i : items) {
				sum += i.getCost();
			}

			foodOrder.setTotalcost(sum);
			foodOrder.setUser(user);
			user.setFoodOrder(order1);
		}
		dao.updateUser(user);
		ModelAndView mav = new ModelAndView("displaybill");
		mav.addObject("bill", sum);
		return mav;
	}

}
