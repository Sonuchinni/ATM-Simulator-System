package bankManagementSystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;




public class Login extends JFrame implements ActionListener{
	
	JButton signIn, clear, signUp;
	JTextField CardTextField;
	JPasswordField pinTextField;
	
	Login(){
		
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		
		JLabel text = new JLabel("WELCOME TO ATM");
		text.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,40));
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		JLabel CardNo = new JLabel("Card No : ");
		CardNo.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		CardNo.setBounds(160, 150, 250, 40);
		add(CardNo);
		
		CardTextField = new JTextField();
		CardTextField.setBounds(300, 157, 230, 30);
		add(CardTextField);
		
		JLabel pin = new JLabel("PIN : ");
		pin.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		pin.setBounds(175, 220, 250, 30);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 230, 30);
		add(pinTextField);
		
		signIn = new JButton("Sign In");
		signIn.setBounds(300, 300, 100, 30);
		signIn.setBackground(Color.BLACK);
		signIn.setForeground(Color.WHITE);
		signIn.addActionListener(this);
		add(signIn);
		
		clear = new JButton("Clear");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signUp = new JButton("Sign Up");
		signUp.setBounds(300, 350, 230, 30);
		signUp.setBackground(Color.BLACK);
		signUp.setForeground(Color.WHITE);
		signUp.addActionListener(this);
		add(signUp);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == signIn) {
			
			conn c = new conn();
			String cardnumber  = CardTextField.getText();
            String pinnumber  = pinTextField.getText();
            String query  = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            
            try {
    			
    	    	ResultSet rs = c.s.executeQuery(query);
    	    	if(rs.next()) {
    	    		
    	    		setVisible(false);
    	    		new Transactions(pinnumber).setVisible(true);
    	    		
    	    	}else {
    	    		JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
    	    	}
    	    	
              
    		} catch (Exception e) {
    			
    			System.out.println(e);
    			
    		}
			
		}else if(ae.getSource() == clear) {
			
			CardTextField.setText("");
			pinTextField.setText("");
			
		}else if(ae.getSource() == signUp) {
			
			setVisible(false);
            new Signup().setVisible(true);
			
		}
		
	}
	
	public static void main(String args[]) {
		new Login();
	}
}


