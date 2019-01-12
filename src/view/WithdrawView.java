package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;
import model.BankAccount;
import model.User;



public class WithdrawView  extends JPanel implements ActionListener{
	private ViewManager manager;
	private JButton exitButton;
	private JTextField withdrawAmountField;
	private JButton withdrawButton;
	

	public WithdrawView(ViewManager manager) {
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
		this.add(new javax.swing.JLabel("WithdrawView", javax.swing.SwingConstants.CENTER));
		initWithdrawAmount();
		initExitButton();
		initWithdrawButton();
	}


	private void initExitButton() {
		exitButton = new JButton("Exit");
		exitButton.setBounds(205, 460-20, 200, 35);
		exitButton.addActionListener(this);
	
		this.add(exitButton);
	}
	
	private void initWithdrawAmount() {
		JLabel label = new JLabel("Withdraw Amount.", SwingConstants.RIGHT);
		label.setBounds(100, 180-20, 95, 35);
		label.setLabelFor(withdrawAmountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		withdrawAmountField = new JTextField(20);
		withdrawAmountField.setBounds(205, 180-20, 200, 35);
		
		this.add(label);
		this.add(withdrawAmountField);
	}
	
	private void initWithdrawButton() {
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(205, 420-20, 200, 35);
		withdrawButton.addActionListener(this);
		
		this.add(withdrawButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if (source.equals(exitButton)) {
			manager.switchTo(ATM.HOME_VIEW);
		}
		// TODO Fill in the rest of the possible functions
		
	}
}
