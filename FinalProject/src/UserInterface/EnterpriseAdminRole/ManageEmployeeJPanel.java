/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnterpriseAdminRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Roles.Role;
import Business.UserAccount.UserAccount;
//import com.teknikindustries.bulksms.SMS;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author achar
 */
public class ManageEmployeeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEmployeeJPanel
     */
    private JPanel userProcessContainer;
    private OrganizationDirectory organizationDirectory;
    private Enterprise enterprise;
    private EcoSystem business;
    private String email;
    private String name;
    private String username;
    private String password;
    private long mobileNumber;

    public ManageEmployeeJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory, EcoSystem business, Enterprise enterprise) {
        initComponents();
        this.organizationDirectory = organizationDirectory;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        populateOrganizationComboBox();
        populateTable();

    }

    public void populateRoleCombobox(Organization organization) {
        RoleCombobox.removeAllItems();
        for (Role role : organization.getSupportedRole()) {
            RoleCombobox.addItem(role);
//            System.out.println(role.getClass().getName());
        }
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) employeeTable.getModel();
        dtm.setRowCount(0);

        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {

                Object[] row = new Object[6];
                row[0] = o.getName();
                row[1] = ua.getEmployee().getName();
                row[2] = ua.getUsername();
                row[3] = ua.getRole();
                row[4] = ua.getEmployee().getEmailID();
                row[5] = ua.getEmployee().getMobileNumber();

                dtm.addRow(row);
            }
        }
        employeeTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
    }

    public void populateOrganizationComboBox() {
        for (Organization o : organizationDirectory.getOrganizationList()) {
            OrganizationCombobox.addItem(o);
        }
    }

    public void Textfields() {
        nameTextField.setText("");
        emailIdTextField.setText("");
        usernameTextField.setText("");
        passwordTextField.setText("");
        mobileNumTextField.setText("");
        OrganizationCombobox.setSelectedIndex(0);
        RoleCombobox.setSelectedIndex(0);
    }

    public void mail() {
//        SMS sms= new SMS();
//        sms.SendSMS("Niymahes", "mavericks", "Hi Welcome to mavericks system","+1"+mobileNumTextField.getText() , "http://usa.bulksms.com/eapi/submission/send_sms/2/2.0");
        JOptionPane.showMessageDialog(null, "Message sent!");
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
            message.setSubject("Welcome to the mavericks project");
            message.setText("Hi new sign up done successfully");
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Mail is sent");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        nameTextField = new javax.swing.JTextField();
        emailIdTextField = new javax.swing.JTextField();
        mobileNumTextField = new javax.swing.JTextField();
        nameJLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        emailJLabel = new javax.swing.JLabel();
        mobileNumJLabel = new javax.swing.JLabel();
        usernameJLabel = new javax.swing.JLabel();
        passwordJLabel = new javax.swing.JLabel();
        RoleLabel = new javax.swing.JLabel();
        OrganizationLabel = new javax.swing.JLabel();
        OrganizationCombobox = new javax.swing.JComboBox();
        RoleCombobox = new javax.swing.JComboBox();
        addJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        headingJLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();

        nameTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        emailIdTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mobileNumTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mobileNumTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileNumTextFieldActionPerformed(evt);
            }
        });

        nameJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nameJLabel.setText("Name:");
        nameJLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        usernameTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        emailJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        emailJLabel.setText("Email ID:");
        emailJLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mobileNumJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mobileNumJLabel.setText("Mobile Number:");
        mobileNumJLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        usernameJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        usernameJLabel.setText("Username:");
        usernameJLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        passwordJLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        passwordJLabel.setText("Password:");
        passwordJLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        RoleLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        RoleLabel.setText("Role:");
        RoleLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        OrganizationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        OrganizationLabel.setText("Organization:");
        OrganizationLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        OrganizationCombobox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        OrganizationCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--" }));
        OrganizationCombobox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        OrganizationCombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                OrganizationComboboxItemStateChanged(evt);
            }
        });

        RoleCombobox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        RoleCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--" }));
        RoleCombobox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        addJButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        addJButton.setText("Add");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        headingJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        headingJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingJLabel.setText("Manage Employee");

        passwordTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organization", "Name", "Username", "Role", "Email", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(employeeTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mobileNumJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(usernameJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mobileNumTextField)
                            .addComponent(passwordTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrganizationLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RoleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailIdTextField)
                            .addComponent(nameTextField)
                            .addComponent(RoleCombobox, 0, 229, Short.MAX_VALUE)
                            .addComponent(OrganizationCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(259, 259, 259))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(headingJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(headingJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrganizationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrganizationCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RoleCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileNumJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobileNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        try {
            name = nameTextField.getText();
            email = emailIdTextField.getText();
            username = usernameTextField.getText();
            password = passwordTextField.getText();
            mobileNumber = Long.parseLong(mobileNumTextField.getText());
            Organization organization = (Organization) OrganizationCombobox.getSelectedItem();
            Role role = (Role) RoleCombobox.getSelectedItem();
            if (!OrganizationCombobox.getSelectedItem().toString().equals("--Select--") && !RoleCombobox.getSelectedItem().toString().equals("--Select--") && !usernameTextField.getText().trim().isEmpty() && !passwordTextField.getText().trim().isEmpty() && !nameTextField.getText().trim().isEmpty() && !emailIdTextField.getText().trim().isEmpty() && !mobileNumTextField.getText().trim().isEmpty()) {
                if (enterprise.getUserAccountDirectory().checkIfUsernameIsUnique(username) == true) {
                    if (!String.valueOf(mobileNumber).matches("[a-zA-Z]") && String.valueOf(mobileNumber).length() == 10 && String.valueOf(mobileNumber).matches("[0-9]+")) {
                        if (email.matches("^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$")) {
                            if (usernameTextField.getText().equals(passwordTextField.getText())) {
                                JOptionPane.showMessageDialog(null, "Username and password cannot be same");
                                usernameTextField.setText("");
                            } else {
                                switch (organization.toString()) {
                                    case "Investor Organization": {
                                        mail();
                                        Employee e = organization.getEmployeeDirectory().addEmployee(name, email, mobileNumber, Organization.Type.Investor);
                                        organization.getUserAccountDirectory().createUserAccount(username, password, e, role);
                                        JOptionPane.showMessageDialog(null, "Investor Created Succesfully");
                                        Textfields();
                                        break;
                                    }
                                    case "Custodian Organization": {
                                        mail();
                                        Employee e = organization.getEmployeeDirectory().addEmployee(name, email, mobileNumber, Organization.Type.Custodian);
                                        organization.getUserAccountDirectory().createUserAccount(username, password, e, role);
                                        JOptionPane.showMessageDialog(null, "Custodian Created Succesfully");
                                        Textfields();
                                        break;
                                    }
                                    case "Miner Organization": {
                                        mail();
                                        Employee e = organization.getEmployeeDirectory().addEmployee(name, email, mobileNumber, Organization.Type.Miner);
                                        organization.getUserAccountDirectory().createUserAccount(username, password, e, role);
                                        JOptionPane.showMessageDialog(null, "Miner Created Succesfully");
                                        Textfields();
                                        break;
                                    }
                                    case "Doctor Organization": {
                                        mail();
                                        Employee e = organization.getEmployeeDirectory().addEmployee(name, email, mobileNumber, Organization.Type.Doctor);
                                        organization.getUserAccountDirectory().createUserAccount(username, password, e, role);
                                        JOptionPane.showMessageDialog(null, "Doctor Created Succesfully");
                                        Textfields();
                                        break;
                                    }
                                    case "Lab Organization": {
                                        mail();
                                        Employee e = organization.getEmployeeDirectory().addEmployee(name, email, mobileNumber, Organization.Type.LabAssistant);
                                        organization.getUserAccountDirectory().createUserAccount(username, password, e, role);
                                        JOptionPane.showMessageDialog(null, "Lab Assistant Created Succesfully");
                                        Textfields();
                                        break;
                                    }
                                    case "MallAdmin Organization": {
                                        mail();
                                        Employee e = organization.getEmployeeDirectory().addEmployee(name, email, mobileNumber, Organization.Type.MallAdmin);
                                        organization.getUserAccountDirectory().createUserAccount(username, password, e, role);
                                        JOptionPane.showMessageDialog(null, "Mall Admin Created Succesfully");
                                        Textfields();
                                        break;
                                    }
                                    case "Retailer Organization": {
                                        mail();
                                        Employee e = organization.getEmployeeDirectory().addEmployee(name, email, mobileNumber, Organization.Type.Retailer);
                                        organization.getUserAccountDirectory().createUserAccount(username, password, e, role);
                                        JOptionPane.showMessageDialog(null, "Retailer Created Succesfully");
                                        Textfields();
                                        break;
                                    }
                                    case "Customer Organization": {
                                        mail();
                                        Employee e = organization.getEmployeeDirectory().addEmployee(name, email, mobileNumber, Organization.Type.Customer);
                                        organization.getUserAccountDirectory().createUserAccount(username, password, e, role);
                                        JOptionPane.showMessageDialog(null, "Customer Created Succesfully");
                                        Textfields();
                                        break;
                                    }
                                    default:
                                        break;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter valid email address");
                            emailIdTextField.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter mobile number with 10 digits");
                        mobileNumTextField.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User already exists");
                    usernameTextField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "All fields are madatory");
            }
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(null, "Please enter valid number");
            mobileNumTextField.setText("");
        }
        populateTable();
    }//GEN-LAST:event_addJButtonActionPerformed

    private void OrganizationComboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_OrganizationComboboxItemStateChanged
        // TODO add your handling code here:
        if (OrganizationCombobox.getSelectedItem() != null) {
            if (!OrganizationCombobox.getSelectedItem().toString().equals("--Select--")) {
                Organization organization = (Organization) OrganizationCombobox.getSelectedItem();
                if (organization != null) {
                    populateRoleCombobox(organization);
                }
            }
        }
    }//GEN-LAST:event_OrganizationComboboxItemStateChanged

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void mobileNumTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileNumTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileNumTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox OrganizationCombobox;
    private javax.swing.JLabel OrganizationLabel;
    private javax.swing.JComboBox RoleCombobox;
    private javax.swing.JLabel RoleLabel;
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField emailIdTextField;
    private javax.swing.JLabel emailJLabel;
    private javax.swing.JTable employeeTable;
    private javax.swing.JLabel headingJLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mobileNumJLabel;
    private javax.swing.JTextField mobileNumTextField;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel usernameJLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
