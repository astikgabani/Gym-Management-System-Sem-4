/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym.management.system;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author SHREEJI
 */
public class Connection1 
{
  public static Connection ConnectorDb()
  {
      Connection conn= null;
      try 
      {
          Class.forName("org.sqlite.JDBC");
      }
      catch (ClassNotFoundException e) 
      {
          JOptionPane.showMessageDialog(null, "Class Not Found");
      }
      try
      {
          conn=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\admin\\Documents\\NetBeansProjects\\bank\\Gym.sqlite");
      }
      catch (SQLException ex) 
      {
          JOptionPane.showMessageDialog(null, "File Not Found");
      }
      return conn;
  }
}
