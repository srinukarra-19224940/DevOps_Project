/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;
/**
 *
 * @author srinu
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class CricketDao {
    // RETRIVE PLAYERS FROM DATABASE
    
    public  ArrayList<Player>  displayPlayers(){
       ResultSet rs = null;
       ArrayList<Player> al = new ArrayList<Player>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://cricket-instance-identifier.c1ql7f1j4qa3.us-east-1.rds.amazonaws.com:3306/CricketTestingDB","karra","karrakarra");
            Statement stmt=conn.createStatement();  
             rs=stmt.executeQuery("select * from player_info"); 
            
             al=setPlayer(rs, al);
            
      }catch(Exception e){
          System.out.println(e);
        }
           return al;        
}

    private ArrayList<Player> setPlayer(ResultSet rs, ArrayList<Player> al) throws SQLException {
        while(rs.next())  
        {
        Player p = new Player();
        p.setJerseyno(rs.getInt(1));
        p.setPlayer_name(rs.getString(2));
        p.setPlayer_age(rs.getInt(3));
        p.setPlayer_type(rs.getString(4));
        p.setTotal_runs(rs.getInt(5));
        p.setTotal_wickets(rs.getInt(6));
        al.add(p);
        }
        return al;
    }
     // INSERT PLAYERS INTO DATABSE
    public int  insertplayer(Player player)throws ClassNotFoundException{
        String INSERT_SQL = "INSERT INTO CricketTestingDB.player_info" +
                "(jerseyno, player_name, player_age, player_type, total_runs, total_wickets) VALUES "+
                "(?, ?, ?, ?, ?, ?);";
        int result =0;
        try{
         Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://cricket-instance-identifier.c1ql7f1j4qa3.us-east-1.rds.amazonaws.com:3306/CricketTestingDB","karra","karrakarra");
            Statement stmt=conn.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from player_info");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+ rs.getInt(3)+" "+rs.getString(4));  
            
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
            ps.setInt(1, player.getJerseyno());
            ps.setString(2, player.getPlayer_name());
            ps.setInt(3, player.getPlayer_age());
            ps.setString(4, player.getPlayer_type());
            ps.setInt(5, player.getTotal_runs());
            ps.setInt(6, player.getTotal_wickets());
            
            result = ps.executeUpdate();        
        }catch(Exception e){
          System.out.println(e);
        }
         return result;       
    }
    
    // UPDATE PLAYERS 
    
    public ArrayList<Player> getPlayerDataByJerseyNo(int upJerseyno){
        ResultSet rs = null;
        Player p = new Player();
        ArrayList<Player> al = new ArrayList<Player>();
        String retrive = "select * from player_info where jerseyno ="+ upJerseyno;
        try{
         Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://cricket-instance-identifier.c1ql7f1j4qa3.us-east-1.rds.amazonaws.com:3306/CricketTestingDB","karra","karrakarra");
            Statement stmt=conn.createStatement();  
            rs=stmt.executeQuery(retrive); 
            al= setPlayer(rs,al);
        }
        catch(Exception e){
          System.out.println(e);
          }
        return al;
    }
      public boolean updatePlayerInfo(Player player) throws ClassNotFoundException{
          String update = "update player_info set jerseyno=?,player_name=?,player_age=?,"
                  + "player_type=?,total_runs=?,total_wickets=? where jerseyno = "+player.getJerseyno(); 
        
   
            try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://cricket-instance-identifier.c1ql7f1j4qa3.us-east-1.rds.amazonaws.com:3306/CricketTestingDB","karra","karrakarra");
//            Statement stmt=conn.createStatement();  
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setInt(1, player.getJerseyno());
            ps.setString(2, player.getPlayer_name());
            ps.setInt(3, player.getPlayer_age());
            ps.setString(4, player.getPlayer_type());
            ps.setInt(5, player.getTotal_runs());
            ps.setInt(6, player.getTotal_wickets());
            
            if(ps.executeUpdate()>0){
                System.out.println("Done");
                return true;
            }
            
            }
        catch(Exception e){
          System.out.println(e);
      }
        return false;
            
        
      }
      // DELETE PLAYERS FROM DATABASE
     public void doDelete(int delJerseyno)throws ClassNotFoundException{
        String delete = "delete from player_info "
                  + " where jerseyno = "+delJerseyno; 
        System.out.println("Record deleted");
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://cricket-instance-identifier.c1ql7f1j4qa3.us-east-1.rds.amazonaws.com:3306/CricketTestingDB","karra","karrakarra");
            PreparedStatement ps = conn.prepareStatement(delete);
               ps.executeUpdate();
            }
        catch(Exception e){
          System.out.println(e);
     
            
        
      }  
     }

}




        

