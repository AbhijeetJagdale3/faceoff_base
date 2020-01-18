package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.ICompetitionDao;
import com.app.pojos.User;

@Controller
@RequestMapping("/comp")
public class CompetitionControler {
	@Autowired
	private ICompetitionDao dao;
	
	@GetMapping("/invlist")
	public String getInvList(RedirectAttributes flashMap,HttpSession session)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		flashMap.addFlashAttribute("invList",dao.getInvitationList(((User)session.getAttribute("user")).getId()));
		System.out.println(1);
		return "redirect:/user/profile";
	}
	@GetMapping("/inv")
	public String sendInv(@RequestParam Integer uid,RedirectAttributes flashMap,HttpSession session)
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		flashMap.addFlashAttribute("status", dao.invitUser(uid, ((User)session.getAttribute("user")).getId()));
		return "redirect:/user/profile";
	}
	@GetMapping("/accept")
	public String acceptInv(@RequestParam Integer uid,RedirectAttributes flashMap,HttpSession session) 
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		flashMap.addFlashAttribute("status", dao.acceptInv(uid, ((User)session.getAttribute("user")).getId()));
		return "redirect:/comp/invlist";
	};
	@GetMapping("/remove")
	public String removeInv(@RequestParam Integer uid,RedirectAttributes flashMap,HttpSession session) 
	{
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		flashMap.addFlashAttribute("status", dao.removeInvitation(uid, ((User)session.getAttribute("user")).getId()));
		return "redirect:/comp/invlist";
	};
	

}
