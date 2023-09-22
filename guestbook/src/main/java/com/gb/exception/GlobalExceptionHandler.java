package com.gb.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
	// 모든 예외 처리
	@ExceptionHandler(Exception.class)
	// 기술 침투는 하지 않는 것이 좋음.. 이 경우 뷰 페이지로 돌려야 하므로
	// 어쩔 수 없이 HttpServlet 객체를 사용
	public void handlerExcetion(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
		// 1. 로깅
		// 로그는 파일로 남겨야 함. 하지만 지금은 jsp 페이지로 보내보자.
		StringWriter error = new StringWriter();
		e.printStackTrace(new PrintWriter(error));
		request.setAttribute("error", error);
		
		// 2. 에러페이지
		// 컨트롤러가 아니므로 뷰 페이지의 full path를 작성해야 함.
		request.getRequestDispatcher("/WEB-INF/views/error/error.jsp").forward(request, response);
	}
}
