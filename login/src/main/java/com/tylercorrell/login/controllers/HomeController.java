package com.tylercorrell.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tylercorrell.login.models.LoginUser;
import com.tylercorrell.login.models.User;
import com.tylercorrell.login.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String showLogin(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User user, BindingResult result, HttpSession session, Model model) {
		User validUser = userServ.register(user, result);
		if(validUser == null) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		userServ.create(validUser);
		session.setAttribute("userId", validUser.getId());
		return "redirect:/dashboard";	
	}
	
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser loginUser, 
												BindingResult result, Model model, 
												HttpSession session) {
		User validateUser = userServ.login(loginUser, result);
		if(validateUser == null) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		session.setAttribute("userId", validateUser.getId());
		return "redirect:/dashboard";
	}

	@GetMapping("/dashboard")
	public String showDashboard(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		User currentUser = userServ.getUserById(userId);
		model.addAttribute("currentUser", currentUser);
			
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}
	
}
