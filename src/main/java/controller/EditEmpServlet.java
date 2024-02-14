package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeEntry;

/**
 * Servlet implementation class EditEmpServlet
 */
@WebServlet("/editEmpServlet")
public class EditEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmpServlet() {
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
		
		EmployeeEntryHelper dao = new EmployeeEntryHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer tempEmpNo = Integer.parseInt(request.getParameter("empNo"));
		
		EmployeeEntry empToUpdate = dao.searchForEntryByEmpNo(tempEmpNo);
		empToUpdate.setFirstName(firstName);
		empToUpdate.setLastName(lastName);
		
		dao.updateEntry(empToUpdate);
		
		getServletContext().getRequestDispatcher("/viewEmpRosterServlet").forward(request, response);
	}

}
