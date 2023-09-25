package com.gb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gb.service.GuestBookService;
import com.gb.vo.GuestBookVO;

@Controller
@RequestMapping("/mainTwo")
public class JoinController {
	
	@ResponseBody
	@RequestMapping("/join")
	public Map<String, Object> join() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "oh");
		map.put("age", 25);

		return map;
	}
}
