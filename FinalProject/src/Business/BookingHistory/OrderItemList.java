/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BookingHistory;

import java.util.ArrayList;

/**
 *
 * @author Niyati Maheshwari
 */
public class OrderItemList {
    
    private ArrayList<OrderItem> orderItemList;
    
    private ArrayList<OrderItem> placeOrderList;

    public ArrayList<OrderItem> getPlaceOrderList() {
        return placeOrderList;
    }

    public void setPlaceOrderList(ArrayList<OrderItem> placeOrderList) {
        this.placeOrderList = placeOrderList;
    }

    public OrderItemList() {
        orderItemList = new ArrayList<OrderItem>();
        placeOrderList = new ArrayList<OrderItem>();
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public OrderItem addItemToList() {
        OrderItem oi = new OrderItem();
        orderItemList.add(oi);
        return oi;
    }
    
    public void removeOrderItem(OrderItem oi){
        orderItemList.remove(oi);
    }
}
