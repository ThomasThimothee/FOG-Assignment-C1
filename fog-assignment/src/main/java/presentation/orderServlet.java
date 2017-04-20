package presentation;

import business.Flat;
import business.FlatFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        String formName = request.getParameter("formName");
        switch (formName) {
            case "order":
                try {
                    int carportWidth = Integer.parseInt(request.getParameter("carport width"));
                    int carportLength = Integer.parseInt(request.getParameter("carport length"));
                    int shedWidth = Integer.parseInt(request.getParameter("shed width"));
                    int shedLength = Integer.parseInt(request.getParameter("shed length"));
                    String roofType = (String) request.getParameter("roof type");
                    Flat flat = new Flat("Flat", "Plastmo Ecolite Blue", carportWidth, carportLength, shedWidth, shedLength, 0);
                    String listOfParts = flat.createPartList();
                    request.setAttribute("carport width", carportWidth);
                    request.setAttribute("carport length", carportLength);
                    request.setAttribute("shed width", shedWidth);
                    request.setAttribute("shed length", shedLength);
                    request.setAttribute("listOfParts", listOfParts);
                    request.getRequestDispatcher("OrderConfirmation.jsp").forward(request, response);
                } catch (NullPointerException e) {
                    request.setAttribute("errorMessageUserNotFound", "Incorrect messurements");
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
