package presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.Customer;
import business.facades.CustomerFacade;
import business.Employee;
import business.exceptions.EmailAlreadyInUseException;
import business.exceptions.IncorrectEmailFormattingException;
import business.exceptions.InsecurePasswordException;
import business.exceptions.InvalidUsernameOrPasswordException;
import business.exceptions.StorageLayerException;
import business.facades.EmployeeFacade;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lovro
 */
public class UserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String formName = request.getParameter("formName");
        switch (formName) {
            case "CustomerRegistrationForm":
                customerRegister(request, response);
                break;
            case "CustomerLoginForm":
                customerLogin(request, session, response);
                break;
            case "EmployeeRegistrationForm":
                employeeRegister(request, response);
                break;
            case "EmployeeLoginForm":
                employeeLogin(request, response);
                break;
            case "CustomerInformation":
                customerGetInfo(request, session, response);
                break;
        }
    }

    private void customerGetInfo(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException, ServletException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            Customer updatedCustomer = new Customer(email, password, firstName, lastName, address, phone);
            Customer oldCustomer = (Customer) session.getAttribute("currentCustomer");
            CustomerFacade.updateCustomerInformation(updatedCustomer, oldCustomer);
            session.setAttribute("currentCustomer", updatedCustomer);
            request.getRequestDispatcher("loggedInHome.jsp").forward(request, response);
        } catch (InvalidUsernameOrPasswordException e) {
            System.out.println(e.getMessage());
            request.setAttribute("Error", "errorMessageEmailExists");
            request.getRequestDispatcher("customerInfo.jsp").forward(request, response);
        } catch (InsecurePasswordException ex) {
            System.out.println(ex.getMessage());
            request.setAttribute("InsecurePasswordException", "Error");
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("firstName", request.getParameter("firstName"));
            request.setAttribute("lastName", request.getParameter("lastName"));
            request.setAttribute("address", request.getParameter("address"));
            request.setAttribute("phone", request.getParameter("phone"));
            request.getRequestDispatcher("customerInfo.jsp").forward(request, response);
        } catch (IncorrectEmailFormattingException e) {
            System.out.println(e.getMessage());
            request.setAttribute("Error", "IncorrectEmailFormattingException");
            request.getRequestDispatcher("customerInfo.jsp").forward(request, response);
        } catch (EmailAlreadyInUseException ex) {
            System.out.println(ex.getMessage());
            request.setAttribute("Error", "EmailAlreadyInUseException");
            request.getRequestDispatcher("customerInfo.jsp").forward(request, response);
        } catch (StorageLayerException e) {
             request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }

    private void employeeLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Employee employee = EmployeeFacade.getEmployee(username, password);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);
            request.getSession().setAttribute("currentEmployee", employee);
            request.getRequestDispatcher("employeeOverview.jsp").forward(request, response);
        } catch (InvalidUsernameOrPasswordException e) {
            request.setAttribute("Error", "errorMessageUserNotFound");
            request.getRequestDispatcher("loginEmployee.jsp").forward(request, response);
        } catch (StorageLayerException ex) {
             request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }

    private void employeeRegister(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            EmployeeFacade.createEmployee(username, password, firstName, lastName, phone, email);
            request.getRequestDispatcher("loginEmployee.jsp").forward(request, response);
        } catch (InvalidUsernameOrPasswordException e) {
            request.setAttribute("errorMessageUsernameExists", "Error");
            request.getRequestDispatcher("regEmployee.jsp").forward(request, response);
        } catch (InsecurePasswordException ex) {
            System.out.println(ex.getMessage());
            request.setAttribute("Error", "InsecurePasswordException");
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("firstName", request.getParameter("firstName"));
            request.setAttribute("lastName", request.getParameter("lastName"));
            request.setAttribute("address", request.getParameter("address"));
            request.setAttribute("phone", request.getParameter("phone"));
            request.getRequestDispatcher("regEmployee.jsp").forward(request, response);
        } catch (StorageLayerException e) {
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }

    private void customerLogin(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Customer customer = CustomerFacade.getCustomer(email, password);
            CustomerFacade.setCustomerId(customer);
            session.setAttribute("currentCustomer", customer);
            request.getRequestDispatcher("loggedInHome.jsp").forward(request, response);
        } catch (InvalidUsernameOrPasswordException e) {
            System.out.println(e.getMessage());
            request.setAttribute("Error", "errorMessageUserNotFound");
            request.getRequestDispatcher("loginCustomer.jsp").forward(request, response);
        } catch (StorageLayerException ex) {
            
        }
    }

    private void customerRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            CustomerFacade.createCustomer(email, password, firstName, lastName, address, phone);
            request.getRequestDispatcher("loginCustomer.jsp").forward(request, response);
        } catch (InvalidUsernameOrPasswordException e) {
            System.out.println(e.getMessage());
            request.setAttribute("Error", "errorMessageEmailExists");
            request.getRequestDispatcher("regCustomer.jsp").forward(request, response);
        } catch (InsecurePasswordException ex) {
            System.out.println(ex.getMessage());
            request.setAttribute("InsecurePasswordException", "Error");
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("firstName", request.getParameter("firstName"));
            request.setAttribute("lastName", request.getParameter("lastName"));
            request.setAttribute("address", request.getParameter("address"));
            request.setAttribute("phone", request.getParameter("phone"));
            request.getRequestDispatcher("regCustomer.jsp").forward(request, response);
        } catch (IncorrectEmailFormattingException e) {
            System.out.println(e.getMessage());
            request.setAttribute("Error", "IncorrectEmailFormattingException");
            request.getRequestDispatcher("regCustomer.jsp").forward(request, response);
        } catch (EmailAlreadyInUseException ex) {
            System.out.println(ex.getMessage());
            request.setAttribute("Error", "EmailAlreadyInUseException");
            request.getRequestDispatcher("regCustomer.jsp").forward(request, response);
        } catch (StorageLayerException e) {
             request.getRequestDispatcher("errorPage.jsp").forward(request, response);
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
