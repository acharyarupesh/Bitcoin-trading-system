/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.MallEnterprise.AuthorityRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Actor.MallAdmin;
import Business.Organization.AdminMallOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Niyati Maheshwari
 */
public class MallAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AuthorityWorkArea
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private AdminMallOrganization adminMallOrganization;
    private Enterprise enterprise;
    private Organization organization;
    private EcoSystem business;
    public MallAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, AdminMallOrganization adminMallOrganization, Enterprise enterprise, Organization organization, EcoSystem business) {
        initComponents(); //To change body of generated methods, choose Tools | Templates.
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.adminMallOrganization = adminMallOrganization;
        this.enterprise = enterprise;
        this.organization = organization;
        this.business = business;
        MallAdmin admin = (MallAdmin) account.getEmployee();
        
        btcJLabel.setText(String.valueOf(admin.getNoOfBitcoins()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headingJLabel = new javax.swing.JLabel();
        manageRetailerButton = new javax.swing.JButton();
        customerOrderReportButton = new javax.swing.JButton();
        retailerTracking = new javax.swing.JButton();
        checkRequestsButton = new javax.swing.JButton();
        btcJLabel = new javax.swing.JLabel();
        walletBalanceJLabel = new javax.swing.JLabel();

        headingJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        headingJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingJLabel.setText("Authority Work Area");

        manageRetailerButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        manageRetailerButton.setText("Manage Retailers");
        manageRetailerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRetailerButtonActionPerformed(evt);
            }
        });

        customerOrderReportButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        customerOrderReportButton.setText("Customer Order Report");
        customerOrderReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerOrderReportButtonActionPerformed(evt);
            }
        });

        retailerTracking.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        retailerTracking.setText("Retailer Tracking");
        retailerTracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retailerTrackingActionPerformed(evt);
            }
        });

        checkRequestsButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        checkRequestsButton.setText("Check Requests");
        checkRequestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRequestsButtonActionPerformed(evt);
            }
        });

        btcJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btcJLabel.setText("<Wallet Balance>");

        walletBalanceJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        walletBalanceJLabel.setText("Wallet Balance:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headingJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(checkRequestsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(manageRetailerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(retailerTracking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(customerOrderReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(278, 278, 278))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(walletBalanceJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btcJLabel)
                                .addGap(5, 5, 5))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(walletBalanceJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btcJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(manageRetailerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(customerOrderReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(retailerTracking, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(checkRequestsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageRetailerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRetailerButtonActionPerformed
        // TODO add your handling code here:
        ManageRetailerJPanel mrjpanel=new ManageRetailerJPanel(userProcessContainer,enterprise);
        userProcessContainer.add("mrjpanel",mrjpanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageRetailerButtonActionPerformed

    private void customerOrderReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerOrderReportButtonActionPerformed
        // TODO add your handling code here:
        ManageCustomersJPanel mcjpanel=new ManageCustomersJPanel(userProcessContainer,enterprise);
        userProcessContainer.add("mcjpanel",mcjpanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_customerOrderReportButtonActionPerformed

    private void retailerTrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retailerTrackingActionPerformed
        // TODO add your handling code here:
        RetailerTrackingJPanel RTjpanel=new RetailerTrackingJPanel(userProcessContainer,enterprise);
        userProcessContainer.add("RTjpanel",RTjpanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_retailerTrackingActionPerformed

    private void checkRequestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkRequestsButtonActionPerformed
        // TODO add your handling code here:
        CheckRequestJPanel CRjpanel=new CheckRequestJPanel(userProcessContainer,enterprise, business, account);
        userProcessContainer.add("CRjpanel",CRjpanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_checkRequestsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btcJLabel;
    private javax.swing.JButton checkRequestsButton;
    private javax.swing.JButton customerOrderReportButton;
    private javax.swing.JLabel headingJLabel;
    private javax.swing.JButton manageRetailerButton;
    private javax.swing.JButton retailerTracking;
    private javax.swing.JLabel walletBalanceJLabel;
    // End of variables declaration//GEN-END:variables
}
