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
public class BitcoinMallEnterprise extends Enterprise{

    public BitcoinMallEnterprise(String name) {
        super(name, EnterpriseType.BitcoinMall);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
