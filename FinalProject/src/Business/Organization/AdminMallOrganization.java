/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.AdminMallRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Niyati Maheshwari
 */
public class AdminMallOrganization extends Organization{
    public AdminMallOrganization() {
        super(Organization.Type.MallAdmin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AdminMallRole());
        return roles;
    }
}
