<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file upload</title>
</head>
<body>
<h1>Upload completed</h1>
<div class="result-images">
  <img alt="img" src="${pageContest.request.contextPath}${url}" style="width:150px">
</div>
<p><a href='/guestbook/form'> 다시 업로드 하기 </a></p>
</body>
</html>