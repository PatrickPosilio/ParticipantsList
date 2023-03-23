import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstProject extends JFrame{
    private JPanel panelMain;
    private JLabel nameLabel;
    private JLabel TimeSlotHLabel;
    private JLabel TimeSlotMLabel;
    private JButton AddParticipantButton;
    private JTextArea textAreaFeedback;
    private JTextArea textAreaParticipants;
    private JSpinner spinnerHours;
    private JSpinner spinnerMinutes;
    private JTextField textFieldName;

    public FirstProject() {
        AddParticipantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = textFieldName.getText();
                String time = spinnerHours.getValue() + ":" + spinnerMinutes.getValue();
                String participant = name + " - " + time;
                textAreaParticipants.append(participant + "\n");
                textAreaFeedback.append("Participant " + name + " was added\n");
                JOptionPane.showMessageDialog(AddParticipantButton, name + ", thank you for making an appointment at: " + time + ".");
            }
        });
    }

    public static void main(String[] args) {
        FirstProject a = new FirstProject();
        a.setContentPane(a.panelMain);
        a.setTitle("Thank you!");
        a.setSize(300, 400);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
