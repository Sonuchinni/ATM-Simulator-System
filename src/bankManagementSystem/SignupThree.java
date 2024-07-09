package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.sql.*;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener{

	JRadioButton r1, r2, r3, r4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	String formno;
	
	SignupThree(String formno){
		
		this.formno = formno;
		setLayout(null);
		
		JLabel formNo = new JLabel("APPLICATION FORM NO. "+formno);
		formNo.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,38));
		formNo.setBounds(190, 10, 600, 40);
		add(formNo);
		
		JLabel accountDetails = new JLabel("Page 3 : ACCOUNT DETAILS");
		accountDetails.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,22));
		accountDetails.setBounds(260, 70, 400, 30);
		add(accountDetails);
		
		JLabel type = new JLabel("Account Type : ");
		type.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		type.setBounds(100, 140, 200, 30);
		add(type);
		
		r1 = new JRadioButton("Saving Account");
		r1.setBounds(100, 180, 150, 20);
		r1.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
		r1.setBackground(Color.WHITE);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setBounds(350, 180, 250, 20);
		r2.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
		r2.setBackground(Color.WHITE);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setBounds(100, 220, 250, 20);
		r3.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
		r3.setBackground(Color.WHITE);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setBounds(350, 220, 250, 20);
		r4.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
		r4.setBackground(Color.WHITE);
		add(r4);
		
		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		
		
		
		JLabel card = new JLabel("Card Number : ");
		card.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		card.setBounds(100, 300, 200, 30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
		number.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		number.setBounds(330, 300, 300, 30);
		add(number);
		
		JLabel carddetail = new JLabel("( Your 16 digit card number )");
		carddetail.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,12));
		carddetail.setBounds(85, 330, 300, 20);
		add(carddetail);
		
		
		
		
		JLabel pin = new JLabel("PIN : ");
		pin.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		pin.setBounds(140, 370, 200, 30);
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		pnumber.setBounds(330, 370, 300, 30);
		add(pnumber);
		
		JLabel pindetail = new JLabel("( Your 4 digit password )");
		pindetail.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,12));
		pindetail.setBounds(95, 400, 300, 20);
		add(pindetail);
		
		
		
		
		JLabel services = new JLabel("Services Required : ");
		services.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		services.setBounds(100, 450, 200, 30);
		add(services);
		
		c1 = new JCheckBox("ATM Card");
		c1.setBounds(100, 500, 200, 30);
		c1.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
		c1.setBackground(Color.WHITE);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBounds(350, 500, 200, 30);
		c2.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
		c2.setBackground(Color.WHITE);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBounds(100, 550, 200, 30);
		c3.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
		c3.setBackground(Color.WHITE);
		add(c3);
		
		c4 = new JCheckBox("Email & SMS Alerts");
		c4.setBounds(350, 550, 200, 30);
		c4.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
		c4.setBackground(Color.WHITE);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBounds(100, 600, 200, 30);
		c5.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
		c5.setBackground(Color.WHITE);
		add(c5);
		
		c6 = new JCheckBox("E - Statement");
		c6.setBounds(350, 600, 200, 30);
		c6.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
		c6.setBackground(Color.WHITE);
		add(c6);
		
		c7 = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge");
		c7.setBounds(100, 680, 600, 30);
		c7.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,13));
		c7.setBackground(Color.WHITE);
		add(c7);
		
		
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,14));
		submit.setBounds(250, 720, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,14));
		cancel.setBounds(420, 720, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,820);
		setVisible(true);
		setLocation(350,10);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == submit) {
			
			String accountType = null;
			if(r1.isSelected()) {
				accountType = "Saving Account";
			}else if(r2.isSelected()) {
				accountType = "Fixed Deposit Account";
			}else if(r3.isSelected()) {
				accountType = "Current Account";
			}else if(r4.isSelected()) {
				accountType = "Recurring Deposit Account";
			}
			
			Random random = new Random();
			String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
//			String cardnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			
			String facility = "";
			if(c1.isSelected()) {
				facility = facility + " ATM Card";
			}else if(c2.isSelected()) {
				facility = facility + " Internet Banking";
			}else if(c3.isSelected()) {
				facility = facility + " Mobile Banking";
			}else if(c4.isSelected()) {
				facility = facility + " Email & SMS Alerts";
			}else if(c5.isSelected()) {
				facility = facility + " Cheque Book";
			}else if(c6.isSelected()) {
				facility = facility + " E - Statement";
			}
			
			try {
				
		    	if(accountType.equals("")){
		    		JOptionPane.showMessageDialog(null, "Fill all the required fields");
		    	}else {
		    		conn c = new conn();
		            String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
		            String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
		            c.s.executeUpdate(query1);
		            c.s.executeUpdate(query2);
		            
		            JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: "+ pinnumber);
		            
		            setVisible(false);
		            new Deposit(pinnumber).setVisible(false);
		    	}
		    	
			} catch (Exception e) {
				
				System.out.println(e);
				
			}
			
			
		}else if(ae.getSource() == cancel) {
			
			setVisible(false);
			new Login().setVisible(true);
			
		}
		
	}
	
	public static void main(String args[]) {
		new SignupThree("");
	}
}
