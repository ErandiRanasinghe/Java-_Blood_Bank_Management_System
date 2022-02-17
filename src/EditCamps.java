import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditCamps extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	
public void dropdown() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/BBMS" + "?user=root&password="); 
			String sql="SELECT * FROM bloodcamp";
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet set = pst.executeQuery();
			
			while (set.next()) {
				
				comboBox.addItem(set.getString("EventName"));
			}
		
		}	catch (Exception ex) {
				ex.printStackTrace();
		}
		}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCamps frame = new EditCamps();
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
	private JComboBox<String> comboBox;
	public EditCamps() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 552);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EVENT NAME");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(121, 104, 151, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DATE");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(121, 182, 135, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("VANUE");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(121, 272, 127, 30);
		contentPane.add(lblNewLabel_2);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
					String sql="select * from bloodcamp where EventName=? ";
					PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
					pst.setString(1, (String)comboBox.getSelectedItem() );
					
					ResultSet set = pst.executeQuery();
					
					
					while(set.next()) {
						
						textField.setText(set.getString("Date"));
						textField_1.setText(set.getString("Vanue"));

					}
						
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			
			}
		});
		comboBox.setBounds(405, 104, 162, 30);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(452, 396, 171, 38);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if (RegisterData()) { 
					
					 } 
			}
		
			private boolean RegisterData() {
				String lblNewLabel =  (String) comboBox.getSelectedItem(); 
				String lblNewLabel_1 =  (String) textField.getText(); 
				String lblNewLabel_2 =  (String) textField_1.getText(); 
				
		
		 java.sql.Statement s = null; 
		 Boolean status = false;
		 
		 try { 
			 Class.forName("com.mysql.jdbc.Driver"); 
			 conn =(Connection) DriverManager.getConnection("" + "jdbc:mysql://localhost/bbms" + "?user=root&password="); 
			 s = conn.createStatement();
			// SQL Insert
			 String sql = "UPDATE bloodcamp SET EventName='"+ lblNewLabel + "',Date='" + lblNewLabel_1 + "', Vanue= '"+ lblNewLabel_2 +"' WHERE EventName='"+ lblNewLabel +"'" ; 
			 s.execute(sql); 
			 
			 status = true; 
			  
			 JOptionPane.showMessageDialog(null, "Update BloodCamp details Successfully"); 
			 textField.setText(""); 
			 textField_1.setText("");
		
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
	
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BloodCamps obj = new BloodCamps();
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(92, 397, 165, 37);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(405, 189, 162, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(405, 275, 162, 33);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("EDIT EVENTS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(291, 10, 230, 60);
		contentPane.add(lblNewLabel_3);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (RegisterData()) { 
					
				 } 
		}
	
		private boolean RegisterData() {
			String lblNewLabel =  (String) comboBox.getSelectedItem(); 
			
				
	
	 java.sql.Statement s = null; 
	 Boolean status = false;
	 
	 try { 
		 Class.forName("com.mysql.jdbc.Driver"); 
		 conn =(Connection) DriverManager.getConnection("" + "jdbc:mysql://localhost/bbms" + "?user=root&password="); 
		 s = conn.createStatement();
		 
		// SQL Insert
		 String sql = "DELETE from bloodcamp WHERE EventName='"+ lblNewLabel  + "'"; 
		 s.execute(sql); 
		
		 status = true; 
		  
		
		 JOptionPane.showMessageDialog(null, "Remove Event Successfully"); 
		 textField.setText(""); 
		 textField_1.setText("");
		
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
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(267, 396, 171, 38);
		contentPane.add(btnDelete);
		
		 dropdown();
	}
}
