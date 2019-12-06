package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Controller
@RequestMapping("/user")
public class UserControler {
	@Autowired
	private IUserDao dao;

	@GetMapping("/login")
	public String userLogin(Model map) {
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		map.addAttribute("status", "");
		return "/user/login";
	}

	@PostMapping("/login") 
	public String postUserLogin(@RequestParam String email,
			@RequestParam String password, HttpSession hs, RedirectAttributes flashMap) 
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		User u = dao.validateUser(email, password); 
		if (u == null) 
		{ 
			flashMap.addFlashAttribute("status","Invalid username or password"); 
			return "redirect:/user/login"; 
		}
	  hs.setAttribute("user", u);
	  return "/user/home";
	}
	@GetMapping("/register")
	public String getRegisterUser(User u,HttpSession hs)
	{
		System.out.println("in get user/register");
		hs.invalidate();
		return "/user/register";
	}
	@PostMapping("/register")
	public String postRegisterUser(User u,RedirectAttributes flashMap)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+u);
		if(u==null)
		{
			flashMap.addFlashAttribute("status", "Unable to registered new User, try again");
			return "redirect:/user/register";
		}
		flashMap.addFlashAttribute("status", dao.addUser(u));
		return "/user/login";
	}
	@GetMapping("/profile")
	public String getProfile(RedirectAttributes flashMap)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		return "/user/profile";	
	}
	@GetMapping("/logout")
	public String getLogout(Model map,HttpSession hs)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		map.addAttribute("user",hs.getAttribute("user"));
		hs.invalidate();
		return "/user/logout";	
	}

	
	

}
