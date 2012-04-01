/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.domain;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Brian T. Bailey
 */
public class FemaleComparator implements Comparator {

    @Override
    public int compare(Object t1, Object t2) {
        // Sort Females First
        // Downcast Objects to BankRecord Objects
        BankRecord br1 = (BankRecord)t1;
        BankRecord br2 = (BankRecord)t2;
        // Compare BankRecord Objects by sex
        if (br1.getSex().equals("MALE") && br2.getSex().equals("FEMALE")) {
            return 1;
        } else if (br1.getSex().equals("FEMALE") && br2.getSex().equals("MALE")) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public static int countFemalesWithMortgageAndSavings(List<BankRecord> brList) {
        // Declare count and set to zero
        int count = 0;
        
        // Loop through the List and count Females with a Mortgage and Savings Account
        for (BankRecord br : brList) {
            if (br.getSex().equalsIgnoreCase("FEMALE")) {
                if (br.isMortgage() && br.isSaveAcct()) {
                    count++;
                }
            }
        }
        
        // Return the count
        return count;
    }
    
}
