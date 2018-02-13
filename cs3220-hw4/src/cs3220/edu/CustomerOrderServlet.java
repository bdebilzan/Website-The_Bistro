package cs3220.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import java.util.Date;
import java.util.List;


@WebServlet("/CustomerOrderServlet")
public class CustomerOrderServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		List<Order> orderEntries = (List<Order>) getServletContext().getAttribute("orderEntries");
		
		String removeItem =request.getParameter("removeItem");
		if(removeItem!=null)
		{
			for(Order entry : orderEntries)
			{
				if(entry.getId() == Integer.parseInt(removeItem))
				{
					orderEntries.remove(entry);
				}
			}
		}
		
		context.setAttribute("orderEntries", orderEntries);
		
		request.setAttribute("orderEntries", orderEntries);
		request.getRequestDispatcher("WEB-INF/order.jsp").forward(request, response);
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect(request.getContextPath() + "/CustomerStatusesServlet");
	}

}