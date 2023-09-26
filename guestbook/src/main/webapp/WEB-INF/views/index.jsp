<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
pageContext.setAttribute("newLine", "\n");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form id="add-form" action="" method="post">
		<input type="text" name="name" id="input-name" placeholder="이름">
		<input type="password" name="pwd" id="input-password"
			placeholder="비밀번호">
		<textarea id="tx-content" name="content" placeholder="내용을 입력해 주세요."></textarea>
		<input id="input-submit" type="submit" value="보내기" />
	</form>

	<form action="/guestbook/main" method="post">
		<table border="1" width="500">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="확인"></td>
			</tr>
		</table>
	</form>
	<br>
	<c:set var="count" value="${fn:length(list)}" />
	<c:forEach items="${list}" var="vo" varStatus="status">
		<table width="510" border="1">
			<tr>
				<td>${ (count - status.index) }</td>
				<td>${vo.name }</td>
				<td>${vo.regDate }</td>
				<td><a href="/guestbook/main/deleteform?no=${vo.no }">삭제</a></td>
			</tr>
			<tr>
				<!-- 개행(\n)을 JSTL에서 사용할 수 없어 page context에 다른 변수로 추가 -->
				<td>${fn:replace(vo.content, newLine, "<br>") }</td>
			</tr>
		</table>
		<br>
	</c:forEach>
	<img alt="img"
		src="${pageContext.servletContext.contextPath}/assets/images/1.jpeg">

	<script type="text/javascript" >
  $("#add-form").submit(function(event) {
    event.preventDefault();
    // JSON으로 요청
    var data = {};
    $.each($(this).serializeArray(), function(index, o){
    	data[o.name] = o.value
    })
    $.ajac({
    	url: "ajaxtest/api/guestbook/insert",
    	type: "POST",
    	dataType: "json", // ajax 통신으로 받는 타입
    	contentType: "application/json", // ajax 통신으로 보내는 타입
    	data: JSON.stringify(data),
    	success: function(result){
    		// ajax 통신 성공 시 로직 수행
    	}
    })
    
    /* 
    // serialize는 FORM의 <input> 요소들의 name이 배열형태로 그 값이 인코딩되어 URL query string으로 하는 메서드
    let queryString = $(this).serialize();
    
    $.ajax({
      url: "/ajaxtest/api/guestbook/insert",
      type: "POST",
      dataType: "json",
      data: queryString,
      success: function(result){
        // ajax 통신 성공 시 로직 수행
        consol.log(result);
      }
    }) */
  })
  </script>

</body>
</html>