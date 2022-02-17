import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Window.Type;

public class UserReg extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserID;
	private JTextField textFieldAddress;
	private JTextField textFieldName;
	private JTextField textFieldNIC;
	private JTextField textFieldPhoneNo;
	private JTextField textFieldmobileNo;
	private JComboBox<String> comboBoxusertype;
	private JComboBox<String>  comboBoxgender;
	public JDateChooser  dateChooser;
	private JTextField textFieldpassword;
	private JTextField pfconfirmpassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserReg frame = new UserReg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserReg() {
		initialize(); 
	 }
	
	private void initialize() { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 842);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(354, 0, 559, 840);
		panel.setLayout(null);
		panel.setBackground(SystemColor.windowBorder);
		contentPane.add(panel);
		
		textFieldUserID = new JTextField();
		textFieldUserID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldUserID.setColumns(10);
		textFieldUserID.setBounds(234, 154, 303, 37);
		panel.add(textFieldUserID);
		
		JLabel lblNewLabel_1 = new JLabel("USER REGISTRATION");
		lblNewLabel_1.setForeground(new Color(64, 224, 208));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(119, 29, 327, 45);
		panel.add(lblNewLabel_1);
		
		JLabel lbluserID = new JLabel("User ID");
		lbluserID.setForeground(Color.WHITE);
		lbluserID.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbluserID.setBounds(37, 150, 118, 41);
		panel.add(lbluserID);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(37, 84, 118, 52);
		panel.add(lblName);
		
		JLabel lblPNo = new JLabel("Landline No");
		lblPNo.setForeground(Color.WHITE);
		lblPNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPNo.setBounds(37, 334, 141, 52);
		panel.add(lblPNo);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(37, 412, 118, 45);
		panel.add(lblAddress);
		
		JLabel lblusertype = new JLabel("User Type");
		lblusertype.setForeground(Color.WHITE);
		lblusertype.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblusertype.setBounds(37, 479, 118, 45);
		panel.add(lblusertype);
		
		JLabel lblNIC = new JLabel("NIC");
		lblNIC.setForeground(Color.WHITE);
		lblNIC.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNIC.setBounds(37, 573, 118, 45);
		panel.add(lblNIC);
		
		JLabel lblDOB = new JLabel("DOB");
		lblDOB.setForeground(Color.WHITE);
		lblDOB.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDOB.setBounds(37, 618, 118, 45);
		panel.add(lblDOB);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(234, 389, 303, 81);
		panel.add(textFieldAddress);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldName.setColumns(10);
		textFieldName.setBounds(234, 107, 303, 37);
		panel.add(textFieldName);
		
		textFieldNIC = new JTextField();
		textFieldNIC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNIC.setColumns(10);
		textFieldNIC.setBounds(234, 579, 303, 37);
		panel.add(textFieldNIC);
		
		comboBoxusertype = new JComboBox<String>();
		comboBoxusertype.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxusertype.addItem("");
		comboBoxusertype.addItem("Admin");
		comboBoxusertype.addItem("Other User");
		comboBoxusertype.setBounds(234, 483, 303, 39);
		panel.add(comboBoxusertype);
		
		textFieldPhoneNo = new JTextField();
		textFieldPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPhoneNo.setColumns(10);
		textFieldPhoneNo.setBounds(234, 342, 303, 37);
		panel.add(textFieldPhoneNo);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 textFieldName.setText(""); 
				 textFieldUserID.setText(""); 
				 textFieldpassword.setText(""); 
				 pfconfirmpassword.setText(""); 
				 textFieldmobileNo.setText(""); 
				 textFieldPhoneNo.setText(""); 
				 textFieldAddress.setText(""); 
				 comboBoxusertype.setSelectedItem(""); 
				 comboBoxgender.setSelectedItem("");  
				 textFieldNIC.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnClear.setBackground(Color.BLUE);
		btnClear.setBounds(327, 717, 153, 35);
		panel.add(btnClear);
		
		textFieldmobileNo = new JTextField();
		textFieldmobileNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldmobileNo.setColumns(10);
		textFieldmobileNo.setBounds(234, 295, 303, 37);
		panel.add(textFieldmobileNo);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(37, 193, 118, 45);
		panel.add(lblPassword);
		
		JLabel lblphoneMobile = new JLabel("Mobile No");
		lblphoneMobile.setForeground(Color.WHITE);
		lblphoneMobile.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblphoneMobile.setBounds(37, 288, 118, 45);
		panel.add(lblphoneMobile);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(37, 526, 118, 45);
		panel.add(lblGender);
		
		comboBoxgender = new JComboBox<String>();
		comboBoxgender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxgender.addItem("");
		comboBoxgender.addItem("Male");
		comboBoxgender.addItem("Female");
		comboBoxgender.setBounds(234, 532, 303, 37);
		panel.add(comboBoxgender);
		
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(234, 626, 303, 37);
		panel.add(dateChooser);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(20, 172, 346, 322);
		ImageIcon img = new ImageIcon(this.getClass().getResource("user-icon.png"));
		lblNewLabel.setIcon(img);
		contentPane.add(lblNewLabel);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(95, 715, 153, 35);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setBackground(Color.PINK);
		contentPane.add(btnExit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(95, 620, 153, 35);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsersMain obj = new UsersMain();
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBack.setBackground(Color.PINK);
		contentPane.add(btnBack);
		
		
		JButton btnADD = new JButton("ADD");
		
			btnADD.setFont(new Font("Tahoma", Font.BOLD, 25));
			btnADD.setBackground(Color.BLUE);
			btnADD.setBounds(64, 717, 153, 35);
			panel.add(btnADD);
			
			JLabel lblConfirmPassword = new JLabel("Confirm Password");
			lblConfirmPassword.setForeground(Color.WHITE);
			lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblConfirmPassword.setBounds(37, 239, 187, 45);
			panel.add(lblConfirmPassword);
			
			textFieldpassword = new JTextField();
			textFieldpassword.setFont(new Font("Webdings", Font.PLAIN, 18));
			textFieldpassword.setBounds(234, 201, 303, 37);
			panel.add(textFieldpassword);
			textFieldpassword.setColumns(10);
			
			pfconfirmpassword = new JTextField();
			pfconfirmpassword.setFont(new Font("Webdings", Font.PLAIN, 18));
			pfconfirmpassword.setBounds(234, 249, 303, 37);
			panel.add(pfconfirmpassword);
			pfconfirmpassword.setColumns(10);
			btnADD.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (RegisterData()) { 
					 
					 } 
			}
			
	});
}
			private boolean RegisterData() {
				DateFormat df= new SimpleDateFormat ("yyyy-mm-dd");
				
					 // ------------data validation-----------------
					 String lblName =  textFieldName.getText(); 
					 String lbluserID = textFieldUserID.getText(); 
					 String lblPassword = textFieldpassword.getText();
					 String lblConfirmPassword = pfconfirmpassword.getText();
					 String lblphoneMobile = textFieldmobileNo.getText(); 
					 String lblPNo = textFieldPhoneNo.getText();
					 String lblAddress = textFieldAddress.getText();
					 String lblusertype =   comboBoxusertype.getSelectedItem().toString();
					 String lblGender =   comboBoxgender.getSelectedItem().toString();
					 String lblNIC = textFieldNIC.getText();
					 String lblDOB =(df.format(dateChooser.getDate()));
					
		 if (lblName.equals("")) { 
			 JOptionPane.showMessageDialog(null, "Please Input (Username)"); 
			 textFieldName.requestFocusInWindow(); 
			 return false; 
		 	}
			
		 if (!lblName.matches("[a-zA-Z_ ]+")) { 
			 JOptionPane.showMessageDialog(null, "Invalid name"); 
			 textFieldName.requestFocusInWindow(); 
			 return false; 
			 } 
		 
		 if (lbluserID.equals("")) { 
			 JOptionPane.showMessageDialog(null, "Please Input (User ID)"); 
			 textFieldUserID.requestFocusInWindow(); 
			 return false; 
		 }
		 
		 
		 if (lblphoneMobile.equals("")) { 
			 JOptionPane.showMessageDialog(null, "Please Input Your (Mobile No)"); 
			 textFieldmobileNo.requestFocusInWindow(); 
			 return false; 
		 }
		 
		 if (lblPassword.equals("")) { 
			 JOptionPane.showMessageDialog(null, "Please Input (Password)"); 
			
			 return false; 
		 }
		 
		 if (lblConfirmPassword != null && !lblConfirmPassword.equals(lblPassword)) { 
			 
			 JOptionPane.showMessageDialog(null, "Confirm Password DoesNot match"); 
			
			 return false; 
		 }

		 
		 if (lblAddress.equals("")) { 
			 JOptionPane.showMessageDialog(null, "Please Input (Address)"); 
			 textFieldAddress.requestFocusInWindow(); 
			 return false; 
			 } 
			
		 if (lblusertype.equals("")) { 
			 JOptionPane.showMessageDialog(null, "Please Select Your (User Type)"); 
			 comboBoxusertype.requestFocusInWindow(); 
			 return false; 
			 }
		 
		 if (lblGender.equals("")) { 
			 JOptionPane.showMessageDialog(null, "Please Select Your (Gender)"); 
			 comboBoxgender.requestFocusInWindow(); 
			 return false; 
			 }
		 
		 if (lblNIC.equals("")) { 
			 JOptionPane.showMessageDialog(null, "Please Input Your (NIC)"); 
			 textFieldNIC.requestFocusInWindow(); 
			 return false; 
			 }
		 
		 if (lblDOB.equals("")) { 
			 JOptionPane.showMessageDialog(null, "Please Select Your (DOB)"); 
			 dateChooser.requestFocusInWindow(); 
			 return false; 
			 }
		
		 Connection connect = null; 
		 java.sql.Statement s = null; 
		 Boolean status = false;
		 try { 
			 Class.forName("com.mysql.jdbc.Driver"); 
			 connect =(Connection) DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/bbms" + "?user=root&password="); 
			 s = connect.createStatement();
			 
			// SQL Insert
			 String sql = "INSERT INTO user " + "(Name,UserID,Password,ConfirmPassword,PhoneNo1,PhoneNo2,Address,UserType,Gender,NIC,DOB) " + "VALUES ('"+ lblName + "','" + lbluserID	+ "','"+ lblPassword + "','"+ lblConfirmPassword +"', '" + lblphoneMobile + "','" + lblPNo + "','" + lblAddress + "','" + lblusertype + "','" + lblGender + "','" + lblNIC + "','" + lblDOB + "') ";  
			 String sql1 = "INSERT INTO login " + "(UserID,Password,UserType) " + "VALUES ('" + lbluserID	+ "','"+ lblPassword + "','" + lblusertype + "') ";
			 s.execute(sql); 
			 s.execute(sql1);
			 textFieldName.setText(""); 
			 textFieldUserID.setText(""); 
			 textFieldpassword.setText(""); 
			 pfconfirmpassword.setText(""); 
			 textFieldmobileNo.setText(""); 
			 textFieldPhoneNo.setText(""); 
			 textFieldAddress.setText(""); 
			 comboBoxusertype.setSelectedItem(""); 
			 comboBoxgender.setSelectedItem("");  
			 textFieldNIC.setText("");
			
			// dateChooser.setText(""); 
			 status = true; 
			 
			 JOptionPane.showMessageDialog(null, "Add new user Successfully"); 
			 
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
			 return false;  
			
	}	
}
