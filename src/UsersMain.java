import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;


import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class UsersMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersMain frame = new UsersMain();
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
	
	Connection conn= null;
	PreparedStatement pst= null;
	ResultSet rs=null;
	private JTable table;
	public UsersMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/BBMS" + "?user=root&password="); 
				
						String query = "SELECT * FROM user";
						pst=(PreparedStatement) conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						while(rs.next()){
							
						}
						
						pst.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1137, 616);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(847, -26, 344, 613);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("user.png"));
		lblNewLabel_2 .setIcon(img);
		lblNewLabel_2.setBounds(93, 34, 150, 147);
		panel_1.add(lblNewLabel_2);
		
		JButton btnAddUsers = new JButton("ADD USER");
		btnAddUsers.setBounds(40, 206, 206, 57);
		panel_1.add(btnAddUsers);
		btnAddUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserReg wlm = new UserReg();
				wlm.setVisible(true);
				dispose();
			}
		});
		btnAddUsers.setForeground(Color.WHITE);
		btnAddUsers.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddUsers.setBackground(Color.BLUE);
		
		JButton btnUpdate = new JButton("UPDATE USER");
		btnUpdate.setBounds(40, 313, 206, 57);
		panel_1.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Update wlm = new User_Update();
				wlm.setVisible(true);
				dispose();
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate.setBackground(Color.BLUE);
		
		JButton btnDelete = new JButton("DELETE USER");
		btnDelete.setBounds(40, 416, 206, 57);
		panel_1.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Update wlm = new User_Update();
				wlm.setVisible(true);
				dispose();
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBackground(Color.BLUE);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(40, 522, 206, 51);
		panel_1.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFormlogafter wlm = new MainFormlogafter();
				wlm.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBack.setBackground(Color.GRAY);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		panel.setBounds(0, 0, 903, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Details");
		lblNewLabel.setBounds(356, 10, 244, 49);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(37, 76, 812, 503);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("blueback.jpg"));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(img1);
		lblNewLabel_1.setBounds(-146, 0, 1191, 612);
		contentPane.add(lblNewLabel_1);
	}
}
