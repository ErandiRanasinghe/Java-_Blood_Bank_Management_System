import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.LineBorder;

public class BloodStock extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodStock frame = new BloodStock();
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
	
	private JTable table;

	
	private JTable table2;
	private JTable table3;
	private JTable table4;
	private JTable table5;
	private JTable table6;
	private JTable table7;
	private JTable table8;
	
	Connection conn= null;
	PreparedStatement pst= null;
	ResultSet rs=null;

	public BloodStock() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
				
						String query = "SELECT COUNT(*) FROM bloodunit WHERE BloodGroup = 'A+'";
						pst=(PreparedStatement) conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						while(rs.next()){
							
						}
						
						pst.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}	
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
				
						String query = "SELECT COUNT(*) FROM bloodunit WHERE BloodGroup = 'A-'";
						pst=(PreparedStatement) conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table2.setModel(DbUtils.resultSetToTableModel(rs));
						while(rs.next()){
							
						}
						
						pst.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}	
			
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
				
						String query = "SELECT COUNT(*) FROM bloodunit WHERE BloodGroup = 'AB+'";
						pst=(PreparedStatement) conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table3.setModel(DbUtils.resultSetToTableModel(rs));
						while(rs.next()){
							
						}
						
						pst.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}	
				
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
				
						String query = "SELECT COUNT(*) FROM bloodunit WHERE BloodGroup = 'AB-'";
						pst=(PreparedStatement) conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table4.setModel(DbUtils.resultSetToTableModel(rs));
						while(rs.next()){
							
						}
						
						pst.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}	
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
				
						String query = "SELECT COUNT(*) FROM bloodunit WHERE BloodGroup = 'B+'";
						pst=(PreparedStatement) conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table5.setModel(DbUtils.resultSetToTableModel(rs));
						while(rs.next()){
							
						}
						
						pst.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}	
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
				
						String query = "SELECT COUNT(*) FROM bloodunit WHERE BloodGroup = 'B-'";
						pst=(PreparedStatement) conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table6.setModel(DbUtils.resultSetToTableModel(rs));
						while(rs.next()){
							
						}
						
						pst.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}	
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
				
						String query = "SELECT COUNT(*) FROM bloodunit WHERE BloodGroup = 'O+'";
						pst=(PreparedStatement) conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table7.setModel(DbUtils.resultSetToTableModel(rs));
						while(rs.next()){
							
						}
						
						pst.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}	
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
				
						String query = "SELECT COUNT(*) FROM bloodunit WHERE BloodGroup = 'O-'";
						pst=(PreparedStatement) conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table8.setModel(DbUtils.resultSetToTableModel(rs));
						while(rs.next()){
							
						}
						
						pst.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}	
			
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1187, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				
				
			}
		});
		panel.setBackground(new Color(165, 42, 42));
		panel.setBounds(424, 0, 253, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("View Stock");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				APositve obj= new APositve();
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(42, 149, 163, 33);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total Units");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(25, 66, 90, 63);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_5 = new JLabel("Blood Group");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_5.setBounds(25, 10, 124, 63);
		panel.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("A+");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_6.setBounds(138, 10, 67, 63);
		panel.add(lblNewLabel_2_6);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 22));
		table.setBounds(117, 86, 88, 26);
		panel.add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 424, 677);
		panel_2.setBackground(Color.BLACK);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/blood dropp.png"));
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(10, 10, 385, 357);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to the ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setBounds(31, 378, 407, 92);
		panel_2.add(lblNewLabel);
		
		JLabel lblBloodInventry = new JLabel("Blood Inventry");
		lblBloodInventry.setForeground(Color.WHITE);
		lblBloodInventry.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblBloodInventry.setBounds(38, 465, 374, 79);
		panel_2.add(lblBloodInventry);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFormlogafter obj= new MainFormlogafter();
				obj.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton.setBounds(129, 554, 135, 42);
		panel_2.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				
				
			}
		});
		panel_1.setBackground(new Color(165, 42, 42));
		panel_1.setBounds(675, 0, 253, 204);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("View Stock");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				ANegetive obj= new ANegetive();
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(53, 150, 163, 33);
		panel_1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Units");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(36, 66, 90, 63);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("Blood Group");
		lblNewLabel_2_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_5_1.setBounds(36, 10, 124, 63);
		panel_1.add(lblNewLabel_2_5_1);
		
		JLabel lblNewLabel_2_6_1 = new JLabel("A-");
		lblNewLabel_2_6_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_6_1.setBounds(149, 10, 67, 63);
		panel_1.add(lblNewLabel_2_6_1);
		
		table2 = new JTable();
		table2.setShowVerticalLines(false);
		table2.setShowHorizontalLines(false);
		table2.setShowGrid(false);
		table2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		table2.setBounds(140, 90, 88, 27);
		panel_1.add(table2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				
			
			}
		});
		panel_4.setBackground(new Color(165, 42, 42));
		panel_4.setBounds(424, 201, 253, 204);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton_1_3 = new JButton("View Stock");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ABnegetive obj= new ABnegetive();
				obj.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_3.setBounds(57, 144, 163, 33);
		panel_4.add(btnNewButton_1_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Total Units");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(40, 61, 90, 63);
		panel_4.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_5_3 = new JLabel("Blood Group");
		lblNewLabel_2_5_3.addContainerListener(new ContainerAdapter() {
			
		});
		lblNewLabel_2_5_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_5_3.setBounds(40, 5, 124, 63);
		panel_4.add(lblNewLabel_2_5_3);
		
		JLabel lblNewLabel_2_6_3 = new JLabel("AB-");
		lblNewLabel_2_6_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_6_3.setBounds(153, 5, 67, 63);
		panel_4.add(lblNewLabel_2_6_3);
		
		table4 = new JTable();
		table4.setShowVerticalLines(false);
		table4.setShowHorizontalLines(false);
		table4.setShowGrid(false);
		table4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		table4.setBounds(140, 78, 88, 26);
		panel_4.add(table4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				
				
				
				
			}
		});
		panel_5.setBackground(new Color(165, 42, 42));
		panel_5.setBounds(675, 201, 253, 204);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnNewButton_1_4 = new JButton("View Stock");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BPositive obj= new BPositive();
				obj.setVisible(true);
				dispose();	
			}
		});
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_4.setBounds(41, 148, 163, 33);
		panel_5.add(btnNewButton_1_4);
		
		JLabel lblNewLabel_2_4 = new JLabel("Total Units");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(31, 66, 90, 63);
		panel_5.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5_4 = new JLabel("Blood Group");
		lblNewLabel_2_5_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_5_4.setBounds(31, 10, 124, 63);
		panel_5.add(lblNewLabel_2_5_4);
		
		JLabel lblNewLabel_2_6_4 = new JLabel("B+");
		lblNewLabel_2_6_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_6_4.setBounds(144, 10, 67, 63);
		panel_5.add(lblNewLabel_2_6_4);
		
		table5 = new JTable();
		table5.setShowVerticalLines(false);
		table5.setShowHorizontalLines(false);
		table5.setShowGrid(false);
		table5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		table5.setBounds(131, 83, 88, 26);
		panel_5.add(table5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				
				
			}
		});
		panel_6.setBackground(new Color(165, 42, 42));
		panel_6.setBounds(925, 201, 253, 204);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnNewButton_1_5 = new JButton("View Stock");
		btnNewButton_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BNegetive obj= new BNegetive();
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1_5.setBounds(57, 148, 163, 33);
		panel_6.add(btnNewButton_1_5);
		
		JLabel lblNewLabel_2_7 = new JLabel("Total Units");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_7.setBounds(37, 62, 90, 63);
		panel_6.add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_2_5_5 = new JLabel("Blood Group");
		lblNewLabel_2_5_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_5_5.setBounds(37, 6, 124, 63);
		panel_6.add(lblNewLabel_2_5_5);
		
		JLabel lblNewLabel_2_6_5 = new JLabel("B-");
		lblNewLabel_2_6_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_6_5.setBounds(150, 6, 67, 63);
		panel_6.add(lblNewLabel_2_6_5);
		
		table6 = new JTable();
		table6.setShowGrid(false);
		table6.setShowHorizontalLines(false);
		table6.setShowVerticalLines(false);
		table6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		table6.setBounds(143, 88, 77, 26);
		panel_6.add(table6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				
			}
		});
		panel_7.setBackground(new Color(165, 42, 42));
		panel_7.setBounds(424, 400, 253, 210);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JButton btnNewButton_1_6 = new JButton("View Stock");
		btnNewButton_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Opositive obj= new Opositive();
				obj.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_6.setBounds(52, 155, 163, 33);
		panel_7.add(btnNewButton_1_6);
		
		JLabel lblNewLabel_2_8 = new JLabel("Total Units");
		lblNewLabel_2_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_8.setBounds(42, 73, 90, 63);
		panel_7.add(lblNewLabel_2_8);
		
		JLabel lblNewLabel_2_5_6 = new JLabel("Blood Group");
		lblNewLabel_2_5_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_5_6.setBounds(42, 17, 124, 63);
		panel_7.add(lblNewLabel_2_5_6);
		
		JLabel lblNewLabel_2_6_6 = new JLabel("O+");
		lblNewLabel_2_6_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_6_6.setBounds(155, 17, 67, 63);
		panel_7.add(lblNewLabel_2_6_6);
		
		table7 = new JTable();
		table7.setShowGrid(false);
		table7.setShowHorizontalLines(false);
		table7.setShowVerticalLines(false);
		table7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		table7.setBounds(144, 90, 71, 25);
		panel_7.add(table7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
			
			}
		});
		panel_8.setBackground(new Color(165, 42, 42));
		panel_8.setBounds(675, 400, 253, 210);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JButton btnNewButton_1_7 = new JButton("View Stock");
		btnNewButton_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Onegetive obj= new Onegetive();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_7.setBounds(46, 156, 163, 33);
		panel_8.add(btnNewButton_1_7);
		
		JLabel lblNewLabel_2_9 = new JLabel("Total Units");
		lblNewLabel_2_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_9.setBounds(36, 74, 90, 63);
		panel_8.add(lblNewLabel_2_9);
		
		JLabel lblNewLabel_2_5_7 = new JLabel("Blood Group");
		lblNewLabel_2_5_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_5_7.setBounds(36, 18, 124, 63);
		panel_8.add(lblNewLabel_2_5_7);
		
		JLabel lblNewLabel_2_6_7 = new JLabel("O-");
		lblNewLabel_2_6_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_6_7.setBounds(149, 18, 67, 63);
		panel_8.add(lblNewLabel_2_6_7);
		
		table8 = new JTable();
		table8.setShowGrid(false);
		table8.setShowHorizontalLines(false);
		table8.setShowVerticalLines(false);
		table8.setFont(new Font("Tahoma", Font.PLAIN, 22));
		table8.setBounds(136, 91, 73, 26);
		panel_8.add(table8);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
	
			}
		});
		panel_3.setBackground(new Color(165, 42, 42));
		panel_3.setBounds(925, 0, 253, 204);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_1_2 = new JButton("View Stock");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABPosivite obj= new ABPosivite();
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2.setBounds(47, 150, 163, 33);
		panel_3.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Total Units");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(27, 66, 90, 63);
		panel_3.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_5_2 = new JLabel("Blood Group");
		lblNewLabel_2_5_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_5_2.setBounds(27, 10, 124, 63);
		panel_3.add(lblNewLabel_2_5_2);
		
		JLabel lblNewLabel_2_6_2 = new JLabel("AB+");
		lblNewLabel_2_6_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_6_2.setBounds(140, 10, 67, 63);
		panel_3.add(lblNewLabel_2_6_2);
		
		table3 = new JTable();
		table3.setShowGrid(false);
		table3.setShowHorizontalLines(false);
		table3.setShowVerticalLines(false);
		table3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		table3.setBounds(127, 92, 83, 26);
		panel_3.add(table3);
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8_1.setBackground(new Color(165, 42, 42));
		panel_8_1.setBounds(925, 400, 253, 210);
		contentPane.add(panel_8_1);
		panel_8_1.setLayout(null);
		
		JButton btnNewButton_1_8 = new JButton("Remove Expired blood");
		btnNewButton_1_8.setBackground(new Color(0, 0, 0));
		btnNewButton_1_8.setForeground(Color.WHITE);
		btnNewButton_1_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveBlood obj= new RemoveBlood();
				obj.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton_1_8.setBounds(10, 75, 221, 58);
		panel_8_1.add(btnNewButton_1_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(165, 42, 42));
		panel_9.setBounds(0, 609, 1195, 101);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
	}
}
