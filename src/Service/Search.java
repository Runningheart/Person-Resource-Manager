package Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Staff;
import dao.*;
import Service.*;
/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		
		String choose=request.getParameter("choose");
		String reg=request.getParameter("text");
		List<Staff> staff=null;
		StaffDao dao=new StaffDao();
		JobDao jobdao=new JobDao();
		DepartmentDao departmentDao=new DepartmentDao();
		if(choose.equals("1")) {
			staff=dao.QueryByNum(reg);
		}else if(choose.equals("2")) {
			staff=dao.QueryByName(reg);
		}else if(choose.equals("3")) {
			staff=dao.QueryByJobid(jobdao.QueryByName(reg).getId());
		}else if(choose.equals("4")){
			staff=dao.QueryByDepid(departmentDao.QueryByName(reg).getId());
		}
//		for(Staff s:staff) {
//			s.toString();
//		}
		request.setAttribute("list", staff);
		request.getRequestDispatcher("search.jsp?Page=1").forward(request, response);
	}

}
