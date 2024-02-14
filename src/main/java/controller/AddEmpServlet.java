package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeEntry;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/addEmpServlet")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		EmployeeEntry empEnt = new EmployeeEntry(firstName, lastName);
		EmployeeEntryHelper dao = new EmployeeEntryHelper();
		dao.addEmployee(empEnt);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
