/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BookingHistory;

/**
 *
 * @author Niyati Maheshwari
 */
public class Invoice {
    
    private static int count;
    private int invoiceId;
    private float price;
    private float tax;
    private float total;
    
    public Invoice(){
        count++;
        invoiceId=count;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
