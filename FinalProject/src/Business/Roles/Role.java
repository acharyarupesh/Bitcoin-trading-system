/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Actor.Custodian;
import Business.Organization.Actor.Customer;
import Business.Organization.Actor.Doctor;
import Business.Organization.Actor.Investor;
import Business.Organization.Actor.LabAssistant;
import Business.Organization.Actor.MallAdmin;
import Business.Organization.Actor.Miner;
import Business.Organization.Actor.Retailer;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author achar
 */
public abstract class Role {

    public enum RoleType {
        Investor("Investor"),
        Custodian("Custodian"),
        Miner("Miner"),
        AdminMall("MallAdmin"),
        Customer("Customer"),
        Retailer("Retailer"),
        Doctor("Doctor"),
        LabAssistant("LabAssistant");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

        public abstract JPanel createWorkArea(JPanel userProcessContainer,
                UserAccount account,
                Organization organization,
                Enterprise enterprise,
                EcoSystem business
                );
        
        @Override
        public String toString(){
            return this.getClass().getName();
        }
    }
