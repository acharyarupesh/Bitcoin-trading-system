/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ExchangeEnterprise.MinerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.MinerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MinerWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author preet
 */
public class MinerApprovalsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MinerApprovalsJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private MinerOrganization minerOrganization;
    private Enterprise enterprise;
    private EcoSystem business;

    public MinerApprovalsJPanel(JPanel userProcessContainer, UserAccount userAccount, MinerOrganization minerOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.minerOrganization = minerOrganization;
        this.enterprise = enterprise;
        this.business = business;
        populateTable();
    }

    public void populateTable(){
        DefaultTableModel dtm  = (DefaultTableModel) apprTransJTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest wr : userAccount.getWorkqueue().getWorkRequestList()){
            Object[] row = new Object[6];
            row[0] = wr.getRequestedDate();
            row[1] = wr.getSender();
            row[2] = wr.getReceiver();
            row[3] = wr.getBitcoinsRequested();
            row[4] = wr.getStatus();
            row[5] = ((MinerWorkRequest) wr).getBitcoinRewards();
            
            dtm.addRow(row);
        }
        apprTransJTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        apprTransJTable = new javax.swing.JTable();
        approvedTransactionJLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        downloadBtn = new javax.swing.JButton();
        headingJLabel = new javax.swing.JLabel();

        apprTransJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Sender", "Receiver", "Bitcoins", "Status", "Rewards"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(apprTransJTable);

        approvedTransactionJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        approvedTransactionJLabel.setText("Approved Transactions :");

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        downloadBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        downloadBtn.setText("Download Report");
        downloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadBtnActionPerformed(evt);
            }
        });

        headingJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        headingJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingJLabel.setText("Approvals");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headingJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(downloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(approvedTransactionJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(approvedTransactionJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(downloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void downloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadBtnActionPerformed
        // TODO add your handling code here:
        
        File file = new File("C:\\Users\\preet\\OneDrive\\Documents\\NetBeansProjects\\cryptocurrency\\FinalProject\\minerApprTrans.xls");

       try {
           FileWriter fw = new FileWriter(file);
           BufferedWriter bw = new BufferedWriter(fw);

           for (int j = 0; j < apprTransJTable.getColumnCount(); j++) {
               bw.write(apprTransJTable.getColumnName(j) + "\t");
           }
           bw.newLine();

           for (int i = 0; i < apprTransJTable.getRowCount(); i++) {
               for (int j = 0; j < apprTransJTable.getColumnCount(); j++) {
                   bw.write(apprTransJTable.getValueAt(i, j).toString() + "\t");
               }
               bw.newLine();
           }

           bw.close();
           fw.close();
       } catch (IOException ex) {
//           Logger.getLogger(ManageCustomersJPanel.class.getName()).log(Level.SEVERE, null, ex);
       }
       JOptionPane.showMessageDialog(null, "Report Downloaded Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_downloadBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable apprTransJTable;
    private javax.swing.JLabel approvedTransactionJLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton downloadBtn;
    private javax.swing.JLabel headingJLabel;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
