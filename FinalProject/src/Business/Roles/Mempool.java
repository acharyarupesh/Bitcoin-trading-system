/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.MinerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.ExchangeEnterprise.MinerRole.MempoolJPanel;
import UserInterface.ExchangeEnterprise.MinerRole.MinerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author preet
 */
public class Mempool extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new MempoolJPanel(userProcessContainer, account, (MinerOrganization)organization, enterprise, business);
    }
}
