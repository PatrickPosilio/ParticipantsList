// Importing necessary Java classes
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Defining a class named FirstProject that extends JFrame
public class FirstProject extends JFrame{

    // Declaring private instance variables for the UI components
    private JPanel panelMain;
    private JButton AddParticipantButton;
    private JTextArea textAreaFeedback;
    private JTextArea textAreaParticipants;
    private JSpinner spinnerHours;
    private JSpinner spinnerMinutes;
    private JTextField textFieldName;
    private JButton ClearButton;

    // Creating the main method to start the application
    public static void main(String[] args) {
        // Creating an instance of the FirstProject class
        FirstProject a = new FirstProject();

        // Setting the content pane, title, size, visibility and default close operation for the JFrame
        a.setContentPane(a.panelMain);
        a.setTitle("Registration");
        a.setSize(1000, 800);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Constructor for the FirstProject class
    public FirstProject() {
        // Creating spinner models for hours and minutes
        SpinnerNumberModel hoursModel = new SpinnerNumberModel(0, 0, 23, 1);
        SpinnerNumberModel minutesModel = new SpinnerNumberModel(0, 0, 59, 1);

        // Setting the spinner models for hours and minutes
        spinnerHours.setModel(hoursModel);
        spinnerMinutes.setModel(minutesModel);

        // Adding an action listener to the AddParticipantButton to perform an action when it is clicked
        AddParticipantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Getting the name, hours and minutes entered by the user
                String name = textFieldName.getText();
                int hours = (int) spinnerHours.getValue();
                int minutes = (int) spinnerMinutes.getValue();

                // Formatting the hours and minutes as a time string
                String time = String.format("%02d:%02d", hours, minutes);

                // Combining the name and time as a participant string
                String participant = name + " - " + time;

                // Checking if the name is valid and adding the participant to the text area
                if (name.isEmpty() || !name.matches( "[a-zA-Z]+")) {
                    textAreaFeedback.append("The given name is not valid.\n");
                } else {
                    textAreaParticipants.append("•" + participant + "\n");
                    textAreaFeedback.append("Participant " + name + " was added\n");
                }
            }
        });

        // Adding an action listener to the ClearButton to perform an action when it is clicked
        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Clearing the text areas
                textAreaFeedback.setText("");
                textAreaParticipants.setText("");
            }
        });
    }
}
