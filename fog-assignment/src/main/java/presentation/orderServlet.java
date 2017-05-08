package presentation;

import business.Customer;
import business.Flat;
import business.Partlist;
import business.Pointy;
import business.facades.OrderFacade;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lovro
 */
public class orderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("currentCustomer");// try to retrieve current user
        String action = request.getParameter("action");
        String carportType = request.getParameter("carportType");
        switch (action) {
            case "order":
                try {
                    int carportWidth = Integer.parseInt(request.getParameter("carport width"));
                    int carportLength = Integer.parseInt(request.getParameter("carport length"));
                    int shedWidth = Integer.parseInt(request.getParameter("shed width"));
                    int shedLength = Integer.parseInt(request.getParameter("shed length"));
                    String roofType = (String) request.getParameter("roof type");
                    int angle = 0;
                    if (carportType.equals("Pointy")) {
                        angle = Integer.parseInt(request.getParameter("angle"));
                    }
                    if (carportWidth - 30 < shedWidth || carportLength - 30 < shedLength) {
                        request.setAttribute("errorMessageIncorrectDimensions", "Error");
                        switch (carportType) {
                            case "Flat":
                                request.getRequestDispatcher("flatOrder.jsp").forward(request, response);
                                return;
                            case "Pointy":
                                request.getRequestDispatcher("pointyOrder.jsp").forward(request, response);
                                return;
                            default:
                                request.getRequestDispatcher("index.html").forward(request, response);
                                return;
                        }
                    }
                    java.util.Date dateJava = new java.util.Date();
                    java.sql.Timestamp dateSql = new Timestamp(dateJava.getTime());                    
                    OrderFacade.createOrder(customer.getId_customer(), 7, dateSql, false, 0.00); //hard code the idSalesRep and price
                    int orderId = OrderFacade.getOrderId(customer.getId_customer(), dateSql); // hard code the sales person ID

                    Partlist partList;
                    if (carportType.equals("Flat")) {
                        Flat flat = new Flat("Flat", "Plastmo Ecolite Blue", carportLength, carportWidth, shedLength, shedWidth, 0);
                        partList = flat.createPartList(); 
                        request.setAttribute("selectedCarport", flat);
                   } else { 
                        Pointy pointy = new Pointy(carportType, roofType, carportLength, carportWidth, shedLength, shedWidth, 0, angle);
                        partList = pointy.createPartList();
                        request.setAttribute("selectedCarport", pointy);
                    }
                    OrderFacade.createOrderLines(partList, orderId);
                    request.getRequestDispatcher("orderConfirmation.jsp").forward(request, response);
                } catch (NullPointerException e) {
                    request.setAttribute("errorMessage", "Incorrect messurements");
                    request.getRequestDispatcher("orderConfirmation.jsp").forward(request, response);
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
