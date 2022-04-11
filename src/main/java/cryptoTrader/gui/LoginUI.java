package cryptoTrader.gui;

import cryptoTrader.service.login.UserServiceProxy;
import cryptoTrader.entity.CurrentClientsInfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * this class represent the login UI
 * @author group-11 
 *
 */


public class LoginUI {

	private JFrame frame;
	private JTextField input_username;
	private JPasswordField input_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel LOGIN = new JLabel("CoinMaster Login");
		LOGIN.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		LOGIN.setBounds(182, 28, 161, 26);
		frame.getContentPane().add(LOGIN);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(53, 87, 82, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(53, 160, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		input_username = new JTextField();
		input_username.setBounds(229, 82, 130, 26);
		frame.getContentPane().add(input_username);
		input_username.setColumns(10);
		
		input_password = new JPasswordField();
		input_password.setBounds(229, 155, 130, 26);
		frame.getContentPane().add(input_password);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String password = input_password.getText();
					String username = input_username.getText();
					// UserService.authenticate(username, password)) {
					UserServiceProxy authen = new UserServiceProxy();
					if (authen.authenticate(username, password)) {
						input_password.setText(null);
						input_username.setText(null);
						JFrame mainFrame = MainUI.getInstance();
						mainFrame.setSize(900, 600);
						mainFrame.pack();
						mainFrame.setVisible(true);
						frame.setVisible(false);

						// initialize the clients info
						CurrentClientsInfo current = CurrentClientsInfo.getInstance();
					}else {
						JOptionPane.showMessageDialog(null, "invalid user infomation", "Login error", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
			}
		});
		btnNewButton.setBounds(192, 217, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 194, 439, 12);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(53, 63, 406, 12);
		frame.getContentPane().add(separator_1);
	}
}
