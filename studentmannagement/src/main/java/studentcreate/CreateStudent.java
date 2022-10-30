package studentcreate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.model.StudentPojo;
import com.student.dao.StudentImplement;

/**
 * Servlet implementation class CreateStudent
 */
public class CreateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		StudentImplement studi=new StudentImplement();
		StudentPojo student=new StudentPojo();
		student.setStudentId(Integer.parseInt(request.getParameter("sid")));
		student.setStudentName(request.getParameter("sname"));
		student.setStudentRollNo(Integer.parseInt(request.getParameter("srllno")));
		student.setStudentGrade(request.getParameter("garde"));
		String msg=studi.createStudent(student);
		
	    out.println(msg);
	    RequestDispatcher reqd=request.getRequestDispatcher("student.html");
	    reqd.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
