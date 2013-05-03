/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmademad
 */
import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.awt.event.*;

public class DictatorClient extends JFrame implements ActionListener{
    public javax.swing.JButton jButton1;
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JRadioButton jRadioButton1;
    public javax.swing.JRadioButton jRadioButton2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    // End of variables declaration
    public void graphics() throws Exception
    {
         setSize(500,300);
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Accept");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Refuse");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Continue");


        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(50, 50, 50)
                .add(jRadioButton1)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jButton1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 24, Short.MAX_VALUE)
                        .add(jRadioButton2)
                        .add(58, 58, 58))
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jTextField2)
                            .add(jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButton1)
                    .add(jRadioButton2)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );


        jButton1.setVisible(false);
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        setVisible(true);
        
        game();
    }
    
    public void game() throws Exception
    {
        
        
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setText("This is a study of economic decision making. There are no correct"
                + " or wrong answers. You will be given a certain number of tokens (having some monetary"
                + " value) and you will be faced with a series of choices of what to do with the"
                + " money. Your earnings will depend on your choices during the game.");
        jRadioButton1.setVisible(true);
        jRadioButton2.setVisible(true);            
        
    }
    
    public void actionPerformed(ActionEvent ee)    {}
    
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);
        jTextArea1.setText("Please wait...");
        Test o = new Test();
        o.execute();
         }

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        
    }
}





class Test extends javax.swing.SwingWorker
{
   static DictatorClient o = new DictatorClient();
 public String doInBackground() throws Exception
 {
        
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        
        try {
            kkSocket = new Socket("localhost", 4444);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: taranis.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: taranis.");
            System.exit(1);
        }
        
        
        
        String fromServer;
        fromServer = in.readLine();
        System.out.println(fromServer);
        o.jTextArea1.setText(fromServer);
        
        final PrintWriter k  =   new PrintWriter(kkSocket.getOutputStream(), true);
        o.jButton1.setVisible(true);
        o.jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o.jTextArea1.setText("Please wait..");
                o.jButton1.setVisible(false);
                k.println(1);
            }
        });
        /*
        o.jTextArea1.setText("Please enter your name: ");
        o.jTextField2.setVisible(true);
        o.jTextField2.getParent().revalidate();
 
        o.jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              k.println(o.jTextField2.getText());
            }
        });
        
        
        */
     
    
        fromServer = in.readLine();
        o.jTextArea1.setText(fromServer);
        
        
       
        if(fromServer.contains("have been chosen")) {
        o.jTextField1.setVisible(true);
        o.jTextField1.getParent().revalidate();
        o.repaint();
        
        o.jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              k.println(o.jTextField1.getText());
            }
        });
       
        }
        
        fromServer = in.readLine();
        o.jTextArea1.setText(fromServer);
        o.jTextField1.setVisible(false);
        o.jTextField1.getParent().revalidate();
    
        out.close();
        in.close();
        kkSocket.close();
     return "";
 }
 
 public static void main(String[] args) throws Exception {
              
        o.graphics();

    }
}
