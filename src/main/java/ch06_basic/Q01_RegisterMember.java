package ch06_basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Q01_RegisterMember
 */
@WebServlet("/ch06/register")
public class Q01_RegisterMember extends HttpServlet {

	// Form 화면을 띄워주는 코드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>Register Member</title>"
				+ "</head>"
				+ "<body>"
				+ "	<h1>회원 등록</h1>"
				+ "	<hr>"
				+ "	<form action=\"/jw/ch06/register\" method=\"post\">"
				+ "		아이디: <input type=\"text\" name=\"uid\"><br><br>"
				+ "		패스워드: <input type=\"password\" name=\"pwd\"><br><br>"
				+ "		이름: <input type=\"text\" name=\"uname\"><br><br>"
				+ "		이메일: <input type=\"text\" name=\"email\"><br><br>"
				+ "		<input type=\"submit\" value=\"등록\">"
				+ "	</form>"
				+ "</body>"
				+ "</html>";
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(html);
	}

	// 입력 결과를 받아서 화면에 보여주는 코드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>회원 등록</title>"
				+ "</head>"
				+ "<body>"
				+ "	<h1>회원 등록 창에서 입력한 값</h1>"
				+ "	<hr>"
				+ "	<ul>"
				+ "		<li>아이디: " + uid + "</li>"
				+ "		<li>패스워드: " + pwd + "</li>"
				+ "		<li>이름: " + uname + "</li>"
				+ "		<li>이메일: " + email + "</li>"
				+ "	</ul>"
				+ "	<button onclick=\"location.href='/jw/ch06/register'\">재실행</button>"
				+ "</body>"
				+ "</html>";
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(html);
	}

}