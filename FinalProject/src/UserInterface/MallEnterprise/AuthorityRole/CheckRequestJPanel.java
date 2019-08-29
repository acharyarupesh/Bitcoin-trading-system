/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.MallEnterprise.AuthorityRole;

import Business.BookingHistory.Product;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Actor.Retailer;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MallAdminWorkRequest;
import Business.WorkQueue.MinerWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Niyati Maheshwari
 */
public class CheckRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CheckRequestJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem business;
    private UserAccount account;
    public CheckRequestJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem business, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        this.account = account;
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) requestTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest wr : account.getWorkqueue().getWorkRequestList()){
            Object row[] = new Object[5];
            row[0] = ((MallAdminWorkRequest) wr).getInvoiceNumber();
            row[1] = wr.getSender();
            row[2] = ((MallAdminWorkRequest) wr).getBitcoinsRequested();
            Retailer r = (Retailer) wr.getSender().getEmployee();
            row[3] = calSum(r.getProductCatalog().getProductCatalog());
            row[4] = wr.getMessage();
            
            dtm.addRow(row);
        }
        requestTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
    }
    
    public int calSum(ArrayList<Product> products){
        int total = 0;

        for (Product p : products) {
            total += p.getSold();
        }

        return total;
    }
    
    public UserAccount getRetailer() {
        UserAccount userAccount = null;
        int selectedrow = requestTable.getSelectedRow();
        String name = String.valueOf(requestTable.getValueAt(selectedrow, 1));
        double value = -(double)requestTable.getValueAt(selectedrow, 2);
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                        if (name.equals(String.valueOf(ua.getUsername()))) {
                            userAccount = ua;
                            Retailer r = (Retailer) ua.getEmployee();
                            r.setInvoiceRequest(value);
                            r.setInvoiceMessage("Done");
                            break;
                        }
                    }
                }
            }
        }
        return userAccount;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        checkButton = new javax.swing.JButton();
        retailerNameJLabel = new javax.swing.JLabel();
        revenueJLabel = new javax.swing.JLabel();
        retailerName = new javax.swing.JLabel();
        revenue = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        processButton = new javax.swing.JButton();
        myRevenueJLabel = new javax.swing.JLabel();
        myRevenue = new javax.swing.JLabel();

        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Number", "Retailer", "Money", "No. of Product Sold", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(requestTable);
        if (requestTable.getColumnModel().getColumnCount() > 0) {
            requestTable.getColumnModel().getColumn(0).setHeaderValue("Invoice Number");
        }

        checkButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        checkButton.setText("Check");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        retailerNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        retailerNameJLabel.setText("Retailer:");

        revenueJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        revenueJLabel.setText("Revenue:");

        backButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        processButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        processButton.setText("Process");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        myRevenueJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        myRevenueJLabel.setText("My Revenue:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(revenueJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(retailerNameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(retailerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(revenue, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(myRevenueJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retailerNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retailerName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(revenueJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(revenue, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myRevenueJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        // TODO add your handling code here:
        int row = requestTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        UserAccount ua = (UserAccount) requestTable.getValueAt(row, 1);
        Retailer r = (Retailer) ua.getEmployee();
        retailerName.setText(r.getName());
        revenue.setText(String.valueOf(r.getRevenueOfTheDay()));
    }//GEN-LAST:event_checkButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        // TODO add your handling code here:
        int row= requestTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        double amount=-((double)requestTable.getValueAt(row, 2));
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if ("Exchange".equals(String.valueOf(enterprise.getEnterpriseType()))) {
                    for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (o.getName().equals("Miner Organization")) {
                            MinerWorkRequest minerRequest = new MinerWorkRequest();
                            minerRequest.setRequestedDate(new Date());
                            minerRequest.setSender(account);
                            minerRequest.setReceiver(getRetailer());
                            minerRequest.setStatus("Payment Initiated");
                            minerRequest.setBitcoinRewards(1);
                            minerRequest.setBitcoinsRequested(-amount);
                            o.getWorkqueue().getWorkRequestList().add(minerRequest);
                            
                        }
                    }
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "Request processed successfully");
    }//GEN-LAST:event_processButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton checkButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel myRevenue;
    private javax.swing.JLabel myRevenueJLabel;
    private javax.swing.JButton processButton;
    private javax.swing.JTable requestTable;
    private javax.swing.JLabel retailerName;
    private javax.swing.JLabel retailerNameJLabel;
    private javax.swing.JLabel revenue;
    private javax.swing.JLabel revenueJLabel;
    // End of variables declaration//GEN-END:variables
}