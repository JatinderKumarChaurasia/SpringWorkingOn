package com.databasetest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public TestDBServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = "springstudent";
		String password = "springstudent";
		// for JAVA9 AND ABOVE
	//	String jdbcURL = "jdbc:mysql://localhost:3306/customer_tracker?useSSL=false&amp;serverTimezone=UTC";
		String jdbcURL = "jdbc:mysql://localhost:3306/customer_tracker?useSSL=false";

		String driver = "com.mysql.jdbc.Driver";

		try {
			PrintWriter output = response.getWriter();
			output.println("Connecting to Database :" + jdbcURL);
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(jdbcURL,user,password);
			output.println("Connected Successfully--------------------------------)");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
