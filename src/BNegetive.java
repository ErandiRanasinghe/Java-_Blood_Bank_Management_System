import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BNegetive extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conn= null;
	PreparedStatement pst= null;
	ResultSet rs=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BNegetive frame = new BNegetive();
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
	public BNegetive() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					 conn =DriverManager.getConnection("" + "jdbc:mysql://localhost/BBMS" + "?user=root&password="); 
				
						String query = "SELECT BloodGroup,Unit,ExpireDate FROM Bloodunit WHERE BloodGroup='B-'";
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
		setBounds(100, 100, 637, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 153, 255));
		panel.setBounds(0, 0, 630, 72);
		contentPane.add(panel);
		
		JLabel lblBBloodGroup_1 = new JLabel(" B-  Blood Group");
		lblBBloodGroup_1.setForeground(Color.WHITE);
		lblBBloodGroup_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBBloodGroup_1.setBackground(Color.BLACK);
		lblBBloodGroup_1.setBounds(196, 22, 241, 27);
		panel.add(lblBBloodGroup_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 153, 255));
		panel_1.setBounds(0, 561, 630, 72);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BloodStock obj= new BloodStock();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(240, 20, 126, 30);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 94, 478, 439);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
