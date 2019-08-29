/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.BookingHistory.Invoice;
import java.util.ArrayList;

/**
 *
 * @author Niyati Maheshwari
 */
public class InvoiceDirectory {
    private ArrayList <Invoice> invoiceDirectory;
    
    public InvoiceDirectory(){
        invoiceDirectory=new ArrayList<Invoice>();
    }

    public ArrayList<Invoice> getInvoiceDirectory() {
        return invoiceDirectory;
    }
}
