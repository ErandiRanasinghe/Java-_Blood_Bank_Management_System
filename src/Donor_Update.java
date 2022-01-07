import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Donor_Update extends JFrame {

	private JPanel contentPane;
	private JTextField textFielddname;
	private JTextField textFieldgender;
	private JTextField textFieldBGroup;
	private JTextField textFieldMno;
	private JTextField textFieldLNo;
	private JTextField textFieldAddress;
	private JTextField textFielEmail;
	private JTextField textFieldNIC;
	private JTextField textFieldDOB;
	private JTextField textFieldAge;
	private JTextField textFieldweight;
	private JTextField textFielddiseses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donor_Update frame = new Donor_Update();
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
private JComboBox<String> comboBoxdonorID ;	
	
public void dropdown() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
			String sql="SELECT * FROM donor";
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet set = pst.executeQuery();
			
			while (set.next()) {
				
				comboBoxdonorID.addItem(set.getString("DonorID"));
			}
		
		}	catch (Exception ex) {
				ex.printStackTrace();
			
		}
	
	}
	
	public Donor_Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 834);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 153, 204));
		panel_1.setBounds(0, 0, 909, 822);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Donor.png"));
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(80, 247, 228, 267);
		panel_1.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonorMain wlm = new DonorMain();
				wlm.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(128, 0, 0));
		btnBack.setBounds(125, 720, 130, 45);
		panel_1.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setBounds(383, 0, 551, 799);
		panel_1.add(panel);
		
		JLabel lblNewLabel = new JLabel("UPDATE DONOR DETAILS");
		lblNewLabel.setForeground(new Color(72, 209, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(77, 10, 418, 63);
		panel.add(lblNewLabel);
		
		JLabel lblDonorid = new JLabel("Donor ID");
		lblDonorid.setForeground(Color.WHITE);
		lblDonorid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDonorid.setBounds(38, 83, 118, 45);
		panel.add(lblDonorid);
		
		JLabel lblDonorname = new JLabel("Name");
		lblDonorname.setForeground(Color.WHITE);
		lblDonorname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDonorname.setBounds(38, 138, 118, 37);
		panel.add(lblDonorname);
		
		textFielddname = new JTextField();
		textFielddname.setColumns(10);
		textFielddname.setBounds(206, 138, 303, 30);
		panel.add(textFielddname);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(38, 468, 118, 37);
		panel.add(lblGender);
		
		textFieldgender = new JTextField();
		textFieldgender.setColumns(10);
		textFieldgender.setBounds(206, 476, 303, 29);
		panel.add(textFieldgender);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setForeground(Color.WHITE);
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBloodGroup.setBounds(38, 613, 145, 37);
		panel.add(lblBloodGroup);
		
		textFieldBGroup = new JTextField();
		textFieldBGroup.setColumns(10);
		textFieldBGroup.setBounds(206, 613, 303, 30);
		panel.add(textFieldBGroup);
		
		JButton btnAdd = new JButton("UPDATE");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (RegisterData()) { 
					
				 } 
		}
	
		private boolean RegisterData() {
			
				 // ------------data validation-----------------
			String lblDonorid =  comboBoxdonorID.getSelectedItem().toString();  
			 String lblDonorname =  textFielddname.getText(); 
			 String lblAge =  textFieldAge.getText(); 
			 String lblWeight =  textFieldweight.getText(); 
			 String lblPhoneNo =textFieldMno.getText(); 
			 String lblLandNo  =  textFieldLNo.getText();
			 String lblAddress = textFieldAddress.getText();
			 String lblemail  =    textFielEmail.getText();
			 String lblGender =    textFieldgender.getText();
			 String lblNIC = textFieldNIC.getText();
			 String lblDOB = textFieldDOB.getText(); 
			 String lblBloodGroup = textFieldBGroup.getText(); 
			 String lblDisesses= textFielddiseses.getText(); 
				 
	
	
	 java.sql.Statement s = null; 
	 Boolean status = false;
	 
	 try { 
		 Class.forName("com.mysql.jdbc.Driver"); 
		 conn =(Connection) DriverManager.getConnection("" + "jdbc:mysql://localhost/bbms" + "?user=root&password="); 
		 s = conn.createStatement();
		 
		// SQL Insert
		 String sql = "UPDATE donor SET DonorID='"+ lblDonorid + "',Name='" + lblDonorname  + "',PhoneNo1 ='" + lblPhoneNo +"',PhoneNo2='" + lblLandNo + "',Address='" + lblAddress + "',Email='" + lblemail + "',Gender='"+ lblGender + "',NIC='"+ lblNIC + "', DOB='"+ lblDOB +"', Age='"+ lblAge+"', Weight='"+ lblWeight+"', Diaseases='"+ lblDisesses +"', BloodGroup='"+ lblBloodGroup +"' WHERE DonorID='"+lblDonorid+"' "; 
		 s.execute(sql); 
		 status = true; 
		  
		 JOptionPane.showMessageDialog(null, "Update Donor details Successfully"); 
		 comboBoxdonorID.setSelectedItem(""); 
	
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
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBackground(Color.BLUE);
		btnAdd.setBounds(38, 724, 130, 45);
		panel.add(btnAdd);
		
		JButton btnClear = new JButton("DELETE");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (RegisterData()) { 
					
				 } 
		}
	
		private boolean RegisterData() {
			
				 // ------------data validation-----------------
				String lblDonorid =  comboBoxdonorID.getSelectedItem().toString();  
				 String lblDonorname =  textFielddname.getText(); 
				 String lblAge =  textFieldAge.getText(); 
				 String lblWeight =  textFieldweight.getText(); 
				 String lblPhoneNo =textFieldMno.getText(); 
				 String lblLandNo  =  textFieldLNo.getText();
				 String lblAddress = textFieldAddress.getText();
				 String lblemail  =    textFielEmail.getText();
				 String lblGender =    textFieldgender.getText();
				 String lblNIC = textFieldNIC.getText();
				 String lblDOB = textFieldDOB.getText(); 
				 String lblBloodGroup = textFieldBGroup.getText(); 
				 String lblDisesses= textFielddiseses.getText(); 
	
	
	 java.sql.Statement s = null; 
	 Boolean status = false;
	 
	 try { 
		 Class.forName("com.mysql.jdbc.Driver"); 
		 conn =(Connection) DriverManager.getConnection("" + "jdbc:mysql://localhost/bbms" + "?user=root&password="); 
		 s = conn.createStatement();
		 
		// SQL Insert
		 String sql = "DELETE from donor WHERE DonorID='"+ lblDonorid  + "'"; 
		 s.execute(sql); 
		
		 status = true; 
		 JOptionPane.showMessageDialog(null, "Delete Donor Successfully"); 
		 
	
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
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBackground(Color.BLUE);
		btnClear.setBounds(343, 724, 130, 45);
		panel.add(btnClear);
		
		 comboBoxdonorID = new JComboBox();
		comboBoxdonorID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
					String sql="select * from donor where DonorID=? ";
					PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
					pst.setString(1, (String)comboBoxdonorID .getSelectedItem() );
					
					ResultSet set = pst.executeQuery();
					
					
					while(set.next()) {
						
						textFielddname.setText(set.getString("Name"));
						
						textFieldMno.setText(set.getString("PhoneNo1"));
						textFieldLNo.setText(set.getString("PhoneNo2"));
						 textFieldAddress.setText(set.getString("Address"));
						 textFielEmail.setText(set.getString("Email"));
						 textFieldgender.setText(set.getString("Gender"));
						 textFieldNIC.setText(set.getString("NIC"));
						 textFieldDOB.setText(set.getString("DOB"));
						 textFieldAge.setText(set.getString("Age"));
						 textFieldweight.setText(set.getString("Weight"));
						 textFieldBGroup.setText(set.getString("BloodGroup"));
						 textFielddiseses.setText(set.getString("Diaseases"));
					
					}
						
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		comboBoxdonorID.setBounds(206, 90, 303, 30);
		panel.add(comboBoxdonorID);
		
		JLabel lblPhoneNo = new JLabel("Mobile No");
		lblPhoneNo.setForeground(Color.WHITE);
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhoneNo.setBounds(38, 184, 118, 37);
		panel.add(lblPhoneNo);
		
		textFieldMno = new JTextField();
		textFieldMno.setColumns(10);
		textFieldMno.setBounds(206, 185, 303, 30);
		panel.add(textFieldMno);
		
		JLabel lblLandNo = new JLabel("Land No");
		lblLandNo.setForeground(Color.WHITE);
		lblLandNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLandNo.setBounds(38, 228, 118, 37);
		panel.add(lblLandNo);
		
		textFieldLNo = new JTextField();
		textFieldLNo.setColumns(10);
		textFieldLNo.setBounds(206, 231, 303, 30);
		panel.add(textFieldLNo);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(38, 275, 118, 37);
		panel.add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(206, 278, 303, 42);
		panel.add(textFieldAddress);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setForeground(Color.WHITE);
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblemail.setBounds(38, 322, 118, 37);
		panel.add(lblemail);
		
		textFielEmail = new JTextField();
		textFielEmail.setColumns(10);
		textFielEmail.setBounds(206, 330, 303, 30);
		panel.add(textFielEmail);
		
		JLabel lblNic = new JLabel("NIC");
		lblNic.setForeground(Color.WHITE);
		lblNic.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNic.setBounds(38, 369, 118, 37);
		panel.add(lblNic);
		
		textFieldNIC = new JTextField();
		textFieldNIC.setColumns(10);
		textFieldNIC.setBounds(206, 377, 303, 30);
		panel.add(textFieldNIC);
		
		JLabel lblDOB = new JLabel("DOB");
		lblDOB.setForeground(Color.WHITE);
		lblDOB.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDOB.setBounds(38, 421, 118, 37);
		panel.add(lblDOB);
		
		textFieldDOB = new JTextField();
		textFieldDOB.setColumns(10);
		textFieldDOB.setBounds(206, 422, 303, 30);
		panel.add(textFieldDOB);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAge.setBounds(38, 513, 118, 37);
		panel.add(lblAge);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(206, 521, 303, 30);
		panel.add(textFieldAge);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setForeground(Color.WHITE);
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWeight.setBounds(38, 560, 118, 45);
		panel.add(lblWeight);
		
		textFieldweight = new JTextField();
		textFieldweight.setColumns(10);
		textFieldweight.setBounds(206, 568, 303, 30);
		panel.add(textFieldweight);
		
		JLabel lblDisesses = new JLabel("Diseases");
		lblDisesses.setForeground(Color.WHITE);
		lblDisesses.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDisesses.setBounds(38, 660, 145, 37);
		panel.add(lblDisesses);
		
		textFielddiseses = new JTextField();
		textFielddiseses.setEditable(false);
		textFielddiseses.setColumns(10);
		textFielddiseses.setBounds(206, 660, 303, 30);
		panel.add(textFielddiseses);
		dropdown();
	}
}
