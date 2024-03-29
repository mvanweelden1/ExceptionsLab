package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using Java
 * Exception handling techniques. <p> Your challenge is to consider all the
 * possible things that can go wrong with this program and use exception
 * handling where appropriate to prevent the program from crashing. In addition
 * you must display a friendly error message in a JOptionPane and ask the user
 * to try again.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {

    private static final int LAST_NAME_IDX = 1;

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        String lastName = null;
        do { 
             try {
            String fullName = JOptionPane.showInputDialog("Enter full name:");
            lastName = app.extractLastName(fullName);
            String msg = "Your last name is: " + lastName;
            JOptionPane.showMessageDialog(null, msg);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Please try again\n "
                    + e.getMessage());
        }
            
        } while (lastName == null || lastName.length() == 0);

    }

    public String extractLastName(String fullName) throws IllegalArgumentException {
        if (fullName.length() == 0) {
            throw new IllegalArgumentException("You must enter a first and last "
                    + "name with a space in between");
        }

        String[] nameParts = fullName.split(" ");
        return nameParts[LAST_NAME_IDX];
    }
}
