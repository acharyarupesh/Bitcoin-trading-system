/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.MallEnterprise.AuthorityRole;

import Business.BookingHistory.Product;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Actor.Customer;
import Business.Organization.Actor.Retailer;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Niyati Maheshwari
 */
public class RetailerTrackingJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RetailerTrackingJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private String attachment_path;
    private String email;
    public RetailerTrackingJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;

        populateTable();
        category();
//        emailTextField.setVisible(false);
//        path_attach.setVisible(false);
//        jLabel2.setVisible(false);
//        jLabel3.setVisible(false);
//        attachButton.setVisible(false);
//        emailButton.setVisible(false);
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) retailerTable.getModel();
        dtm.setRowCount(0);

        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                if ("Retailer".equals(String.valueOf(ua.getEmployee().getType()))) {
                    Retailer r = (Retailer) ua.getEmployee();
                    Object[] row = new Object[3];
                    row[0] = ua.getEmployee().getName();
                    row[1] = calSum(r.getProductCatalog().getProductCatalog());
                    row[2] = calMoney(r.getProductCatalog().getProductCatalog());

                    dtm.addRow(row);
                }
            }
        }
    }

    public int calSum(ArrayList<Product> product) {
        int total = 0;

        for (Product p : product) {
            total += p.getSold();
        }

        return total;
    }

    public int calMoney(ArrayList<Product> product) {
        int revenue = 0;

        for (Product p : product) {
            revenue = revenue + p.getSold() * p.getPrice();
        }

        return revenue;
    }

    public void category() {
        int eSum = 0;
        int cSum = 0;
        int fSum = 0;
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                if ("Retailer".equals(String.valueOf(ua.getEmployee().getType()))) {
                    Retailer r = (Retailer) ua.getEmployee();
                    for (Product p : r.getProductCatalog().getProductCatalog()) {
                        if (p.getProductCategory().equals("Electronics")) {
                            eSum += p.getSold();
                        } else if (p.getProductCategory().equals("Clothing")) {
                            cSum += p.getSold();
                        } else {
                            fSum += p.getSold();
                        }
                    }
                }
            }
        }

        foodLabel.setText(String.valueOf(fSum));
        electronicsLabel.setText(String.valueOf(eSum));
        clothingLabel.setText(String.valueOf(cSum));
    }
    
    
    public void mail() {
        email = emailTextField.getText();
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("acharya.rupesh0@gmail.com", "dishaclasses");
            }
        }
        );
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("acharya.rupesh0@gmail.com"));
            System.out.print(email);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Please find the attached report");

            MimeBodyPart messgaeBodypart = new MimeBodyPart();
            messgaeBodypart.setText("Hi Image is sent to you");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messgaeBodypart);

            messgaeBodypart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachment_path);
            messgaeBodypart.setDataHandler(new DataHandler(source));
            messgaeBodypart.setFileName(new File(attachment_path).getName());
            multipart.addBodyPart(messgaeBodypart);
            message.setContent(multipart);

            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Mail is sent");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "All fields are mandatory");
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

        headingJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        retailerTable = new javax.swing.JTable();
        soldCategoryJLabel = new javax.swing.JLabel();
        foodJLabel = new javax.swing.JLabel();
        clothingJLabel = new javax.swing.JLabel();
        electronicsJLabel = new javax.swing.JLabel();
        electronicsLabel = new javax.swing.JLabel();
        clothingLabel = new javax.swing.JLabel();
        foodLabel = new javax.swing.JLabel();
        downloadButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        createChartButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        path_attach = new javax.swing.JTextField();
        attachButton = new javax.swing.JButton();
        emailButton = new javax.swing.JButton();

        headingJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        headingJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingJLabel.setText("Retailer Report");

        retailerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Retailer", "Number of Products Sold", "Total Revenue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(retailerTable);

        soldCategoryJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        soldCategoryJLabel.setText("Number of Products Sold by Category:");

        foodJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        foodJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        foodJLabel.setText("Food:");

        clothingJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        clothingJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        clothingJLabel.setText("Clothing:");

        electronicsJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        electronicsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        electronicsJLabel.setText("Electronics:");

        electronicsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        clothingLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        foodLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        downloadButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        downloadButton.setText("Download Report");
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        createChartButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        createChartButton.setText("Create Chart");
        createChartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createChartButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Email ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("File:");

        attachButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        attachButton.setText("Upload");
        attachButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachButtonActionPerformed(evt);
            }
        });

        emailButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        emailButton.setText("Send");
        emailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(headingJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(soldCategoryJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(electronicsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clothingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(foodJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(electronicsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clothingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(foodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createChartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 14, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(path_attach, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(attachButton)))
                                .addGap(73, 73, 73))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soldCategoryJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createChartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(electronicsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clothingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(foodJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(path_attach, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attachButton)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailButton)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(128, 128, 128))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(electronicsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clothingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addComponent(foodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed
        // TODO add your handling code here:
        File file = new File("D:\\AEDSpring2018\\acharya_rupesh_001899473\\customer.xls");

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int j = 0; j < retailerTable.getColumnCount(); j++) {
                bw.write(retailerTable.getColumnName(j) + "\t");
            }
            bw.newLine();

            for (int i = 0; i < retailerTable.getRowCount(); i++) {
                for (int j = 0; j < retailerTable.getColumnCount(); j++) {
                    bw.write(retailerTable.getValueAt(i, j).toString() + "\t");
                }
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ManageCustomersJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Report Downloaded Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_downloadButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backButtonActionPerformed

    private void createChartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createChartButtonActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (o.toString().equals("Retailer Organization")) {
                for (Employee e : o.getEmployeeDirectory().getEmployeeList()) {
                    if ("Retailer".equals(String.valueOf(e.getType()))) {
                        Retailer retailer = (Retailer) e;
                        dataset.setValue(calMoney(retailer.getProductCatalog().getProductCatalog()), "Total Revenue", e.getName());
                    }
                }
            }
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Retailer Report", "Retailer Name", "Revenue by Retailer", dataset, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(Color.YELLOW);
        chart.getTitle().setPaint(Color.BLUE);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartFrame frame = new ChartFrame("Bar Chart for Retailer", chart);
        frame.setVisible(true);
        frame.setSize(450, 350);

        try {
            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File file1 = new File("Retailer_Report.png");
            ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);

        } catch (Exception e) {

        }
    }//GEN-LAST:event_createChartButtonActionPerformed

    private void attachButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        attachment_path = f.getAbsolutePath();
        path_attach.setText(attachment_path);
    }//GEN-LAST:event_attachButtonActionPerformed

    private void emailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailButtonActionPerformed
        // TODO add your handling code here:
        mail();
    }//GEN-LAST:event_emailButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attachButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel clothingJLabel;
    private javax.swing.JLabel clothingLabel;
    private javax.swing.JButton createChartButton;
    private javax.swing.JButton downloadButton;
    private javax.swing.JLabel electronicsJLabel;
    private javax.swing.JLabel electronicsLabel;
    private javax.swing.JButton emailButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel foodJLabel;
    private javax.swing.JLabel foodLabel;
    private javax.swing.JLabel headingJLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField path_attach;
    private javax.swing.JTable retailerTable;
    private javax.swing.JLabel soldCategoryJLabel;
    // End of variables declaration//GEN-END:variables
}
