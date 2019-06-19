package Service;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CheckList;
import Models.Staff;
import dao.*;
import tool.Helper;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
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
		String activity = request.getParameter("activity");
		String datatime = request.getParameter("datatime");
		String comments = request.getParameter("comments");
		
		Staff s=new Staff();
		s.setNum(num);
		
		Staff staff=new StaffDao().Query(s).get(0);
		
		
		if(staff!=null) {
			CheckList checkList=new CheckList();
			checkList.setActivity(activity);
			checkList.setComments(comments);
			checkList.setDateTime(Helper.strToDate(datatime));
			checkList.setStaff_id(staff);
			new CheckListDao().add(checkList);
			System.out.println("success");
		}
		response.sendRedirect("checkmananger.jsp");
	}

}
