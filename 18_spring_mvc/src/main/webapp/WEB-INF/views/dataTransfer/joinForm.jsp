<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
</head>
<body>

	<form action="transfer4" method="post"> 
		<input type="hidden" name="url1" value="transfer1">
		<input type="hidden" name="url2" value="transfer2">
		<input type="hidden" name="url3" value="transfer3">
		<input type="hidden" name="url4" value="transfer4">
		<input type="hidden" name="url5" value="transfer5">
		<fieldset>
			<legend>회원가입</legend>
			<p> 아이디 : <input type="text" name="memberId" /></p>
			<p> 이름 :  <input type="text" name="memberName" /></p>
			<p> 
				성별 : <select name="memberGender">
							<option value="M">남자</option>
							<option value="F">여자</option>
						</select>
			</p>		
			<p> 연락처 : <input type="text"  name="hp" ></p>		
			<p> 이메일 : <input type="email" name="email" ></p>		
			<p> 거주지 : <input type="text"  name="residence" ></p>		
		    <p><input type="submit" value="회원가입" ></p>
		</fieldset>	
     </form>
     
    <p>이미 회원가입이 되어있으면 <a href="transfer5?isMember=yes&isSession=no">로그인(param)으로 이동하기</a></p>
    <p>이미 회원가입이 되어있으면 <a href="transfer6/yes/no">로그인(path variable)으로 이동하기</a></p>

</body>
</html>