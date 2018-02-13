package cs3220.edu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/AdminCreateFoodServlet"})
public class AdminCreateFoodServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/admincreate-food.jsp");
	        
	       dispatcher.forward(request, response);
		
	}
	
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 Double price=0.0;
		 	List<FoodItem> items = (List<FoodItem>) request.getSession(false).getAttribute("items");
		 	if(items==null)
		 		items=new ArrayList<FoodItem>();
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String imageUrl = request.getParameter("url");
			try{
			 price = Double.parseDouble(request.getParameter("price"));
			}
			catch(Exception ex){
				//not a double
			}
			items.add(new FoodItem(items.size(), name, description, imageUrl, price));
			
			request.setAttribute("date", new Date());
			request.getSession(false).setAttribute("items", items);
			
			response.sendRedirect(request.getContextPath()+"/RestaurantAdminServlet");
	    }
	

}