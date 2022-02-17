import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class CollectBlood extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDonorName;
	
	private JTextField textField;
	private JComboBox<String> comboBoxDonorID;
	/**
	 * Launch the application.
	 */
	Connection conn=null; 
	private JTextField textFieldbloodgroup;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CollectBlood frame = new CollectBlood();
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
	
	public void dropdown() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
			String sql="SELECT * FROM donor";
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet set = pst.executeQuery();
			
			while (set.next()) {
				
				comboBoxDonorID.addItem(set.getString("DonorID"));
			}
		
		}	catch (Exception ex) {
				ex.printStackTrace();
			
		}
		
	}
	public CollectBlood() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 719);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 778, 105);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Blood Unit");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblNewLabel.setBounds(283, 27, 349, 50);
		panel.add(lblNewLabel);
		
		comboBoxDonorID = new JComboBox();
		comboBoxDonorID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
					String sql="select * from donor where DonorID=? ";
					PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
					pst.setString(1, (String)comboBoxDonorID.getSelectedItem() );
					
					ResultSet set = pst.executeQuery();
					
					
					while(set.next()) {
						
						textFieldDonorName.setText(set.getString("Name"));
						textFieldbloodgroup.setText(set.getString("BloodGroup"));
					}
						
				} catch (Exception ex) {
					ex.printStackTrace();
				}	
			}
		});
		comboBoxDonorID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxDonorID.setBounds(353, 146, 266, 41);
		contentPane.add(comboBoxDonorID);
		
		textFieldDonorName = new JTextField();
		textFieldDonorName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldDonorName.setColumns(10);
		textFieldDonorName.setBounds(353, 206, 266, 41);
		contentPane.add(textFieldDonorName);
		
		JLabel lblDonorId = new JLabel("Donor ID");
		lblDonorId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDonorId.setBounds(119, 154, 168, 33);
		contentPane.add(lblDonorId);
		
		JLabel lblusername = new JLabel("Donor Name");
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblusername.setBounds(119, 214, 168, 33);
		contentPane.add(lblusername);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBloodGroup.setBounds(119, 267, 168, 41);
		contentPane.add(lblBloodGroup);
		
		JLabel lblCollectDate = new JLabel("Collect Date");
		lblCollectDate.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCollectDate.setBounds(119, 404, 168, 41);
		contentPane.add(lblCollectDate);
		
		JLabel lblExpireDate = new JLabel("Expire Date");
		lblExpireDate.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblExpireDate.setBounds(119, 472, 168, 41);
		contentPane.add(lblExpireDate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFormlogafter newjframe = new MainFormlogafter ();
				newjframe.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(102, 102, 102));
		btnBack.setBounds(58, 577, 154, 48);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.WHITE);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBackground(new Color(139, 0, 0));
		btnExit.setBounds(563, 577, 154, 48);
		contentPane.add(btnExit);
		
		JDateChooser dateChoosercollectdate = new JDateChooser();
		dateChoosercollectdate.setBounds(353, 404, 266, 48);
		contentPane.add(dateChoosercollectdate);
		
		JDateChooser dateChooserëxpiredate = new JDateChooser();
		dateChooserëxpiredate.setBounds(353, 472, 266, 41);
		contentPane.add(dateChooserëxpiredate);
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (RegisterData()) { 
					
					 } 	
			}
			private boolean RegisterData() {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				 String lblDonorId =   comboBoxDonorID.getSelectedItem().toString();  
				 String lblusername =   textFieldDonorName.getText(); 
				 String lblBloodGroup  =   textFieldbloodgroup.getText(); 
				 String lblUnit =   textField.getText(); 
				 String lblCollectDate =  (df.format(dateChoosercollectdate.getDate()));
				 String lblExpireDate =  (df.format(dateChooserëxpiredate.getDate()));
				 
				 java.sql.Statement s = null; 
				 Boolean status = false;
				 try { 
					 
					 Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/BBMS" + "?user=root&password="); 
					 s = conn.createStatement();
					 
					 String sql = "INSERT INTO bloodunit " + "(DonorID,DonorName,BloodGroup,Unit,CollectingDate,ExpireDate) " + "VALUES ('"+ lblDonorId + "','" + lblusername+ "','"+ lblBloodGroup + "','" + lblUnit+ "','" + lblCollectDate + "','" + lblExpireDate + "') "; 
					 s.execute(sql); 
					 textFieldDonorName.setText(""); 
					
					 textFieldbloodgroup.setText(""); 
					 status = true; 
				
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
				
				// TODO Auto-generated method stub
				return false;
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBackground(Color.BLUE);
		btnSave.setBounds(313, 577, 154, 48);
		contentPane.add(btnSave);
		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUnit.setBounds(119, 338, 168, 33);
		contentPane.add(lblUnit);
		
		textField = new JTextField("1");
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(353, 331, 266, 48);
		contentPane.add(textField);
		
		textFieldbloodgroup = new JTextField();
		textFieldbloodgroup.setBounds(353, 273, 266, 41);
		contentPane.add(textFieldbloodgroup);
		textFieldbloodgroup.setColumns(10);
		
		dropdown();
	}
}
