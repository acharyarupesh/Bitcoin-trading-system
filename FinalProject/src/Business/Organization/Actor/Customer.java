/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Actor;

import Business.BookingHistory.OrderItemList;
import Business.Employee.Employee;
import Business.Organization.CustomerDirectory;

/**
 *
 * @author achar
 */
public class Customer extends Employee{
    private double noOfBitcoins;
    private CustomerDirectory customerDirectory;
    private OrderItemList orderItem;
    private OrderItemList placeOrder;
    private int totalMoneySpent = 0;
    private String tracking;
    private String custName;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private int phoneNumber;
    private int login = 0;
    
    
    public Customer(){
        super();
        orderItem = new OrderItemList();
        placeOrder = new OrderItemList();
    }

    public double getNoOfBitcoins() {
        return noOfBitcoins;
    }

    public void setNoOfBitcoins(double x) {
        this.noOfBitcoins = noOfBitcoins + x;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public OrderItemList getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItemList orderItem) {
        this.orderItem = orderItem;
    }

    public OrderItemList getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(OrderItemList placeOrder) {
        this.placeOrder = placeOrder;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public void setTotalMoneySpent(int totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int x) {
        login = login + x;
    }
    
    
    
    @Override
    public String toString() {
        return custName;
    }

}
