/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.Roles.Role;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author achar
 */
public abstract class Organization {
    private String name;
    private WorkQueue workqueue; 
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int count = 1000;
    
    public Organization(String name){
        
        this.name = name;
        workqueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = count;
        ++count;
    }
    
    public enum Type{
        Investor("Investor Organization"),
        Custodian("Custodian Organization"),
        Miner("Miner Organization"),
        MallAdmin("MallAdmin Organization"),
        Retailer("Retailer Organization"),
        Customer("Customer Organization"),
        Doctor("Doctor Organization"),
        LabAssistant("Lab Organization"),
        SystemAdmin("SystemAdmin"),
        EnterpriseAdmin("EnterpriseAdmin");
        
        private String value;
        private Type(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    public abstract ArrayList<Role> getSupportedRole();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkqueue() {
        return workqueue;
    }

    public void setWorkqueue(WorkQueue workqueue) {
        this.workqueue = workqueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}

