package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;
import model.BankAccount;
import model.User;



public class TransferView  extends JPanel implements ActionListener{
	private ViewManager manager;
	private JButton exitButton;
	private JTextField transferAmountField;
	private JButton transferButton;
	private JTextField targetAccountField;
	

	public TransferView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}

	
	private void initialize() {
		
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the CreateView.
		
		this.setLayout(null);// What is this
		this.add(new javax.swing.JLabel("TransferView", javax.swing.SwingConstants.CENTER));
		initTransferAmount();
		initExitButton();
		initTransferButton();
		initTargetAccountField();
	}


	private void initExitButton() {
		exitButton = new JButton("Exit");
		exitButton.setBounds(205, 460-20, 200, 35);
		exitButton.addActionListener(this);
	
		this.add(exitButton);
	}
	
	private void initTransferAmount() {
		JLabel label = new JLabel("Transfer Amount", SwingConstants.RIGHT);
		label.setBounds(50, 180-20, 145, 35);
		label.setLabelFor(transferAmountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		transferAmountField = new JTextField(20);
		transferAmountField.setBounds(205, 180-20, 200, 35);
		
		this.add(label);
		this.add(transferAmountField);
	}
	
	private void initTargetAccountField() {
		JLabel label = new JLabel("Target Account Number", SwingConstants.RIGHT);
		label.setBounds(25, 220-20, 170, 35);
		label.setLabelFor(targetAccountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		targetAccountField = new JTextField(20);
		targetAccountField.setBounds(205, 220-20, 200, 35);
		
		this.add(label);
		this.add(targetAccountField);
	}
	
	private void initTransferButton() {
		transferButton = new JButton("Transfer");
		transferButton.setBounds(205, 420-20, 200, 35);
		transferButton.addActionListener(this);
		
		this.add(transferButton);
	}
	
	public void reset(){
		transferAmountField.setText("");
		targetAccountField.setText("");
	}
	
	public boolean validateTarget(){
		if (manager.getAccount(Long.parseLong(targetAccountField.getText())) != null){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validateTransferAmount(String transfer){
		try {
			if (Double.parseDouble(transfer) >= 0.01 && Double.parseDouble(transfer) <= manager.getAccount().getBalance()){
				return true;
			}else{
				return false;
			}
		}catch (Exception e){
			return false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if (source.equals(exitButton)) {
			manager.switchTo(ATM.HOME_VIEW);
		}
		
		if (source.equals(transferButton)){
			boolean success = true;
			if (validateTarget()){
			}else{
				try {			
					JOptionPane.showMessageDialog(
						manager.getViews(),
						"Invalid Target Account",
						"Error Try Again",
						JOptionPane.ERROR_MESSAGE);
				} catch (Exception _e) {
					_e.printStackTrace();
				}
				success = false;
			}
			if (validateTransferAmount(transferAmountField.getText())){
			}else{
				try {			
					JOptionPane.showMessageDialog(
						manager.getViews(),
						"Invalid Transfer Amount",
						"Error Try Again",
						JOptionPane.ERROR_MESSAGE);
				} catch (Exception _e) {
					_e.printStackTrace();
				}
				success = false;
			}
			
			if (success){
				BankAccount target = manager.getAccount(Long.parseLong(targetAccountField.getText()));
				manager.transferFunds(target, Double.parseDouble(transferAmountField.getText()));
				manager.switchTo(ATM.HOME_VIEW);
			}
			
		}
		// TODO Fill in the rest of the possible functions
		
	}
}
