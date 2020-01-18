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

import com.app.dao.IPoemDao;
import com.app.pojos.Poem;
import com.app.pojos.User;

@Controller
@RequestMapping("/poem")
public class PoemControler {
	@Autowired
	private IPoemDao dao;
	@GetMapping("/add")
	public String getAddPoem(Poem p)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		return "/poem/add";
	}
	
	@PostMapping("/add")
	public String postAddPoem(Poem p,HttpSession hs,Model map)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+p);
		map.addAttribute("status", dao.addPoem(p,((User)hs.getAttribute("user")).getId()));
		return "redirect:/user/profile";
	}
	@GetMapping("/show")
	public String getShowPoem(RedirectAttributes flashMap,HttpSession hs)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		flashMap.addFlashAttribute("poemList",dao.getPoemList(((User)hs.getAttribute("user")).getId()));
		return "redirect:/user/profile";
	}
	@GetMapping("/remove")
	public String getRemoveshayari(@RequestParam Integer pid,RedirectAttributes flashMap,HttpSession hs)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		System.out.println(dao.removePoem(pid, ((User)hs.getAttribute("user")).getId()));
		return "redirect:/poem/show";
	}
}
