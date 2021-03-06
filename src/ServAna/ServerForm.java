/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServeurGUI.java
 *
 * Created on 24 dec. 2012, 5:05:39
 */
package ServAna;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import RequestResponse.ConsoleServeur;
import java.net.ServerSocket;
import javax.swing.DefaultListModel;
import ServAna.ListeTaches;
import ServAna.ServerThread;

/**
 *
 * @author Bob
 */
public class ServerForm extends javax.swing.JFrame implements ConsoleServeur{

    private int port;
     
    /** Creates new form ServeurGUI */
    public ServerForm() 
    {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tabs = new javax.swing.JTabbedPane();
        TabServeur = new javax.swing.JPanel();
        L_port = new javax.swing.JLabel();
        TF_port = new javax.swing.JTextField();
        B_connect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableauEvenements = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Serveur_Appareils");

        Tabs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tabs.setDoubleBuffered(true);

        L_port.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L_port.setText("Port");

        TF_port.setText("2000");
        TF_port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_portActionPerformed(evt);
            }
        });

        B_connect.setText("Connect");
        B_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_connectActionPerformed(evt);
            }
        });

        TableauEvenements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Trace"
            }
        ));
        jScrollPane1.setViewportView(TableauEvenements);

        javax.swing.GroupLayout TabServeurLayout = new javax.swing.GroupLayout(TabServeur);
        TabServeur.setLayout(TabServeurLayout);
        TabServeurLayout.setHorizontalGroup(
            TabServeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabServeurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabServeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TabServeurLayout.createSequentialGroup()
                        .addComponent(L_port)
                        .addGap(18, 18, 18)
                        .addComponent(TF_port, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                        .addComponent(B_connect)))
                .addContainerGap())
        );
        TabServeurLayout.setVerticalGroup(
            TabServeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabServeurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabServeurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_port)
                    .addComponent(TF_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_connect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Tabs.addTab("Serveur", TabServeur);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        getAccessibleContext().setAccessibleName("ServeurMv");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_connectActionPerformed
        port = Integer.parseInt(TF_port.getText());
        ServerThread threadServeur = new ServerThread(port, new ListeTaches(), this);
        // thread qui lancera les threads clients
        threadServeur.start();   
    }//GEN-LAST:event_B_connectActionPerformed

    private void TF_portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_portActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_portActionPerformed

@Override
public void TraceEvenements(String commentaire)
{
    Vector ligne = new Vector();
    ligne.add(commentaire);
    DefaultTableModel dtm = (DefaultTableModel)TableauEvenements.getModel();
    dtm.insertRow(dtm.getRowCount(),ligne);
}

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ServerForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_connect;
    private javax.swing.JLabel L_port;
    private javax.swing.JTextField TF_port;
    private javax.swing.JPanel TabServeur;
    private javax.swing.JTable TableauEvenements;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
