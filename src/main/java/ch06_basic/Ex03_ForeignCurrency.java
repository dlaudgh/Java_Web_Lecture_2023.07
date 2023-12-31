package ch06_basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex03_ForeignCurrency
 */
@WebServlet("/ch06/currency")
public class Ex03_ForeignCurrency extends HttpServlet {
	static final String[] FOREIGN_CURRENCY = {"USD", "EUR", "JPY", "CNY"};
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String won_ = request.getParameter("won");
		String currency_ = request.getParameter("currency");
		
		int won = Integer.parseInt(won_);
		
		double[] currencyRate = {1304.8, 1429.21, 913.18, 180.14};
		int currencyIndex = Integer.parseInt(currency_);
		
		double exchangeAmount = won / currencyRate[currencyIndex];
		String data = String.format("%,d 원 -> ", won);
		data += String.format("%.2f %s", exchangeAmount, FOREIGN_CURRENCY[currencyIndex]);
		
		String html = "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>환율 계산기</title>"
				+ "</head>"
				+ "<body style=\"margin: 40px\">"
				+ "	<h1>환율 계산기</h1>"
				+ "	<hr>"
				+ "	<h3>" + data + "</h3>"
				+ "	<br>"
				+ "	<button onclick=\"location.href='/jw/ch06/foreignCurrency.html'\">재실행</button>"
				+ "</body>"
				+ "</html>";
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
