/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Organization.Actor.Custodian;
import Business.Organization.Actor.Customer;
import Business.Organization.Actor.Doctor;
import Business.Organization.Actor.Investor;
import Business.Organization.Actor.LabAssistant;
import Business.Organization.Actor.MallAdmin;
import Business.Organization.Actor.Miner;
import Business.Organization.Actor.Retailer;
import Business.Organization.Actor.SystemAdmin;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author achar
 */
public class EmployeeDirectory {

    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee addEmployee(String name, String emailID, long mobileNumber, Type type) {
        if (type == Organization.Type.Investor) {
            Investor investor = new Investor();
            investor.setName(name);
            investor.setEmailID(emailID);
            investor.setMobileNumber(mobileNumber);
            investor.setNoOfBitcoins(0);
            investor.setType(type);
            employeeList.add(investor);
            return investor;
        } else if (type == Organization.Type.Miner) {
            Miner miner = new Miner();
            miner.setName(name);
            miner.setEmailID(emailID);
            miner.setMobileNumber(mobileNumber);
            miner.setNoOfBitcoins(0);
            miner.setType(type);
            employeeList.add(miner);
            return miner;
        } else if (type == Organization.Type.Custodian) {
            Custodian custodian = new Custodian();
            custodian.setName(name);
            custodian.setEmailID(emailID);
            custodian.setMobileNumber(mobileNumber);
            custodian.setType(type);
            employeeList.add(custodian);
            return custodian;
        } else if (type == Organization.Type.MallAdmin) {
            MallAdmin mallAdmin = new MallAdmin();
            mallAdmin.setName(name);
            mallAdmin.setEmailID(emailID);
            mallAdmin.setMobileNumber(mobileNumber);
            mallAdmin.setNoOfBitcoins(0);
            mallAdmin.setType(type);
            employeeList.add(mallAdmin);
            return mallAdmin;
        } else if (type == Organization.Type.Retailer) {
            Retailer retailer = new Retailer();
            retailer.setName(name);
            retailer.setEmailID(emailID);
            retailer.setMobileNumber(mobileNumber);
            retailer.setNoOfBitcoins(0);
            retailer.setType(type);
            employeeList.add(retailer);
            return retailer;
        } else if (type == Organization.Type.Customer) {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmailID(emailID);
            customer.setMobileNumber(mobileNumber);
            customer.setNoOfBitcoins(0);
            customer.setType(type);
            employeeList.add(customer);
            return customer;
        } else if (type == Organization.Type.Doctor) {
            Doctor doctor = new Doctor();
            doctor.setName(name);
            doctor.setEmailID(emailID);
            doctor.setMobileNumber(mobileNumber);
            doctor.setNoOfBitcoins(0);
            doctor.setType(type);
            employeeList.add(doctor);
            return doctor;
        } else if (type == Organization.Type.LabAssistant) {
            LabAssistant labAssistant = new LabAssistant();
            labAssistant.setName(name);
            labAssistant.setEmailID(emailID);
            labAssistant.setMobileNumber(mobileNumber);
            labAssistant.setNoOfBitcoins(0);
            labAssistant.setType(type);
            employeeList.add(labAssistant);
            return labAssistant;
        } else if (type == Organization.Type.SystemAdmin) {
            SystemAdmin systemAdmin = new SystemAdmin();
            systemAdmin.setName(name);
            systemAdmin.setEmailID(emailID);
            systemAdmin.setMobileNumber(mobileNumber);
//            systemAdmin.setNoOfBitcoins(0);
            systemAdmin.setType(type);
            employeeList.add(systemAdmin);
            return systemAdmin;
        }
        return null;
    }
    
}
