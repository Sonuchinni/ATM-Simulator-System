package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;


public class Transactions extends JFrame implements ActionListener{

	JButton deposit, withdrawl, fastCash, miniStatement, pinChange, balanceenquiry, exit;
	String pinnumber;
	
	Transactions(String pinnumber){
		
		this.pinnumber = pinnumber;
		setLayout(null);
		
//		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l2 = new JLabel(i3);
//        l2.setBounds(0, 0, 960, 1080);
//        add(l2);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setForeground(Color.black);
        text.setBounds(170, 150, 700, 25);
        text.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,40));
        add(text);
		
        
        deposit = new JButton("Deposit");
        deposit.setBounds(50, 270, 250, 50);
        deposit.addActionListener(this);
        add(deposit);
        
        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(320, 270, 250, 50);
        withdrawl.addActionListener(this);
        add(withdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(590, 270, 250, 50);
        fastCash.addActionListener(this);
        add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(50, 370, 250, 50);
        miniStatement.addActionListener(this);
        add(miniStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(320, 370, 250, 50);
        pinChange.addActionListener(this);
        add(pinChange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(590, 370, 250, 50);
        balanceenquiry.addActionListener(this);
        add(balanceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(320, 470, 250, 50);
        exit.addActionListener(this);
        add(exit);
        
        
		getContentPane().setBackground(Color.WHITE);
		
		setSize(900,900);
		setVisible(true);
		
		setLocation(300, 0);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == exit) {
			
			System.exit(0);
			
		}else if(ae.getSource() == deposit) {
			
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
			
		}else if(ae.getSource() == withdrawl) {
			
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
			
		}else if(ae.getSource() == fastCash) {
			
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
			
		}else if(ae.getSource() == pinChange) {
			
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
			
		}else if(ae.getSource() == balanceenquiry) {
			
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
			
		}else if(ae.getSource() == miniStatement) {
			
			new MiniStatement(pinnumber).setVisible(true);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Transactions("");
	}

}
