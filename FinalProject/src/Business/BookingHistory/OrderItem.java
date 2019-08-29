/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BookingHistory;

import Business.Organization.Actor.Retailer;



/**
 *
 * @author Niyati Maheshwari
 */
public class OrderItem {
    
    private int quantity;
    private Product product;
    private Retailer retailer;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }
    
    @Override
    public String toString() {
        return product.getProductName();
    }
}
