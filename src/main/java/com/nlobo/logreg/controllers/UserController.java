package com.nlobo.logreg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nlobo.logreg.models.LoginUser;
import com.nlobo.logreg.models.User;
import com.nlobo.logreg.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/users/register")
	public String register(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("user") User user,
			BindingResult result) {
		
		User newUser = userService.register(user, result);
		
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("userId", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/users/login")
	public String login(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result) {
		
		// call the login method in the service
		User loggedInUser = userService.login(loginUser, result);
		
		if (result.hasErrors()) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		
		session.setAttribute("userId", loggedInUser.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session){
		User user = userService.findById((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
}
