package com.gb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gb.repository.GuestBookDAO;
import com.gb.vo.GuestBookVO;

@Service
public class GuestBookService {
	@Autowired
	private GuestBookDAO guestBookDAO;
	
	public List<GuestBookVO> getList() {
		return guestBookDAO.getList();
	}
	
	public GuestBookVO insert(GuestBookVO guestBookVO) {
		GuestBookVO vo = null;
		
		int count = guestBookDAO.insert(guestBookVO)? 1 : 0;
		if(count == 1) {
			vo = guestBookDAO.get(guestBookVO.getNo());
		}
		
		return vo;
	}
	
	public boolean delete(GuestBookVO vo) {
		String originPwd = guestBookDAO.getPwd(vo.getNo());
		String inputPwd = guestBookDAO.getInputPwd(vo.getPwd());
		
		if(!originPwd.equals(inputPwd)) {
			return false;
		}
		
		return guestBookDAO.delete(vo.getNo());
	}
}
