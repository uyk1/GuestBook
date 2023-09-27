<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AjaxTest</title>
</head>
<body>

	<form id="add-form" action="" method="post">
		<input type="text" name="name" id="input-name" placeholder="이름">
		<input type="password" name="pwd" id="input-password"
			placeholder="비밀번호">
		<textarea id="tx-content" name="content" placeholder="내용을 입력해 주세요."></textarea>
		<input id="input-submit" type="submit" value="보내기" />
	</form>

	<script type="text/javascript">
  $("#add-form").submit(function(event)) {
	  event.preventDefault();
	  
	  // serialize는 FORM의 <input> 요소들의 name이 배열형태로 그 값이 인코딩되어 URL query string으로 하는 메서드
	  let queryString = $(this).serialize();
	  
	  $.ajax({
		  url: "/guestbook/insert",
		  type: "POST",
		  dataType: "json",
		  data: queryString,
		  success: function(result){
			  // ajax 통신 성공 시 로직 수행
		  }
	  })
  }
  </script>

</body>
</html>