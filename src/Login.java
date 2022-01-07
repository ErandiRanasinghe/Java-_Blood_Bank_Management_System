import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	

	
	Connection con = null;
	PreparedStatement pst=null;
	ResultSet rs = null;
	
	
	private JPanel contentPane;
	private JTextField textFieldUserID;
	public JComboBox<String> comboBoxlog;
	private JTextField textFieldPassword;
	
	public static String userRole = null;
	/**
	 * Launch the application.
	 * @return 
	 */		
	
	public static void main(String[] args) {

		EventQueue eventQueue = new EventQueue();
		EventQueue.invokeLater(new Runnable() {
		
			public void run() {
				
				try {
					Login frame = new Login();
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
	
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBounds(594, 608, 168, 48);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1000, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabeladminLogin = new JLabel("User Login");
		lblNewLabeladminLogin.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabeladminLogin.setForeground(Color.WHITE);
		lblNewLabeladminLogin.setBounds(337, 10, 281, 55);
		panel.add(lblNewLabeladminLogin);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBackground(new Color(255, 51, 102));
		contentPane.add(btnExit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(89, 608, 177, 48);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainform mainframe = new Mainform();
				mainframe.setVisible(true);
				dispose();
				
				
			}

		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(Color.GRAY);
		contentPane.add(btnBack);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setForeground(Color.WHITE);
		btnClear.setBounds(348, 608, 168, 48);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldUserID.setText(null);
				textFieldPassword.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBackground(Color.BLUE);
		contentPane.add(btnClear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(86, 148, 676, 384);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(77, 290, 519, 41);
		panel_1.add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnLogin.setBackground(new Color(0, 0, 255));
		
		JLabel lbluserID = new JLabel("User ID");
		lbluserID.setBounds(84, 77, 168, 33);
		panel_1.add(lbluserID);
		lbluserID.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		textFieldUserID = new JTextField();
		textFieldUserID.setBounds(330, 69, 266, 41);
		panel_1.add(textFieldUserID);
		textFieldUserID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldUserID.setColumns(10);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(84, 134, 168, 33);
		panel_1.add(lblpassword);
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setBounds(84, 186, 168, 33);
		panel_1.add(lblUserType);
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		comboBoxlog = new JComboBox<String>();
		comboBoxlog.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxlog.addItem("");
		comboBoxlog.addItem("Admin");
		comboBoxlog.addItem("Other User");
		comboBoxlog.setBounds(329, 186, 267, 41);
		panel_1.add(comboBoxlog);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Webdings", Font.PLAIN, 18));
		textFieldPassword.setBounds(330, 126, 266, 41);
		panel_1.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/userbg.jpg"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(0, 0, 1000, 688);
		contentPane.add(lblNewLabel);
		
		
		
		btnLogin.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				userRole = comboBoxlog.getSelectedItem().toString();
				try{
					String query = "SELECT * FROM `login` WHERE UserID=? and Password=? and UserType=?";
					con = DriverManager.getConnection("jdbc:mysql://localhost/BBMS", "root", "");
					pst=(PreparedStatement) con.prepareStatement(query);
					pst.setString(1, textFieldUserID.getText());
					pst.setString(2, textFieldPassword.getText());
					pst.setString(3, userRole ) ;
					rs=pst.executeQuery();
					if(rs.next()){
					MainFormlogafter a = new MainFormlogafter();
					a.setVisible(true);
					dispose();}
					else{
					JOptionPane.showMessageDialog(null, "UserID , Password and UserType does not matched");

					}
					}
					catch(Exception ex){
					JOptionPane.showMessageDialog(null, this, ex.getMessage(), getDefaultCloseOperation());

					}}
				
			
	});
		
			
		
	}

}
