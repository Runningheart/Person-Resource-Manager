package Service;

import java.io.IOException;
import java.sql.Date;
import dao.*;
import tool.Helper;
import Service.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.PersonnelChange;
import Models.Staff;

/**
 * Servlet implementation class Staffout
 */
@WebServlet("/Staffout")
public class Staffout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Staffout() {
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
		String date = request.getParameter("date");
		
		if(num==null||num.equals("")) {
			response.sendRedirect("person_out.jsp");
		}else {
			Staff s=new Staff();
			s.setNum(num);
			Staff staff=new StaffDao().Query(s).get(0);
			staff.setIsOnline("离职");
			new StaffDao().update(staff);
			
			PersonnelChange change=new PersonnelChange();
			change.setActivity("离职");
			change.setDateTime(Helper.strToDate(date));
			change.setNowJob(null);
			change.setOldJob(staff.getJob_id());
			change.setStaff_id(staff);
			
			new PersonnelChangeDao().add(change);
			
			response.sendRedirect("person_out.jsp");
		}
	}

}
