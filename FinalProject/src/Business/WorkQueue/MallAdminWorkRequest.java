/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author achar
 */
public class MallAdminWorkRequest extends WorkRequest{
    private int invoiceNumber;
    private int count=1100;
    public MallAdminWorkRequest(){
        count++;
        invoiceNumber = count;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }
    
    
}
