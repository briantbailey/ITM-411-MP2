/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mp2.domain.BankRecord;
import mp2.domain.FemaleComparator;
import mp2.domain.IncomeComparator;
import mp2.domain.MaleComparator;

/**
 *
 * @author Brian T. Bailey
 */
public class OutputUtils {

    public static void printOutputHeader() {
        // Display Header to Console
        System.out.println("Project: MP2");
        System.out.println("Course: ITM-411");
        System.out.println("Author: Brian T. Bailey");
        System.out.println("----------------------------------------------------------------------");
        System.out.format("%n");
        
        // Print Header to File
        PrintWriter pw = null;
        try {
            // Create new output file here... all other calls should append
            pw = new PrintWriter(new BufferedWriter(new FileWriter("data/bankrecords.txt")));
            pw.println("Project: MP2");
            pw.println("Course: ITM-411");
            pw.println("Author: Brian T. Bailey");
            pw.println("----------------------------------------------------------------------");
            pw.format("%n");
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(OutputUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
    
    public static void printString(String aString) {
        // Output the String to the Console
        System.out.println(aString);
        
        // Output the String to the File... Append to the existing file
        PrintWriter pw = null;
        try {
            // Create PriwnWriter-FileWriter Stream and append to existing file
            pw = new PrintWriter(new BufferedWriter(new FileWriter("data/bankrecords.txt", true)));
            pw.println(aString);
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(OutputUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
    
    public static void printTimeDifference(Date timeSerialized, Date timeDeserialized) {
        // Output to Console...
        System.out.println("");
        System.out.println("Object Serialization and Deserialization Times");
        System.out.println("----------------------------------------------------------------------");
        System.out.format("The object was serialized: %s%n", timeSerialized);
        System.out.format("The object was deserialized: %s%n", timeDeserialized);
        System.out.println("----------------------------------------------------------------------");
        System.out.format("The time difference between %nserialization and deserialization: %s (%s milliseconds)%n", (timeDeserialized.getTime() - timeSerialized.getTime())/1000.0 + " secs", (timeDeserialized.getTime() - timeSerialized.getTime()) );
        System.out.println("----------------------------------------------------------------------");
        System.out.format("%n%n");
        
        // Output to the File... Append to the existing file
        PrintWriter pw = null;
        try {
            // Create PriwnWriter-FileWriter Stream and append to existing file
            pw = new PrintWriter(new BufferedWriter(new FileWriter("data/bankrecords.txt", true)));
            pw.println("");
            pw.println("Object Serialization and Deserialization Times");
            pw.println("----------------------------------------------------------------------");
            pw.format("The object was serialized: %s%n", timeSerialized);
            pw.format("The object was deserialized: %s%n", timeDeserialized);
            pw.println("----------------------------------------------------------------------");
            pw.format("The time difference between %nserialization and deserialization: %s (%s milliseconds)%n", (timeDeserialized.getTime() - timeSerialized.getTime()) / 1000.0 + " secs", (timeDeserialized.getTime() - timeSerialized.getTime()));
            pw.println("----------------------------------------------------------------------");
            pw.format("%n%n");
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(OutputUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public static void printAvgIncomeByLocation(Map<String, List<BankRecord>> newBankRecords) {
        // Get location Lists out of the map
        List<BankRecord> townList = newBankRecords.get("town");
        List<BankRecord> ruralList = newBankRecords.get("rural");
        List<BankRecord> suburbanList = newBankRecords.get("suburban");
        List<BankRecord> innerCityList = newBankRecords.get("inner_city");
        
        // Declare variables to hold avg income for each region
        double townAvg, ruralAvg, suburbanAvg, innerCityAvg;
        
        // Calculate Averages
        townAvg = IncomeComparator.calculateAvgIncome(townList);
        ruralAvg = IncomeComparator.calculateAvgIncome(ruralList);
        suburbanAvg = IncomeComparator.calculateAvgIncome(suburbanList);
        innerCityAvg = IncomeComparator.calculateAvgIncome(innerCityList);
        
        // Display Results to Console...
        System.out.println("----------------------------");
        System.out.println("Average Income Per Location:");
        System.out.println("----------------------------");
        System.out.format("%-12s $ %,.2f%n", "Town: ", townAvg);
        System.out.format("%-12s $ %,.2f%n", "Rural: ", ruralAvg);
        System.out.format("%-12s $ %,.2f%n", "Suburban: ", suburbanAvg);
        System.out.format("%-12s $ %,.2f%n", "Inner City: ", innerCityAvg);
        System.out.println("----------------------------");
        System.out.format("%n%n");
        
        // Output Results to the File... Append to the existing file
        PrintWriter pw = null;
        try {
            // Create PriwnWriter-FileWriter Stream and append to existing file
            pw = new PrintWriter(new BufferedWriter(new FileWriter("data/bankrecords.txt", true)));
            pw.println("----------------------------");
            pw.println("Average Income Per Location:");
            pw.println("----------------------------");
            pw.format("%-12s $ %,.2f%n", "Town: ", townAvg);
            pw.format("%-12s $ %,.2f%n", "Rural: ", ruralAvg);
            pw.format("%-12s $ %,.2f%n", "Suburban: ", suburbanAvg);
            pw.format("%-12s $ %,.2f%n", "Inner City: ", innerCityAvg);
            pw.println("----------------------------");
            pw.format("%n%n");
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(OutputUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        
    }

    public static void printMinMaxAgeByLocation(Map<String, List<BankRecord>> newBankRecords) {
        // Get location Lists out of the map
        List<BankRecord> townList = newBankRecords.get("town");
        List<BankRecord> ruralList = newBankRecords.get("rural");
        List<BankRecord> suburbanList = newBankRecords.get("suburban");
        List<BankRecord> innerCityList = newBankRecords.get("inner_city");
        
        // Caculate Min-Max Age for each region-location
        int townMinAge = BankRecordUtils.calculateMinAge(townList);
        int townMaxAge = BankRecordUtils.calculateMaxAge(townList);
        int ruralMinAge = BankRecordUtils.calculateMinAge(ruralList);
        int ruralMaxAge = BankRecordUtils.calculateMaxAge(ruralList);
        int suburbanMinAge = BankRecordUtils.calculateMinAge(suburbanList);
        int suburbanMaxAge = BankRecordUtils.calculateMaxAge(suburbanList);
        int innerCityMinAge = BankRecordUtils.calculateMinAge(innerCityList);
        int innerCityMaxAge = BankRecordUtils.calculateMaxAge(innerCityList);
        
        // Display Results to Console...
        System.out.println("----------------------------");
        System.out.println("Min and Max Age By Location:");
        System.out.println("----------------------------");
        System.out.format("%11s%6s%6s%n","", "Min", "Max");
        System.out.format("%11s%6d%6d%n", "Town:", townMinAge, townMaxAge);
        System.out.format("%11s%6d%6d%n", "Rural:", ruralMinAge, ruralMaxAge);
        System.out.format("%11s%6d%6d%n", "Suburban:", suburbanMinAge, suburbanMaxAge);
        System.out.format("%11s%6d%6d%n", "Inner City:", innerCityMinAge, innerCityMaxAge);
        System.out.println("----------------------------");
        System.out.format("%n%n");
        
        // Output Results to the File... Append to the existing file
        PrintWriter pw = null;
        try {
            // Create PriwnWriter-FileWriter Stream and append to existing file
            pw = new PrintWriter(new BufferedWriter(new FileWriter("data/bankrecords.txt", true)));
            pw.println("----------------------------");
            pw.println("Min and Max Age By Location:");
            pw.println("----------------------------");
            pw.format("%11s%6s%6s%n", "", "Min", "Max");
            pw.format("%11s%6d%6d%n", "Town:", townMinAge, townMaxAge);
            pw.format("%11s%6d%6d%n", "Rural:", ruralMinAge, ruralMaxAge);
            pw.format("%11s%6d%6d%n", "Suburban:", suburbanMinAge, suburbanMaxAge);
            pw.format("%11s%6d%6d%n", "Inner City:", innerCityMinAge, innerCityMaxAge);
            pw.println("----------------------------");
            pw.format("%n%n");
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(OutputUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        
    }

    public static void printNumFemalesMortgageAndSavings(Map<String, List<BankRecord>> newBankRecords) {
        // Get location Lists out of the map
        List<BankRecord> townList = newBankRecords.get("town");
        List<BankRecord> ruralList = newBankRecords.get("rural");
        List<BankRecord> suburbanList = newBankRecords.get("suburban");
        List<BankRecord> innerCityList = newBankRecords.get("inner_city");
        
        // Count Females with Mortgage and Savings Account for each region-location
        int townCount = FemaleComparator.countFemalesWithMortgageAndSavings(townList);
        int ruralCount = FemaleComparator.countFemalesWithMortgageAndSavings(ruralList);
        int suburbanCount = FemaleComparator.countFemalesWithMortgageAndSavings(suburbanList);
        int innerCityCount = FemaleComparator.countFemalesWithMortgageAndSavings(innerCityList);
        
        // Display Results to Console...
        System.out.println("----------------------------");
        System.out.format("Number of Females with a %nMortgage & Savings Account %nBy Location:%n");
        System.out.println("----------------------------");
        System.out.format("%11s%6d%n", "Town:", townCount);
        System.out.format("%11s%6d%n", "Rural:", ruralCount);
        System.out.format("%11s%6d%n", "Suburban:", suburbanCount);
        System.out.format("%11s%6d%n", "Inner City:", innerCityCount);
        System.out.println("----------------------------");
        System.out.format("%n%n");
        
        // Output Results to the File... Append to the existing file
        PrintWriter pw = null;
        try {
            // Create PriwnWriter-FileWriter Stream and append to existing file
            pw = new PrintWriter(new BufferedWriter(new FileWriter("data/bankrecords.txt", true)));
            pw.println("----------------------------");
            pw.format("Number of Females with a %nMortgage & Savings Account %nBy Location:%n");
            pw.println("----------------------------");
            pw.format("%11s%6d%n", "Town:", townCount);
            pw.format("%11s%6d%n", "Rural:", ruralCount);
            pw.format("%11s%6d%n", "Suburban:", suburbanCount);
            pw.format("%11s%6d%n", "Inner City:", innerCityCount);
            pw.println("----------------------------");
            pw.format("%n%n");
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(OutputUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public static void printNumMalesCarAndChildren(Map<String, List<BankRecord>> newBankRecords) {
        // Get location Lists out of the map
        List<BankRecord> townList = newBankRecords.get("town");
        List<BankRecord> ruralList = newBankRecords.get("rural");
        List<BankRecord> suburbanList = newBankRecords.get("suburban");
        List<BankRecord> innerCityList = newBankRecords.get("inner_city");
        
        // Count Males with a Car and Children for each region-location
        int townCount = MaleComparator.countMalesWithCarAndChildren(townList);
        int ruralCount = MaleComparator.countMalesWithCarAndChildren(ruralList);
        int suburbanCount = MaleComparator.countMalesWithCarAndChildren(suburbanList);
        int innerCityCount = MaleComparator.countMalesWithCarAndChildren(innerCityList);
        
        // Display Results to Console...
        System.out.println("----------------------------");
        System.out.format("Number of Males with a %nCar & Children By Location:%n");
        System.out.println("----------------------------");
        System.out.format("%11s%6d%n", "Town:", townCount);
        System.out.format("%11s%6d%n", "Rural:", ruralCount);
        System.out.format("%11s%6d%n", "Suburban:", suburbanCount);
        System.out.format("%11s%6d%n", "Inner City:", innerCityCount);
        System.out.println("----------------------------");
        System.out.format("%n%n");
        
        // Output Results to the File... Append to the existing file
        PrintWriter pw = null;
        try {
            // Create PriwnWriter-FileWriter Stream and append to existing file
            pw = new PrintWriter(new BufferedWriter(new FileWriter("data/bankrecords.txt", true)));
            pw.println("----------------------------");
            pw.format("Number of Males with a %nCar & Children By Location:%n");
            pw.println("----------------------------");
            pw.format("%11s%6d%n", "Town:", townCount);
            pw.format("%11s%6d%n", "Rural:", ruralCount);
            pw.format("%11s%6d%n", "Suburban:", suburbanCount);
            pw.format("%11s%6d%n", "Inner City:", innerCityCount);
            pw.println("----------------------------");
            pw.format("%n%n");
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(OutputUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
    
    
}
