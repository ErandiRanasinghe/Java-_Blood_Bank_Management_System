import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class DonorMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorMain frame = new DonorMain();
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
	
	public DonorMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost:3308/BBMS" + "?user=root&password="); 
				
						String query = "SELECT * FROM donor";
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
		setBounds(100, 100, 1218, 584);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(958, 75, 273, 528);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAddNewDonor = new JButton("ADD DONOR");
		btnAddNewDonor.setBounds(48, 28, 159, 59);
		panel_1.add(btnAddNewDonor);
		btnAddNewDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonorReg newjframe = new DonorReg ();
				newjframe.setVisible(true);
				dispose();	
			}
		});
		btnAddNewDonor.setForeground(Color.WHITE);
		btnAddNewDonor.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddNewDonor.setBackground(new Color(153, 0, 204));
		
		JButton btnUpdateDonor = new JButton("UPDATE DONOR");
		btnUpdateDonor.setBounds(48, 112, 159, 59);
		panel_1.add(btnUpdateDonor);
		btnUpdateDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Donor_Update newjframe = new Donor_Update ();
				newjframe.setVisible(true);
				dispose();
			}
		});
		btnUpdateDonor.setForeground(Color.WHITE);
		btnUpdateDonor.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateDonor.setBackground(new Color(153, 0, 204));
		
		JButton btnDeleteDonor = new JButton("DELETE DONOR");
		btnDeleteDonor.setBounds(48, 204, 159, 59);
		panel_1.add(btnDeleteDonor);
		btnDeleteDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Donor_Update newjframe = new Donor_Update ();
				newjframe.setVisible(true);
				dispose();	
			}
		});
		btnDeleteDonor.setForeground(Color.WHITE);
		btnDeleteDonor.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteDonor.setBackground(new Color(153, 0, 204));
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(48, 293, 159, 52);
		panel_1.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFormlogafter newjframe = new MainFormlogafter ();
				newjframe.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(Color.GRAY);
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(48, 371, 159, 52);
		panel_1.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBackground(new Color(178, 34, 34));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1355, 76);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDonorDetails = new JLabel("Donor Details");
		lblDonorDetails.setBounds(465, 10, 207, 48);
		panel.add(lblDonorDetails);
		lblDonorDetails.setForeground(Color.WHITE);
		lblDonorDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 75, 886, 472);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/BloodDBk.jpg"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(-83, 75, 1408, 528);
		contentPane.add(lblNewLabel);
		
		
	}
}
