package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;
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
public class InformationView extends JPanel implements ActionListener {
	
	private ViewManager manager;			// manages interactions between the views, model, and database
	private JTextField accountNumberField;
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
	private JButton editInformationButton;
	private JButton cancelButton;
	private JButton exitButton;
	private JButton saveButton;
	private JButton passwordButton;

	
	/**
	 * Constructs an instance (or object) of the InformationView class.
	 * 
	 * @param manager
	 */
	
	public InformationView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	

	
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the InformationView components.
	 */
	
	private void initialize() {
		
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the InformationView.
		
		this.setLayout(null);// What is this
		this.add(new javax.swing.JLabel("InformationView", javax.swing.SwingConstants.CENTER));
		initAccountNumberField();
		initFirstNameField();
		initLastNameField();
		initDateOfBirth();
		initPhoneNumberField();
		initAddressField();
		initCityField();
		initStateField();
		initPostalField();
		initPinField();
		initEditInformationButton();
		initExitButton();
		initCancelButton();
		initSaveButton();
		initPasswordButton();
		
		// TODO
		//
		// this is where you should build the InformationView (i.e., all the components that
		// allow the user to enter his or her information and information a new account).
		//
		// feel free to use my layout in LoginView as an example for laying out and
		// positioning your components.
	}
	
	private void initAccountNumberField() {
		JLabel label = new JLabel("Account Number", SwingConstants.RIGHT);
		label.setBounds(75, 0, 120, 35);
		label.setLabelFor(accountNumberField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		accountNumberField = new JTextField(20);
		accountNumberField.setBounds(205, 0, 200, 35);
		
		accountNumberField.setEnabled(false);
		this.add(label);
		this.add(accountNumberField);
		
	}
	
	private void initFirstNameField() {
		JLabel label = new JLabel("First Name.", SwingConstants.RIGHT);
		label.setBounds(100, 40, 95, 35);
		label.setLabelFor(firstNameField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		firstNameField = new JTextField(20);
		firstNameField.setBounds(205, 40, 200, 35);
		
		firstNameField.setEnabled(false);
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
		
		lastNameField.setEnabled(false);
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
	
	private void initEditInformationButton() {
		editInformationButton = new JButton("Edit");
		editInformationButton.setBounds(205, 420-20, 200, 35);
		editInformationButton.addActionListener(this);
		
		this.add(editInformationButton);
	}
	
	private void initExitButton() {
		exitButton = new JButton("Exit");
		exitButton.setBounds(50, 420-20, 100, 35);
		exitButton.addActionListener(this);
		
		this.add(exitButton);
	}
	
	private void initSaveButton() {
		saveButton = new JButton("Save");
		saveButton.setBounds(205, 420-20, 200, 35);
		saveButton.addActionListener(this);
		
		this.add(saveButton);
	}
	
	private void initCancelButton() {
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(50, 460-20, 100, 35);
		cancelButton.addActionListener(this);
		this.add(cancelButton);
	}
	
	private void initPasswordButton(){
		passwordButton = new JButton("Change Password");
		passwordButton.setBounds(205, 460-20, 200, 35);
		passwordButton.addActionListener(this);
		this.add(passwordButton);
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
	
	private boolean validatePin(String pin){
		try {
			if (Integer.parseInt(pin) >= 0 && Integer.parseInt(pin) <= 9999 && pin.length() == 4){
				return true;
			}else{
				return false;
			}
		}catch (Exception e){
			return false;
		}
	}
	
	public void reset(BankAccount account) {
		accountNumberField.setText(Long.toString(account.getAccountNumber()));
		accountNumberField.setEnabled(false);
		firstNameField.setText(account.getUser().getFirstName());
		firstNameField.setEnabled(false);
		lastNameField.setText(account.getUser().getLastName());
		lastNameField.setEnabled(false);
		monthField.setSelectedItem((account.getUser().getDob()%10000)/100);
		monthField.setEnabled(false);
		dayField.setSelectedItem(account.getUser().getDob()%100);
		dayField.setEnabled(false);
		yearField.setSelectedItem(account.getUser().getDob()/10000);
		yearField.setEnabled(false);
		phoneNumberField1.setText(Long.toString(account.getUser().getPhone()).substring(0, 3));
		phoneNumberField1.setEnabled(false);
		phoneNumberField2.setText(Long.toString(account.getUser().getPhone()).substring(3, 6));
		phoneNumberField2.setEnabled(false);
		phoneNumberField3.setText(Long.toString(account.getUser().getPhone()).substring(6, 10));
		phoneNumberField3.setEnabled(false);
		addressField.setText(account.getUser().getStreetAddress());
		addressField.setEnabled(false);
		cityField.setText(account.getUser().getCity());
		cityField.setEnabled(false);
		stateField.setSelectedItem(account.getUser().getState());
		stateField.setEnabled(false);
		postalField.setText(account.getUser().getZip());
		postalField.setEnabled(false);
		pinField.setText(Integer.toString(account.getUser().getPin()));
		pinField.setEnabled(false);
		cancelButton.setEnabled(false);
		editInformationButton.setVisible(true);
		saveButton.setVisible(false);
		passwordButton.setEnabled(false);
		
	}
	
	private void setEditMode(){
		phoneNumberField1.setEnabled(true);
		phoneNumberField2.setEnabled(true);
		phoneNumberField3.setEnabled(true);
		addressField.setEnabled(true);
		cityField.setEnabled(true);
		stateField.setEnabled(true);
		postalField.setEnabled(true);
		cancelButton.setEnabled(true);
		editInformationButton.setVisible(false);;
		saveButton.setVisible(true);
		passwordButton.setEnabled(true);
	}
	
	
	/*
	 * InformationView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The InformationView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the InformationView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source.equals(exitButton)) {
			manager.switchTo(ATM.HOME_VIEW);;
		}
		if (source.equals(editInformationButton)){
			if (editInformationButton.getText().equals("Edit")){
				setEditMode();
				
			}
		}
		
		
		if (source.equals(saveButton)){
			int[] valid = validateInputs();
			if (valid[0] == 0 && valid[1] == 0 && valid[2] == 0 && valid[3] == 0){
				manager.updateAccountInfo(cityField.getText(), (String) stateField.getSelectedItem(), addressField.getText(), postalField.getText(), Long.parseLong((phoneNumberField1.getText() + phoneNumberField2.getText() + phoneNumberField3.getText())));
				reset(manager.getAccount(Long.parseLong(accountNumberField.getText())));
				editInformationButton.setVisible(true);
				saveButton.setVisible(false);
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
		if (source.equals(cancelButton)){
			BankAccount account = manager.getAccount();
			editInformationButton.setVisible(true);
			saveButton.setVisible(false);
			reset(account);
		}
		
		if (source.equals(passwordButton)){
			BankAccount account = manager.getAccount();
			String current = "";
			String newPin = "";
			try {			
				current = JOptionPane.showInputDialog(
					manager.getViews(),
					"Enter Old Pin",
					"0000");
			} catch (Exception _e) {
				_e.printStackTrace();
			}
			try {			
				newPin = JOptionPane.showInputDialog(
					manager.getViews(),
					"Enter New Pin",
					"0000");
			} catch (Exception _e) {
				_e.printStackTrace();
			}
			if (validatePin(current) && validatePin(newPin)){
				try {			
					int choice = JOptionPane.showConfirmDialog(
						manager.getViews(),
						"Are you sure, this will be permanent?",
						"Change Password",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE
					);
					
					if (choice == 0) {
						if (manager.updatePin(Integer.parseInt(current), Integer.parseInt(newPin))){
							manager.updateAccount(manager.getAccount());
						}else{
							try {			
								JOptionPane.showMessageDialog(
									manager.getViews(),
									"Incorrect Pin",
									"Error Try Again",
									JOptionPane.ERROR_MESSAGE);
							} catch (Exception _e) {
								_e.printStackTrace();
							}
						}
					}
				} catch (Exception _e) {
					_e.printStackTrace();
				}
			}else{
				try {			
					JOptionPane.showMessageDialog(
						manager.getViews(),
						"Invalid Pin(s)",
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