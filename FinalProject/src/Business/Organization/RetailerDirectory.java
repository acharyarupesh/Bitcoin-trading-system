/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.RetailerRole;
import java.util.ArrayList;

/**
 *
 * @author Niyati Maheshwari
 */
public class RetailerDirectory {
    
    private ArrayList<RetailerRole> retailerList;

    public RetailerDirectory() {
        retailerList = new ArrayList<RetailerRole>();
    }

    public ArrayList<RetailerRole> getRetailerList() {
        return retailerList;
    }

    public RetailerRole addRetailor() {
        RetailerRole r = new RetailerRole();
        retailerList.add(r);
        return r;
    }

    public void removeRetailor(RetailerRole r) {
        retailerList.remove(r);
    }
}
