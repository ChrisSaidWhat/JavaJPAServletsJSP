package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author christophersaid - csaid
 * CIS175 - Spring 2024
 * Feb 22, 2024
 */
@Entity 
@Table(name="manager")
public class ManagerEntry {
	//	instance variables
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int manNo;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@OneToMany
	private List<EmployeeEntry> listOfEmps;
	
	//	constructors
	public ManagerEntry() {
		
	}
	
	public ManagerEntry(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	//	getters and setters
	public int getManNo() {
		return manNo;
	}

	public void setManNo(int manNo) {
		this.manNo = manNo;
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
	
	public List<EmployeeEntry> getListOfEmps() {
		return listOfEmps;
	}

	public void setListOfEmps(List<EmployeeEntry> listOfEmps) {
		this.listOfEmps = listOfEmps;
	}

	//  helper methods
    public String returnManagerDetails() {
        return this.manNo + ": " + this.firstName + " " + this.lastName;
    }
	
}
