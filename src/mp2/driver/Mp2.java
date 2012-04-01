/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.driver;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mp2.domain.BankRecord;
import mp2.domain.PersistentObject;
import mp2.utils.BankRecordUtils;
import mp2.utils.OutputUtils;

/**
 *
 * @author Brian T. Bailey
 */
public class Mp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Output Headers to Console and File
        OutputUtils.printOutputHeader();
        OutputUtils.printString("Application Run-time Status");
        OutputUtils.printString("---------------------------");
        
        // Read and parse data file using readRecordData() util method
        OutputUtils.printString("Reading Records From Data File...");
        List<BankRecord> records = BankRecordUtils.readRecordData();
        
        // Create a Map Object of Region-Record Lists from the data records
        // Map Keys are town, rural, suburban, inner_city
        OutputUtils.printString("Creating Map Object of Region-Location Lists...");
        Map<String, List<BankRecord>> bankRecords = BankRecordUtils.createRecordsMapByRegion(records);
        
        // Encapsulate bankRecords Map and Date into a PersistentObject
        OutputUtils.printString("Encapsulating Map and Date into Persistent Object...");
        PersistentObject po = new PersistentObject(bankRecords, new Date());
        
        // Serialize PersistentObject to File
        OutputUtils.printString("Serializing Persistent Object...");
        BankRecordUtils.serializePersistentObject(po);
        
        // Sleep application for 5 secs
        OutputUtils.printString("Application Sleeping for 5 Secs...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Mp2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Deserialize PersistentObject from File
        OutputUtils.printString("Deserializing Persistent Object...");
        PersistentObject dpo = BankRecordUtils.deserializePersistentObject();
        
        // Extract Map Object and Date Object from deserialized PersistentObject
        OutputUtils.printString("Extracting Bank Records and Date from Persistent Object...");
        Date timeSerialized = dpo.getTimestamp();
        Map<String, List<BankRecord>> newBankRecords = dpo.getBankRecords();
        
        // Get current time
        Date timeDeserialized = new Date();
        
        // Output to Console and File Data Analytics Starting...
        OutputUtils.printString("Start Data Analytics...");
        OutputUtils.printString("");
        
        // Calculate and Display Data Analytics...
        OutputUtils.printTimeDifference(timeSerialized, timeDeserialized);
        OutputUtils.printAvgIncomeByLocation(newBankRecords);
        OutputUtils.printMinMaxAgeByLocation(newBankRecords);
        OutputUtils.printNumFemalesMortgageAndSavings(newBankRecords);
        OutputUtils.printNumMalesCarAndChildren(newBankRecords);
        
        // Display Application Finished
        OutputUtils.printString("The Application Has Finished Running");
    }


}
