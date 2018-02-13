package cs3220.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import cs3220.edu.Database;

@WebServlet("/fooditem/create")
public class CreateFoodItemServlet extends HttpServlet {
    public void init () throws ServletException {
        // load driver
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch( ClassNotFoundException e ) {
            throw new ServletException( e );
        }
    }

	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/admincreate-food.jsp")
        .forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String foodname = request.getParameter("name");
	    String description = request.getParameter("description");
	    String imageurl = request.getParameter("url");
	    Double price = Double.parseDouble(request.getParameter("price"));
	    
	    FoodItem newEntry = new FoodItem(-1, foodname, description, imageurl, price);
	    FoodItemDAO dao = new FoodItemDAO();
        dao.add(newEntry);
        response.sendRedirect("../RestaurantAdminServlet");
	}
}