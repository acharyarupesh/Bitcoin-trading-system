/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.InvestorRole;
import Business.Roles.MinerRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Niyati Maheshwari
 */
public class MinerOrganization extends Organization{
    
    public MinerOrganization() {
        super(Organization.Type.Miner.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new MinerRole());
        return roles;
    }
    
}
