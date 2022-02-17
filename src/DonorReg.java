import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DonorReg extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldcheckAge;
	private JTextField textFieldCheckWeight;
	private JTextField textFieldname;
	private JTextField textFielddonorID;
	private JTextField textFieldLandNo;
	private JTextField textFieldAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldNIC;
	private JTextField textFieldMobileNo;
	private JLabel show_age_validation;
	private JLabel Show_validation_weight;
	public JDateChooser  dateChooser;                          //  Date chooser Format
	private JPanel panel2;
	private  JComboBox<String> comboBoxDiaseases;
	private JComboBox<String> comboBoxGender;
	private  JComboBox<String> comboBoxBloodGroup;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorReg frame = new DonorReg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 */
	
	public DonorReg() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
//				if (Integer.parseInt(textFieldcheckAge.getText())<18) {
//					panel2.setVisible(false);
//				}
//				
//				else if (Integer.parseInt(textFieldCheckWeight.getText())<50) {
//					panel2.setVisible(false);
//				}
//				else if (comboBoxDiaseases.getSelectedItem().toString().equals("Yes")) {
//					panel2.setVisible(false);
//			
//				}
//				else {
//					panel2.setVisible(true);
//				}
//				
				panel2.setVisible(false);				
				}
		});
		initialize(); 
		
		comboBoxDiaseases.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (Integer.parseInt(textFieldcheckAge.getText())<18) {
				panel2.setVisible(false);
				JOptionPane.showMessageDialog(null, "Age should be greater than 18 to register as a Donor"); 
			}
			
			else if (Integer.parseInt(textFieldCheckWeight.getText())<50) {
				panel2.setVisible(false);
				JOptionPane.showMessageDialog(null, "Weight should be greater than 50 to register as a Donor"); 
			}
			else if (comboBoxDiaseases.getSelectedItem().toString().equals("Yes")) {
				panel2.setVisible(false);
				JOptionPane.showMessageDialog(null, "Deaseases should be 'No' to register as a Donor"); 
		
			}
			else {
				panel2.setVisible(true);
			}
				
			}
		});
	 }
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 787);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(219, 112, 147));
		panel1.setBounds(0, 10, 963, 750);
		contentPane.add(panel1);
		
		JPanel panelcheckheightwidth = new JPanel();
		panelcheckheightwidth.setLayout(null);
		panelcheckheightwidth.setBounds(10, 10, 403, 246);
		panel1.add(panelcheckheightwidth);
		
		JLabel lblAge = new JLabel("Age ");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAge.setBounds(32, 61, 45, 30);
		panelcheckheightwidth.add(lblAge);
		
		JLabel lblweight = new JLabel("Weight");
		lblweight.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblweight.setBounds(32, 124, 78, 30);
		panelcheckheightwidth.add(lblweight);
		
		JLabel lblcheck = new JLabel("Enter the Donor's Age and Weight in Here");
		lblcheck.setForeground(new Color(0, 0, 153));
		lblcheck.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcheck.setBounds(45, 21, 348, 30);
		panelcheckheightwidth.add(lblcheck);
		
		textFieldcheckAge = new JTextField();
		textFieldcheckAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldcheckAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				try {
					int i=Integer.parseInt(textFieldcheckAge.getText());
					show_age_validation.setText("");
					
					
				}catch (NumberFormatException e1) {
					show_age_validation.setText("Invalid Numder");
					
				}
			}
		});
	
		textFieldcheckAge.setColumns(10);
		textFieldcheckAge.setBounds(166, 66, 214, 30);
		panelcheckheightwidth.add(textFieldcheckAge);
		
		textFieldCheckWeight = new JTextField();
		textFieldCheckWeight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCheckWeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					int j=Integer.parseInt(textFieldCheckWeight.getText());
				
					Show_validation_weight.setText("") ;
					
					
				}catch (NumberFormatException e2) {
					Show_validation_weight.setText("Invalid Numder");	
				}
				
			}
		});
		textFieldCheckWeight.setColumns(10);
		textFieldCheckWeight.setBounds(166, 124, 214, 30);
		panelcheckheightwidth.add(textFieldCheckWeight);
		
		JLabel lblDeasese = new JLabel("Diaseases");
		lblDeasese.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDeasese.setBounds(32, 181, 102, 30);
		panelcheckheightwidth.add(lblDeasese);
		
		comboBoxDiaseases = new JComboBox<String>();
		comboBoxDiaseases.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxDiaseases.addItem("");
		comboBoxDiaseases.addItem("Yes");
		comboBoxDiaseases.addItem("No");
		comboBoxDiaseases.setBounds(166, 185, 214, 30);
		panelcheckheightwidth.add(comboBoxDiaseases);
		
		JLabel lblNewLabel_2 = new JLabel("Yrs");
		lblNewLabel_2.setBounds(80, 74, 45, 13);
		panelcheckheightwidth.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("(Kg)");
		lblNewLabel_3.setBounds(111, 137, 45, 13);
		panelcheckheightwidth.add(lblNewLabel_3);
		
		show_age_validation = new JLabel("");
		show_age_validation.setBounds(144, 101, 214, 13);
		panelcheckheightwidth.add(show_age_validation);
		
		Show_validation_weight = new JLabel("");
		Show_validation_weight.setBounds(144, 157, 214, 13);
		panelcheckheightwidth.add(Show_validation_weight);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Donor.png"));
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(92, 300, 244, 246);
		panel1.add(lblNewLabel_1);
		
		panel2 = new JPanel();
		panel2.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				
				
			}
		});
		panel2.setLayout(null);
		panel2.setBackground(SystemColor.controlDkShadow);
		panel2.setBounds(423, -19, 543, 798);
		panel1.add(panel2);
		
		JLabel lblNewLabel = new JLabel("DONOR REGISTRATION");
		lblNewLabel.setForeground(new Color(72, 209, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(132, 10, 339, 63);
		panel2.add(lblNewLabel);
		
		JLabel lblDonorid = new JLabel("Donor ID");
		lblDonorid.setForeground(Color.WHITE);
		lblDonorid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDonorid.setBounds(38, 137, 118, 45);
		panel2.add(lblDonorid);
		
		textFieldname = new JTextField();
		textFieldname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldname.setColumns(10);
		textFieldname.setBounds(206, 90, 303, 37);
		panel2.add(textFieldname);
		
		JLabel lblDonorname = new JLabel("Name");
		lblDonorname.setForeground(Color.WHITE);
		lblDonorname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDonorname.setBounds(38, 90, 118, 37);
		panel2.add(lblDonorname);
		
		textFielddonorID = new JTextField();
		textFielddonorID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFielddonorID.setColumns(10);
		textFielddonorID.setBounds(206, 138, 303, 37);
		panel2.add(textFielddonorID);
		
		JLabel lblPhoneNo = new JLabel("Mobile No");
		lblPhoneNo.setForeground(Color.WHITE);
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhoneNo.setBounds(38, 185, 118, 37);
		panel2.add(lblPhoneNo);
		
		textFieldLandNo = new JTextField();
		textFieldLandNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldLandNo.setColumns(10);
		textFieldLandNo.setBounds(206, 235, 303, 38);
		panel2.add(textFieldLandNo);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(38, 543, 118, 37);
		panel2.add(lblGender);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(206, 283, 303, 90);
		panel2.add(textFieldAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(38, 305, 118, 37);
		panel2.add(lblAddress);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(206, 383, 303, 37);
		panel2.add(textFieldEmail);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setForeground(Color.WHITE);
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblemail.setBounds(38, 383, 118, 37);
		panel2.add(lblemail);
		
		textFieldNIC = new JTextField();
		textFieldNIC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNIC.setColumns(10);
		textFieldNIC.setBounds(206, 430, 303, 39);
		panel2.add(textFieldNIC);
		
		JLabel lblNic = new JLabel("NIC");
		lblNic.setForeground(Color.WHITE);
		lblNic.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNic.setBounds(38, 430, 118, 37);
		panel2.add(lblNic);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setForeground(Color.WHITE);
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBloodGroup.setBounds(38, 590, 145, 37);
		panel2.add(lblBloodGroup);
		
		textFieldMobileNo = new JTextField();
		textFieldMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldMobileNo.setColumns(10);
		textFieldMobileNo.setBounds(206, 185, 303, 38);
		panel2.add(textFieldMobileNo);
		
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBackground(Color.BLUE);
		btnClear.setBounds(313, 672, 130, 45);
		panel2.add(btnClear);
		
		JLabel lblLandNo = new JLabel("Land No");
		lblLandNo.setForeground(Color.WHITE);
		lblLandNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLandNo.setBounds(38, 236, 118, 37);
		panel2.add(lblLandNo);
		
		JLabel lblDOB = new JLabel("DOB");
		lblDOB.setForeground(Color.WHITE);
		lblDOB.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDOB.setBounds(38, 496, 118, 37);
		panel2.add(lblDOB);
		
		comboBoxGender = new JComboBox<String>();
		comboBoxGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxGender.addItem("");
		comboBoxGender.addItem("Male");
		comboBoxGender.addItem("Female");
		comboBoxGender.setBounds(206, 535, 303, 37);
		panel2.add(comboBoxGender);
		
		comboBoxBloodGroup = new JComboBox<String>();
		comboBoxBloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxBloodGroup.addItem("");
		comboBoxBloodGroup.addItem("A+");
		comboBoxBloodGroup.addItem("A-");
		comboBoxBloodGroup.addItem("B+");
		comboBoxBloodGroup.addItem("B-");
		comboBoxBloodGroup.addItem("O+");
		comboBoxBloodGroup.addItem("O-");
		comboBoxBloodGroup.addItem("AB+");
		comboBoxBloodGroup.addItem("AB-");
		comboBoxBloodGroup.setBounds(206, 582, 303, 37);
		panel2.add(comboBoxBloodGroup);
		
		dateChooser = new JDateChooser();						//  Date chooser Format
		dateChooser.setBounds(206, 479, 303, 46);
		panel2.add(dateChooser);
		
		JButton btnclear = new JButton("BACK");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonorMain wlm = new DonorMain();
				wlm.setVisible(true);
				dispose();
			}
		});
		btnclear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnclear.setBackground(new Color(128, 0, 0));
		btnclear.setBounds(128, 645, 130, 45);
		panel1.add(btnclear);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBackground(Color.BLUE);
		btnAdd.setBounds(49, 672, 130, 45);
		panel2.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (RegisterData()) { 
					
					 } 	
				
			}
		
	});
	}
			private boolean RegisterData() {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");   //  Date chooser Format
				
				 String lblAge  =   textFieldcheckAge.getText(); 
				 String lblweight  =   textFieldCheckWeight.getText(); 
				 String lblDeasese  =   comboBoxDiaseases.getSelectedItem().toString(); 
				 String lblDonorname  =   textFieldname.getText(); 
				 String lblDonorid =   textFielddonorID.getText(); 
				String lblPhoneNo =   textFieldMobileNo.getText(); 
				String lblLandNo = textFieldLandNo.getText();
				 String lblAddress =   textFieldAddress.getText(); 
				 String lblemail =  textFieldEmail.getText();
				 String lblNic =  textFieldNIC.getText();
				 String lblDOB =(df.format(dateChooser.getDate()));		//  Date chooser Format
				 String lblGender =   comboBoxGender.getSelectedItem().toString();
				 String lblBloodGroup = comboBoxBloodGroup.getSelectedItem().toString();
				 
				 
				 if (lblDonorname.equals("")) { 
					 JOptionPane.showMessageDialog(null, "Please Input (Username)"); 
					 
					 return false; 
				 	}
				
				 if (lblDonorid.equals("")) { 
					 JOptionPane.showMessageDialog(null, "Please Input (Donor ID)"); 
					 
					 return false; 
				 	}
				 if (lblPhoneNo.equals("")) { 
					 JOptionPane.showMessageDialog(null, "Please Input (Phone NO)"); 
					 
					 return false; 
				 	}
				 
				 if (lblAddress.equals("")) { 
					 JOptionPane.showMessageDialog(null, "Please Input (Address)"); 
					 
					 return false; 
				 	}
				 
				 if (lblemail.equals("")) { 
					 JOptionPane.showMessageDialog(null, "Please Input (Email)"); 
					 
					 return false; 
				 	}
				 
				 if (lblNic.equals("")) { 
					 JOptionPane.showMessageDialog(null, "Please Input (NIC)"); 
					 
					 return false; 
				 	}
				 if (lblDOB.equals("")) { 
					 JOptionPane.showMessageDialog(null, "Please Select your (DOB)"); 
					 
					 return false; 
				 	}
				 if (lblGender.equals("")) { 
					 JOptionPane.showMessageDialog(null, "Please Select your (Gender)"); 
					 
					 return false; 
				 	}
				 if (lblBloodGroup.equals("")) { 
					 JOptionPane.showMessageDialog(null, "Please Select your (BloodGroup)"); 
					 
					 return false; 
				 	}
				 
				 
				 Connection connect = null; 
				 java.sql.Statement s = null; 
				 Boolean status = false;
				 try { 
					 Class.forName("com.mysql.jdbc.Driver"); 
					 connect =DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/BBMS" + "?user=root&password="); 
					 s = connect.createStatement();
					 
					 String sql = "INSERT INTO donor " + "(Name,DonorID,PhoneNo1,PhoneNo2,Address,Email,NIC,DOB,Age,Weight,Diaseases,Gender,BloodGroup) " + "VALUES ('"+ lblDonorname + "','" + lblDonorid	+ "','"+ lblPhoneNo + "','" + lblLandNo+ "','" + lblAddress + "','" + lblemail + "','" + lblNic + "','" + lblDOB + "','" + lblAge  + "','" + lblweight  + "','" + lblDeasese   + "','" + lblGender    + "','" + lblBloodGroup  + "') "; 
					 s.execute(sql); 
					 textFieldname.setText(""); 
					 textFielddonorID.setText(""); 
					 textFieldMobileNo.setText(""); 
					 textFieldLandNo.setText(""); 
					 textFieldAddress.setText(""); 
					 textFieldEmail.setText(""); 
					 textFieldNIC.setText(""); 
					// textFieldcheckAge.setText(""); 
					// textFieldCheckWeight.setText("");
					 comboBoxGender.setSelectedItem(""); 
					 comboBoxBloodGroup.setSelectedItem(""); 
					 comboBoxDiaseases.setSelectedItem("");
					 panel2.setVisible(false);
					
				     status = true; 
					 
				     JOptionPane.showMessageDialog(null, "Register New user successfully");
					 
					 } catch (Exception e) { // TODO Auto-generated catch block
					 JOptionPane.showMessageDialog(null, e.getMessage()); 
					 e.printStackTrace(); 
					 } 
					 try { 
					 if (s != null) { 
					 s.close(); 
					 connect.close(); 
					 } 
					 } catch (SQLException e) { // TODO Auto-generated catch block
					 System.out.println(e.getMessage()); 
					 e.printStackTrace(); 
					 } 
				
				// TODO Auto-generated method stub
				return false;
			
	
		
		
		
		
		
	}
}
