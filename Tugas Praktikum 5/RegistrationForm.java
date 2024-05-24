import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm {

    private static JTextField nameField;
    private static JTextField dobField;
    private static JTextField regNumberField;
    private static JTextField phoneField;
    private static JTextArea addressField;
    private static JTextField emailField;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Daftar Ulang Mahasiswa Baru");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(new Color(230, 230, 250)); 

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 5, 5));
        panel.setBackground(new Color(255, 240, 245)); 

        JLabel nameLabel = new JLabel("Nama Lengkap:");
        nameLabel.setForeground(new Color(75, 0, 130)); 
        nameField = new JTextField(20);
        JLabel dobLabel = new JLabel("Tanggal Lahir:");
        dobLabel.setForeground(new Color(75, 0, 130));
        dobField = new JTextField(20);
        JLabel regNumberLabel = new JLabel("Nomor Pendaftaran:");
        regNumberLabel.setForeground(new Color(75, 0, 130));
        regNumberField = new JTextField(20);
        JLabel phoneLabel = new JLabel("No. Telp:");
        phoneLabel.setForeground(new Color(75, 0, 130));
        phoneField = new JTextField(20);
        JLabel addressLabel = new JLabel("Alamat:");
        addressLabel.setForeground(new Color(75, 0, 130));
        addressField = new JTextArea(3, 20);
        JLabel emailLabel = new JLabel("E-mail:");
        emailLabel.setForeground(new Color(75, 0, 130));
        emailField = new JTextField(20);

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(176, 224, 230));
        submitButton.setForeground(new Color(25, 25, 112)); 
        submitButton.addActionListener(new SubmitButtonListener());

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(dobLabel);
        panel.add(dobField);
        panel.add(regNumberLabel);
        panel.add(regNumberField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(addressLabel);
        panel.add(new JScrollPane(addressField));
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(new JLabel("")); 
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    static class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (nameField.getText().isEmpty() || dobField.getText().isEmpty() || regNumberField.getText().isEmpty() || 
                phoneField.getText().isEmpty() || addressField.getText().isEmpty() || emailField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus terisi.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int response = JOptionPane.showConfirmDialog(null, "Apakah anda yakin data yang Anda isi sudah benar?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
            if (response == JOptionPane.OK_OPTION) {
                JFrame dataFrame = new JFrame("Data Mahasiswa");
                dataFrame.setSize(400, 300);
                dataFrame.getContentPane().setBackground(new Color(230, 230, 250));

                JPanel dataPanel = new JPanel();
                dataPanel.setLayout(new GridLayout(6, 1));
                dataPanel.setBackground(new Color(255, 240, 245));

                JLabel nameLabel = new JLabel("Nama\t: " + nameField.getText());
                nameLabel.setForeground(new Color(75, 0, 130));
                JLabel dobLabel = new JLabel("Tanggal Lahir\t: " + dobField.getText());
                dobLabel.setForeground(new Color(75, 0, 130));
                JLabel regNumberLabel = new JLabel("Nomor Pendaftaran: " + regNumberField.getText());
                regNumberLabel.setForeground(new Color(75, 0, 130));
                JLabel phoneLabel = new JLabel("No. Telp\t: " + phoneField.getText());
                phoneLabel.setForeground(new Color(75, 0, 130));
                JLabel addressLabel = new JLabel("Alamat\t: " + addressField.getText());
                addressLabel.setForeground(new Color(75, 0, 130));
                JLabel emailLabel = new JLabel("E-mail\t: " + emailField.getText());
                emailLabel.setForeground(new Color(75, 0, 130));

                dataPanel.add(nameLabel);
                dataPanel.add(dobLabel);
                dataPanel.add(regNumberLabel);
                dataPanel.add(phoneLabel);
                dataPanel.add(addressLabel);
                dataPanel.add(emailLabel);

                dataFrame.add(dataPanel);
                dataFrame.setVisible(true);
            }
        }
    }
}