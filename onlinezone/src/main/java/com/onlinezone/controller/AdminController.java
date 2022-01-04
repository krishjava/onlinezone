package com.onlinezone.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinezone.dao.LoginDao;
import com.onlinezone.util.SessionUtility;

@Controller
public class AdminController {
	
	@Autowired
	private LoginDao loginDao;

	@RequestMapping(path = "admin/admin-login-page",method = RequestMethod.GET)
	public String  answer() {
		return "admin/admin_login";
	}
	
	@RequestMapping("/admin/")
	public String  index(HttpSession session) {
		System.out.println("User session : "+session.getAttribute("USER_EMAIL"));
		if(session.getAttribute("USER_EMAIL")!=null) {
			return "admin/index";
		}else {
			return "admin/admin_login";
		}
	}
	
	@RequestMapping("admin/user")
	public String  user(HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null) {
			return "admin/users";
		}else {
			return "admin/index";
		}
	}
	
	@RequestMapping(path = "admin/formprocess",method = RequestMethod.POST)
	public String adminProcess(@RequestParam("email") String username,@RequestParam("password") String password,Model model,HttpSession session) {
		boolean check = loginDao.validateAdminUser(username, password);
		if(check!=false) {
			session.setAttribute("USER_EMAIL",username);
			return "admin/index";
		}else {
			model.addAttribute("loginerror","Provide Login Credentials...");
			return "admin/admin_login";
		}
	}
	
	@RequestMapping("admin/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null) {
			session.invalidate();
			return "admin/admin_login";
		}
		return "admin/admin_login";
	}
}
