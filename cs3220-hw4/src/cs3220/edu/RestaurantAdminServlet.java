package cs3220.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RestaurantAdminServlet")
public class RestaurantAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodItem> items = (List<FoodItem>) request.getSession().getAttribute("items");
		
		String deletedRecipeName=request.getParameter("Submit");
		if(deletedRecipeName!=null)
		{
			for (Iterator<FoodItem> iter =items.listIterator(); iter.hasNext(); ) {
			    FoodItem item = iter.next();
			    if (item.getName().equals(deletedRecipeName)) {
			        iter.remove();
			    }
			}
		}
		
		String editRecipeName=request.getParameter("Submit");
		if(editRecipeName!=null)
		{
			for (Iterator<FoodItem> iter =items.listIterator(); iter.hasNext(); ) {
			    FoodItem item = iter.next();
			    if (item.getName().equals(editRecipeName)) {
			        
			    }
			}
		}
		
		FoodItemDAO dao = new FoodItemDAO();
		
		request.setAttribute("items", dao.list());
		request.setAttribute("date", new Date());
		request.getRequestDispatcher("WEB-INF/admininventory.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getContextPath() + "/AdminCreateFoodServlet");
		
	}

	
}