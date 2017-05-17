package presentation;

import business.Customer;
import business.Order;
import business.exceptions.InvalidOrderIdException;
import business.exceptions.StorageLayerException;
import business.facades.OrderFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thomasthimothee
 */
public class CustomerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("currentCustomer");
        String formName = request.getParameter("formName");
        switch (formName) {
            case "customerPayment":
                customerChoosePayOrder(request, response);
                break;
            case "PayOrder":
                customerPayOrder(request, customer, response);
                break;
            case "ViewDrawing":
                customerViewDrawing(request, customer, response);
                break;
        }
    }

    private void customerChoosePayOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = 0;
        double finalPrice = 0;
        double amount = 0;
        Order order = null;
        try {
            orderId = Integer.parseInt(request.getParameter("orderId"));
            finalPrice = Double.parseDouble(request.getParameter("finalPrice"));
            amount = Double.parseDouble(request.getParameter("amount"));
            order = OrderFacade.getFacade().retrieveOrder(orderId);
        } catch (InvalidOrderIdException | NumberFormatException ex) {
            request.setAttribute("Error", "IncorrectOrderId");
            request.getRequestDispatcher("customerOverview.jsp").forward(request, response);
        } catch (StorageLayerException e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        if (finalPrice == amount) {
            try {
                OrderFacade.getFacade().updateSatus(orderId);
                request.getRequestDispatcher("customerOverview.jsp").forward(request, response);
            } catch (StorageLayerException e) {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("currentOrder", order);
            request.setAttribute("InvalideAmount", "Error");
            request.getRequestDispatcher("customerPayment.jsp").forward(request, response);
        }
    }

    private void customerViewDrawing(HttpServletRequest request, Customer customer, HttpServletResponse response) throws IOException, ServletException {
        try {
            int idOrder = Integer.parseInt(request.getParameter("idOrder"));
            Order order = OrderFacade.getFacade().retrieveOrder(idOrder);
            if (customer.getId_customer() == order.getCustomerId()) {
                request.setAttribute("currentOrder", order);
                request.getRequestDispatcher("customerDrawing.jsp").forward(request, response);
            } else {
                throw new InvalidOrderIdException();
            }
        } catch (InvalidOrderIdException | NumberFormatException e) {
            request.setAttribute("Error", "IncorrectOrderId");
            request.getRequestDispatcher("customerOverview.jsp").forward(request, response);
        } catch (StorageLayerException e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void customerPayOrder(HttpServletRequest request, Customer customer, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idOrder = Integer.parseInt(request.getParameter("idOrder"));
            Order order = OrderFacade.getFacade().retrieveOrder(idOrder);
            if (customer.getId_customer() == order.getCustomerId()) {
                request.setAttribute("currentOrder", order);
                request.getRequestDispatcher("customerPayment.jsp").forward(request, response);
            } else {
                throw new InvalidOrderIdException();
            }
        } catch (InvalidOrderIdException | NumberFormatException e) {
            request.setAttribute("Error", "IncorrectOrderId");
            request.getRequestDispatcher("customerOverview.jsp").forward(request, response);
        } catch (StorageLayerException e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
