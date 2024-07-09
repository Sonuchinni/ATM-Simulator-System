package bankManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class Deposit extends JFrame implements ActionListener{

	JTextField amount;
	JButton deposit,back;
	String pinnumber;
	
	Deposit(String pinnumber){
		
		this.pinnumber = pinnumber;
		setLayout(null);
		
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,30));
		text.setBounds(100, 10, 4000, 200);
		add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,25));
		amount.setBounds(100, 180, 400, 50);
		add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(515, 180, 150, 50);
		deposit.addActionListener(this);
		add(deposit);
		
		back = new JButton("Back");
		back.setBounds(300, 300, 150, 50);
		back.addActionListener(this);
		add(back);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(900,900);
		setVisible(true);
		setLocation(300, 0);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == deposit) {
			
			String number = amount.getText();
			Date date = new Date();
			
			if(number.equals("")) {
				
				JOptionPane.showMessageDialog(null, "Please enter the number you want to deposit");
				
			}else {
				try {
					
					conn c = new conn();
		            String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
		            c.s.executeUpdate(query);
		            JOptionPane.showMessageDialog(null, "Rs " + number + "deposited successfully");
		            setVisible(false);
    	    		new Transactions(pinnumber).setVisible(true);
		            
				}catch (Exception e) {
	    			
	    			System.out.println(e);
	    			
	    		}
				
	            
			}
			
		}else if(ae.getSource() == back) {
			
			setVisible(false);
    		new Transactions(pinnumber).setVisible(true);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		new Deposit("");
	}

}
