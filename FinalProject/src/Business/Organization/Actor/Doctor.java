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
public class Doctor extends Employee{
    private double noOfBitcoins;
    
    public Doctor(){
        super();
    }

    public double getNoOfBitcoins() {
        return noOfBitcoins;
    }

    public void setNoOfBitcoins(double x) {
        this.noOfBitcoins = noOfBitcoins + x;
    }

}
