package bankManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class Withdrawl extends JFrame implements ActionListener{

	JTextField amount;
	JButton withdraw,back;
	String pinnumber;
	
	Withdrawl(String pinnumber){
		
		this.pinnumber = pinnumber;
		setLayout(null);
		
		JLabel text = new JLabel("Enter the amount you want to withdraw");
		text.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,30));
		text.setBounds(100, 10, 4000, 200);
		add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,22));
		amount.setBounds(100, 180, 400, 50);
		add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(515, 180, 150, 50);
		withdraw.addActionListener(this);
		add(withdraw);
		
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
		
		if(ae.getSource() == withdraw) {
			
			String number = amount.getText();
			Date date = new Date();
			
			if(number.equals("")) {
				
				JOptionPane.showMessageDialog(null, "Please enter the number you want to withdraw");
				
			}else {
				try {
					
					conn c = new conn();
					
					 ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
	                    int balance = 0;
	                    while(rs.next()){
	                       if(rs.getString("type").equals("Deposit")){
	                           balance += Integer.parseInt(rs.getString("amount"));
	                       }else{
	                           balance -= Integer.parseInt(rs.getString("amount"));
	                       }
	                    }
	                    if(ae.getSource() != back && balance < Integer.parseInt(number)){
	                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
	                        return;
	                    }
	                    
	                    
		            String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
		            c.s.executeUpdate(query);
		            JOptionPane.showMessageDialog(null, "Rs " + number + " withdrew successfully");
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
		
		new Withdrawl("");
	}

}
