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
 * Servlet implementation class EditManServlet
 */
@WebServlet("/editManServlet")
public class EditManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditManServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		ManagerEntryHelper dao = new ManagerEntryHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer tempManNo = Integer.parseInt(request.getParameter("manNo"));
		
		ManagerEntry manToUpdate = dao.searchForEntryByManNo(tempManNo);
		manToUpdate.setFirstName(firstName);
		manToUpdate.setLastName(lastName);
		
		dao.updateEntry(manToUpdate);
		
		getServletContext().getRequestDispatcher("/viewManRosterServlet").forward(request, response);
	}

}
