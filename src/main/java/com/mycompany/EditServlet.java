/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
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
            out.println("<title>Servlet EditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditServlet at " + request.getContextPath() + "</h1>");
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
    
    // Player Update Operation
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       response.setContentType("text/html");
       PrintWriter out =response.getWriter();
       out.println("<h1>Update Player Information</h1>");
       String JerseyNO = request.getParameter("jerseyno");
       int jerseyNo = Integer.parseInt(JerseyNO);
       ArrayList<Player> al  = cricketDao.getPlayerDataByJerseyNo(jerseyNo);
       System.out.println("ArrayList :" +al);
       int count = 0;
       for (Player player:al){
           out.println("<form action='EditServlet' method = 'post'>");
           out.println("Jersey No : ");
           out.println("<input type =\"text\" name = 'jerseyno'  Value=\""+player.getJerseyno()+"\"/>");
           out.println("<br><br>");
           out.println("Player Name : ");
           out.println(" <input type =\"text\" name ='player_name' Value=\""+player.getPlayer_name()+"\"/>");
           out.println("<br><br>");
           
             out.println("Player Age : ");
           out.println(" <input type =\"text\" name ='player_age' Value=\""+player.getPlayer_age()+"\"/>");
           
           out.println("<br><br>");
           out.println("Player Type : ");
           out.println(" <input type =\"text\" name ='player_type' Value=\""+player.getPlayer_type()+"\"/>");
           
           out.println("<br><br>");
           out.println("Total Runs : ");
           out.println(" <input type =\"text\" name ='total_runs' Value=\""+player.getTotal_runs()+"\"/>");
           
           out.println("<br><br>");
           out.println("Total Wickets : ");
           out.println(" <input type =\"text\" name ='total_wickets' Value=\""+player.getTotal_wickets()+"\"/>");
           
           out.println("<br><br>");
           
          count++;
       }
       if(count == 0){
           out.println("<h2>No Record Found</h2>");
       }
       else{
           
       
        out.println(" <button type =\"Submit\" class=\"btn-btn-primary\">Save</button>");
           out.println("  <button class=\"btn btn-primary\" ><a  href=\"welcome.jsp\" \">Cancel</a></button>");
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
            cricketDao.updatePlayerInfo(player);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cricket.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/updateResponse.jsp");
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
