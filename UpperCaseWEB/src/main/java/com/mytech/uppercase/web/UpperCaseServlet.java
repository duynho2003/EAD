package com.mytech.uppercase.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.naming.InitialContext;

import com.mytech.uppercase.ejb.UpperCaseBeanRemote;

/**
 * Servlet implementation class UpperCaseServlet
 */
public class UpperCaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpperCaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String message = req.getParameter("message");
		try {
			InitialContext context = new InitialContext();
			UpperCaseBeanRemote bean = (UpperCaseBeanRemote) context.lookup("java:app/UpperCaseEJB/UpperCaseBean!com.mytech.uppercase.ejb.UpperCaseBeanRemote");
			String result = bean.transformToUpperCase(message);
			System.out.println("Message after transform: " + result);
			req.setAttribute("result", result);
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} catch (Exception e) {
			System.out.println(">>>Error: " + e.getMessage());
		}
	}

}
