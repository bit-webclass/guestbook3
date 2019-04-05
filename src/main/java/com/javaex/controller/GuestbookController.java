package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	private GuestbookDao dao = new GuestbookDao();
	
	@RequestMapping(value="/addlist", method=RequestMethod.GET)
	public String addList(Model model) {
		List<GuestbookVo> list = dao.getList();
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/addList.jsp";
	}
	

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute GuestbookVo guestbookVo ) {
		int cnt = dao.insert(guestbookVo);

		return "redirect:/addlist";
	}
	
	
	@RequestMapping(value="/deleteform", method=RequestMethod.GET)
	public String deleteForm() {

		return "/WEB-INF/views/deleteForm.jsp";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		int cnt = dao.delete(guestbookVo);
		
		return "redirect:/addlist";
	}
}
