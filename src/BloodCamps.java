import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BloodCamps extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodCamps frame = new BloodCamps();
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
	
	public BloodCamps() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/BBMS" + "?user=root&password="); 
				
						String query = "SELECT * FROM bloodcamp";
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
		setBounds(200, 100, 903, 653);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 120, 830, 360);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DATE", "EVENT", "VANUE"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.LIGHT_GRAY);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("ADD NEW EVENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addnewbloodcamp newjframe = new Addnewbloodcamp ();
				newjframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(671, 519, 196, 49);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("UPDATE EVENTS");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCamps newjframe = new EditCamps ();
				newjframe.setVisible(true);
				dispose();
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(204, 0, 51));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(216, 519, 196, 49);
		contentPane.add(btnExit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFormlogafter newjframe = new MainFormlogafter();
				newjframe.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.GRAY);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(37, 519, 150, 49);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("UPCOMING BLOOD CAMPS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(265, 36, 465, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnDeletePastEvents = new JButton("DELETE PAST EVENTS");
		btnDeletePastEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCamps newjframe = new EditCamps ();
				newjframe.setVisible(true);
				dispose();
			}
		});
		btnDeletePastEvents.setForeground(Color.WHITE);
		btnDeletePastEvents.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeletePastEvents.setBackground(Color.BLUE);
		btnDeletePastEvents.setBounds(438, 519, 211, 49);
		contentPane.add(btnDeletePastEvents);
	}
}
