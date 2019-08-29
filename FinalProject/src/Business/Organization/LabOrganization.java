/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.LabRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author achar
 */
public class LabOrganization extends Organization {

    public LabOrganization() {
        super(Organization.Type.LabAssistant.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LabRole());
        return roles;
    }
}
