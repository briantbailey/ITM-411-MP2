/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.domain;

import java.io.Serializable;

/**
 *
 * @author Brian T. Bailey
 */
public abstract class Record implements Serializable {

    public Record() {
    }

    @Override
    public String toString() {
        return "Record{" + '}';
    }
    
}
