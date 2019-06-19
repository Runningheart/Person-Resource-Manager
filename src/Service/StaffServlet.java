package Service;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Department;
import Models.Job;
import Models.Staff;
import dao.DepartmentDao;
import dao.JobDao;
import dao.StaffDao;
import tool.Helper;

/**
 * Servlet implementation class StaffServlet
 */

@WebServlet(name = "StaffServlet",urlPatterns = "/StaffServlet")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String health = request.getParameter("health");
		String political = request.getParameter("political");
		String birthday = request.getParameter("birthday");
		String jobname = request.getParameter("job");
		String departname = request.getParameter("dep");
		String isOnline = "在职";
		
		
		System.out.println(jobname+"###"+departname);
		Job job=new JobDao().QueryByName(jobname);
		Department department=new DepartmentDao().QueryByName(departname);
		
		if(job==null||department==null) {
			System.out.println("null warning");
			response.sendRedirect("person_new.jsp");
		}else {
			Staff staff=new Staff();
			staff.setNum(num);
			staff.setName(name);
			staff.setHealth(health);
			staff.setPolitical(political);
			staff.setBirthday(Helper.strToDate(birthday));
			staff.setJob_id(job);
			staff.setDep_id(department);
			staff.setIsOnline(isOnline);
			try {
				new StaffDao().add(staff);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("person_new.jsp");
	
	}

}
