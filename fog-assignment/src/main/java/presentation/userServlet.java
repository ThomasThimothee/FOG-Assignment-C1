package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.Customer;
import business.facades.CustomerFacade;
import business.Employee;
import business.InvalidUsernameOrPasswordException;
import business.facades.EmployeeFacade;

/**
 *
 * @author Lovro
 */
public class userServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String formName = request.getParameter("formName");
        switch (formName) {
            case "CustomerRegistrationForm":
                try {
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String address = request.getParameter("address");
                    String phone = request.getParameter("phone");
                    CustomerFacade.createCustomer(email, password, firstName, lastName, address, phone);
                    request.setAttribute("messageUserCreated", "Congratulations, your new account has been created! Log in with your e-mail and password.");
                    request.getRequestDispatcher("loginCustomer.jsp").forward(request, response);
                } catch (InvalidUsernameOrPasswordException e) {
                    System.out.println(e.getMessage());
                    request.setAttribute("errorMessageEmailExists", "Error");
                    request.getRequestDispatcher("regCustomer.jsp").forward(request, response);
                    
                }
                break;
            case "CustomerLoginForm":
                try {
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    Customer customer = CustomerFacade.getCustomer(email, password);
                    request.getSession().setAttribute("email", email);
                    request.getSession().setAttribute("password", password);
                    request.getSession().setAttribute("currentUser", customer);
                    request.getRequestDispatcher("index.html").forward(request, response);

                } catch (InvalidUsernameOrPasswordException e) {
                   request.setAttribute("errorMessageUserNotFound", "Error");
                    request.getRequestDispatcher("loginCustomer.jsp").forward(request, response);
                }
                break;
            case "EmployeeRegistrationForm":
               try {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    EmployeeFacade.createEmployee(username, password, firstName, lastName, phone, email);
                    request.setAttribute("messageUserCreated", "Congratulations, your new account has been created! Log in with your e-mail and password.");
                    request.getRequestDispatcher("loginEmployee.jsp").forward(request, response);
                } catch (InvalidUsernameOrPasswordException e) {
                   request.setAttribute("errorMessageUsernameExists", "Error");
                    request.getRequestDispatcher("regEmployee.jsp").forward(request, response);
                }
                break;
                case"EmployeeLoginForm":
                      try {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    Employee employee = EmployeeFacade.getEmployee(username, password);
                    request.getSession().setAttribute("username", username);
                    request.getSession().setAttribute("password", password);
                    request.getSession().setAttribute("currentUser", employee);
                    request.getRequestDispatcher("index.html").forward(request, response);

                } catch (InvalidUsernameOrPasswordException e) {
                     request.setAttribute("errorMessageUserNotFound", "Error");
                    request.getRequestDispatcher("loginEmployee.jsp").forward(request, response);
                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
