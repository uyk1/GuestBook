package com.gb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gb.exception.GuestBookException;
import com.gb.repository.GuestBookDAO;
import com.gb.service.GuestBookService;
import com.gb.vo.GuestBookVO;

@Controller
@RequestMapping("/main")
public class GuestBookController {
	@Autowired
	private GuestBookService guestBookService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String list(Model model) {
		List<GuestBookVO> list = guestBookService.getList();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String insert(GuestBookVO vo) {
		guestBookService.insert(vo);
		return "redirect:/main/";
	}
	
	@RequestMapping(value="/deleteform", method=RequestMethod.GET)
	public String delete(@RequestParam Integer no, Model model) {
		model.addAttribute("no",no);
		return "deleteform";
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestBookVO vo) {
		guestBookService.delete(vo);
		return "redirect:/main/";
	}
	
//	@Autowired
//	private GuestBookDAO guestbookDAO;
	
//	@RequestMapping("/")
//	public String main(@RequestParam(value="a", required = true, defaultValue = "bye") String a) {
//		System.out.println(a);
//		return "/WEB-INF/views/index.jsp";
//	}
	
//	@RequestMapping("")
//	public String main(@ModelAttribute GuestBookVO vo) {
//		System.out.println(vo.getName());
//		System.out.println(vo.getContent());
//		return "/WEB-INF/views/index.jsp";
//	}
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String main(@RequestParam(value="a", required = false) String a) {
//		System.out.println(a);
//		return "/WEB-INF/views/index.jsp";
//	}
	
//	@RequestMapping(value="/{no}")
//	public String main(@PathVariable("no") Integer no) {
//		System.out.println(no);
//		return "/WEB-INF/views/index.jsp";
//	}
	
//	@RequestMapping(value="/{no:(?!assets|image|search}", method=RequestMethod.GET)
//	public String main(@PathVariable("no") Integer no) {
//		System.out.println(no);
//		return "/WEB-INF/views/index.jsp";
//	}
	
//	@RequestMapping("/")
//	public String main() {
//		System.out.println("리다이렉트");
//		return "/WEB-INF/views/index.jsp";
//	}
//	
//	@RequestMapping("/redirect")
//	public String redirectTest() {
//		return "redirect:/main/";
//	}
	
//	@RequestMapping("/")
//	public String main(Model model) {
//		List<GuestBookVO> list = guestbookDAO.getList();
//		model.addAttribute("list", list);
//		
//		return "/WEB-INF/views/index.jsp";
//	}
	
}

