package studentcreate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.model.StudentPojo;
import com.student.dao.StudentImplement;
import com.student.db.DBUtility;

/**
 * Servlet implementation class EditStudent
 */
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudent() {
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
		
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from student where studentId=?");
			
			ps.setInt(1, studentId);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				
				out.println("<form action='./updateStudent'>");
				out.println("<table>");
				
				out.println("<tr>");
				out.println("<td>Student ID</td>");
				out.println("<td><input type='text' name='sid' value='"+rs.getInt(1)+"' /></td>");
				out.println("<tr>");
				
				out.println("<tr>");
				out.println("<td>Student name</td>");
				out.println("<td><input type='text' name='sname' value='"+rs.getString(2)+"' /></td>");
				out.println("<tr>");
				
				out.println("<tr>");
				out.println("<td>Student rollno</td>");
				out.println("<td><input type='text' name='srollno' value='"+rs.getInt(3)+"' /></td>");
				out.println("<tr>");
				
				out.println("<tr>");
				out.println("<td>Student grade</td>");
				out.println("<td><input type='text' name='sgrade' value='"+rs.getString(4)+"' /></td>");
				out.println("<tr>");
				
				out.println("<tr>");
				
				out.println("<td><button type='submit' style='color:red'>update</button></td>");
				out.println("<tr>");
				
				out.println("</table>");
				out.println("</form>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
