package lab2;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {

    private NameService nameService;

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() {

        String fullName = JOptionPane.showInputDialog("Enter full name:");
        if (fullName == null) {
            System.exit(0);
        }
        String lastName = "Unknown";
        try {
            lastName = nameService.extractLastName(fullName);

        } catch (RuntimeException ae) {
            JOptionPane.showMessageDialog(null, "You must enter a full name "
                    + "with a space in between");
        }

        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);

    }
}
