package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IShayariDao;
import com.app.pojos.Shayari;
import com.app.pojos.User;

@Controller
@RequestMapping("/shayari")
public class ShayariControler {
	@Autowired
	private IShayariDao dao;
	@GetMapping("/add")
	public String getAddshayari(Shayari p)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		return "/shayari/add";
	}
	
	@PostMapping("/add")
	public String postAddshayari(Shayari s,HttpSession hs,Model map)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+s);
		map.addAttribute("status", dao.addShayari(s,((User)hs.getAttribute("user")).getId()));
		return "redirect:/user/profile";
	}
	@GetMapping("/show")
	public String getShaowshayari(RedirectAttributes flashMap,HttpSession hs)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		List<Shayari> sh=dao.getShayariList(((User)hs.getAttribute("user")).getId());
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+sh);
		flashMap.addFlashAttribute("shayariList",sh);
		return "redirect:/user/profile";
	}
	@GetMapping("/remove")
	public String getRemoveshayari(@RequestParam Integer sid,RedirectAttributes flashMap,HttpSession hs)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		System.out.println(dao.removeShayari(sid, ((User)hs.getAttribute("user")).getId()));
		return "redirect:/shayari/show";
	}
}
