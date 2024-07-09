package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignupTwo extends JFrame implements ActionListener{
	
	
	JTextField nameText,fnameText,emailText,addText,cityText,stateText,pinText,pan,aadhar;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	JComboBox religion,category,income,education,occupation;
	String formno;
	
	SignupTwo(String formno){
		
		this.formno = formno;
		setLayout(null);
		setTitle("New Account Application Form : Page-2");
		
		JLabel formNo = new JLabel("APPLICATION FORM NO. "+formno);
		formNo.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,38));
		formNo.setBounds(170, 10, 600, 40);
		add(formNo);
		
		JLabel additionalDetails = new JLabel("Page 2 : ADDITIONAL DETAILS");
		additionalDetails.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,22));
		additionalDetails.setBounds(260, 70, 400, 30);
		add(additionalDetails);
		
		
		
		
		JLabel name = new JLabel("Religion : ");
		name.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		String valreligion[] = {"Hindu", "Christian","Muslim","Budhism","Sikh","Other"};
		religion = new JComboBox(valreligion);
		religion .setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion );
		
		
		
		
		JLabel fname = new JLabel("Category : ");
		fname.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		String valcategory[] = {"General", "OBC","SC","ST","Other"};
		category = new JComboBox(valcategory);
		category .setBounds(300, 190, 400, 30);
		category.setBackground(Color.WHITE);
		add(category);
		
		
		
		
		JLabel dob = new JLabel("Income : ");
		dob.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		String valincome[] = {"Null", "< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
		income = new JComboBox(valincome);
		income .setBounds(300, 240, 400, 30);
		income.setBackground(Color.WHITE);
		add(income);
		
		
		
		
		JLabel gender = new JLabel("Educational ");
		gender.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		JLabel email = new JLabel("Qualification : ");
		email.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		email.setBounds(100, 315, 200, 30);
		add(email);
		
		String valeq[] = {"Non - Graduate", "Graduate","Post - Graduate","Doctorate","Others"};
		education = new JComboBox(valeq);
		education .setBounds(300, 315, 400, 30);
		education.setBackground(Color.WHITE);
		add(education);
		
		
		
		
		JLabel marital = new JLabel("Occupation : ");
		marital.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		String valocc[] = {"Salaried", "Self-Employed","Business","Student","Retired","Others"};
		occupation = new JComboBox(valocc);
		occupation .setBounds(300, 390, 400, 30);
		occupation.setBackground(Color.WHITE);
		add(occupation);
		
		
		
		
		JLabel address = new JLabel("PAN Number : ");
		address.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		pan = new JTextField();
		pan.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);
		
		
		
		
		JLabel city = new JLabel("Aadhar Number : ");
		city.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		aadhar = new JTextField();
		aadhar.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,14));
		aadhar.setBounds(300, 490, 400, 30);
		add(aadhar);
		
		
		
		
		JLabel state = new JLabel("Senior Citizen: ");
		state.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 60, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450, 540, 80, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup seniorGroup = new ButtonGroup();
		seniorGroup.add(syes);
		seniorGroup.add(sno);
		
		
		
		
		JLabel pincode = new JLabel("Existing Account : ");
		pincode.setFont(new Font("Bookman Old Style",Font.ROMAN_BASELINE,20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 60, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(450, 590, 80, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup existingGroup = new ButtonGroup();
		existingGroup.add(eyes);
		existingGroup.add(eno);
		
		
		
		
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
		
		
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        
	    String seniorcitizen = null;
	    if(syes.isSelected()){ 
	    	seniorcitizen = "Yes";
	    }else if(sno.isSelected()){ 
	    	seniorcitizen = "No";
	    }
	          
	    String existingaccount = null;
	    if(eyes.isSelected()){ 
	    	existingaccount = "Yes";
	    }else if(eno.isSelected()){ 
	    	existingaccount = "No";
	    }
	         
	    String span = pan.getText();
	    String saadhar = aadhar.getText();
	    
			
	    try {
			
	    	
	    	conn c = new conn();
            String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
          
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
	    
	}
	
	public static void main(String args[]) {
		new SignupTwo("");
	}
}