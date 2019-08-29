/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Organization.Actor.Retailer;
import java.util.Date;

/**
 *
 * @author Niyati Maheshwari
 */
public class RetailerWorkRequest extends WorkRequest{
    private double invoiceAmount;
    private int invoiceNo;
    private static int count = 0;

    public RetailerWorkRequest() {
        count++;
        invoiceNo = count;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.invoiceNo);
    }

    
}
