/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ExchangeEnterprise.MinerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Actor.Customer;
import Business.Organization.Actor.Doctor;
import Business.Organization.Actor.Investor;
import Business.Organization.Actor.LabAssistant;
import Business.Organization.Actor.MallAdmin;
import Business.Organization.Actor.Miner;
import Business.Organization.Actor.Retailer;
import Business.Organization.MinerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MinerWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.LedgerJPanel;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author preet
 */
public class MempoolJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MempoolJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private MinerOrganization minerOrganization;
    private Enterprise enterprise;
    private EcoSystem business;
    private ArrayList<WorkRequest> block;
    public MempoolJPanel(JPanel userProcessContainer, UserAccount account, MinerOrganization minerOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.minerOrganization = minerOrganization;
        this.enterprise = enterprise;
        this.business = business;
        this.block = new ArrayList<WorkRequest>();
        populateTable();
        approvedRequestJTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
    }
    
    

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) mempoolJTable.getModel();
        dtm.setRowCount(0);

        for (WorkRequest wr : minerOrganization.getWorkqueue().getWorkRequestList()) {
            Object[] row = new Object[6];
            row[0] = wr.getRequestedDate();
            row[1] = wr.getSender();
            row[2] = wr.getReceiver();
            row[3] = wr.getBitcoinsRequested();
            row[4] = wr;
            row[5] = ((MinerWorkRequest) wr).getBitcoinRewards();

            dtm.addRow(row);
        }
        mempoolJTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
    }

    private boolean askQuestion() {

        boolean flag = false;
        int number1, number2;

        Random rand = new Random();
        int oper = (rand.nextInt(4) + 1);

        char operator;

        switch (oper) {
            case 1:
                operator = '+';
                break;

            case 2:
                operator = '-';
                break;

            case 3:
                operator = '*';
                break;

            case 4:
                operator = '/';
                break;
        }

        number1 = rand.nextInt(20) + 1;
        number2 = rand.nextInt(10) + 1;
        try{
        if (oper == 1) {
            int sum = number1 + number2;
            int input = Integer.parseInt(JOptionPane.showInputDialog("What is the inclusion of " + number1 + " & " + number2 + "?"));
            if (input == sum) {
                flag = true;
            }
        } else if (oper == 2) {
            int sub = number1 - number2;
            int input = Integer.parseInt(JOptionPane.showInputDialog("What is the diminution of " + number2 + " from " + number1 + "?"));
            if (input == sub) {
                flag = true;
            }
        } else if (oper == 3) {
            int mul = number1 * number2;
            int input = Integer.parseInt(JOptionPane.showInputDialog("What is the amplification of " + number1 + " & " + number2 + "?"));
            if (input == mul) {
                flag = true;
            }
        } else if (oper == 4) {
            int div = number1 / number2;
            int input = Integer.parseInt(JOptionPane.showInputDialog("What is the division of " + number1 + " by " + number2 + "? (Enter the quotient)"));
            if (input == div) {
                flag = true;
            }
        }
        }
        catch(Exception e){
            return flag;
        }

        return flag;
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
        approvedRequestJTable = new javax.swing.JTable();
        confirmButton = new javax.swing.JButton();
        confirmJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mempoolJTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        publishBtn = new javax.swing.JButton();
        unconfirmJLabel = new javax.swing.JLabel();
        headingJLabel = new javax.swing.JLabel();

        approvedRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(approvedRequestJTable);

        confirmButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        confirmJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        confirmJLabel.setText("Confirmed Transactions :");

        mempoolJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(mempoolJTable);

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        publishBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        publishBtn.setText("Publish");
        publishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishBtnActionPerformed(evt);
            }
        });

        unconfirmJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        unconfirmJLabel.setText("Unconfirmed Transactions :");

        headingJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        headingJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingJLabel.setText("Mempool");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headingJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(publishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unconfirmJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(unconfirmJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(confirmJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(publishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(408, 408, 408))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
        int row = mempoolJTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        boolean result = askQuestion();
        if (result == true) {
            if (block.size() < 4) {
                WorkRequest request = (WorkRequest) mempoolJTable.getValueAt(row, 4);
                request.setResovledDate(new Date());
                block.add(request);                
                DefaultTableModel dtm = (DefaultTableModel) approvedRequestJTable.getModel();
                dtm.setRowCount(0);
                UserAccount ua = request.getSender();
                if("Investor".equals(String.valueOf(ua.getEmployee().getType()))){
                    Investor i = (Investor) ua.getEmployee();
                    i.setNoOfBitcoins(-request.getBitcoinsRequested());
                }else if("Retailer".equals(String.valueOf(ua.getEmployee().getType()))){
                    Retailer i = (Retailer) ua.getEmployee();
                    i.setNoOfBitcoins(-request.getBitcoinsRequested());
                }else if("Customer".equals(String.valueOf(ua.getEmployee().getType()))){
                    Customer i = (Customer) ua.getEmployee();
                    i.setNoOfBitcoins(-request.getBitcoinsRequested());
                }else if("MallAdmin".equals(String.valueOf(ua.getEmployee().getType()))){
                    MallAdmin i = (MallAdmin) ua.getEmployee();
                    i.setNoOfBitcoins(-request.getBitcoinsRequested());
                }else if("Doctor".equals(String.valueOf(ua.getEmployee().getType()))){
                    Doctor i = (Doctor) ua.getEmployee();
                    i.setNoOfBitcoins(-request.getBitcoinsRequested());
                }else if("LabAssistant".equals(String.valueOf(ua.getEmployee().getType()))){
                    LabAssistant i = (LabAssistant) ua.getEmployee();
                    i.setNoOfBitcoins(-request.getBitcoinsRequested());
                }
                
                for(WorkRequest wr : ua.getWorkqueue().getWorkRequestList()){
                    if(wr.getRequestedDate().equals(request.getRequestedDate())){
                        wr.setResovledDate(request.getResovledDate());
                        wr.setStatus("Confirmed");
                    }
                }
                
                UserAccount ua1 = request.getReceiver();
                if("Investor".equals(String.valueOf(ua1.getEmployee().getType()))){
                    Investor i = (Investor) ua1.getEmployee();
                    i.setNoOfBitcoins(request.getBitcoinsRequested());
                }else if("Retailer".equals(String.valueOf(ua1.getEmployee().getType()))){
                    Retailer i = (Retailer) ua1.getEmployee();
                    i.setNoOfBitcoins(request.getBitcoinsRequested());
                }else if("Customer".equals(String.valueOf(ua1.getEmployee().getType()))){
                    Customer i = (Customer) ua1.getEmployee();
                    i.setNoOfBitcoins(request.getBitcoinsRequested());
                }else if("MallAdmin".equals(String.valueOf(ua1.getEmployee().getType()))){
                    MallAdmin i = (MallAdmin) ua1.getEmployee();
                    i.setNoOfBitcoins(request.getBitcoinsRequested());
                }else if("Doctor".equals(String.valueOf(ua1.getEmployee().getType()))){
                    Doctor i = (Doctor) ua1.getEmployee();
                    i.setNoOfBitcoins(request.getBitcoinsRequested());
                }else if("LabAssistant".equals(String.valueOf(ua1.getEmployee().getType()))){
                    LabAssistant i = (LabAssistant) ua1.getEmployee();
                    i.setNoOfBitcoins(request.getBitcoinsRequested());
                }
                
                for(WorkRequest wr: ua1.getWorkqueue().getWorkRequestList()){
                    if(wr.getRequestedDate().equals(request.getRequestedDate())){
                        wr.setResovledDate(request.getResovledDate());
                        wr.setStatus("Confirmed");
                    }
                }
                
                for (WorkRequest wr : block) {
                    Object[] newRow = new Object[6];
                    newRow[0] = wr.getResovledDate();
                    newRow[1] = wr.getSender();
                    newRow[2] = wr.getReceiver();
                    newRow[3] = wr.getBitcoinsRequested();
                    newRow[4] = wr;
                    newRow[5] = ((MinerWorkRequest) wr).getBitcoinRewards();
                    
                    dtm.addRow(newRow);
                    userAccount.getWorkqueue().getWorkRequestList().add(wr);
                }
                
                Miner miner = (Miner)userAccount.getEmployee();
                miner.setNoOfBitcoins(1);
                minerOrganization.getWorkqueue().getWorkRequestList().remove(row);
                populateTable();
                
            } else {
                JOptionPane.showMessageDialog(null, "Your block is full!\nPlease publish this block to approve more requests");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Wrong answer. Please try again");
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void publishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishBtnActionPerformed
        // TODO add your handling code here:
        if (block.size() <= 4) {
            business.getLedger().add(block);
            LedgerJPanel ledgerJPanel = new LedgerJPanel(userProcessContainer, business);
            userProcessContainer.add("ledgerJPanel", ledgerJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }

    }//GEN-LAST:event_publishBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable approvedRequestJTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel confirmJLabel;
    private javax.swing.JLabel headingJLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable mempoolJTable;
    private javax.swing.JButton publishBtn;
    private javax.swing.JLabel unconfirmJLabel;
    // End of variables declaration//GEN-END:variables
}