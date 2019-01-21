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



public class DepositView  extends JPanel implements ActionListener{
	private ViewManager manager;
	private JButton exitButton;
	private JTextField depositAmountField;
	private JButton depositButton;
	private JLabel errorMessageLabel;
	

	public DepositView(ViewManager manager) {
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
		this.add(new javax.swing.JLabel("DepositView", javax.swing.SwingConstants.CENTER));
		initDepositAmount();
		initExitButton();
		initDepositButton();
	}


	private void initExitButton() {
		exitButton = new JButton("Exit");
		exitButton.setBounds(205, 460-20, 200, 35);
		exitButton.addActionListener(this);
	
		this.add(exitButton);
	}
	
	private void initDepositAmount() {
		JLabel label = new JLabel("Deposit Value", SwingConstants.RIGHT);
		label.setBounds(50, 180-20, 145, 35);
		label.setLabelFor(depositAmountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		depositAmountField = new JTextField(20);
		depositAmountField.setBounds(205, 180-20, 200, 35);
		
		this.add(label);
		this.add(depositAmountField);
	}
	
	private void initDepositButton() {
		depositButton = new JButton("Deposit");
		depositButton.setBounds(205, 420-20, 200, 35);
		depositButton.addActionListener(this);
		
		this.add(depositButton);
	}
	
	public void reset(){
		depositAmountField.setText("");
	}
	
	private boolean validateDeposit(String deposit){
		try {
			if (Double.parseDouble(deposit) >= 0.01){
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
		
		if (source.equals(depositButton)){
			if (validateDeposit(depositAmountField.getText())){
				manager.deposit(Double.parseDouble(depositAmountField.getText()));
				manager.switchTo(ATM.HOME_VIEW);
			}else{
				try {			
					JOptionPane.showMessageDialog(
						manager.getViews(),
						"Invalid Depoist",
						"Error Try Again",
						JOptionPane.ERROR_MESSAGE);
				} catch (Exception _e) {
					_e.printStackTrace();
				}
			}
		}
		// TODO Fill in the rest of the possible functions
		
	}
}
