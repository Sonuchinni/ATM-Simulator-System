package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class PinChange extends JFrame implements ActionListener{

	JButton change,back;
	JPasswordField pin,repin;
	String pinnumber;
	
	PinChange(String pinnumber){
		
		this.pinnumber = pinnumber;
		setLayout(null);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.black);
        text.setBounds(160, 10, 4000, 200);
        text.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,30));
        add(text);
        
        JLabel pintext = new JLabel("New PIN");
        pintext.setForeground(Color.black);
        pintext.setBounds(100, 200, 180, 25);
        pintext.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
        add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(330, 200, 180, 25);
        pin.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,25));
        add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.black);
        repintext.setBounds(100, 250, 200, 50);
        repintext.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
        add(repintext);
		
        repin = new JPasswordField();
        repin.setBounds(330, 265, 180, 25);
        repin.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,25));
        add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(130, 350, 150, 30);
        change.addActionListener(this);
        add(change);
        
        back = new JButton("BACK");
        back.setBounds(330, 350, 150, 30);
        back.addActionListener(this);
        add(back);
        
		getContentPane().setBackground(Color.WHITE);
		
		setSize(900,900);
		setVisible(true);
		
		setLocation(300, 0);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == change) {
			try {
				String npin = pin.getText();
				String rpin = repin.getText();
				
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered pin does not match");
					return;
				}
				
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter new pin");
					return;
				}
				
				if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re- enter new pin");
					return;
				}
				
				conn c = new conn();
				String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
				String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
				String query3 = "update SignupThree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				JOptionPane.showMessageDialog(null, "Pin changed successfully");
				
				setVisible(false);
	    		new Transactions(rpin).setVisible(true);
				
			}catch (Exception e) {
				
				System.out.println(e);
				
			}
		} else {
			setVisible(false);
    		new Transactions(pinnumber).setVisible(true);
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PinChange("").setVisible(true);
	}

}
