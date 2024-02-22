package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeEntry;
import model.ManagerEntry;

/**
 * Servlet implementation class AddManServlet
 */
@WebServlet("/addManServlet")
public class AddManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddManServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		ManagerEntry manEnt = new ManagerEntry(firstName, lastName);
		ManagerEntryHelper dao = new ManagerEntryHelper();
		dao.addManager(manEnt);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
