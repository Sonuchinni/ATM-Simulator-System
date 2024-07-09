package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{

	JButton deposit, withdrawl, fastCash, miniStatement, pinChange, balanceenquiry, exit;
	String pinnumber;
	
	FastCash(String pinnumber){
		
		this.pinnumber = pinnumber;
		setLayout(null);
		
//		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l2 = new JLabel(i3);
//        l2.setBounds(0, 0, 960, 1080);
//        add(l2);
        
        JLabel text = new JLabel("Select withdrawl Amount");
        text.setForeground(Color.black);
        text.setBounds(100, 10, 4000, 200);
        text.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,30));
        add(text);
		
        
        deposit = new JButton("100");
        deposit.setBounds(50, 200, 250, 50);
        deposit.addActionListener(this);
        add(deposit);
        
        withdrawl = new JButton("500");
        withdrawl.setBounds(320, 200, 250, 50);
        withdrawl.addActionListener(this);
        add(withdrawl);
        
        fastCash = new JButton("1000");
        fastCash.setBounds(590, 200, 250, 50);
        fastCash.addActionListener(this);
        add(fastCash);
        
        miniStatement = new JButton("2000");
        miniStatement.setBounds(50, 300, 250, 50);
        miniStatement.addActionListener(this);
        add(miniStatement);
        
        pinChange = new JButton("5000");
        pinChange.setBounds(320, 300, 250, 50);
        pinChange.addActionListener(this);
        add(pinChange);
        
        balanceenquiry = new JButton("10000");
        balanceenquiry.setBounds(590, 300, 250, 50);
        balanceenquiry.addActionListener(this);
        add(balanceenquiry);
        
        exit = new JButton("Back");
        exit.setBounds(320, 400, 250, 50);
        exit.addActionListener(this);
        add(exit);
        
        
		getContentPane().setBackground(Color.WHITE);
		
		setSize(900,900);
		setVisible(true);
		
		setLocation(300, 0);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == exit) {
			
			setVisible(false);
    		new Transactions(pinnumber).setVisible(true);
			
		}else {
			
			String amount = ((JButton)ae.getSource()).getText();
			conn c = new conn();
			
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance = 0;
				
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				if(ae.getSource() != exit && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient balance");
					return;
				}
				Date date = new Date();
				String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited successsfully");
				
				setVisible(false);
	    		new Transactions(pinnumber).setVisible(true);
				
			}catch (Exception e) {
    			
    			System.out.println(e);
    			
    		}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FastCash("");
	}

}
