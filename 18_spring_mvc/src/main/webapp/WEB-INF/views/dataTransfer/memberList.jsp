<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
</head>
<body>
	<h1>${method }</h1>
	<br>
	<table border="1">
		<tr align="center">
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>연락처</th>
			<th>이메일</th>
			<th>거주지</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr align="center">
				<td>${member.memberId }</td>
				<td>${member.memberName }</td>
				<td>${member.memberGender }</td>
				<td>${member.hp }</td>
				<td>${member.email }</td>
				<td>${member.regidence }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>