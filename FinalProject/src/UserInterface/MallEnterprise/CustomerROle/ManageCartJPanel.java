/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.MallEnterprise.CustomerROle;

import Business.BookingHistory.OrderItem;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Actor.Customer;
import Business.Organization.Actor.MallAdmin;
import Business.Organization.CustodianOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CustodianWorkRequest;
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
public class ManageCartJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageCartJPanel
     */
    private JPanel userProcessContainer;
    private ArrayList<OrderItem> list;
    private Customer customer;
    private Enterprise enterprise;
    private EcoSystem business;
    private UserAccount accoumt;
    private double amount;

    public ManageCartJPanel(JPanel userProcessContainer, ArrayList<OrderItem> orderItemList, Customer customer, Enterprise enterprise, EcoSystem business, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.list = orderItemList;
        this.customer = customer;
        this.enterprise = enterprise;
        this.business = business;
        this.accoumt = account;
        btcJLabel.setText(String.valueOf(customer.getNoOfBitcoins()));
        populateTable();
        amountPayble();
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) cartItemsTable.getModel();
        dtm.setRowCount(0);
        for (OrderItem oil : list) {
            Object row[] = new Object[4];
            row[0] = oil;
            row[1] = oil.getProduct().getPrice();
            row[2] = oil.getQuantity();
            row[3] = oil.getQuantity() * oil.getProduct().getPrice();
            dtm.addRow(row);
        }
        cartItemsTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
    }

    public void amountPayble() {
        int total = 0;
        int priceperRow;
        int numberOfRows = cartItemsTable.getRowCount();
        for (int i = 0; i < numberOfRows; i++) {
            priceperRow = (Integer) cartItemsTable.getValueAt(i, 3);
            total = total + priceperRow;
        }
        totalAmountJlabel.setText(String.valueOf(total));
        amount = total;
    }

    public void trackRetailer() {
        for (OrderItem oil : customer.getPlaceOrder().getPlaceOrderList()) {
            int x = oil.getQuantity();
            oil.getProduct().setSold(x);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        cartItemsTable = new javax.swing.JTable();
        headingJLabel = new javax.swing.JLabel();
        modifyQtyButton = new javax.swing.JButton();
        modifyQuantityTxtField = new javax.swing.JTextField();
        amountDisplayLAbel = new javax.swing.JLabel();
        totalAmountJlabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        checkOutButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        walletBalanceJLabel = new javax.swing.JLabel();
        btcJLabel = new javax.swing.JLabel();
        addBitcoinsButton = new javax.swing.JButton();
        bitcoinsTextField = new javax.swing.JTextField();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        cartItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product name", "Price", "Quantity", "Total amount"
            }
        ));
        jScrollPane1.setViewportView(cartItemsTable);

        headingJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        headingJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingJLabel.setText("Manage your Cart");

        modifyQtyButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        modifyQtyButton.setText("Modify quantity");
        modifyQtyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyQtyButtonActionPerformed(evt);
            }
        });

        amountDisplayLAbel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        amountDisplayLAbel.setText("Total Amount to pay:");

        totalAmountJlabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        backButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        checkOutButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        checkOutButton.setText("Check out");
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        removeButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        walletBalanceJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        walletBalanceJLabel.setText("Wallet Balance:");

        btcJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btcJLabel.setText("<Wallet Balance>");

        addBitcoinsButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        addBitcoinsButton.setText("Add Bitcoins to Wallet");
        addBitcoinsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBitcoinsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(headingJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(modifyQuantityTxtField)
                                    .addComponent(amountDisplayLAbel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalAmountJlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(modifyQtyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(checkOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bitcoinsTextField)
                                .addGap(18, 18, 18)
                                .addComponent(addBitcoinsButton)))
                        .addGap(43, 43, 43))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(walletBalanceJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btcJLabel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(headingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btcJLabel)
                    .addComponent(walletBalanceJLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modifyQuantityTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifyQtyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountDisplayLAbel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(totalAmountJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBitcoinsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bitcoinsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void modifyQtyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyQtyButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = cartItemsTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        OrderItem oi = (OrderItem) cartItemsTable.getValueAt(selectedRow, 0);
        int currentAvail = oi.getProduct().getQuantity();
        int oldQty = oi.getQuantity();
        int newQty = Integer.parseInt(modifyQuantityTxtField.getText());
        if (newQty > (currentAvail + oldQty)) {
            JOptionPane.showMessageDialog(null, "Quantity is more than availability");
        } else {
            if (newQty <= 0) {
                JOptionPane.showMessageDialog(null, "Quantity should be greater than zero");
                return;
            }
            oi.setQuantity(newQty);
            oi.getProduct().changeQuantity(oldQty - newQty);
            populateTable();
            amountPayble();
            System.out.print("Product quantity left: " + oi.getProduct().getQuantity());
        }

    }//GEN-LAST:event_modifyQtyButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed
        // TODO add your handling code here:
        if (customer.getNoOfBitcoins() >= Double.parseDouble(totalAmountJlabel.getText())) {

            customer.getPlaceOrder().getPlaceOrderList().addAll(list);
            int total = 0;
            int priceperRow;
            int numberOfRows = cartItemsTable.getRowCount();
            for (int i = 0; i < numberOfRows; i++) {
                priceperRow = (Integer) cartItemsTable.getValueAt(i, 3);
                total = total + priceperRow;
            }
            for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
                for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                    if ("MallAdmin".equals(String.valueOf(ua.getEmployee().getType()))) {
                        MallAdmin ma = (MallAdmin) ua.getEmployee();
                        ma.setInvoiceAmount(total);
                    }
                }
            }
            customer.setTotalMoneySpent(total);
            list.clear();
            trackRetailer();
            CustomerDetailsJPanel cdjpanel = new CustomerDetailsJPanel(userProcessContainer, customer, enterprise, list, business, accoumt, amount);
            userProcessContainer.add("cdjpanel", cdjpanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient Balance");
        }
    }//GEN-LAST:event_checkOutButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = cartItemsTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        OrderItem oi = (OrderItem) cartItemsTable.getValueAt(selectedRow, 0);
        int oldQty = oi.getQuantity();
        oi.getProduct().changeQuantity(oldQty);
        list.remove(oi);
        populateTable();
        amountPayble();

        //System.out.print("Product quantity left after removal: " + oi.getProduct().getQuantity());
    }//GEN-LAST:event_removeButtonActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        populateTable();
        amountPayble();
    }//GEN-LAST:event_formComponentShown

    private void addBitcoinsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBitcoinsButtonActionPerformed
        // TODO add your handling code here:
        if (!bitcoinsTextField.getText().trim().isEmpty()) {
            double bitcoins = Double.parseDouble(bitcoinsTextField.getText().trim());
            CustodianWorkRequest request = new CustodianWorkRequest();
            request.setMessage("Adding money to wallet");
            request.setSender(accoumt);
            request.setRequestType("Buy");
            request.setBitcoinsRequested(bitcoins);
            request.setStatus("Pending");
            request.setRequestedDate(new Date());

            Organization org = null;
            for (Network n : business.getNetworkList()) {
                for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization organization : e.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof CustodianOrganization) {
                            org = organization;
                            break;
                        }
                    }
                }
            }
            if (org != null) {
                org.getWorkqueue().getWorkRequestList().add(request);
                accoumt.getWorkqueue().getWorkRequestList().add(request);
            }
            JOptionPane.showMessageDialog(null, "Request has been successfully submitted");
            
        }else
            JOptionPane.showMessageDialog(null, "Please enter amount");

    }//GEN-LAST:event_addBitcoinsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBitcoinsButton;
    private javax.swing.JLabel amountDisplayLAbel;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField bitcoinsTextField;
    private javax.swing.JLabel btcJLabel;
    private javax.swing.JTable cartItemsTable;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JLabel headingJLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyQtyButton;
    private javax.swing.JTextField modifyQuantityTxtField;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel totalAmountJlabel;
    private javax.swing.JLabel walletBalanceJLabel;
    // End of variables declaration//GEN-END:variables
}