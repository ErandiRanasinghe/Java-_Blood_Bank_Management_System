import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Color;

public class RemoveBlood extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBoxExdate;

	/**
	 * Launch the application.
	 * 
	 */
public void dropdown() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/BBMS" + "?user=root&password="); 
			String sql="SELECT * FROM bloodunit";
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet set = pst.executeQuery();
			
			while (set.next()) {
				
				comboBoxExdate.addItem(set.getString("ExpireDate"));
			}
		
		}	catch (Exception ex) {
				ex.printStackTrace();
			
		}}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveBlood frame = new RemoveBlood();
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
	PreparedStatement pst= null;
	ResultSet rs=null;
	
	public RemoveBlood() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxExdate = new JComboBox();
		comboBoxExdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBoxExdate.setBounds(344, 93, 256, 39);
		contentPane.add(comboBoxExdate);
		
		JLabel lblNewLabel = new JLabel("Expire Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(64, 89, 160, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BloodStock obj= new BloodStock();
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(64, 261, 132, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButtoremoven = new JButton("REMOVE");
		btnNewButtoremoven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (RegisterData()) { 
					
				 } 
		}
	
		private boolean RegisterData() {
			String lblNewLabel =  (String) comboBoxExdate.getSelectedItem(); 
			
			
	
	
	 java.sql.Statement s = null; 
	 Boolean status = false;
	 
	 try { 
		 Class.forName("com.mysql.jdbc.Driver"); 
		 conn =(Connection) DriverManager.getConnection("" + "jdbc:mysql://localhost/bbms" + "?user=root&password="); 
		 s = conn.createStatement();
		 
		// SQL Insert
		 String sql = "DELETE from bloodunit WHERE ExpireDate='"+ lblNewLabel + "'"; 
		 s.execute(sql); 
		 status = true; 
		  
		
		 JOptionPane.showMessageDialog(null, "Delete Blood Units Successfully"); 
		
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
		btnNewButtoremoven.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButtoremoven.setBounds(410, 261, 145, 31);
		contentPane.add(btnNewButtoremoven);
		
		dropdown();
	}
}
