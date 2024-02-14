import controller.EmployeeEntryHelper;
import model.EmployeeEntry;

import java.util.Scanner;
import java.util.List;
/**
 * @author christophersaid - csaid
 * CIS175 - Spring 2024
 * Jan 29, 2024
 */
public class StartProgram {

    static Scanner in = new Scanner(System.in);
    static EmployeeEntryHelper eeh = new EmployeeEntryHelper();

    private static void addAnEntry() {
        System.out.println("Enter a first name: ");
        String firstName = in.nextLine();
        System.out.println("Enter a last name: ");
        String lastName = in.nextLine();
        EmployeeEntry toAdd = new EmployeeEntry(firstName, lastName);
        eeh.addEmployee(toAdd);
    }

    private static void deleteAnEntry() {
        System.out.println("Enter the first name to delete: ");
        String firstName = in.nextLine();
        System.out.println("Enter the last name to delete: ");
        String lastName = in.nextLine();
        EmployeeEntry toDelete = new EmployeeEntry(firstName, lastName);
        eeh.deleteEntry(toDelete);
    }

    private static void editAnEntry() {
        System.out.println("How would you like to search? ");
        System.out.println("1: Search by first name");
        System.out.println("2: Search by last name");
        int searchBy = in.nextInt();
        in.nextLine();

        List<EmployeeEntry> foundEntries;

        if (searchBy == 1) {
            System.out.println("Enter the first name: ");
            String firstName = in.nextLine();
            foundEntries = eeh.searchForEntryByFirstName(firstName);
        } else {
            System.out.println("Enter the last name: ");
            String lastName = in.nextLine();
            foundEntries = eeh.searchForEntryByLastName(lastName);
        }

        if (!foundEntries.isEmpty()) {
            System.out.println("Found results.");
            for (EmployeeEntry e : foundEntries) {
                System.out.println(e.returnEmployeeDetails());
            }

            System.out.print("Which empNo to edit: ");
            int empNoToEdit = in.nextInt();

            EmployeeEntry toEdit = eeh.searchForEntryByEmpNo(empNoToEdit);
            System.out.println("Retrieved " + toEdit.getFirstName() + " " + toEdit.getLastName());
            System.out.println("1: Update first name");
            System.out.println("2: Update last name");
            int update = in.nextInt();
            in.nextLine();

            if (update == 1) {
                System.out.print("New first name: ");
                String newFirstName = in.nextLine();
                toEdit.setFirstName(newFirstName);
            } else if (update == 2) {
                System.out.print("New last name: ");
                String newLastName = in.nextLine();
                toEdit.setLastName(newLastName);
            }

            eeh.updateEntry(toEdit);

        } else {
            System.out.println("---- No results found.");
        }
    }

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        boolean goAgain = true;
        System.out.println("---- Welcome to this employee management system! ----");

        while (goAgain) {
            System.out.println("* Select an option:");
            System.out.println("* 1 -- Add an employee");
            System.out.println("* 2 -- Edit an employee");
            System.out.println("* 3 -- Delete an employee");
            System.out.println("* 4 -- View the list");
            System.out.println("* 5 -- Exit employee management system");
            System.out.print("* Your Selection: ");
            int selection = in.nextInt();
            in.nextLine();

            if (selection == 1) {
                addAnEntry();
            } else if (selection == 2) {
                editAnEntry();
            } else if (selection == 3) {
                deleteAnEntry();
            } else if (selection == 4) {
                viewList();
            } else {
                eeh.cleanUp();
                System.out.println("    Goodbye!    ");
                goAgain = false;
            }
        }
    }

    private static void viewList() {
        List<EmployeeEntry> allEntries = eeh.showAllEntries();
        for (EmployeeEntry singleEntry : allEntries) {
            System.out.println(singleEntry.returnEmployeeDetails());
        }
    }

}