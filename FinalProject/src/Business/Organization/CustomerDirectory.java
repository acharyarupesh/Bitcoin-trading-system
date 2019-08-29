/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Roles.CustomerRole;
import java.util.ArrayList;

/**
 *
 * @author Niyati Maheshwari
 */
public class CustomerDirectory {
    
    private ArrayList<CustomerRole> customerDirectory;
    
    public CustomerDirectory(){
        customerDirectory=new ArrayList<CustomerRole>();
    }

    public ArrayList<CustomerRole> getCustomerDirectory() {
        return customerDirectory;
    }
    
    public CustomerRole addCustomer(){
        CustomerRole c=new CustomerRole();
        customerDirectory.add(c);
        return c;
    }
    
    public void removeCustomer(CustomerRole c){
        customerDirectory.remove(c);
    }
}
