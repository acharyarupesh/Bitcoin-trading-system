/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.CustodianRole;
import Business.Roles.InvestorRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Niyati Maheshwari
 */
public class CustodianOrganization extends Organization{
    
    
    public CustodianOrganization() {
        super(Organization.Type.Custodian.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CustodianRole());
        return roles;
    }
}
