/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Do.PassengerDO;
import Do.TrainClassSeatStatusDO;
import Domain.Passenger;
import Domain.TrainClassSeatStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vishnu-pt517
 */
public class BookT extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            long tcs = Long.parseLong(request.getParameter("tcs"));
            int count = 7;
            String name[] = new String[count];
            int age[] = new int[count];
            int pref[] = new int[count];
            int gen[] = new int[count];
            
            int i;
            for (i = 0; i < 6; i++) {
                name[i] = request.getParameter("name" + i);
                if (name[i] == null || name[i].trim().equals("")) {
                    break;
                }
                age[i] = Integer.parseInt(request.getParameter("age" + i));
                pref[i] = Integer.parseInt(request.getParameter("berth" + i));
                gen[i] = Integer.parseInt(request.getParameter("gender" + i));
            }
            TrainClassSeatStatusDO tcsdo = new TrainClassSeatStatusDO();
            PassengerDO pdo = new PassengerDO();
            long pnr = System.currentTimeMillis();
            for (int j = 0; j < i; j++) {
                TrainClassSeatStatus tcss = tcsdo.getPref(tcs, pref[j]);
                if (tcss == null) {
                    System.out.println("Required berth not available..!");
                } else {
                    tcss.pnr = pnr;
                    tcss.availability = false;
                    Passenger p = new Passenger();
                    p.age = age[j];
                    p.gender = gen[j];
                    p.name = name[j];
                    p.pnr = pnr;
                    p.sno = 101;
                    p.currentSeat = tcss.seatNo;
                    pdo.add(p);
                    tcsdo.update(tcss);
                }
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
