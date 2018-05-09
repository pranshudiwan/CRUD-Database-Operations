package com.pranshu.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pranshu.dao.EmployeeDao;
import com.pranshu.model.Employee;

public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/employee.jsp";
	private static String LIST_EMPLOYEE = "/ListEmployees.jsp";
	private static String SEARCH_EMPLOYEE = "/SearchResults.jsp";
	private EmployeeDao employeedao;

	public EmployeeController() {
		super();
		employeedao = new EmployeeDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = null;
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			employeedao.deleteEmployee(id);
			forward = LIST_EMPLOYEE;
			request.setAttribute("employees", employeedao.getAllEmployees());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int id = Integer.parseInt(request.getParameter("id"));
			Employee employee = employeedao.getId(id);
			request.setAttribute("employee", employee);
		} else if (action.equalsIgnoreCase("listEmployees")) {
			forward = LIST_EMPLOYEE;
			request.setAttribute("employees", employeedao.getAllEmployees());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee employee = new Employee();
		RequestDispatcher view = null;
		String mobile = request.getParameter("mobile");
		String str_drop = request.getParameter("drop");

		if (str_drop == null) {
			
			String id = request.getParameter("id");
			employee.setName(request.getParameter("name"));
			employee.setMobile((mobile == null) ? 0 : Long.parseLong(mobile));
			employee.setDept(request.getParameter("dept"));

			if (id == null || id.isEmpty()) {
				employeedao.addEmployee(employee);
			} else {
				employee.setId(Integer.parseInt(id));
				employeedao.updateEmployee(employee);
			}

			view = request.getRequestDispatcher(LIST_EMPLOYEE);
			request.setAttribute("employees", employeedao.getAllEmployees());
			view.forward(request, response);

		} else {
			switch (str_drop) {
			case "id":
				String empid = request.getParameter("param");
				employee.setId(Integer.parseInt(empid));
				employeedao.searchEmployeeById(employee);
				view = request.getRequestDispatcher(SEARCH_EMPLOYEE);
				request.setAttribute("searchEmployeeResults", employeedao.searchEmployeeById(employee));
				break;

			case "name":
				String empname = request.getParameter("param");
				employee.setName(empname);
				employeedao.searchEmployeeByName(employee);
				view = request.getRequestDispatcher(SEARCH_EMPLOYEE);
				request.setAttribute("searchEmployeeResults", employeedao.searchEmployeeByName(employee));
				break;

			case "mobile":
				String empmobile = request.getParameter("param");
				employee.setMobile(Long.parseLong(empmobile));
				employeedao.searchEmployeeByMobile(employee);
				view = request.getRequestDispatcher(SEARCH_EMPLOYEE);
				request.setAttribute("searchEmployeeResults", employeedao.searchEmployeeByMobile(employee));
				break;

			case "dept":
				String empdept = request.getParameter("param");
				employee.setDept(empdept);
				employeedao.searchEmployeeByDept(employee);
				view = request.getRequestDispatcher(SEARCH_EMPLOYEE);
				request.setAttribute("searchEmployeeResults", employeedao.searchEmployeeByDept(employee));
				break;
				
			default:
				//response.setHeader("Refresh", "0; URL=main.jsp");
			}
			
			try {
			view.forward(request, response);
			} catch(NullPointerException e) {
				System.out.println("wfwfwffeg");
				response.setHeader("Refresh", "0; URL=employee.jsp");
			}
		} 
	}
}
