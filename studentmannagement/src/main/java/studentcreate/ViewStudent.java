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
 * Servlet implementation class ViewStudent
 */
public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudent() {
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
		
		int studentId =Integer.parseInt(request.getParameter("sid"));
		
		student =studi.viewStudent(studentId);
		
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>Student ID</td>");
		out.println("<td>Student Name</td>");
		out.println("<td>Student RollNo</td>");
		out.println("<td>Student Garde</td>");	
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td>"+student.getStudentId()+"</td>");
		out.println("<td>"+student.getStudentName()+"</td>");
		out.println("<td>"+student.getStudentRollNo()+"</td>");
		out.println("<td>"+student.getStudentGrade()+"</td>");
		out.println("</tr>");
		out.println("</table>");
		
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
