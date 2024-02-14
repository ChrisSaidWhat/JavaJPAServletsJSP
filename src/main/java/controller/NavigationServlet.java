package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeEntry;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String act = request.getParameter("doThisToItem");
		String path = "/viewEmpRosterServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempEmpNo = Integer.parseInt(request.getParameter("empNo"));
				EmployeeEntry empToDelete = dao.searchForEntryByEmpNo(tempEmpNo);
				dao.deleteEntry(empToDelete);
			}
			catch(NumberFormatException e) {
				System.out.println("FAILURE @LN:47 -- NavigationServlet.java");
			}
		}
		else if(act.equals("edit")) {
			try {
				Integer tempEmpNo = Integer.parseInt(request.getParameter("empNo"));
				EmployeeEntry empToEdit = dao.searchForEntryByEmpNo(tempEmpNo);
				request.setAttribute("empToEdit", empToEdit);
				path = "/editEmp.jsp";
			}
			catch(NumberFormatException e) {
				System.out.println("FAILURE @LN:57 -- NavigationServlet.java");
			}
			
		}
		else if(act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
