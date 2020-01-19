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
			@RequestParam String password, HttpSession hs, RedirectAttributes flashMap,Model map) 
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		User u =null;
		try {
		u = dao.validateUser(email, password); 
		}catch (Exception e) {
			System.out.println("Invalid username or password");
			map.addAttribute("status","Invalid username or password"); 
			return "/user/login"; 
		}
	  hs.setAttribute("user", u);
	  return "/user/home";
	}
	@GetMapping("/register")
	public String getRegisterUser(User u,HttpSession hs)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+u);
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
	@GetMapping("/alluser")
	public String getAllUserList(RedirectAttributes flashMap)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		flashMap.addFlashAttribute("userList", dao.getAllUser());
		return "redirect:/user/profile";
	}
	@GetMapping("/search")
	public String searchUser(@RequestParam String searchstr,Model map,RedirectAttributes flashMap)
	{
		System.out.println(searchstr);
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		flashMap.addFlashAttribute("userList", dao.searchUser(searchstr));
		return "redirect:/user/profile";
	}
	
	

}
