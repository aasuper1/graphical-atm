package controller;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JOptionPane;

import data.Database;
import model.BankAccount;
import model.User;
import view.ATM;
import view.CreateView;
import view.DepositView;
import view.LoginView;
import view.TransferView;
import view.WithdrawView;
import view.HomeView;
import view.InformationView;

public class ViewManager {
	
	private Container views;				// the collection of all views in the application
	private Database db;					// a reference to the database
	private BankAccount account;			// the user's bank account
	private BankAccount destination;		// an account to which the user can transfer funds
	
	/**
	 * Constructs an instance (or object) of the ViewManager class.
	 * 
	 * @param layout
	 * @param container
	 */
	
	public ViewManager(Container views) {
		this.setViews(views);
		this.db = new Database();
	}
	
	
	/**
	 * Gets the current account
	 * 
	 */
	public BankAccount getAccount(){
		return account;
	}
	
	
	/**
	 * Gets account based on number
	 *
	 */
	public BankAccount getAccount(long accountNumber) {
		return db.getAccount(accountNumber);
	}
	
	
	
	///////////////////// INSTANCE METHODS ////////////////////////////////////////////
	
	/**
	 * Routes a login request from the LoginView to the Database.
	 * 
	 * @param accountNumber
	 * @param pin
	 */
	
	public void insertAccount(BankAccount bankAccount){
		db.insertAccount(bankAccount);
		JOptionPane.showMessageDialog(null, "Your Bank Account Number is: " + bankAccount.getAccountNumber());
		account = db.getAccount(Long.valueOf(bankAccount.getAccountNumber()), bankAccount.getUser().getPin());
		switchTo(ATM.HOME_VIEW);
	}
	
	public void transferFunds(BankAccount _destination, double _amount){
		account.transfer(_destination, _amount);
		db.updateAccount(_destination);
		db.updateAccount(account);
	}
	
	public void deposit(double _amount){
		account.deposit(_amount);
		db.updateAccount(account);
	}
	
	public void withdraw(double _amount){
		account.withdraw(_amount);
		db.updateAccount(account);
	}
	
	public void updateAccountInfo(String city, String state, String streetAddress, String zip, long phone){
		account.getUser().setCity(city);
		account.getUser().setState(state);
		account.getUser().setStreetAddress(streetAddress);
		account.getUser().setZip(zip);
		account.getUser().setPhone(phone);
		db.updateAccount(account);
	}
	
	public boolean updatePin(int current, int pin){
		return account.getUser().setPin(current, pin);
	}
	
	public void updateAccount(BankAccount bankAccount){
		db.updateAccount(bankAccount);
	}
	
	public void closeAccount(){
		try {			
			int choice = JOptionPane.showConfirmDialog(
				getViews(),
				"Are you sure?",
				"Close Account",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
			);
			
			if (choice == 0) {
				db.closeAccount(account);
				account.setStatus('N');
				logout();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	public void login(String accountNumber, char[] pin) {
		LoginView lv = ((LoginView) getViews().getComponents()[ATM.LOGIN_VIEW_INDEX]);
		
		try {
			account = db.getAccount(Long.valueOf(accountNumber), Integer.valueOf(new String(pin)));
			
			if (account == null) {
				lv.updateErrorMessage("Invalid account number and/or PIN.");
			}else if(account.getStatus() == 'N'){
				lv.updateErrorMessage("Can't access closed account");
			} else {
				((HomeView)getViews().getComponent(2)).reset(account);
				switchTo(ATM.HOME_VIEW);
				lv.clear();
			}
		} catch (NumberFormatException e) {
			lv.updateErrorMessage("Account numbers and PINs don't have letters.");
		}
	}
	
	public void logout() {
		LoginView lv = ((LoginView) getViews().getComponents()[ATM.LOGIN_VIEW_INDEX]);
		
		try {
			switchTo(ATM.LOGIN_VIEW);
			account = null;
		} catch (NumberFormatException e) {
			lv.updateErrorMessage("Error Cannot Logout");
		}
	}
	
	/**
	 * Switches the active (or visible) view upon request.
	 * 
	 * @param view
	 */
	
	public void switchTo(String view) {
		((CardLayout) getViews().getLayout()).show(getViews(), view);
		if (view == ATM.HOME_VIEW){
			((HomeView) getViews().getComponents()[ATM.HOME_VIEW_INDEX]).reset(account);
		}
		if (view == ATM.CREATE_VIEW) {
			((CreateView) getViews().getComponents()[ATM.CREATE_VIEW_INDEX]).reset();
		}
		if (view == ATM.LOGIN_VIEW) {
			((LoginView) getViews().getComponents()[ATM.LOGIN_VIEW_INDEX]).reset();
		}
		if (view == ATM.INFORMATION_VIEW){
			((InformationView) getViews().getComponents()[ATM.INFORMATION_VIEW_INDEX]).reset(account);
		}
		if (view == ATM.TRANSFER_VIEW){
			((TransferView) getViews().getComponents()[ATM.TRANSFER_VIEW_INDEX]).reset();
		}
		if (view == ATM.DEPOSIT_VIEW){
			((DepositView) getViews().getComponents()[ATM.DEPOSIT_VIEW_INDEX]).reset();
		}
		if (view == ATM.WITHDRAW_VIEW){
			((WithdrawView) getViews().getComponents()[ATM.WITHDRAW_VIEW_INDEX]).reset();
		}
		
	}
	
	/**
	 * Routes a shutdown request to the database before exiting the application. This
	 * allows the database to clean up any open resources it used.
	 */
	
	public void shutdown() {
		try {			
			int choice = JOptionPane.showConfirmDialog(
				getViews(),
				"Are you sure?",
				"Shutdown ATM",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
			);
			
			if (choice == 0) {
				db.shutdown();
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Container getViews() {
		return views;
	}


	public void setViews(Container views) {
		this.views = views;
	}
}
