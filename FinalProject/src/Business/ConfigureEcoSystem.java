/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Actor.Customer;
import Business.Organization.Actor.Doctor;
import Business.Organization.Actor.Investor;
import Business.Organization.Organization;
import Business.Roles.AdminMallRole;
import Business.Roles.CustodianRole;
import Business.Roles.CustomerRole;
import Business.Roles.DoctorRole;
import Business.Roles.EnterpriseAdmin;
import Business.Roles.InvestorRole;
import Business.Roles.LabRole;
import Business.Roles.MinerRole;
import Business.Roles.RetailerRole;
import Business.Roles.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author achar
 */
public class ConfigureEcoSystem {
    
    public static EcoSystem configure(){
        EcoSystem system = EcoSystem.getInstance();
        
        //Creating SystemAdmin
        Employee employee = system.getEmployeeDirectory().addEmployee("Admin", "admin@gmail.com", 853188747, Organization.Type.SystemAdmin);     
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("admin", "admin", employee, new SystemAdminRole());
        
        //Creating Network
        Network network = system.createAndAddNetwork();
        network.setName("India");
        
        //Creating Enterprise 1
        Enterprise enterpise1 = network.getEnterpriseDirectory().createAndAddEnterprise("Coinbase", Enterprise.EnterpriseType.Exchange);        
        
        //Creating Enterprise1 Admin
        Employee employee1 = enterpise1.getEmployeeDirectory().addEmployee("Rupesh", "acharya.rupesh0@gmail.com", 98567432, Organization.Type.EnterpriseAdmin);
        //Creating  UserAccount for Employee1
        UserAccount useraccount = enterpise1.getUserAccountDirectory().createUserAccount("rupesh", "rupesh", employee1, new EnterpriseAdmin());
        
        //Creating Organization for Enterpise 1
        Organization organization1 = enterpise1.getOrganizationDirectory().createOrganization(Organization.Type.Investor);
        //Creating employees for Organization 1
        Employee employee3 = organization1.getEmployeeDirectory().addEmployee("Niyati", "maheshwari.ni@husky.neu.edu", 123456789, Organization.Type.Investor);
        UserAccount ua1 = organization1.getUserAccountDirectory().createUserAccount("investor1", "investor1", employee3, new InvestorRole());
        Investor investor1 = (Investor) employee3;
        investor1.setNoOfBitcoins(100);
        Employee employee6 = organization1.getEmployeeDirectory().addEmployee("Karan", "racca.ka@husky.neu.edu", 123456789, Organization.Type.Investor); 
        UserAccount ua4 = organization1.getUserAccountDirectory().createUserAccount("investor2", "investor2", employee6, new InvestorRole());
        Investor investor2 = (Investor) employee6;
        investor2.setNoOfBitcoins(100);
        
        
        Organization organization2 = enterpise1.getOrganizationDirectory().createOrganization(Organization.Type.Custodian);
        //Creating employees for Organization2
        Employee employee4 = organization2.getEmployeeDirectory().addEmployee("Rahul", "modi.rah@husky.neu.edu", 123456789, Organization.Type.Custodian);
        UserAccount ua2 = organization2.getUserAccountDirectory().createUserAccount("custodian1", "custodian1", employee4, new CustodianRole());
        
        Employee employee7 = organization2.getEmployeeDirectory().addEmployee("Parnal", "dighe.par@husky.neu.edu", 123456789, Organization.Type.Custodian);
        UserAccount ua5 = organization2.getUserAccountDirectory().createUserAccount("custodian2", "custodian2", employee7, new CustodianRole());
        
        
        Organization organization3 = enterpise1.getOrganizationDirectory().createOrganization(Organization.Type.Miner);
        //Creating employees for Organzation 3
        Employee employee5 = organization3.getEmployeeDirectory().addEmployee("Tapan", "mehta.tap@husky.neu.edu", 123456789, Organization.Type.Miner);
        UserAccount ua3 = organization3.getUserAccountDirectory().createUserAccount("miner1", "miner1", employee5, new MinerRole());
        
        Employee employee8 = organization3.getEmployeeDirectory().addEmployee("Jinal", "waghela.ji@husky.neu.edu", 123456789, Organization.Type.Miner);
        UserAccount ua6 = organization3.getUserAccountDirectory().createUserAccount("miner2", "miner2", employee8, new MinerRole());
        
        
        Enterprise enterpise2 = network.getEnterpriseDirectory().createAndAddEnterprise("Mall", Enterprise.EnterpriseType.BitcoinMall);          
        //Creating Enterprise2 Admin
        Employee employee2 = enterpise2.getEmployeeDirectory().addEmployee("Preetam", "acharya.rupesh0@gmail.com", 98567432, Organization.Type.EnterpriseAdmin);
        
        //Creating  UserAccount for Employee1
        UserAccount useraccount1 = enterpise2.getUserAccountDirectory().createUserAccount("preetam", "preetam", employee2, new EnterpriseAdmin());
        
        //Creating Investor Organization for Enterpise 1
        Organization organization4 = enterpise2.getOrganizationDirectory().createOrganization(Organization.Type.Retailer);
        //Creating employees for Organization 1
        Employee employee9 = organization4.getEmployeeDirectory().addEmployee("Pratik", "pratik.shjs@husky.neu.edu", 273124091, Organization.Type.Retailer);
        UserAccount ua7 = organization4.getUserAccountDirectory().createUserAccount("retailer1", "retailer1", employee9, new RetailerRole());
        Employee employee10 = organization4.getEmployeeDirectory().addEmployee("Qazxsw", "qwaszx@qa.com", 123456789, Organization.Type.Retailer); 
        UserAccount ua8 = organization4.getUserAccountDirectory().createUserAccount("retailer2", "retailer2", employee10, new RetailerRole());
        
        
        Organization organization5 = enterpise2.getOrganizationDirectory().createOrganization(Organization.Type.Customer);
        //Creating employees for Organization 1
        Employee employee11 = organization5.getEmployeeDirectory().addEmployee("Heena", "heena@husky.neu.edu", 273124091, Organization.Type.Customer);
        UserAccount ua9 = organization5.getUserAccountDirectory().createUserAccount("customer1", "customer1", employee11, new CustomerRole());
        Customer customer1 = (Customer) employee11;
        customer1.setNoOfBitcoins(100);
        Employee employee12 = organization5.getEmployeeDirectory().addEmployee("Shweta", "shweta@qa.com", 123456789, Organization.Type.Customer); 
        UserAccount ua10 = organization5.getUserAccountDirectory().createUserAccount("customer2", "customer2", employee12, new CustomerRole());
        Customer customer2 = (Customer) employee12;
        customer2.setNoOfBitcoins(100);
        
        
        Organization organization8 = enterpise2.getOrganizationDirectory().createOrganization(Organization.Type.MallAdmin);
        Employee employee18 = organization8.getEmployeeDirectory().addEmployee("Abhishek", "abhishek@husky.neu.edu", 273124091, Organization.Type.MallAdmin);
        UserAccount ua16 = organization8.getUserAccountDirectory().createUserAccount("malladmin", "malladmin", employee18, new AdminMallRole());
        
        Enterprise enterpise3 = network.getEnterpriseDirectory().createAndAddEnterprise("Mavericks Clinic", Enterprise.EnterpriseType.Clinic);        
        
        //Creating Enterprise1 Admin
        Employee employee13 = enterpise3.getEmployeeDirectory().addEmployee("Akhil", "aklsngh@gmail.com", 98567432, Organization.Type.EnterpriseAdmin);
        //Creating  UserAccount for Employee1
        UserAccount ua11 = enterpise3.getUserAccountDirectory().createUserAccount("akhil", "akhil", employee13, new EnterpriseAdmin());
        
        
        Organization organization6 = enterpise3.getOrganizationDirectory().createOrganization(Organization.Type.Doctor);
        //Creating employees for Organization 1
        Employee employee14 = organization6.getEmployeeDirectory().addEmployee("Shashank", "pratik.shjs@husky.neu.edu", 273124091, Organization.Type.Doctor);
        UserAccount ua12 = organization6.getUserAccountDirectory().createUserAccount("doctor1", "doctor1", employee14, new DoctorRole());
        Doctor doctor1 = (Doctor) employee14;
        doctor1.setNoOfBitcoins(100);
        Employee employee15 = organization6.getEmployeeDirectory().addEmployee("Micheal", "qwaszx@qa.com", 123456789, Organization.Type.Doctor); 
        UserAccount ua13 = organization6.getUserAccountDirectory().createUserAccount("doctor2", "doctor2", employee15, new DoctorRole());
        Doctor doctor2 = (Doctor) employee15;
        doctor2.setNoOfBitcoins(100);
        
        Organization organization7 = enterpise3.getOrganizationDirectory().createOrganization(Organization.Type.LabAssistant);
        //Creating employees for Organization 1
        Employee employee16 = organization7.getEmployeeDirectory().addEmployee("Aditya", "acharya.rupesh0@gmail.com", 273124091, Organization.Type.LabAssistant);
        UserAccount ua14 = organization7.getUserAccountDirectory().createUserAccount("lab1", "lab1", employee16, new LabRole());
        Employee employee17 = organization7.getEmployeeDirectory().addEmployee("Sanjay", "jain.pree@husky.neu.edu", 123456789, Organization.Type.LabAssistant); 
        UserAccount ua15 = organization7.getUserAccountDirectory().createUserAccount("lab2", "lab2", employee17, new LabRole());
        
        return system;
    }
    
}
