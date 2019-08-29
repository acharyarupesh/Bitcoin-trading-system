/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Actor;

import Business.Employee.Employee;

/**
 *
 * @author achar
 */
public class MallAdmin extends Employee {
    private double noOfBitcoins;
    private double myRevenue = 0;
    private double InvoiceAmount = 0;
//    private WorkQueue workQueue;
    
    public MallAdmin(){
        super();
    }

    public double getNoOfBitcoins() {
        return noOfBitcoins;
    }

    public void setNoOfBitcoins(double x) {
        this.noOfBitcoins = noOfBitcoins + x;
    }

    public double getMyRevenue() {
        return myRevenue;
    }

    public void setMyRevenue(double myRevenue) {
        this.myRevenue = myRevenue;
    }

    public double getInvoiceAmount() {
        return InvoiceAmount;
    }

    public void setInvoiceAmount(double InvoiceAmount) {
        this.InvoiceAmount = InvoiceAmount;
    }

//    public WorkQueue getWorkQueue() {
//        return workQueue;
//    }
//
//    public void setWorkQueue(WorkQueue workQueue) {
//        this.workQueue = workQueue;
//    }
}
