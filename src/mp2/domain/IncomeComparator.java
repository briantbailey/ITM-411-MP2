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
public class IncomeComparator implements Comparator {

    @Override
    public int compare(Object t1, Object t2) {
        // Downcast Objects to BankRecord Objects
        BankRecord br1 = (BankRecord)t1;
        BankRecord br2 = (BankRecord)t2;
        // Compare BankRecord Objects by Age
        if (br1.getIncome() > br2.getIncome()) {
            return 1;
        } else if (br1.getIncome() < br2.getIncome()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public static double calculateAvgIncome(List<BankRecord> brList) {
        double average = 0.0;
        double sum = 0.0;
        
        // Caculate average
        for (BankRecord br : brList) {
            sum += br.getIncome();
        }
        // Prevent a divide by zero
        if (!brList.isEmpty()) {
            average = sum / (double)brList.size();
        }
        
        // Return Average
        return average;
    }
    
}
