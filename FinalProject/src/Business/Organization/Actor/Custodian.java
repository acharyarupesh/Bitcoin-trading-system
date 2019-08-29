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
public class Custodian extends Employee{
    private double myRevenue;
    
    public Custodian(){
        super();
    }

    public double getMyRevenue() {
        return myRevenue;
    }

    public void setMyRevenue(double myRevenue) {
        this.myRevenue = myRevenue;
    }
  
}
