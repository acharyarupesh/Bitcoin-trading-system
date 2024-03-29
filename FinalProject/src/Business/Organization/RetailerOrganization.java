/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.RetailerRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author achar
 */
public class RetailerOrganization extends Organization {

    public RetailerOrganization() {
        super(Organization.Type.Retailer.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RetailerRole());
        return roles;
    }
    
}
