/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import com.sdz.observer.Observer;

/**
 *
 * @author root
 */
public class notify extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form jop
     */
    public notify() {
        initComponents();
        
    }

public void created(){
       jLabel1.setIcon(new javax.swing.ImageIcon("/root/Downloads/ice-cream.png"));
         jLabel2.setText("New Station Created");
    }
      public void modify(){
     jLabel1.setIcon(new javax.swing.ImageIcon("/root/Downloads/ice-cream(1).png"));  
       jLabel2.setText("Station Updated ");
    } 
         public void deleted(){
     jLabel1.setIcon(new javax.swing.ImageIcon("/root/Downloads/ice-cream(2).png"));  
       jLabel2.setText("Station Deleted ");
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(17, 34, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(230, 126, 34));
        jLabel3.setForeground(new java.awt.Color(248, 244, 244));
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 40, -1));

        jLabel2.setFont(new java.awt.Font("Cantarell", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(248, 241, 241));
        jLabel2.setText("New Station Created");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 150));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
setVisible(false);
       

    }//GEN-LAST:event_jLabel3MouseClicked

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

  

    @Override
    public void aktualisiere(String str) {
       notify alt = new notify();
       alt.created();
       alt.setVisible(true);
    }
}
