/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Actor;

import Business.BookingHistory.ProductCatalog;
import Business.Employee.Employee;

/**
 *
 * @author achar
 */
public class Retailer extends Employee{
    private double noOfBitcoins;
    private ProductCatalog productCatalog;
    private double revenueOfTheDay = 0;
    private double invoiceRequest=0;
    private String invoiceMessage;
    private String city;
    
    public Retailer(){
        super();
        productCatalog = new ProductCatalog();
    }

    public double getNoOfBitcoins() {
        return noOfBitcoins;
    }

    public void setNoOfBitcoins(double x) {
        this.noOfBitcoins = noOfBitcoins + x;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public double getRevenueOfTheDay() {
        return revenueOfTheDay;
    }

    public void setRevenueOfTheDay(double revenueOfTheDay) {
        this.revenueOfTheDay = revenueOfTheDay;
    }

    public double getInvoiceRequest() {
        return invoiceRequest;
    }

    public void setInvoiceRequest(double invoiceRequest) {
        this.invoiceRequest = invoiceRequest;
    }

    public String getInvoiceMessage() {
        return invoiceMessage;
    }

    public void setInvoiceMessage(String invoiceMessage) {
        this.invoiceMessage = invoiceMessage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    

}
