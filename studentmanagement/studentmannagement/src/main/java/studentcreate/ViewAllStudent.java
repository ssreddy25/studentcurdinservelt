package studentcreate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.model.StudentPojo;
import com.student.dao.StudentImplement;

/**
 * Servlet implementation class ViewAllStudent
 */
public class ViewAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllStudent() {
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
		List<StudentPojo> students=studi.viewAllStudent();
		
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>Student ID</td>");
		out.println("<td>Student Name</td>");
		out.println("<td>Student RollNo</td>");
		out.println("<td>Student Garde</td>");
		out.println("<td>View Student</td>");
		out.println("<td>Edit Student</td>");
		out.println("<td>Delete Student</td>");
		out.println("</tr>");
        
		
		for(StudentPojo stu:students){
			out.println("<tr>");
			
			out.println("<td>"+stu.getStudentId()+"</td>");
			out.println("<td>"+stu.getStudentName()+"</td>");
			out.println("<td>"+stu.getStudentRollNo()+"</td>");
			out.println("<td>"+stu.getStudentGrade()+"</td>");
			out.println("<td><a href='vstudent?sid="+stu.getStudentId()+"'>view</a></td>");
			out.println("<td><a href='editstudent?sid="+stu.getStudentId()+"'>edit</a></td>");
			out.println("<td><a href='deletestu?sid="+stu.getStudentId()+"'>delete</a></td>");
			out.println("</tr>");
			
			
		}
		
		
	
		out.println("</table>");
		
		out.println("<a href='student.html' style='color:red'>back to home page</a>");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
