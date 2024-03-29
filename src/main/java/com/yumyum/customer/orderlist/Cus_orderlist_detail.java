package com.yumyum.customer.orderlist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yumyum.dao.OrderlistDAO;
import com.yumyum.dto.Order_menuDTO;
import com.yumyum.dto.OrderlistDTO;

@WebServlet("/customer/orderlist/cus_orderlist_detail.do")
public class Cus_orderlist_detail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String userSeq = session.getAttribute("seq").toString();
		
		String orderlistSeq = req.getParameter("seq");
		
		OrderlistDAO dao = new OrderlistDAO();
		
		ArrayList<OrderlistDTO> infoList = dao.getOrderInfo(orderlistSeq);
		ArrayList<Order_menuDTO> menuList = dao.getOrdermenu(userSeq);
		
		req.setAttribute("infoList", infoList);
		req.setAttribute("menuList", menuList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/yumyum/customer/orderlist/cus_orderlist_detail.jsp");
		dispatcher.forward(req, resp);

	}

}