import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Addnewbloodcamp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldentname;
	private JTextField textFieldvanue;
	private JDateChooser dateChoosercollectdate;
	/**
	 * Launch the application.
	 */
	
	 Connection conn = null; 
	 java.sql.Statement s = null; 
	 Boolean status = false;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addnewbloodcamp frame = new Addnewbloodcamp();
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
	public Addnewbloodcamp() {
		initialize();
	}
	
	
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BloodCamps newjframe = new BloodCamps ();
				newjframe.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(71, 449, 185, 41);
		contentPane.add(btnBack);
		
		
		textFieldentname = new JTextField();
		textFieldentname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldentname.setColumns(10);
		textFieldentname.setBounds(396, 239, 266, 41);
		contentPane.add(textFieldentname);
		
		 dateChoosercollectdate = new JDateChooser();
		dateChoosercollectdate.setBounds(396, 150, 266, 48);
		contentPane.add(dateChoosercollectdate);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDate.setBounds(162, 150, 168, 41);
		contentPane.add(lblDate);
		
		JLabel lbleventname = new JLabel("Event Name");
		lbleventname.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbleventname.setBounds(162, 239, 168, 33);
		contentPane.add(lbleventname);
		
		JLabel lblVanue = new JLabel("Vanue");
		lblVanue.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVanue.setBounds(162, 325, 168, 33);
		contentPane.add(lblVanue);
		
		textFieldvanue = new JTextField();
		textFieldvanue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldvanue.setColumns(10);
		textFieldvanue.setBounds(396, 325, 266, 41);
		contentPane.add(textFieldvanue);
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			if (RegisterData()) { 
					 JOptionPane.showMessageDialog(null, "Save Data Successfully"); 
					 } 	
			}
			private boolean RegisterData() {
				
				 DateFormat df= new SimpleDateFormat ("yyyy-mm-dd");
				String lblDate =  (df.format(dateChoosercollectdate.getDate()));
				 String lbleventname =  textFieldentname.getText();
				 String lblVanue =  textFieldvanue.getText();
				 
				 try { 
					 
					 Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
					 s = conn.createStatement();
					 
					 String sql = "INSERT INTO bloodcamp " + "(Date,EventName,Vanue) " + "VALUES ('"+ lblDate+ "','" + lbleventname+ "','"+ lblVanue + "') "; 
					 s.execute(sql); 
					 textFieldentname.setText(""); 
					 textFieldvanue.setText(""); 
					 
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
		btnSave.setBounds(494, 449, 168, 41);
		contentPane.add(btnSave);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 891, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPCOMING EVENTS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(256, 21, 367, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton btnEditDetails = new JButton("EDIT DETAILS");
		btnEditDetails.setForeground(Color.WHITE);
		btnEditDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEditDetails.setBackground(Color.GRAY);
		btnEditDetails.setBounds(286, 449, 177, 41);
		contentPane.add(btnEditDetails);
		
	}
}
