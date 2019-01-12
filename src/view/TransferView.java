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
		label.setBounds(100, 180-20, 95, 35);
		label.setLabelFor(transferAmountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		transferAmountField = new JTextField(20);
		transferAmountField.setBounds(205, 180-20, 200, 35);
		
		this.add(label);
		this.add(transferAmountField);
	}
	
	private void initTargetAccountField() {
		JLabel label = new JLabel("Target Account Number", SwingConstants.RIGHT);
		label.setBounds(100, 220-20, 95, 35);
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
