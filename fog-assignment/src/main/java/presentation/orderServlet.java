package presentation;

import business.Customer;
import business.Flat;
import business.Partlist;
import business.Pointy;
import business.facades.CarportFacade;
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
public class orderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("currentUser");// try to retrieve current user
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
                    if (carportType.equals("pointy")) {
                        angle = Integer.parseInt(request.getParameter("angle"));
                    }
                    if (carportWidth - 30 < shedWidth || carportLength - 30 < shedLength) {
                        request.setAttribute("errorMessageIncorrectDimensions", "Error");
                        switch (carportType) {
                            case "flat":
                                request.getRequestDispatcher("flatOrder.jsp").forward(request, response);
                                break;
                            case "pointy":
                                request.getRequestDispatcher("pointyOrder.jsp").forward(request, response);
                                break;
                            default:
                                request.getRequestDispatcher("index.html").forward(request, response);
                        }
                    }
//                    String concat = customer.getFirstName() + customer.getLastName();
//                    CarportFacade.createCarport(concat);
//                    int carportID = CarportFacade.getCarportId(concat);
                    //// test if retrieve all info needed for the partlist and order in db
                    System.out.println("customer name: " + customer.getFirstName());
                    System.out.println("customer id: " + customer.getId_customer());
                    System.out.println("customer email: " + customer.getEmail());
                    ///
                    
                    Partlist partList;
                    if (carportType.equals("flat")) {
                        Flat flat = new Flat("Flat", "Plastmo Ecolite Blue", carportLength, carportWidth, shedLength, shedWidth, 0);
                        partList = flat.createPartList();
                   } else { 
                        Pointy pointy = new Pointy(carportType, roofType, carportLength, carportWidth, shedLength, shedWidth, 0, angle);
                        partList = pointy.createPartList();
                    }
                    request.setAttribute("carport width", carportWidth);
                    request.setAttribute("carport length", carportLength);
                    request.setAttribute("shed width", shedWidth);
                    request.setAttribute("shed length", shedLength);
                    request.setAttribute("partList", partList);
                    request.setAttribute("carportType", carportType);
                    if (carportType.equals("pointy")) {
                        request.setAttribute("angle", angle);
                    }
                    request.getRequestDispatcher("OrderConfirmation.jsp").forward(request, response);
                } catch (NullPointerException e) {
                    request.setAttribute("errorMessage", "Incorrect messurements");
                    request.getRequestDispatcher("OrderConfirmation.jsp").forward(request, response);
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
