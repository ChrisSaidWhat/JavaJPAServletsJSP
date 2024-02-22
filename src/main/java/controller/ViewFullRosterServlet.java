package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewFullRosterServlet
 */
@WebServlet("/viewFullRosterServlet")
public class ViewFullRosterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFullRosterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerEntryHelper daoMan = new ManagerEntryHelper();
		EmployeeEntryHelper daoEmp = new EmployeeEntryHelper();
		request.setAttribute("manRoster", daoMan.showAllEntries());
		request.setAttribute("empRoster", daoEmp.showAllEntries());
		
		String path = "/fullRoster.jsp";
		
		if(daoMan.showAllEntries().isEmpty() || daoEmp.showAllEntries().isEmpty()) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
