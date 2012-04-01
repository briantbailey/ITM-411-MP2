/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Brian T. Bailey
 */
public class PersistentObject implements Serializable {
    
    // Fields...
    protected Map<String, List<BankRecord>> bankRecords;
    protected Date timestamp;

    // Constructors...
    public PersistentObject() {
    }

    public PersistentObject(Map<String, List<BankRecord>> bankRecords, Date timestamp) {
        this.bankRecords = bankRecords;
        this.timestamp = timestamp;
    }
    
    // Getters and Setters...
    public Map<String, List<BankRecord>> getBankRecords() {
        return bankRecords;
    }

    public void setBankRecords(Map<String, List<BankRecord>> bankRecords) {
        this.bankRecords = bankRecords;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    // toString
    @Override
    public String toString() {
        return "PersistentObject{" + "bankRecords=" + bankRecords + ", timestamp=" + timestamp + '}';
    }
    
}
