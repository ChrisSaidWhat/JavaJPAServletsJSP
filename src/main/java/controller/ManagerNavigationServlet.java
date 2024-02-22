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
 * Servlet implementation class ManagerNavigationServlet
 */
@WebServlet("/managerNavigationServlet")
public class ManagerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerNavigationServlet() {
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
		
		String act = request.getParameter("doThisToItem");
		String path = "/viewManRosterServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempManNo = Integer.parseInt(request.getParameter("manNo"));
				ManagerEntry manToDelete = dao.searchForEntryByManNo(tempManNo);
				dao.deleteEntry(manToDelete);
			}
			catch(NumberFormatException e) {
				System.out.println("FAILURE @LN:47 -- ManagerNavigationServlet.java");
			}
		}
		else if(act.equals("edit")) {
			try {
				Integer tempManNo = Integer.parseInt(request.getParameter("manNo"));
				ManagerEntry manToEdit = dao.searchForEntryByManNo(tempManNo);
				request.setAttribute("manToEdit", manToEdit);
				path = "/editMan.jsp";
			}
			catch(NumberFormatException e) {
				System.out.println("FAILURE @LN:57 -- ManagerNavigationServlet.java");
			}
			
		}
		else if(act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
