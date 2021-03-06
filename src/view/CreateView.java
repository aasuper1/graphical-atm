package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;
import model.User;
import model.BankAccount;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;			// manages interactions between the views, model, and database
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JComboBox<Integer> monthField;
	private JComboBox<Integer> dayField;
	private JComboBox<Integer> yearField;
	private JTextField phoneNumberField1;
	private JTextField phoneNumberField2;
	private JTextField phoneNumberField3;
	private JTextField addressField;
	private JTextField cityField;
	private JComboBox<String> stateField;
	private JTextField postalField;
	private JTextField pinField;
	private JButton createAccountButton;
	private JButton exitButton;

	
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public CreateView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	

	
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the CreateView components.
	 */
	
	private void initialize() {
		
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the CreateView.
		
		this.setLayout(null);// What is this
		this.add(new javax.swing.JLabel("CreateView", javax.swing.SwingConstants.CENTER));
		
		initFirstNameField();
		initLastNameField();
		initDateOfBirth();
		initPhoneNumberField();
		initAddressField();
		initCityField();
		initStateField();
		initPostalField();
		initPinField();
		initCreateAccountButton();
		initExitButton();
		
		// TODO
		//
		// this is where you should build the CreateView (i.e., all the components that
		// allow the user to enter his or her information and create a new account).
		//
		// feel free to use my layout in LoginView as an example for laying out and
		// positioning your components.
	}
	
	private void initFirstNameField() {
		JLabel label = new JLabel("First Name.", SwingConstants.RIGHT);
		label.setBounds(100, 40, 95, 35);
		label.setLabelFor(firstNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		firstNameField = new JTextField(20);
		firstNameField.setBounds(205, 40, 200, 35);
		
		this.add(label);
		this.add(firstNameField);
	}
	
	private void initLastNameField() {
		JLabel label = new JLabel("Last Name.", SwingConstants.RIGHT);
		label.setBounds(100, 80, 95, 35);
		label.setLabelFor(lastNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		lastNameField = new JTextField(20);
		lastNameField.setBounds(205, 80, 200, 35);
		
		this.add(label);
		this.add(lastNameField);
	}
	
	private void initDateOfBirth() {
		JLabel label = new JLabel("Date of Birth", SwingConstants.RIGHT);
		label.setBounds(100, 120, 95, 35);
		label.setLabelFor(lastNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		Integer[] months = {01, 02, 03, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		monthField = new JComboBox<Integer>(months);
		Integer[] years = new Integer [119];
		for (int i = 0; i < 119; i++) {
			years[i] = i + 1900;
		}
		yearField = new JComboBox<Integer>(years);
		Integer[] days = new Integer [31];
		for (int i = 0; i < 31; i++) {
			days[i] = i+1;
		}
		
		
		dayField = new JComboBox<Integer>(days);
		monthField.setBounds(205, 120, 70, 35);
		dayField.setBounds(280, 120, 70, 35);
		yearField.setBounds(355, 120, 100, 35);
		this.add(label);
		this.add(monthField);
		this.add(dayField);
		this.add(yearField);
	}
	
	private void initPhoneNumberField() {
		JLabel label = new JLabel("Phone Number.", SwingConstants.RIGHT);
		label.setBounds(75, 180-20, 120, 35);
		label.setLabelFor(phoneNumberField1);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		phoneNumberField1 = new JTextField(3);
		phoneNumberField1.setBounds(205, 180-20, 60, 35);
		
		phoneNumberField2 = new JTextField(3);
		phoneNumberField2.setBounds(265, 180-20, 60, 35);
		
		phoneNumberField3 = new JTextField(4);
		phoneNumberField3.setBounds(325, 180-20, 80, 35);
		
		this.add(label);
		this.add(phoneNumberField1);
		this.add(phoneNumberField2);
		this.add(phoneNumberField3);
	}
	
	private void initAddressField() {
		JLabel label = new JLabel("Address.", SwingConstants.RIGHT);
		label.setBounds(100, 220-20, 95, 35);
		label.setLabelFor(addressField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		addressField = new JTextField(20);
		addressField.setBounds(205, 220-20, 200, 35);
		
		this.add(label);
		this.add(addressField);
	}
	
	private void initCityField() {
		JLabel label = new JLabel("City.", SwingConstants.RIGHT);
		label.setBounds(100, 260-20, 95, 35);
		label.setLabelFor(cityField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		cityField = new JTextField(20);
		cityField.setBounds(205, 260-20, 200, 35);
		
		this.add(label);
		this.add(cityField);
	}
	
	private void initStateField() {
		JLabel label = new JLabel("State.", SwingConstants.RIGHT);
		label.setBounds(100, 300-20, 95, 35);
		label.setLabelFor(stateField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		
		String[] states = {
				"AK",
				"AL",
				"AZ",
				"AR",
				"CA",
				"CO",
				"CT",
				"DE",
				"FL",
				"GA",
				"HI",
				"ID",
				"IL",
				"IN",
				"IA",
				"KS",
				"KY",
				"LA",
				"ME",
				"MD",
				"MA",
				"MI",
				"MN",
				"MS",
				"MO",
				"MT",
				"NE",
				"NV",
				"NH",
				"NJ",
				"NM",
				"NY",
				"NC",
				"ND",
				"OH",
				"OK",
				"OR",
				"PA",
				"RI",
				"SC",
				"SD",
				"TN",
				"TX",
				"UT",
				"VT",
				"VA",
				"WA",
				"WV",
				"WI",
				"WY"};
		stateField = new JComboBox<String>(states);
		stateField.setBounds(205, 300-20, 200, 35);
		
		this.add(label);
		this.add(stateField);
	}
	
	private void initPostalField() {
		JLabel label = new JLabel("Postal.", SwingConstants.RIGHT);
		label.setBounds(100, 340-20, 95, 35);
		label.setLabelFor(postalField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		postalField = new JTextField(20);
		postalField.setBounds(205, 340-20, 200, 35);
		
		this.add(label);
		this.add(postalField);
	}
	
	private void initPinField() {
		JLabel label = new JLabel("PIN", SwingConstants.RIGHT);
		label.setBounds(100, 380-20, 95, 35);
		label.setLabelFor(pinField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		pinField = new JPasswordField(20);
		pinField.setBounds(205, 380-20, 200, 35);
		
		this.add(label);
		this.add(pinField);
	}
	
	private void initCreateAccountButton() {
		createAccountButton = new JButton("Create Account");
		createAccountButton.setBounds(205, 420-20, 200, 35);
		createAccountButton.addActionListener(this);
		
		this.add(createAccountButton);
	}
	
	private void initExitButton() {
		exitButton = new JButton("Exit");
		exitButton.setBounds(205, 460-20, 200, 35);
		exitButton.addActionListener(this);
		
		this.add(exitButton);
	}
	
	private int[] validateInputs() {
		int[] errors = {1,1,1,1};
		try {
			if (Integer.parseInt(pinField.getText()) >= 0 && Integer.parseInt(pinField.getText()) <= 9999 && pinField.getText().length() == 4){
				errors[0] = 0;
			}else{
				errors[0] = 1;
			}
		}catch (Exception e){
			errors[0] = 1;
		}
		
		try {
			if (Integer.parseInt(phoneNumberField1.getText()) >= 0 && Integer.parseInt(phoneNumberField1.getText()) <= 999 && phoneNumberField1.getText().length() == 3 && Integer.parseInt(phoneNumberField2.getText()) >= 0 && Integer.parseInt(phoneNumberField2.getText()) <= 999 && phoneNumberField2.getText().length() == 3 && Integer.parseInt(phoneNumberField3.getText()) >= 0 && Integer.parseInt(phoneNumberField3.getText()) <= 9999 && phoneNumberField3.getText().length() == 4){
				errors[1] = 0;
			}else{
				errors[1] = 1;
			}
		}catch (Exception e){
			errors[0] = 1;
		}
		
		try {
			if (Integer.parseInt(postalField.getText()) >= 0 && Integer.parseInt(postalField.getText()) <= 99999 && postalField.getText().length() == 5){
				errors[2] = 0;
			}else{
				errors[2] = 1;
			}
		}catch (Exception e){
			errors[2] = 1;
		}
		if (firstNameField.getText().length() != 0 && lastNameField.getText().length() != 0 && phoneNumberField1.getText().length() != 0 && phoneNumberField2.getText().length() != 0 && phoneNumberField3.getText().length() != 0 && addressField.getText().length() != 0 && cityField.getText().length() != 0 && postalField.getText().length() != 0 && pinField.getText().length() != 0){
			errors[3] = 0;
		}
		
		return errors;
	}
	
	public void reset() {
		firstNameField.setText("");
		lastNameField.setText("");
		monthField.setSelectedItem(1);
		dayField.setSelectedItem(1);
		yearField.setSelectedItem(1990);
		phoneNumberField1.setText("");
		phoneNumberField2.setText("");
		phoneNumberField3.setText("");
		addressField.setText("");
		cityField.setText("");
		stateField.setSelectedItem("AK");
		postalField.setText("");
		pinField.setText("");
	}
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The CreateView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source.equals(exitButton)) {
			manager.logout();
		}
		
		if (source.equals(createAccountButton)) {
			int[] valid = validateInputs();
			if (valid[0] == 0 && valid[1] == 0 && valid[2] == 0 && valid[3] == 0){
				User user = new User(Integer.parseInt(pinField.getText()), (int)dayField.getSelectedItem() + (int)monthField.getSelectedItem() * 100 + (int)yearField.getSelectedItem() * 10000, Long.parseLong((phoneNumberField1.getText() + phoneNumberField2.getText() + phoneNumberField3.getText())), firstNameField.getText(), lastNameField.getText(), addressField.getText(),cityField.getText(), stateField.getSelectedItem().toString(), postalField.getText());
				manager.insertAccount(new BankAccount('Y', 0, user));
			}else{
				try {			
					JOptionPane.showMessageDialog(
						manager.getViews(),
						""+"" + ((valid[0] == 1) ? "Fix Pin Format;" : "") + ((valid[1] == 1) ? " Fix Phone Format;" : "") + ((valid[2] == 1) ? " Fix Postal Format;" : "") + ((valid[3] == 1) ? " No Field Can Be Blank" : ""),
						"Error Try Again",
						JOptionPane.ERROR_MESSAGE);
				} catch (Exception _e) {
					_e.printStackTrace();
				}
			}
		}
		// TODO
		//
		// this is where you'll setup your action listener, which is responsible for
		// responding to actions the user might take in this view (an action can be a
		// user clicking a button, typing in a textfield, etc.).
		//
		// feel free to use my action listener in LoginView.java as an example.
	}
}