/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trainer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author admin
 */
public class Connection1 {
   
    public static Connection Connecterdb()
    {//System.out.println("hii");  
        try
        {
            //System.out.println("hii");
            Class.forName("org.sqlite.JDBC");
//           JOptionPane.showMessageDialog(null,"connection established1.." ); 
           // System.out.println("hii");
            Connection con=DriverManager.getConnection("jdbc:sqlite:Gym.sqlite");
        //JOptionPane.showMessageDialog(null,"connection established.." );
        return con;
        }
        catch(Exception e)
        {
            //System.out.println("hii");
           JOptionPane.showMessageDialog(null,"connection failed3..");
           return null;
        }
        
    }
    
}

