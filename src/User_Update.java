import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class User_Update extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAddress;
	private JTextField textFieldName;
	private JTextField textFieldNIC;
	private JTextField textFieldDOB;
	private JTextField textFieldMObileName;
	private JTextField textFieldLandNo;
	private JTextField textFieldGender;
	private JTextField textFieldUserType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Update frame = new User_Update();
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
	Connection conn=null; 
	private JTextField textFieldpassword;
	private JComboBox<String> comboBoxuserID;
	
public void dropdown() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/BBMS" + "?user=root&password="); 
			String sql="SELECT * FROM user";
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet set = pst.executeQuery();
			
			while (set.next()) {
				
				comboBoxuserID.addItem(set.getString("UserID"));
			}
		
		}	catch (Exception ex) {
				ex.printStackTrace();
			
		}
	
	}
	
	public User_Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 822);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/changeUser.png"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(59, 163, 346, 322);
		contentPane.add(lblNewLabel);
		
		JButton btnExit_1 = new JButton("EXIT");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit_1.setBackground(new Color(220, 20, 60));
		btnExit_1.setBounds(134, 707, 153, 35);
		contentPane.add(btnExit_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.windowBorder);
		panel.setBounds(413, 0, 503, 813);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("CHANGE USER DETAILS");
		lblNewLabel_1.setForeground(new Color(64, 224, 208));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(82, 21, 327, 45);
		panel.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(23, 150, 118, 45);
		panel.add(lblName);
		
		JLabel lblMobileName = new JLabel("Mobile No");
		lblMobileName.setForeground(Color.WHITE);
		lblMobileName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMobileName.setBounds(23, 231, 118, 63);
		panel.add(lblMobileName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(23, 381, 118, 35);
		panel.add(lblAddress);
		
		JLabel lblusertype = new JLabel("User Type");
		lblusertype.setForeground(Color.WHITE);
		lblusertype.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblusertype.setBounds(23, 447, 118, 45);
		panel.add(lblusertype);
		
		JLabel lblNIC = new JLabel("NIC");
		lblNIC.setForeground(Color.WHITE);
		lblNIC.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNIC.setBounds(23, 556, 118, 45);
		panel.add(lblNIC);
		
		JLabel lblDOB = new JLabel("DOB");
		lblDOB.setForeground(Color.WHITE);
		lblDOB.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDOB.setBounds(23, 611, 118, 45);
		panel.add(lblDOB);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(151, 345, 303, 96);
		panel.add(textFieldAddress);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(151, 148, 303, 39);
		panel.add(textFieldName);
		
		textFieldNIC = new JTextField();
		textFieldNIC.setColumns(10);
		textFieldNIC.setBounds(151, 561, 303, 44);
		panel.add(textFieldNIC);
		
		textFieldDOB = new JTextField();
		textFieldDOB.setColumns(10);
		textFieldDOB.setBounds(151, 615, 303, 41);
		panel.add(textFieldDOB);
		
		textFieldMObileName = new JTextField();
		textFieldMObileName.setColumns(10);
		textFieldMObileName.setBounds(151, 247, 303, 39);
		panel.add(textFieldMObileName);
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if (RegisterData()) { 
					
				 } 
		}
	
		private boolean RegisterData() {
			
				 // ------------data validation-----------------
				String lbluserID =  comboBoxuserID.getSelectedItem().toString();  
				 String lblName =  textFieldName.getText(); 
				 String lblPassword = textFieldpassword.getText();   
				 String lblMobileName = textFieldMObileName.getText(); 
				 String lblLandNO  = textFieldLandNo.getText();
				 String lblAddress = textFieldAddress.getText();
				 String lblusertype =    textFieldUserType.getText();
				 String lblGender =   textFieldGender.getText();
				 String lblNIC = textFieldNIC.getText();
				 String lblDOB = textFieldDOB.getText(); 
	
	
	 java.sql.Statement s = null; 
	 Boolean status = false;
	 
	 try { 
		 Class.forName("com.mysql.jdbc.Driver"); 
		 conn =(Connection) DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/bbms" + "?user=root&password="); 
		 s = conn.createStatement();
		 
		// SQL Insert
		 String sql = "DELETE from user WHERE UserID='"+ lbluserID + "'"; 
		 s.execute(sql); 
		 String sql1 = "DELETE from login WHERE UserID='"+ lbluserID + "'"; 
		 s.execute(sql1);
		 status = true; 
		  
		 comboBoxuserID.setSelectedItem(""); 
		 JOptionPane.showMessageDialog(null, "Delete User Successfully"); 
		
		 } catch (Exception e) { // TODO Auto-generated catch block
		 JOptionPane.showMessageDialog(null, e.getMessage()); 
		 e.printStackTrace(); 
		 } 
		 try { 
		 if (s != null) { 
		 s.close(); 
		 conn.close(); 
		 } 
		 } catch (SQLException e) { // TODO Auto-generated catch block
		 System.out.println(e.getMessage()); 
		 e.printStackTrace(); 
		 } 
		 return false;  
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDelete.setBackground(Color.BLUE);
		btnDelete.setBounds(294, 705, 153, 35);
		panel.add(btnDelete);
		
		textFieldLandNo = new JTextField();
		textFieldLandNo.setColumns(10);
		textFieldLandNo.setBounds(151, 296, 303, 39);
		panel.add(textFieldLandNo);
		
		JLabel lblLandNO = new JLabel("Land No");
		lblLandNO.setForeground(Color.WHITE);
		lblLandNO.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLandNO.setBounds(23, 289, 118, 45);
		panel.add(lblLandNO);
		
		textFieldGender = new JTextField();
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(151, 506, 303, 45);
		panel.add(textFieldGender);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(23, 502, 118, 45);
		panel.add(lblGender);
		
		JLabel lbluserID = new JLabel("User ID");
		lbluserID.setBounds(23, 93, 118, 45);
		panel.add(lbluserID);
		lbluserID.setForeground(Color.WHITE);
		lbluserID.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		comboBoxuserID = new JComboBox();
		comboBoxuserID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/BBMS" + "?user=root&password="); 
					String sql="select * from user where UserID=? ";
					PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
					pst.setString(1, (String)comboBoxuserID.getSelectedItem() );
					
					ResultSet set = pst.executeQuery();
					
					
					while(set.next()) {
						
						textFieldName.setText(set.getString("Name"));
						textFieldpassword.setText(set.getString("Password"));
						textFieldMObileName .setText(set.getString("PhoneNo1"));
						textFieldLandNo.setText(set.getString("PhoneNo2"));
						 textFieldAddress.setText(set.getString("Address"));
						 textFieldUserType.setText(set.getString("UserType"));
						 textFieldGender.setText(set.getString("Gender"));
						 textFieldNIC.setText(set.getString("NIC"));
						 textFieldDOB.setText(set.getString("DOB"));
						
					}
						
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			
			}
		});
		comboBoxuserID.setBounds(151, 93, 303, 45);
		panel.add(comboBoxuserID);
		
		textFieldUserType = new JTextField();
		textFieldUserType.setColumns(10);
		textFieldUserType.setBounds(151, 451, 303, 45);
		panel.add(textFieldUserType);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(23, 198, 118, 45);
		panel.add(lblPassword);
		
		textFieldpassword = new JTextField();
		textFieldpassword.setColumns(10);
		textFieldpassword.setBounds(151, 198, 303, 39);
		panel.add(textFieldpassword);
		
		JButton btnExit_1_1 = new JButton("BACK");
		btnExit_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsersMain wlm = new UsersMain();
				wlm.setVisible(true);
				dispose();
				
			}
		});
		btnExit_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit_1_1.setBackground(new Color(220, 20, 60));
		btnExit_1_1.setBounds(134, 643, 153, 35);
		contentPane.add(btnExit_1_1);
		
		dropdown();
		
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (RegisterData()) { 
					
					 } 
			}
		
			private boolean RegisterData() {
				
					 // ------------data validation-----------------
					String lbluserID =  comboBoxuserID.getSelectedItem().toString();  
					 String lblName =  textFieldName.getText(); 
					 String lblPassword = textFieldpassword.getText();   
					 String lblMobileName = textFieldMObileName.getText(); 
					 String lblLandNO  = textFieldLandNo.getText();
					 String lblAddress = textFieldAddress.getText();
					 String lblusertype =    textFieldUserType.getText();
					 String lblGender =   textFieldGender.getText();
					 String lblNIC = textFieldNIC.getText();
					 String lblDOB = textFieldDOB.getText(); 
					 
		
		
		 java.sql.Statement s = null; 
		 Boolean status = false;
		 
		 try { 
			 Class.forName("com.mysql.jdbc.Driver"); 
			 conn =(Connection) DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/bbms" + "?user=root&password="); 
			 s = conn.createStatement();
			 
			// SQL Insert
			 String sql = "UPDATE user SET UserID='"+ lbluserID + "',Name='" + lblName  + "', Password= '"+ lblPassword +"', ConfirmPassword='" + lblPassword + "',PhoneNo1 ='" + lblMobileName +"',PhoneNo2='" + lblLandNO + "',Address='" + lblAddress + "',UserType='" + lblusertype + "',Gender='"+ lblGender + "',NIC='"+ lblNIC + "', DOB='"+ lblDOB +"' WHERE UserID='"+lbluserID +"' "; 
			 s.execute(sql); 
			 String sql1 = "UPDATE login SET UserID='"+ lbluserID + "',Password='" + lblPassword + "', UserType= '"+ lblusertype +"' WHERE UserID='"+lbluserID +"' ";
			 s.execute(sql1);
			 status = true; 
			  
			 JOptionPane.showMessageDialog(null, "Update user details Successfully"); 
			 comboBoxuserID.setSelectedItem(""); 
		
			 } catch (Exception e) { // TODO Auto-generated catch block
			 JOptionPane.showMessageDialog(null, e.getMessage()); 
			 e.printStackTrace(); 
			 } 
			 try { 
			 if (s != null) { 
			 s.close(); 
			 conn.close(); 
			 } 
			 } catch (SQLException e) { // TODO Auto-generated catch block
			 System.out.println(e.getMessage()); 
			 e.printStackTrace(); 
			 } 
			 return false;  
			 
			}
	
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnUpdate.setBackground(Color.BLUE);
		btnUpdate.setBounds(46, 705, 153, 35);
		panel.add(btnUpdate);
	
		
	}
}
