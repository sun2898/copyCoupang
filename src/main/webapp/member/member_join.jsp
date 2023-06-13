<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp"%>

	<section>
	
	<div align = "center">
	<h3>회원가입</h3>
 	<form action="joinForm.member" method ="post">
 		<table border="1">
 			<tr>
 				<td>아이디</td>
 				<td> <input type="text" name = "m_id" required="required" pattern = "\w{4,}"> </td>
 			<tr/>
 			<tr>
 				<td>비밀번호</td>
 				<td> <input type="password" name = "m_pw"> </td>
 			<tr/>
 			<tr>
 				<td>이름</td>
 				<td> <input type="text" name = "m_name"> </td>
 			<tr/>
 			<tr>
 				<td>이메일</td>
 				<td> <input type="email" name = "m_email"> </td>
 			<tr/>
 			<tr>
 				<td>주소</td>
 				<td> <input type="text" name = "m_adress"> </td>
 			<tr/>
		</table>
		
		<div style="color: orange;" >${msg }</div>
		
		
		<input type="submit" value = "가입">
		<input type="reset" value = "정보초기화">
		
	
	</section>

<%@ include file = "../include/footer.jsp"%>