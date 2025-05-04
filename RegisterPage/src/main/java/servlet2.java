
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement psmt = null;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uemail = request.getParameter("uemail");
		String upass = request.getParameter("password");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "1234");
			String q = "SELECT * FROM userRegistration WHERE email = ?";
			psmt = con.prepareStatement(q);
			psmt.setString(1, uemail);

			rs = psmt.executeQuery();

			if (rs.next()) {
				// first get value from db and then check
				String storedPassword = rs.getString("password");
                     // check password stored from store db
				if (storedPassword.equals(upass)) {
					out.print("<h1>Login Successful!</h1>");
					// redirect to home 
					response.sendRedirect("home.html");
				} else {
					out.print("<h1>Invalid Password!</h1>");
					RequestDispatcher rd = request.getRequestDispatcher("login.html");
					rd.include(request, response);
				}

			} else {

				out.print("<h1>Invalid Email!</h1>");
			}

		} catch (Exception e) {
			out.print("<h1>" + "Error: " + e.getMessage() + "</h1>");
		}
	}
}
