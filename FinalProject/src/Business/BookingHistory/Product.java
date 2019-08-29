/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BookingHistory;

import Business.Organization.Actor.Retailer;
import Business.Roles.RetailerRole;

/**
 *
 * @author Niyati Maheshwari
 */
public class Product {
    
    
    private static int cnt=0;
    private String productName;
    private int id;
    private int price;
    private int quantity;
    private String productCategory;
    private Retailer retail;
    private int sold = 0;

    public Product(){
        cnt++;
        id=cnt;
    }

    public Retailer getRetail() {
        return retail;
    }

    public void setRetail(Retailer retail) {
        this.retail = retail;
    }
    
    
    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int x) {
        sold = sold + x;
    }
    

    public int getID() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void changeQuantity(int x){
        quantity = quantity + x;
    }
   
    @Override
    public String toString(){
        return productName;
    }
}
