package Service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Admin;
import dao.UserDao;

/**
 * Servlet implementation class ChangeKey
 */
@WebServlet("/ChangeKey")
public class ChangeKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeKey() {
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
		String newpass = request.getParameter("newpass");
		String newpass1 = request.getParameter("newpass1");
		if(!newpass.equals(newpass1)||newpass.equals("")) {
			response.sendRedirect("user_fix.jsp?isDone=false");
		}else {
			 UserDao dao=new UserDao();
			 Admin admin=new Admin();
			 admin.setPassword(newpass);
			 admin.setUser("root");
			 admin.setId(1);
			 dao.update(admin);
			 response.sendRedirect("user_fix.jsp?isDone=true");
		}
	}

}
