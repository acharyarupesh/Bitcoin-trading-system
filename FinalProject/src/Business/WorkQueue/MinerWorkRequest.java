/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author preet
 */
public class MinerWorkRequest extends WorkRequest{
    private int bitcoinRewards = 0;

    public int getBitcoinRewards() {
        return bitcoinRewards;
    }

    public void setBitcoinRewards(int bitcoinRewards) {
        this.bitcoinRewards = bitcoinRewards;
    }
    
}
