/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.utils;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import mp2.domain.AgeComparator;
import mp2.domain.BankRecord;
import mp2.domain.PersistentObject;

/**
 *
 * @author Brian T. Bailey
 */
public class BankRecordUtils {
    
    public static List readRecordData() {
        BufferedReader br;
        String line;
        int linectr = 0;
        List<BankRecord> recordList = new ArrayList<BankRecord>();
        try {
            br = new BufferedReader(new FileReader("data/bank-data.csv"));
            // Throw away first line... header data
            String header = br.readLine();
            while ((line = br.readLine()) != null) {
                Scanner sc = new Scanner(line);
                sc.useDelimiter(",");
                BankRecord record = new BankRecord(
                        sc.next(),
                        Integer.parseInt(sc.next()),
                        sc.next(),
                        sc.next(),
                        Double.parseDouble(sc.next()),
                        (sc.next().equals("YES")) ? true : false,
                        Integer.parseInt(sc.next()),
                        (sc.next().equals("YES")) ? true : false,
                        (sc.next().equals("YES")) ? true : false,
                        (sc.next().equals("YES")) ? true : false,
                        (sc.next().equals("YES")) ? true : false,
                        (sc.next().equals("YES")) ? true : false);
                recordList.add(record);
                linectr++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BankRecordUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BankRecordUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        //System.out.println(linectr);
        return recordList;
    }
    
    public static Map<String, List<BankRecord>> createRecordsMapByRegion(List<BankRecord> records) {
        // Declare and create new HashMap Object
        Map<String, List<BankRecord>> recordMap = new HashMap<String, List<BankRecord>>();
        
        // Declare and create new ArrayLists to hold region records by location
        List<BankRecord> townList = new ArrayList<BankRecord>();
        List<BankRecord> ruralList = new ArrayList<BankRecord>();
        List<BankRecord> suburbanList = new ArrayList<BankRecord>();
        List<BankRecord> innerCityList = new ArrayList<BankRecord>();
        
        // Loop through all the records and place in appropriate region list
        for (BankRecord br : records) {
            if (br.getRegion().equalsIgnoreCase("TOWN")) {
                townList.add(br);
            } else if (br.getRegion().equalsIgnoreCase("RURAL")) {
                ruralList.add(br);
            } else if (br.getRegion().equalsIgnoreCase("SUBURBAN")) {
                suburbanList.add(br);
            } else if (br.getRegion().equalsIgnoreCase("INNER_CITY")) {
                innerCityList.add(br);
            }
        }
        
        // Add region record Lists to Map Object
        recordMap.put("town", townList);
        recordMap.put("rural", ruralList);
        recordMap.put("suburban", suburbanList);
        recordMap.put("inner_city", innerCityList);
        
        // Return Map Object
        return recordMap;
    }
    
    public static void serializePersistentObject(PersistentObject po) {
        // Serialize PersistentObject
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("data/bankrecords.ser"));
            oos.writeObject(po);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BankRecordUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BankRecordUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(BankRecordUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static PersistentObject deserializePersistentObject() {
        // Deserialize PersistentObject
        PersistentObject po = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("data/bankrecords.ser"));
            po = (PersistentObject)ois.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BankRecordUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BankRecordUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BankRecordUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(BankRecordUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // Return PersistentObject
        return po;
    }
    
    public static int calculateMaxAge(List<BankRecord> brList) {
        // Sort BankRecord List in ascending order
        AgeComparator ageComp = new AgeComparator();
        Collections.sort(brList, ageComp);
        
        // Get Max Age (last item in list)
        int age = 0;
        if (!brList.isEmpty()) {
            age = brList.get(brList.size() - 1).getAge();
        }
        
        // Return Max Age
        return age;
    }
    
    public static int calculateMinAge(List<BankRecord> brList) {
        // Sort BankRecord List in ascending order
        AgeComparator ageComp = new AgeComparator();
        Collections.sort(brList, ageComp);
        
        // Get Max Age (first item in list)
        int age = 0;
        if (!brList.isEmpty()) {
            age = brList.get(0).getAge();
        }
        
        // Return Max Age
        return age;
    }
    
}
