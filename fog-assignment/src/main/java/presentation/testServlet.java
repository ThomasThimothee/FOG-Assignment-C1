/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.Order;
import business.exceptions.WrongCustomerIDException;
import business.facades.CustomerFacade;
import business.facades.OrderFacade;
import data.DataMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String formName = request.getParameter("formName");
        switch (formName) {
            case "ViewPartlist":
                try {
                    int idOrder = Integer.parseInt(request.getParameter("idOrder"));
                    OrderFacade.retrievePartlist(idOrder);
                    request.setAttribute("idOrder", idOrder);
                    request.getRequestDispatcher("partList.jsp").forward(request, response);
                } catch (WrongCustomerIDException e) {
                    System.out.println(e.getMessage());
                    request.setAttribute("WrongCustomerID", "Error");
                    request.getRequestDispatcher("employeeOverview.jsp").forward(request, response);
                }
                break;
            case "ViewCustomerDetails":
                try {
                   int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
                    CustomerFacade.retrieveCustomerDetails(idCustomer);
                    request.setAttribute("idCustomer", idCustomer);
                    request.getRequestDispatcher("customerDetails.jsp").forward(request, response);
                    
                } catch (WrongCustomerIDException ex) {
                    System.out.println(ex.getMessage()); 
                    request.setAttribute("WrongCustomerIDException", "Error");
                    request.getRequestDispatcher("employeeOverview.jsp").forward(request, response);
                }
                break;
            case "AddDiscount":
                try {
                    int idOrder = Integer.parseInt(request.getParameter("idOrder"));
                    double discountRate = Double.parseDouble(request.getParameter("discountRate"));
                    OrderFacade.setDiscountRate(discountRate, idOrder);
                    OrderFacade.updateFinalPrice(idOrder);   
                    request.getRequestDispatcher("employeeOverview.jsp").forward(request, response);
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                    request.getRequestDispatcher("error.jsp").forward(request, response);
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
