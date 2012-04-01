/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2.domain;

/**
 *
 * @author Brian T. Bailey
 */
public class BankRecord extends Record {
    
    // Declare Fields
    private String id;
    private int age;
    private String sex;
    private String region;
    private double income;
    private boolean married;
    private int children;
    private boolean car;
    private boolean saveAcct;
    private boolean currentAcct;
    private boolean mortgage;
    private boolean pep;
    
    // Constructors
    public BankRecord() {
    }
    
    public BankRecord(String id, int age, String sex, String region, double income, boolean married, int children, boolean car, boolean saveAcct, boolean currentAcct, boolean mortgage, boolean pep) {
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.region = region;
        this.income = income;
        this.married = married;
        this.children = children;
        this.car = car;
        this.saveAcct = saveAcct;
        this.currentAcct = currentAcct;
        this.mortgage = mortgage;
        this.pep = pep;
    }
    
    
    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCar() {
        return car;
    }

    public void setCar(boolean car) {
        this.car = car;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public boolean isCurrentAcct() {
        return currentAcct;
    }

    public void setCurrentAcct(boolean currentAcct) {
        this.currentAcct = currentAcct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public boolean isMortgage() {
        return mortgage;
    }

    public void setMortgage(boolean mortgage) {
        this.mortgage = mortgage;
    }

    public boolean isPep() {
        return pep;
    }

    public void setPep(boolean pep) {
        this.pep = pep;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public boolean isSaveAcct() {
        return saveAcct;
    }

    public void setSaveAcct(boolean saveAcct) {
        this.saveAcct = saveAcct;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    
    // toString
    @Override
    public String toString() {
        return "BankRecord{" + "id=" + id + ", age=" + age + ", sex=" + sex + ", region=" + region + ", income=" + income + ", married=" + married + ", children=" + children + ", car=" + car + ", saveAcct=" + saveAcct + ", currentAcct=" + currentAcct + ", mortgage=" + mortgage + ", pep=" + pep + '}';
    }
    
}
