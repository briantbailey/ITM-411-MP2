/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.domain;

import java.util.Comparator;

/**
 *
 * @author Brian T. Bailey
 */
public class AgeComparator implements Comparator {

    @Override
    public int compare(Object t1, Object t2) {
        // Downcast Objects to BankRecord Objects
        BankRecord br1 = (BankRecord)t1;
        BankRecord br2 = (BankRecord)t2;
        // Compare BankRecord Objects by Age
        if (br1.getAge() > br2.getAge()) {
            return 1;
        } else if (br1.getAge() < br2.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
    
}
