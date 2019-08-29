/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Actor.Investor;
import Business.Roles.InvestorRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Niyati Maheshwari
 */
public class InvestorOrganization extends Organization {
    
    private ArrayList<Investor> investorList;
    
    public InvestorOrganization() {
        super(Organization.Type.Investor.getValue());
    }

    public ArrayList<Investor> getInvestorList() {
        return investorList;
    }

    public void setInvestorList(ArrayList<Investor> investorList) {
        this.investorList = investorList;
    }
    
    public Investor createAndAddInvestor(){
        Investor investor = new Investor();
        investorList.add(investor);
        return investor;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new InvestorRole());
        return roles;
    }
}
