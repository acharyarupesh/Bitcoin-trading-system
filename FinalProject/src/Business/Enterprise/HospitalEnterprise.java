/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Niyati Maheshwari
 */
public class HospitalEnterprise extends Enterprise{

    public HospitalEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Clinic);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
