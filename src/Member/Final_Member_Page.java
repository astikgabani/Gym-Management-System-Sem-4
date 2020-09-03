/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Member;

import Login.Login;
import Trainer.Connection1;
import com.orsoncharts.renderer.category.BarRenderer3D;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import video.Video;


/**
 *
 * @author Administrator
 */
public class Final_Member_Page extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
      Connection conn=null;
ResultSet rs=null;
PreparedStatement pst=null;  

    String M_ID="15RGYM00001";
    public Final_Member_Page(String s) {
        M_ID=s;
        initComponents();
        PuttingFalse();
        
    //    GroupButton();
        conn=Connection1.Connecterdb();
    pop();
    p();
    popc();
    popcombo();
    }
      void popcombo()
{
    String sql="SELECT * FROM Offer INNER JOIN MemOffer ON Offer.O_ID=MemOffer.O_ID where MemOffer.M_ID=? and Expr >= current_date";
              try {
                  pst=conn.prepareStatement(sql);
                  pst.setString(1,M_ID);
                   rs=pst.executeQuery();
                //    JOptionPane.showMessageDialog(null,"l0");
      //  List<String> strings = new ArrayList<String>();
               while(rs.next())
                   {
                 // JOptionPane.showMessageDialog(null,rs.getString("Name"));
                 jComboBox1.addItem(rs.getString("Name"));
                   
                   }   
            
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,"l");
              }
                      finally
    {
            try {
                rs.close();
                pst.close();
     //           JOptionPane.showMessageDialog(null,"Connection lost..");
                
            } catch (SQLException ex) {
      //          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null,"INCORRECT exception.......");
            }
       
    }
      
}

        void popc()
{
    String sql="SELECT StartDate,EndDate from Member where M_ID=?  ";
              try {
                  pst=conn.prepareStatement(sql);
                 pst.setString(1,M_ID);
                  rs=pst.executeQuery();
                  // JOptionPane.showMessageDialog(null,M_MID.getText());
      //  List<String> strings = new ArrayList<String>();
               if(rs.next())
                   {
                 //JOptionPane.showMessageDialog(null,"Name");
              String st=rs.getString("StartDate");
             String ed= rs.getString("EndDate");
             Date d1=Date.valueOf(st);
             jTextField5.setText(st);
             jTextField6.setText(ed);
             Date d2=Date.valueOf(ed);
            long diff =d2.getTime()-d1.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000)+1;
           Integer diff1 = (int) diffDays;
            jTextField4.setText(diff1.toString());
            
                   }   
               
            
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,"error..");
              }
                      finally
    {
            try {
                rs.close();
                pst.close();
     //           JOptionPane.showMessageDialog(null,"Connection lost..");
                
            } catch (SQLException ex) {
      //          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null,"INCORRECT exception.......");
            }
       
    }
    
    sql="SELECT Offer.Name,Description FROM Offer INNER JOIN Member ON Offer.O_ID=Member.O_ID where Member.M_ID=? ";
              try {
                  pst=conn.prepareStatement(sql);
                 pst.setString(1,M_ID);
                  rs=pst.executeQuery();
                  // JOptionPane.showMessageDialog(null,M_MID.getText());
      //  List<String> strings = new ArrayList<String>();
               if(rs.next())
                   {
                 //JOptionPane.showMessageDialog(null,"Name");
               jTextField3.setText(rs.getString(1));
                 jTextArea2.setText(rs.getString(2));
                   }   
               else
               {
                   jTextField1.setText("");
                 jTextArea2.setText("");
               }
            
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,"error..");
              }
                      finally
    {
            try {
                rs.close();
                pst.close();
     //           JOptionPane.showMessageDialog(null,"Connection lost..");
                
            } catch (SQLException ex) {
      //          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null,"INCORRECT exception.......");
            }
       
    }
      
}
    void p()
    {
       String sql="SELECT Name from Member where M_ID=? ";
      try {
                  pst=conn.prepareStatement(sql);
                 pst.setString(1,M_ID);
            jTextField1.setText(M_ID);
            
                  rs=pst.executeQuery();
                  // JOptionPane.showMessageDialog(null,M_MID.getText());
      //  List<String> strings = new ArrayList<String>();
         if(rs.next())
         {
             jTextField2.setText(rs.getString("Name"));
         }
            
              }
      catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,ex);
              }
         finally
    {
            try {
                rs.close();
                pst.close();
     //           JOptionPane.showMessageDialog(null,"Connection lost..");
                
            } catch (SQLException ex) {
      //          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null,"INCORRECT exception.......");
            }
       
    }   
    }
      
    public void PuttingFalse() {
          // jLabel1.setVisible(false);
        //jLabel2.setVisible(false);
        //jLabel3.setVisible(false);
        //ETEXT1.setVisible(false);
        PRPROGRESS1.setVisible(false);
        ERPROGRESS2.setVisible(false);
//        ERPROGRESS3.setVisible(false);
    }
    public void PuttingTrue() {
        //jLabel1.setVisible(true);
        //jLabel2.setVisible(true);
       // jLabel3.setVisible(true);
      //  ETEXT1.setVisible(true);
        PRPROGRESS1.setVisible(true);
        ERPROGRESS2.setVisible(true);
  //      ERPROGRESS3.setVisible(true);
    }
    void pop()
    {
       String sql="SELECT Exercise.E_ID,Exercise.Name FROM Exercise INNER JOIN MembExe on Exercise.E_ID=MembExe.E_ID where MembExe.M_ID=? ";
      try {
                  pst=conn.prepareStatement(sql);
                pst.setString(1,M_ID);
                  rs=pst.executeQuery();
                  // JOptionPane.showMessageDialog(null,M_MID.getText());
      //  List<String> strings = new ArrayList<String>();
                  do
        {
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));    
            //JOptionPane.showMessageDialog(null,"CORRECT............................................................");
        
        
        }while(rs.next());
            
              }
      catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,ex);
              }
         finally
    {
            try {
                rs.close();
                pst.close();
     //           JOptionPane.showMessageDialog(null,"Connection lost..");
                
            } catch (SQLException ex) {
      //          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null,"INCORRECT exception.......");
            }
       
    }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PRTABLE1 = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ERPROGRESS2 = new javax.swing.JProgressBar();
        PRPROGRESS1 = new javax.swing.JProgressBar();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        PRTEXT1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jButton3.setText("Play");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Member_ID");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Member Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(119, 119, 119)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jButton3)
                .addGap(0, 369, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jButton3)))
                .addGap(0, 157, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Exersice", jPanel1);

        PRTABLE1.setBackground(new java.awt.Color(255, 255, 204));
        PRTABLE1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        PRTABLE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PRTABLE1.setForeground(new java.awt.Color(51, 0, 51));
        PRTABLE1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Weight", null, null},
                {"Height", null, null},
                {"Neck", null, null},
                {"Shoulder", null, null},
                {"Chest(Normal)", null, null},
                {"Chest(Expanded)", null, null},
                {"UpperArm", null, null},
                {"ForeArm", null, null},
                {"UpperArm", null, null},
                {"Waist", null, null},
                {"LowerArm", null, null},
                {"Hips", null, null},
                {"Thigh", null, null},
                {"Calf", null, null},
                {"WHR*", null, null},
                {"BMI*", null, null}
            },
            new String [] {
                "Attribute", "Start", "End"
            }
        ));
        PRTABLE1.setToolTipText("");
        PRTABLE1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PRTABLE1.setName(""); // NOI18N
        PRTABLE1.setRequestFocusEnabled(false);
        PRTABLE1.setRowHeight(36);
        PRTABLE1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        PRTABLE1.getTableHeader().setReorderingAllowed(false);
        PRTABLE1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PRTABLE1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(PRTABLE1);

        jInternalFrame1.setVisible(true);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Starting Date");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Previous Date");

        ERPROGRESS2.setString("");
        ERPROGRESS2.setStringPainted(true);

        PRPROGRESS1.setToolTipText("");
        PRPROGRESS1.setString("");
        PRPROGRESS1.setStringPainted(true);

        jButton2.setText("Bar Chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Line Chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        PRTEXT1.setBackground(new java.awt.Color(255, 204, 204));
        PRTEXT1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PRTEXT1.setForeground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ERPROGRESS2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PRPROGRESS1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(PRTEXT1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton1)
                        .addGap(43, 43, 43)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PRTEXT1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PRPROGRESS1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ERPROGRESS2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Progress Report", jPanel2);

        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Member/rc2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(jLabel2)))
                .addContainerGap(752, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel2)
                .addGap(52, 52, 52)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Log Out", jPanel4);

        jLabel17.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel17.setText("Membership");

        jComboBox1.setBackground(new java.awt.Color(255, 204, 204));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Myriad Arabic", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel10.setText("Current Membership");

        jLabel11.setText("Description");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Your Membership Detail-:");

        jLabel4.setText("Days Remaining");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Start Date");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel9.setText("End Date");

        jTextField6.setText("jTextField6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(528, 528, 528))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addGap(46, 46, 46)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel9))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(327, 327, 327))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(373, 373, 373)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(424, 424, 424))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(182, 182, 182)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(307, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel17)))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(346, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(239, 239, 239)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(244, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Membership Details", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        DefaultTableModel model = (DefaultTableModel)PRTABLE1.getModel();
        String sql="select * from Physical_Details where date1='End' and M_ID=?";
        String sql1="select * from Physical_Details where date1='Start' and M_ID=?";
        try {
            //       f="15RGYM"+j;
            // String h;
            pst=conn.prepareStatement(sql);
            //M_MID.setText(f);

            pst.setString(1, M_ID);

            rs=    pst.executeQuery();
            if(rs.next())
            {
                model.setValueAt(rs.getString("Weight") , 0, 2);
                model.setValueAt(rs.getString("Height") , 1, 2);
                model.setValueAt(rs.getString("Neck") , 2, 2);
                model.setValueAt(rs.getString("Shoulder") , 3, 2);
                model.setValueAt(rs.getString("Chest_n") , 4, 2);
                model.setValueAt(rs.getString("Chest_e") , 5, 2);

                model.setValueAt(rs.getString("UpperArm") , 6, 2);
                model.setValueAt(rs.getString("ForeArm") , 7, 2);

                model.setValueAt(rs.getString("UpperAbdomen") , 8, 2);
                model.setValueAt(rs.getString("Waist") , 9, 2);
                model.setValueAt(rs.getString("LowerAbdomen") , 10, 2);

                model.setValueAt(rs.getString("Hips") , 11, 2);
                model.setValueAt(rs.getString("Thigh") , 12, 2);
                model.setValueAt(rs.getString("Calf") , 13, 2);
                model.setValueAt(rs.getString("WHR") , 14, 2);
                model.setValueAt(rs.getString("BMI") , 15, 2);
            }

        } catch (Exception ex) {
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Icorrect Input...");
        }
        finally
        {
            try {
                rs.close();
                pst.close();

            } catch (SQLException ex) {
                //             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        try {
            //       f="15RGYM"+j;
            // String h;
            pst=conn.prepareStatement(sql1);
            //M_MID.setText(f);

            pst.setString(1, M_ID);

            rs=    pst.executeQuery();
            if(rs.next())
            {
                model.setValueAt((rs.getString("Weight")) , 0, 1);
                model.setValueAt(rs.getString("Height") , 1, 1);
                model.setValueAt(rs.getString("Neck") , 2, 1);
                model.setValueAt(rs.getString("Shoulder") , 3, 1);
                model.setValueAt(rs.getString("Chest_n") , 4, 1);
                model.setValueAt(rs.getString("Chest_e") , 5, 1);

                model.setValueAt(rs.getString("UpperArm") , 6, 1);
                model.setValueAt(rs.getString("ForeArm") , 7, 1);
                //JOptionPane.showMessageDialog(null,"Icorrect");
                model.setValueAt(rs.getString("UpperAbdomen") , 8, 1);
                model.setValueAt(rs.getString("Waist") , 9, 1);
                model.setValueAt(rs.getString("LowerAbdomen") , 10, 1);

                model.setValueAt(rs.getString("Hips") , 11, 1);
                model.setValueAt(rs.getString("Thigh") , 12, 1);
                model.setValueAt(rs.getString("Calf") , 13, 1);
                model.setValueAt(rs.getString("WHR") , 14, 1);
                model.setValueAt(rs.getString("BMI") , 15, 1);
            }

        } catch (Exception ex) {
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Icorrect Input12...");
        }
        finally
        {
            try {
                rs.close();
                pst.close();

            } catch (SQLException ex) {
                //             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String sql="select * from Offer where Name=? ";
        try {
            //       f="15RGYM"+j;
            // String h;
            pst=conn.prepareStatement(sql);
            //M_MID.setText(f);

            pst.setString(1,jComboBox1.getSelectedItem().toString());

            //  JOptionPane.showMessageDialog(null,sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                //   JOptionPane.showMessageDialog(null,"whooo");

                jTextArea1.setText(rs.getString("Description"));
            }

        } catch (Exception ex) {
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"INCORRECT exception i description............................................................");
        }
        finally
        {
            try {
                rs.close();
                pst.close();

            } catch (SQLException ex) {
                //             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        dataset.setValue(PRPROGRESS1.getValue(), "Amount","Starting Date");
        dataset.setValue(ERPROGRESS2.getValue(), "Amount","Last Date");
        //        dataset.setValue(ERPROGRESS3.getValue(), "Amount","Current Date");
        JFreeChart chart=ChartFactory.createLineChart3D(jTextField2.getText(), "Date", "Value", dataset, PlotOrientation.VERTICAL, false, true, false);
        chart.getTitle().setPaint(Color.RED);
        chart.setBackgroundPaint(Color.yellow);
        BarRenderer3D render=new BarRenderer3D();
        CategoryPlot chart1=chart.getCategoryPlot();
        ChartFrame frame=new ChartFrame("Line Chart",chart);
        frame.setVisible(true);
        frame.setSize(450, 320);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        dataset.setValue(PRPROGRESS1.getValue(), "Amount","Starting Date");
        dataset.setValue(ERPROGRESS2.getValue(), "Amount","Previous Date");
        // dataset.setValue(ERPROGRESS3.getValue(), "Amount","Current Date");
        JFreeChart chart=ChartFactory.createBarChart3D(jTextField2.getText(), "Date", "Value", dataset, PlotOrientation.VERTICAL, false, true, false);
        chart.getTitle().setPaint(Color.RED);
        chart.setBackgroundPaint(Color.yellow);
        //BarRenderer3D render=new BarRenderer3D();
        CategoryPlot chart1=chart.getCategoryPlot();
        ChartFrame frame=new ChartFrame("Bar Chart",chart);
        frame.setVisible(true);
        frame.setSize(450, 320);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PRTABLE1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRTABLE1MouseClicked
        PuttingTrue();

        int row=PRTABLE1.getSelectedRow();

        String t4=PRTABLE1.getModel().getValueAt(row, 0).toString();
        String t1=PRTABLE1.getModel().getValueAt(row, 1).toString();
        String t2=PRTABLE1.getModel().getValueAt(row, 2).toString();
        // String t3=PRTABLE1.getModel().getValueAt(row, 3).toString();
        JOptionPane.showMessageDialog(null,t1);
        PRPROGRESS1.setValue(Integer.parseInt(t1));
        ERPROGRESS2.setValue(Integer.parseInt(t2));
        //ERPROGRESS3.setValue(Integer.parseInt(t3));
        PRTEXT1.setText(t4);
    }//GEN-LAST:event_PRTABLE1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel modelTable = (DefaultTableModel) jTable1.getModel();
        int k=jTable1.getSelectedRow();
        String sql="select URL from Exercise where E_ID=?";

        try {
            pst=conn.prepareStatement(sql);
            
            pst.setString(1,jTable1.getModel().getValueAt(k,0).toString());
            rs=pst.executeQuery();
            if(rs.next())
            {
                
                        
                String url=rs.getString("URL");
                JOptionPane.showMessageDialog(null,url);
                Video v=new Video("Video/1");
                v.t();

            }
        } catch (SQLException ex) {
            Logger.getLogger(Final_Member_Page.class.getName()).log(Level.SEVERE, null, ex);
        }

        finally
        {
            try {
                rs.close();
                pst.close();

            } catch (SQLException ex) {
                //             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    Login l=new Login();
   l.setVisible(true);
   this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Final_Member_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Final_Member_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Final_Member_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Final_Member_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Final_Member_Page("15RGYM00001").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ERPROGRESS2;
    private javax.swing.JProgressBar PRPROGRESS1;
    private javax.swing.JTable PRTABLE1;
    private javax.swing.JTextField PRTEXT1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
