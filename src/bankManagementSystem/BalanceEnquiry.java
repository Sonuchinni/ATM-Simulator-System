package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener{

	JButton back;
	String pinnumber;
	
	BalanceEnquiry(String pinnumber){
		
		this.pinnumber = pinnumber;
		setLayout(null);
		
		back = new JButton("BACK");
	    back.setBounds(180, 150, 150, 30);
	    back.addActionListener(this);
	    add(back);
	    
	    conn c = new conn();
	    int balance = 0;
	    
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		JLabel text = new JLabel("Your current account balance is " + balance);
        text.setForeground(Color.black);
        text.setBounds(100, 10, 4000, 200);
        text.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
        add(text);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(900,900);
		setVisible(true);
		setLocation(300, 0);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalanceEnquiry("");
	}

}
