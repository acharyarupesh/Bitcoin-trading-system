/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Roles.Role;
import Business.Roles.SystemAdminRole;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author Niyati Maheshwari
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private ArrayList<ArrayList<WorkRequest>> ledger;
    
    public static EcoSystem getInstance(){
        if(business==null){
            business = new EcoSystem();
        }
        return business;
    }
    
    private EcoSystem(){
        super(null);
        networkList = new ArrayList<Network>();
        ledger = new ArrayList<ArrayList<WorkRequest>>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public Network createAndAddNetwork(){
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    public ArrayList<ArrayList<WorkRequest>> getLedger() {
        return ledger;
    }
//    public boolean checkIfUserIsUnique(String userName){
//        if(this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
//            return false;
//        }
//        
//        for(Network network : networkList){
//            
//        }
//        return true;
//    }
    
    @Override
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
}
