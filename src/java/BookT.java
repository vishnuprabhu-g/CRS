/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Do.PassengerDO;
import Do.PassengerTicketDO;
import Do.TrainClassSeatStatusDO;
import Domain.Passenger;
import Domain.PassengerTicket;
import Domain.TrainClassSeatStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            long tcs =1;
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
            List<Passenger> queue = new ArrayList();
            
            boolean stop = false;
            for (int j = 0; j < i; j++) {
                TrainClassSeatStatus tcss = tcsdo.getPref(tcs, pref[j]);
                if (tcss == null) {
                    System.out.println("Required berth not available..!");
                    stop = true;
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
                    p.currentSeat=tcss.seatNo;
                    p.status=1;
                    queue.add(p);
                }
            }
            if (!stop) {
                
                PassengerTicket pt=new PassengerTicket();
                pt.pnr=pnr;
                pt.timestamp=System.currentTimeMillis();
                pt.totalAdult=i;
                pt.fromStation=1L;pt.toStation=1L;pt.totalChildren=0;pt.totalFare=1;pt.journeyId=1L;
                PassengerTicketDO ptdo=new PassengerTicketDO();
                
                ptdo.add(pt);
                
                for (Passenger pss : queue) {
                    pdo.add(pss);
                }
                
                out.println("PNR:"+pt.pnr);
                for(Passenger p:queue)
                {
                    out.println("Name:"+p.name+" seat:"+p.currentSeat);
                }
            }
            else
            {
                out.println("exit");
                out.close();
            }
            
        } catch (SQLException e) {
            out.println(e);
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
