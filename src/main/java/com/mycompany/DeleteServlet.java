/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
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
            out.println("<title>Servlet DeleteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteServlet at " + request.getContextPath() + "</h1>");
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
            // DELETE PLAYERS FROM DATABASE
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
          response.setContentType("text/html");
       PrintWriter out =response.getWriter();
       out.println("<h1>Delete Player</h1>");
       String JerseyNO = request.getParameter("jerseyno");
       int jerseyNo = Integer.parseInt(JerseyNO);
       ArrayList<Player> al  = cricketDao.getPlayerDataByJerseyNo(jerseyNo);
       String s= "<form action='DeleteServlet?"+jerseyNo+"' method ='post' >";
       out.println(s);
       String row = "";
       System.out.println("ArrayList :" +al);
                   String str = "<table border =1><tr><th>Jerseyno</th><th>PlayerName</th><th>playerAge</th>"
                        + "<th>playerType</th><th>TotalRuns</th><th>TotalWickets</th></tr>";
                int count = 0;
                for (Player player:al){
                 row = "<tr><td id = \"jerseyno\">"+player.getJerseyno()+"</td><td>"+player.getPlayer_name()+"</td>"
                        + "<td>"+player.getPlayer_age()+"</td><td>"+player.getPlayer_type()+"</td>"
                        + "<td>"+player.getTotal_runs()+"</td><td>"+player.getTotal_wickets()+"</td></tr>";
                     str = str + row;
              System.out.println(row);
              count++;
                }
                str +=  "</table>";
                out.println(str);
                if (count == 0){
                out.println("<h2>No Record Found</h2>");
                }
                else{

           out.println("<br>");
           out.println("<h2>Are you Sure You Want To Delete Record ?</h2>");
           out.println("<br>");
           out.println(" <button type =\"Submit\" class=\"btn-btn-primary\">Yes</button>");
           out.println(" <button class=\"btn-btn-primary\"><a  href=\"welcome.jsp\">No</a></button>");
 
                        
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
    // DELETES PLAYERS FROM DATABSE
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
          String jerseyNo = request.getQueryString();
          
         

        
        try {
            cricketDao.doDelete(Integer.parseInt(jerseyNo));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cricket.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/deleteResponse.jsp");
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
