
package src.bank.management;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/bank")
public class BankManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the login.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the PIN from the form
        String pin = request.getParameter("pin");

        // Basic validation (replace with real authentication logic)
        if ("1234".equals(pin)) { // Replace "1234" with your actual validation logic
            response.sendRedirect("dashboard.jsp"); // Redirect to a dashboard page on success
        } else {
            // Set an error message and forward back to the login page
            request.setAttribute("error", "Invalid PIN. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}