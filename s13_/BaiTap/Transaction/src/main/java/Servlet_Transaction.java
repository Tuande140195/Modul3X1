import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Servlet_Transaction", urlPatterns = "/transaction")
public class Servlet_Transaction extends HttpServlet {
    private String jdbcURL = "jdbc:mysql://localhost:3306/bai_12";
    private String jdbcUsername = "demo";
    private String jdbcPassword = "26032000";
    private Connection connection;
    private static final String INSERT_USER = "insert into user_permision (permision_id, user_id) values (?,?)";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        call_Transaction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void call_Transaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, "1");
            preparedStatement.executeUpdate();
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, "1");
            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}