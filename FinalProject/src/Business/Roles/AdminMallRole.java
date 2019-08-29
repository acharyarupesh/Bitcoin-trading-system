/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AdminMallOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.MallEnterprise.AuthorityRole.MallAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Niyati Maheshwari
 */
public class AdminMallRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new MallAdminWorkAreaJPanel(userProcessContainer, account, (AdminMallOrganization)organization, enterprise, organization, business);
    }
}
