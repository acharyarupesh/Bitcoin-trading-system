/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Actor.MallAdmin;
import Business.Organization.Actor.Retailer;
import Business.Organization.Organization;
import Business.Organization.RetailerOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.MallEnterprise.RetailerRole.RetailerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Niyati Maheshwari
 */
public class RetailerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new RetailerWorkAreaJPanel(userProcessContainer, (Retailer)account.getEmployee(), (RetailerOrganization) organization, enterprise, business, account);
    }

}
