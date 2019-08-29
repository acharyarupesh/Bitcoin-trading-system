/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CustodianOrganization;
import Business.Organization.InvestorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.ExchangeEnterprise.CustodianRole.CustodianWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Niyati Maheshwari
 */
public class CustodianRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new CustodianWorkAreaJPanel(userProcessContainer, account, (CustodianOrganization)organization, enterprise);
    }
    
}
