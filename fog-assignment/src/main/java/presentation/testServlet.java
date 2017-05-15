/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.Customer;
import business.Order;
import business.exceptions.WrongCustomerIDException;
import business.exceptions.InvalidOrderIdException;
import business.exceptions.StorageLayerException;
import business.facades.CustomerFacade;
import business.facades.OrderFacade;
import data.DataMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lovro
 */
public class testServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DataMapper dm = new DataMapper();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("currentCustomer");
        String formName = request.getParameter("formName");
        switch (formName) {
            case "ViewPartlist":
                employeeViewPartlist(request, response);
                break;
            case "ViewCustomerDetails":
                employeeViewCustomerDetails(request, response);
                break;
            case "AddDiscount":
                employeeAddDiscount(request, response);
                break;
            case "PayOrder":
                customerPayOrder(request, customer, response);
                break;
            case "ViewDrawing":
                customerViewDrawing(request, customer, response);
                break;
        }
    }

    private void customerViewDrawing(HttpServletRequest request, Customer customer, HttpServletResponse response) throws IOException, ServletException {
        try {
            int idOrder = Integer.parseInt(request.getParameter("idOrder"));
            Order order = OrderFacade.retrieveOrder(idOrder);
            if (customer.getId_customer() == order.getCustomerId()) {
                request.setAttribute("currentOrder", order);
                request.getRequestDispatcher("customerDrawing.jsp").forward(request, response);
            } else {
                throw new InvalidOrderIdException();
            }
        } catch (InvalidOrderIdException | NumberFormatException e) {
            request.setAttribute("Error", "IncorrectOrderId");
            request.getRequestDispatcher("customerOverview.jsp").forward(request, response);
        }
    }

    private void customerPayOrder(HttpServletRequest request, Customer customer, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idOrder = Integer.parseInt(request.getParameter("idOrder"));
            Order order = OrderFacade.retrieveOrder(idOrder);
            if (customer.getId_customer() == order.getCustomerId()) {
                request.setAttribute("currentOrder", order);
                request.getRequestDispatcher("customerPayment.jsp").forward(request, response);
            } else {
                throw new InvalidOrderIdException();
            }
        } catch (InvalidOrderIdException | NumberFormatException e) {
            request.setAttribute("Error", "IncorrectOrderId");
            request.getRequestDispatcher("customerOverview.jsp").forward(request, response);
        }
    }

    private void employeeAddDiscount(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, ServletException, IOException {
        try {
            int idOrder = Integer.parseInt(request.getParameter("idOrder"));
            double discountRate = Double.parseDouble(request.getParameter("discountRate"));
            if (discountRate > 100) {
                throw new InvalidOrderIdException();
            }
            OrderFacade.setDiscountRate(discountRate, idOrder);
   //         OrderFacade.updateFinalPrice(idOrder);
            request.getRequestDispatcher("employeeOverview.jsp").forward(request, response);
        } catch (InvalidOrderIdException | NumberFormatException e) {
            request.setAttribute("Error", "IncorrectDiscountOrOrderId");
            request.getRequestDispatcher("employeeOverview.jsp").forward(request, response);
        }
    }

    private void employeeViewCustomerDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
            CustomerFacade.retrieveCustomerDetails(idCustomer);
            request.setAttribute("idCustomer", idCustomer);
            request.getRequestDispatcher("customerInfoEmployee.jsp").forward(request, response);
        } catch (WrongCustomerIDException | NumberFormatException e) {
            request.setAttribute("Error", "WrongCustomerIDException");
            request.getRequestDispatcher("employeeOverview.jsp").forward(request, response);
        }
    }

    private void employeeViewPartlist(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, ServletException, IOException {
        try {
            int idOrder = Integer.parseInt(request.getParameter("idOrder"));
            OrderFacade.retrievePartlist(idOrder);
            request.setAttribute("idOrder", idOrder);
            request.getRequestDispatcher("partList.jsp").forward(request, response);
        } catch (WrongCustomerIDException | NumberFormatException e) {
            request.setAttribute("Error", "WrongCustomerIDException");
            request.getRequestDispatcher("employeeOverview.jsp").forward(request, response);
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
