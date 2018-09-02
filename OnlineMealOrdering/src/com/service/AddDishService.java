package com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.domian.Dish;
import com.domian.Manager;

/**
 * Servlet implementation class LoginService
 */
@WebServlet("/AddDishService")
public class AddDishService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddDishService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dishName = request.getParameter("dishName");
		String price = request.getParameter("dishPrice");
		String description = request.getParameter("description");
		String filePath = getServletContext().getRealPath("/WebContent/Dishes_img/w.jpg");
		HttpSession session = request.getSession();
		Manager manager = (Manager)session.getAttribute("manager");
		String managerId = manager.getManagerId();
		if(Dish.createDish(dishName, price, description, filePath, managerId)) {
			PrintWriter pw=response.getWriter();
			pw.write("<script language='javascript'>alert('The dish has bee added'); "
					+ "window.location.href='/OnlineMealOrdering/manager_menu.html';</script>");
		}
//		System.out.println("dishPrice:" + price + "dishName:" + dishName);
//		System.out.println("filePath"+filePath);
//		doGet(request, response);

	}


}
