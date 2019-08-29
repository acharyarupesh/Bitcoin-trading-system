/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author achar
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<Organization>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.Investor.getValue())) {
            organization = new InvestorOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Custodian.getValue())) {
            organization = new CustodianOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Miner.getValue())) {
            organization = new MinerOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.MallAdmin.getValue())) {
            organization = new AdminMallOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Retailer.getValue())) {
            organization = new RetailerOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Customer.getValue())) {
            organization = new CustomerOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Doctor.getValue())) {
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.LabAssistant.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    
    
    
}
