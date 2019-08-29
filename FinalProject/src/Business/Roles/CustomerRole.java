/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Actor.Customer;
import Business.Organization.Actor.MallAdmin;
import Business.Organization.CustomerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.MallEnterprise.CustomerROle.CustomerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Niyati Maheshwari
 */
public class CustomerRole  extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new CustomerWorkAreaJPanel(userProcessContainer, (Customer)account.getEmployee(), (CustomerOrganization) organization, enterprise, business, account);
    }
}