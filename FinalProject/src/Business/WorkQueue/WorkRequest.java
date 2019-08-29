/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author achar
 */
public class WorkRequest {
    
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestedDate;
    private Date resovledDate;
    private double bitcoinsRequested;
    private boolean payment = false;
    
    public WorkRequest(){
        requestedDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyyy");
        sdf.format(requestedDate);
//        System.out.println(requestedDate);
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getResovledDate() {
        return resovledDate;
    }

    public void setResovledDate(Date resovledDate) {
        this.resovledDate = resovledDate;
    }

    public double getBitcoinsRequested() {
        return bitcoinsRequested;
    }

    public void setBitcoinsRequested(double bitcoinsRequested) {
        this.bitcoinsRequested = bitcoinsRequested;
    }
    
    @Override
    public String toString(){
        return status;
    }
   
}
