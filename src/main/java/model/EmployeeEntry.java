package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/** 
 * @author christophersaid - csaid
 * CIS175 - Spring 2024
 * Jan 29, 2024
 */
@Entity
@Table(name = "employee")
public class EmployeeEntry {
    //  instance variables
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int empNo;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;

    //  constructors
    public EmployeeEntry() {

    }

    public EmployeeEntry(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //  getters and setters
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //  helper methods
    public String returnEmployeeDetails() {
        return this.empNo + ": " + this.firstName + " " + this.lastName;
    }
}
