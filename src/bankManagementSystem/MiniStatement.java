package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class MiniStatement extends JFrame{

	String pinnumber;
	
	MiniStatement(String pinnumber){
		
		this.pinnumber = pinnumber;
		setTitle("MINI STATEMENT");
		setLayout(null);
		
		JLabel mini = new JLabel();
		add(mini);
		
		JLabel bank = new JLabel("Indian Bank");
        bank.setForeground(Color.black);
        bank.setBounds(150, 20, 100, 20);
        bank.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
        add(bank);
        
        JLabel card = new JLabel();
        card.setForeground(Color.black);
        card.setBounds(20, 80, 300, 20);
        card.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,16));
        add(card);
		
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
			
			while(rs.next()) {
				card.setText("Card Number : " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
				
			}
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		try {
			conn c = new conn();
			int bal = 0;
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
				if(rs.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				}else {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your current account balance is Rs " + bal);
			
		}catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		mini.setBounds(20, 140, 400, 200);
        
		getContentPane().setBackground(Color.WHITE);
		
		setSize(400,600);
		setVisible(true);
		setLocation(20,20);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiniStatement("");
	}

}
