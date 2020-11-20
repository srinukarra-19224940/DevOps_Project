/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author srinu
 */
    //
@WebServlet("/cricket")
public class Cricket extends HttpServlet {
    private CricketDao cricketDao = new CricketDao();
    

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cricket</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cricket at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
    
    // RETRIVE PLAYERS DATA FROM DATABASE
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        // processRequest(request, response);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String row = "";
             try {
                ArrayList<Player> al = cricketDao.displayPlayers();
                System.out.println("hello");
                String str = "<table  BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=50%><tr><th>Jerseyno</th><th>PlayerName</th><th>PlayerAge</th>"
                        + "<th>PlayerType</th><th>TotalRuns</th><th>TotalWickets</th>";
                
                for (Player player:al){
                 row = "<tr><td>"+player.getJerseyno()+"</td><td>"+player.getPlayer_name()+"</td>"
                        + "<td>"+player.getPlayer_age()+"</td><td>"+player.getPlayer_type()+"</td>"
                        + "<td>"+player.getTotal_runs()+"</td><td>"+player.getTotal_wickets()+"</td></tr>";
                     str = str + row;
              System.out.println(row);
                }
                str +=  "</table>";
                out.println(str);
               out.println("<br>");
               out.println("<br>");
                out.println("  <button class=\"btn btn-primary\" ><a  href=\"welcome.jsp\" \">Back</a></button>");
                } catch (Exception ex) {
            Logger.getLogger(Cricket.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
            // INSERT PLAYERS INTO DATABASE
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Player player = new Player();
        String jerseyNo = request.getParameter("jerseyno");
        String playerName = request.getParameter("player_name");
        String playerAge = request.getParameter("player_age");
        String playerType = request.getParameter("player_type");
        String totalRuns = request.getParameter("total_runs");
        String totalWickets = request.getParameter("total_wickets");
        
        
        player.setJerseyno(Integer.parseInt(jerseyNo));
        player.setPlayer_name(playerName);
        player.setPlayer_age(Integer.parseInt(playerAge));
        player.setPlayer_type(playerType);
        player.setTotal_runs(Integer.parseInt(totalRuns));
        player.setTotal_wickets(Integer.parseInt(totalWickets));
        
        try {
            cricketDao.insertplayer(player);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cricket.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/response.jsp");
        dispatcher.forward(request, response); 
        
        
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



