package studentcreate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.model.StudentPojo;
import com.student.dao.StudentImplement;

/**
 * Servlet implementation class UpdateStudent
 */
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
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
//		StudentPojo student=new StudentPojo();
		
		int sid=Integer.parseInt(request.getParameter("sid"));
		
		String sname=request.getParameter("sname");
		
		int srollno=Integer.parseInt(request.getParameter("srollno"));
		
		String sgarde=request.getParameter("sgrade");
		
		StudentPojo student=new StudentPojo(sid,sname,srollno,sgarde);
		
//		student.setStudentId(sid);
//		student.setStudentName(sname);
//		student.setStudentRollNo(srollno);
//		student.setStudentGrade(sgarde);
		
		String msg=studi.updateStudent(sid, student);
		
		out.println("<h1 style='color:green'>"+ msg +"</h1>");
		
		out.println("<a href='vallstudent'>back to the student details</a></td>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
