/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.MallEnterprise.CustomerROle;

import Business.BookingHistory.OrderItem;
import Business.BookingHistory.Product;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Actor.Customer;
import Business.Organization.Actor.Retailer;
import Business.Organization.Organization;
import Business.Organization.RetailerOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Niyati Maheshwari
 */
public class FoodJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FoodJPanel
     */

    private RetailerOrganization e;
    private JPanel userProcessContainer;
    private Customer customer;
    private EcoSystem business;
    ArrayList<Retailer> result = new ArrayList<Retailer>();
    

    public FoodJPanel(JPanel userProcessContainer, Customer customer, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.customer = customer;
        this.business = business;

        populateTable();
        populateCombobox();
    }

    public void populateCombobox() {
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                        if ("Retailer".equals(String.valueOf(ua.getEmployee().getType()))) {
                            Retailer r = (Retailer) ua.getEmployee();
                            retailerListJComboBox.addItem(r.getName());
                        }
                    }
                }
            }
        }
    }
    
    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel)foodTable.getModel();
        dtm.setRowCount(0);
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                        System.out.println(ua.getEmployee().getName() + " " + ua.getEmployee().getType());
                        if ("Retailer".equals(String.valueOf(ua.getEmployee().getType()))) {
                            Retailer r = (Retailer) ua.getEmployee();
                            for (Product p : r.getProductCatalog().getProductCatalog()) {
                                if (p.getProductCategory().equals("Food")) {
                                    Object row[] = new Object[4];
                                    row[0] = r;
                                    row[1] = p;
                                    row[2] = p.getPrice();
                                    row[3] = p.getQuantity();
                                    dtm.addRow(row);
                                }
                            }
                        }
                    }
                }
            }
        }
//        for(Employee r: e.getEmployeeDirectory().getEmployeeList()){
//            for(Product p : retailer.getProductCatalog().getProductCatalog()) {
//                
//            }
//
//        }
        foodTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
    }

    public void populateTable(ArrayList<Retailer> filter) {
        DefaultTableModel dtm = (DefaultTableModel) foodTable.getModel();
        dtm.setRowCount(0);

        for (Retailer r : filter) {
            for (Product p : r.getProductCatalog().getProductCatalog()) {
                if (p.getProductCategory().equals("Food")) {
                    Object row[] = new Object[4];
                    row[0] = r;
                    row[1] = p;
                    row[2] = p.getPrice();
                    row[3] = p.getQuantity();
                    dtm.addRow(row);
                }
            }

        }
    }
    public void searchRetailer(String query) {
        result.clear();

        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                        if ("Retailer".equals(String.valueOf(ua.getEmployee().getType()))) {
                            if (ua.getEmployee().getName().equals(query)) {
                                Retailer r = (Retailer) ua.getEmployee();
                                result.add(r);
                            }
                        }
                    }
                }
            }
        }
        populateTable(result);
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
        retailerListJComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        foodTable = new javax.swing.JTable();
        quantityTextfield = new javax.swing.JTextField();
        quantityJLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        addToCartButton = new javax.swing.JButton();
        continueButton = new javax.swing.JButton();

        headingJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        headingJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingJLabel.setText("FOOD");

        retailerListJComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        retailerListJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "List of Retailors" }));
        retailerListJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                retailerListJComboBoxItemStateChanged(evt);
            }
        });

        foodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Retailor", "Product", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(foodTable);

        quantityJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        quantityJLabel.setText("Quantity:");

        backButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        addToCartButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        addToCartButton.setText("Add to cart");
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        continueButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        continueButton.setText("Continue Shopping");
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(retailerListJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headingJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(quantityJLabel)
                        .addGap(40, 40, 40)
                        .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(retailerListJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void retailerListJComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_retailerListJComboBoxItemStateChanged
        // TODO add your handling code here:
       String query = retailerListJComboBox.getSelectedItem().toString();
        if (query.equals("List of Retailors")) {
            populateTable();
        } else {
            searchRetailer(query);
        }
    }//GEN-LAST:event_retailerListJComboBoxItemStateChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartButtonActionPerformed
        // TODO add your handling code here:
       int row = foodTable.getSelectedRow();
        Product p = (Product) foodTable.getValueAt(row, 1);
        Retailer r = (Retailer) foodTable.getValueAt(row, 0);
        if (row < 0) {

            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            if (quantityTextfield.getText().trim().isEmpty() || !quantityTextfield.getText().trim().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Please enter valid quantity", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int fetchQuantity = Integer.parseInt(quantityTextfield.getText());
            if (fetchQuantity <= p.getQuantity()) {

                OrderItem oi = customer.getOrderItem().addItemToList();
                oi.setProduct(p);
                oi.setRetailer(r);
                oi.setQuantity(fetchQuantity);

                int oldavail = p.getQuantity();
                int newavail = oldavail - fetchQuantity;

                p.setQuantity(newavail);
                JOptionPane.showMessageDialog(null, "Product added successfully");
                populateTable();
                quantityTextfield.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Quantity added is not available in the stock.\nPlease enter quantity less than product availabe in stock");
            }
        } 
        
    }//GEN-LAST:event_addToCartButtonActionPerformed

    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_continueButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton continueButton;
    private javax.swing.JTable foodTable;
    private javax.swing.JLabel headingJLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quantityJLabel;
    private javax.swing.JTextField quantityTextfield;
    private javax.swing.JComboBox retailerListJComboBox;
    // End of variables declaration//GEN-END:variables
}
