package com.imooc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserAgentServlet
 */
@WebServlet("/ua")
public class UserAgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAgentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取请求头中，“User-Agent”的值；
		String userAgent = request.getHeader("User-Agent");
		// 设置一下response，让其支持中文
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(userAgent);
		String output = "";
		if(userAgent.indexOf("Windows NT") != -1) {
			output = "<h1>这是PC版本的</h>";
		}else if((userAgent.indexOf("iPhone") != -1) || (userAgent.indexOf("Android")!= -1)) {
			output = "<h1>这是手机版本的</h1>";
		}
		response.getWriter().println(output);
	}
}
