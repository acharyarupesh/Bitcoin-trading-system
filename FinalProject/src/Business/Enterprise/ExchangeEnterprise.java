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
public class ExchangeEnterprise extends Enterprise {
    public ExchangeEnterprise(String name){
        super(name, EnterpriseType.Exchange);
        
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
