package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import model.BankAccount;

import controller.ViewManager;

@SuppressWarnings("serial")
public class HomeView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JButton logoutButton;
	private JLabel accountNumberDisplay;
	private JLabel nameDisplay;
	private JLabel balanceDisplay;
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton transferButton;
	private JButton personalInformationButton;
	private JButton closeAccountButton;
	
	/**
	 * Constructs an instance (or objects) of the HomeView class.
	 * 
	 * @param manager
	 */
	
	public HomeView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the HomeView components.
	 */
	
	private void initialize() {
		
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the HomeView.
		
		initAccountDetials();
		initLogoutButton();
		initDepositButton();
		initWithdrawButton();
		initTransferButton();
		initPersonalInformationButton();
		initCloseAccountButton();
		
		
		
		// TODO
		//
		// this is where you should build the HomeView (i.e., all the components that
		// allow the user to interact with the ATM - deposit, withdraw, transfer, etc.).
		//
		// feel free to use my layout in LoginView as an example for laying out and
		// positioning your components.
	}
	
	private void initAccountDetials() {
		nameDisplay = new JLabel("Welcome: ", SwingConstants.RIGHT);
		this.add(nameDisplay);
		accountNumberDisplay = new JLabel("Account Number: ", SwingConstants.RIGHT);
		this.add(accountNumberDisplay);
		balanceDisplay = new JLabel("Balance: $", SwingConstants.RIGHT);
		this.add(balanceDisplay);
	}
	
	private void initLogoutButton() {
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(205, 180, 200, 35);
		logoutButton.addActionListener(this);
		this.add(logoutButton);
	}
	
	/*
	 * HomeView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	public void reset(BankAccount account) {
		nameDisplay.setText("Welcome: " + account.getUser().getFirstName() + " " + account.getUser().getLastName() + ";");
		accountNumberDisplay.setText("Account Number: " + account.getAccountNumber() + ";");
		DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
		balanceDisplay.setText("Balance: $" + df2.format(account.getBalance()));
	}
	
	private void initDepositButton() {
		depositButton = new JButton("Deposit");
		depositButton.setBounds(205, 200-20, 200, 35);
		depositButton.addActionListener(this);
		
		this.add(depositButton);
	}
	
	private void initWithdrawButton() {
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(205, 240-20, 200, 35);
		withdrawButton.addActionListener(this);
		
		this.add(withdrawButton);
	}
	
	private void initTransferButton() {
		transferButton = new JButton("Transfer");
		transferButton.setBounds(205, 280-20, 200, 35);
		transferButton.addActionListener(this);
		
		this.add(transferButton);
	}
	private void initPersonalInformationButton() {
		personalInformationButton = new JButton("View/Edit Personal Information");
		personalInformationButton.setBounds(205, 320-20, 300, 35);
		personalInformationButton.addActionListener(this);
		
		this.add(personalInformationButton);
	}
	
	private void initCloseAccountButton() {
		closeAccountButton = new JButton("Close Account");
		closeAccountButton.setBounds(205, 320-20, 200, 35);
		closeAccountButton.addActionListener(this);
		
		this.add(closeAccountButton);
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The HomeView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the HomeView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source.equals(logoutButton)) {
			manager.logout();
		}
		if (source.equals(depositButton)){
			manager.switchTo(ATM.DEPOSIT_VIEW);
		}
		if (source.equals(withdrawButton)){
			manager.switchTo(ATM.WITHDRAW_VIEW);
		}
		if (source.equals(transferButton)){
			manager.switchTo(ATM.TRANSFER_VIEW);
		}
		if (source.equals(personalInformationButton)){
			manager.switchTo(ATM.INFORMATION_VIEW);
		}
		if (source.equals(closeAccountButton)){
			manager.closeAccount();
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