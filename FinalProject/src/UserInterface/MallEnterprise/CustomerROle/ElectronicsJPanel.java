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
public class ElectronicsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ElectronicsJPanel
     */
    private RetailerOrganization e;
    private JPanel userProcessContainer;
    private Customer customer;
    private EcoSystem business;
    ArrayList<Retailer> result = new ArrayList<Retailer>();
  


    public ElectronicsJPanel(JPanel userProcessContainer, Customer customer, EcoSystem business) {
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
                            retailerListJComboBox1.addItem(r.getName());
                        }
                    }
                }
            }
        }
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) electronicsTable.getModel();
        dtm.setRowCount(0);
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                        if ("Retailer".equals(String.valueOf(ua.getEmployee().getType()))) {
                            Retailer r = (Retailer) ua.getEmployee();
                            for (Product p : r.getProductCatalog().getProductCatalog()) {
                                if (p.getProductCategory().equals("Electronics")) {
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
        electronicsTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
    }

    public void populateTable(ArrayList<Retailer> filter) {
        DefaultTableModel dtm = (DefaultTableModel) electronicsTable.getModel();
        dtm.setRowCount(0);
        for (Retailer r : filter) {
            for (Product p : r.getProductCatalog().getProductCatalog()) {
                if (p.getProductCategory().equals("Electronics")) {
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
        retailerListJComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        electronicsTable = new javax.swing.JTable();
        quantityJLAbel = new javax.swing.JLabel();
        quantityTextfield = new javax.swing.JTextField();
        addToCartButton = new javax.swing.JButton();
        continueButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        headingJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        headingJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingJLabel.setText("ELECTRONICS");

        retailerListJComboBox1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        retailerListJComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "List of Retailors" }));
        retailerListJComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                retailerListJComboBox1ItemStateChanged(evt);
            }
        });

        electronicsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Retailor", "Product", "Price", "Stock Left"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(electronicsTable);

        quantityJLAbel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        quantityJLAbel.setText("Quantity:");

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

        backButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(headingJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(quantityJLAbel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                                .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(retailerListJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(retailerListJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(quantityJLAbel)))
                .addGap(29, 29, 29)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void retailerListJComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_retailerListJComboBox1ItemStateChanged
        // TODO add your handling code here:
       String query = retailerListJComboBox1.getSelectedItem().toString();
        if (query.equals("List of Retailors")) {
            populateTable();
        } else {
            searchRetailer(query);
        }
    }//GEN-LAST:event_retailerListJComboBox1ItemStateChanged

    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartButtonActionPerformed
        // TODO add your handling code here:
       int row = electronicsTable.getSelectedRow();
        Product p = (Product) electronicsTable.getValueAt(row, 1);
        Retailer r = (Retailer) electronicsTable.getValueAt(row, 0);
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

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton continueButton;
    private javax.swing.JTable electronicsTable;
    private javax.swing.JLabel headingJLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quantityJLAbel;
    private javax.swing.JTextField quantityTextfield;
    private javax.swing.JComboBox retailerListJComboBox1;
    // End of variables declaration//GEN-END:variables
}
