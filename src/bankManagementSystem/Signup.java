package bankManagementSystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Signup extends JFrame implements ActionListener{
	
	long random;
	
	JTextField nameText,fnameText,emailText,addText,cityText,stateText,pinText;
	JButton next;
	JDateChooser dateChooser;
	JRadioButton male,fmale,other,married,unmarried;
	
	Signup(){
		
		setLayout(null);
		setTitle("New Account Application Form : Page-1");
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
		formno.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,38));
		formno.setBounds(170, 10, 600, 40);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1 : PERSONAL DETAILS");
		personalDetails.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,22));
		personalDetails.setBounds(260, 70, 400, 30);
		add(personalDetails);
		
		JLabel name = new JLabel("Name : ");
		name.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameText = new JTextField();
		nameText.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,14));
		nameText.setBounds(300, 140, 400, 30);
		add(nameText);
		
		JLabel fname = new JLabel("Father's Name : ");
		fname.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		fnameText = new JTextField();
		fnameText.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,14));
		fnameText.setBounds(300, 190, 400, 30);
		add(fnameText);
		
		JLabel dob = new JLabel("Date of Birth : ");
		dob.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender : ");
		gender.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		fmale = new JRadioButton("Female");
		fmale.setBounds(450, 290, 80, 30);
		fmale.setBackground(Color.WHITE);
		add(fmale);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(fmale);
		
		JLabel email = new JLabel("Email : ");
		email.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,14));
		emailText.setBounds(300, 340, 400, 30);
		add(emailText);
		
		JLabel marital = new JLabel("Marital Status : ");
		marital.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 390, 100, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(630, 390, 100, 30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);
		
		JLabel address = new JLabel("Address : ");
		address.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		addText = new JTextField();
		addText.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,14));
		addText.setBounds(300, 440, 400, 30);
		add(addText);
		
		JLabel city = new JLabel("City : ");
		city.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		cityText = new JTextField();
		cityText.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,14));
		cityText.setBounds(300, 490, 400, 30);
		add(cityText);
		
		JLabel state = new JLabel("State : ");
		state.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		stateText = new JTextField();
		stateText.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,14));
		stateText.setBounds(300, 540, 400, 30);
		add(stateText);
		
		JLabel pincode = new JLabel("Pincode : ");
		pincode.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		pinText = new JTextField();
		pinText.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,14));
		pinText.setBounds(300, 590, 400, 30);
		add(pinText);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800);
		setVisible(true);
		setLocation(350,10);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String formno = "" + random;
        String name = nameText.getText();
	    String fname = fnameText.getText();
	    String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
	    String gender = null;
	    if(male.isSelected()){ 
	        gender = "Male";
	    }else if(fmale.isSelected()){ 
	        gender = "Female";
	    }
	          
	    String email = emailText.getText();
	    String marital = null;
	    if(married.isSelected()){ 
	        marital = "Married";
	    }else if(unmarried.isSelected()){ 
	        marital = "Unmarried";
	    }else if(other.isSelected()){ 
	        marital = "Other";
	    }
	         
	    String address = addText.getText();
	    String city = cityText.getText();
	    String pincode = pinText.getText();
	    String state = stateText.getText();
			
	    try {
			
	    	if(nameText.getText().equals("")){
	    		JOptionPane.showMessageDialog(null, "Fill all the required fields");
	    	}else {
	    		conn c = new conn();
	            String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
	            c.s.executeUpdate(query);
	            
	            setVisible(false);
	            new SignupTwo(formno).setVisible(true);
	    	}
	    	
	    	
          
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
	    
	}
	
	public static void main(String args[]) {
		new Signup();
	}
}

//public class Signup extends JFrame {
//    
//    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
//    JTextField t1,t2,t3,t4,t5,t6,t7;
//    JRadioButton r1,r2,r3,r4,r5;
//    JButton b;
//    JDateChooser dateChooser;
//    
//    
//    Random ran = new Random();
//    long first4 = (ran.nextLong() % 9000L) + 1000L;
//    String first = "" + Math.abs(first4);
//    
//    Signup(){
//        
//        setTitle("NEW ACCOUNT APPLICATION FORM");
//        
//        
//        l1 = new JLabel("APPLICATION FORM NO. "+first);
//        l1.setFont(new Font("Raleway", Font.BOLD, 38));
//        
//        l2 = new JLabel("Page 1: Personal Details");
//        l2.setFont(new Font("Raleway", Font.BOLD, 22));
//        
//        l3 = new JLabel("Name:");
//        l3.setFont(new Font("Raleway", Font.BOLD, 20));
//        
//        l4 = new JLabel("Father's Name:");
//        l4.setFont(new Font("Raleway", Font.BOLD, 20));
//        
//        l5 = new JLabel("Date of Birth:");
//        l5.setFont(new Font("Raleway", Font.BOLD, 20));
//        
//        l6 = new JLabel("Gender:");
//        l6.setFont(new Font("Raleway", Font.BOLD, 20));
//        
//        l7 = new JLabel("Email Address:");
//        l7.setFont(new Font("Raleway", Font.BOLD, 20));
//        
//        l8 = new JLabel("Marital Status:");
//        l8.setFont(new Font("Raleway", Font.BOLD, 20));
//        
//        l9 = new JLabel("Address:");
//        l9.setFont(new Font("Raleway", Font.BOLD, 20));
//        
//        l10 = new JLabel("City:");
//        l10.setFont(new Font("Raleway", Font.BOLD, 20));
//        
//        l11 = new JLabel("Pin Code:");
//        l11.setFont(new Font("Raleway", Font.BOLD, 20));
//        
//        l12 = new JLabel("State:");
//        l12.setFont(new Font("Raleway", Font.BOLD, 20));
//        
//        l13 = new JLabel("Date");
//        l13.setFont(new Font("Raleway", Font.BOLD, 14));
//        
//        l14 = new JLabel("Month");
//        l14.setFont(new Font("Raleway", Font.BOLD, 14));
//        
//        l15 = new JLabel("Year");
//        l15.setFont(new Font("Raleway", Font.BOLD, 14));
//        
//        
//        t1 = new JTextField();
//        t1.setFont(new Font("Raleway", Font.BOLD, 14));
//        
//        t2 = new JTextField();
//        t2.setFont(new Font("Raleway", Font.BOLD, 14));
//        
//        t3 = new JTextField();
//        t3.setFont(new Font("Raleway", Font.BOLD, 14));
//        
//        t4 = new JTextField();
//        t4.setFont(new Font("Raleway", Font.BOLD, 14));
//        
//        t5 = new JTextField();
//        t5.setFont(new Font("Raleway", Font.BOLD, 14));
//        
//        t6 = new JTextField();
//        t6.setFont(new Font("Raleway", Font.BOLD, 14));
//        
//        t7 = new JTextField();
//        t7.setFont(new Font("Raleway", Font.BOLD, 14));
//        
//       
//        
//        b = new JButton("Next");
//        b.setFont(new Font("Raleway", Font.BOLD, 14));
//        b.setBackground(Color.BLACK);
//        b.setForeground(Color.WHITE);
//        
//        r1 = new JRadioButton("Male");
//        r1.setFont(new Font("Raleway", Font.BOLD, 14));
//        r1.setBackground(Color.WHITE);
//        
//        r2 = new JRadioButton("Female");
//        r2.setFont(new Font("Raleway", Font.BOLD, 14));
//        r2.setBackground(Color.WHITE);
//        
//        ButtonGroup groupgender = new ButtonGroup();
//        groupgender.add(r1);
//        groupgender.add(r2);
//        
//        r3 = new JRadioButton("Married");
//        r3.setFont(new Font("Raleway", Font.BOLD, 14));
//        r3.setBackground(Color.WHITE);
//        
//        r4 = new JRadioButton("Unmarried");
//        r4.setFont(new Font("Raleway", Font.BOLD, 14));
//        r4.setBackground(Color.WHITE);
//        
//        r5 = new JRadioButton("Other");
//        r5.setFont(new Font("Raleway", Font.BOLD, 14));
//        r5.setBackground(Color.WHITE);
//        
//        ButtonGroup groupstatus = new ButtonGroup();
//        groupstatus.add(r3);
//        groupstatus.add(r4);
//        groupstatus.add(r5);
//        
//        dateChooser = new JDateChooser();
//	//dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//	dateChooser.setForeground(new Color(105, 105, 105));
//	dateChooser.setBounds(137, 337, 200, 29);
//	add(dateChooser);
//        
//        setLayout(null);
//        l1.setBounds(140,20,600,40);
//        add(l1);
//        
//        l2.setBounds(290,80,600,30);
//        add(l2);
//        
//        l3.setBounds(100,140,100,30);
//        add(l3);
//        
//        t1.setBounds(300,140,400,30);
//        add(t1);
//        
//        l4.setBounds(100,190,200,30);
//        add(l4);
//        
//        t2.setBounds(300,190,400,30);
//        add(t2);
//        
//        l5.setBounds(100,240,200,30);
//        add(l5);
//        
//        dateChooser.setBounds(300, 240, 400, 30);
//        
//        l6.setBounds(100,290,200,30);
//        add(l6);
//        
//        r1.setBounds(300,290,60,30);
//        add(r1);
//        
//        r2.setBounds(450,290,90,30);
//        add(r2);
//        
//        l7.setBounds(100,340,200,30);
//        add(l7);
//        
//        t3.setBounds(300,340,400,30);
//        add(t3);
//        
//        l8.setBounds(100,390,200,30);
//        add(l8);
//        
//        r3.setBounds(300,390,100,30);
//        add(r3);
//        
//        r4.setBounds(450,390,100,30);
//        add(r4);
//        
//        r5.setBounds(635,390,100,30);
//        add(r5);
//        
//        
//        
//        l9.setBounds(100,440,200,30);
//        add(l9);
//        
//        t4.setBounds(300,440,400,30);
//        add(t4);
//        
//        l10.setBounds(100,490,200,30);
//        add(l10);
//        
//        t5.setBounds(300,490,400,30);
//        add(t5);
//        
//        l11.setBounds(100,540,200,30);
//        add(l11);
//        
//        t6.setBounds(300,540,400,30);
//        add(t6);
//        
//        l12.setBounds(100,590,200,30);
//        add(l12);
//        
//        t7.setBounds(300,590,400,30);
//        add(t7);
//        
//        b.setBounds(620,660,80,30);
//        add(b);
//        
////        b.addActionListener(this); 
////        
//        getContentPane().setBackground(Color.WHITE);
//        
//        setSize(850,800);
//        setLocation(500,120);
//        setVisible(true);
//    }
    
//    public void actionPerformed(ActionEvent ae){
//        
//        String formno = first;
//        String name = t1.getText();
//        String fname = t2.getText();
//        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
//        String gender = null;
//        if(r1.isSelected()){ 
//            gender = "Male";
//        }else if(r2.isSelected()){ 
//            gender = "Female";
//        }
//            
//        String email = t3.getText();
//        String marital = null;
//        if(r3.isSelected()){ 
//            marital = "Married";
//        }else if(r4.isSelected()){ 
//            marital = "Unmarried";
//        }else if(r5.isSelected()){ 
//            marital = "Other";
//        }
//           
//        String address = t4.getText();
//        String city = t5.getText();
//        String pincode = t6.getText();
//        String state = t7.getText();
        

//        try{
//           
//            if(t6.getText().equals("")){
//                JOptionPane.showMessageDialog(null, "Fill all the required fields");
//            }else{
//                Conn c1 = new Conn();
//                String q1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
//                c1.s.executeUpdate(q1);
//                
//                new Signup2(first).setVisible(true);
//                setVisible(false);
//            }
//            
//        }catch(Exception e){
//             e.printStackTrace();
//        }
        
//    }
    
    
//    public static void main(String[] args){
//        new Signup().setVisible(true);
//    }
//}

