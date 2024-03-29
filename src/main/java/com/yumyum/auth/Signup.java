package com.yumyum.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/signup.do")
public class Signup extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String auth = req.getParameter("auth");
		
		req.setAttribute("auth", auth);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/yumyum/auth/signup.jsp");
		dispatcher.forward(req, resp);

	}

}