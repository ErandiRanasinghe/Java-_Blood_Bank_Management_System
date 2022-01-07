								/* --Please Pay Your Attention--
								 * I load This form's layout in the window opened load(purpose for change settings with userRoles). So without running this page, 
								 * You can't see the layout. 
								 * And before running this form you need to log in to the system through login form.If you run this form without running the loging form it may be show a error in the console.  
								
								 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFormlogafter extends JFrame {

	
	private JPanel contentPane;
	private Button btnUser;
	private Button btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFormlogafter frame = new MainFormlogafter();
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
	public MainFormlogafter() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 1351, 867);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(0, 0, 0));
				panel.setBounds(0, 0, 461, 844);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JButton btnHome = new JButton("HOME");
				btnHome.setBackground(new Color(0, 0, 0));
				btnHome.setHorizontalAlignment(SwingConstants.LEFT);
				btnHome.setForeground(SystemColor.controlDkShadow);
				btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnHome.setBounds(96, 51, 276, 56);
				panel.add(btnHome);
				
				JButton btnUser = new JButton("USER ");
				btnUser.setForeground(Color.WHITE);
				btnUser.setBackground(new Color(0, 0, 0));
				btnUser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UsersMain wlm = new UsersMain();
						wlm.setVisible(true);
						dispose();
						
					}
				});
				btnUser.setHorizontalAlignment(SwingConstants.LEFT);
				btnUser.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnUser.setBounds(96, 143, 276, 56);
				panel.add(btnUser);
				
				JButton btnDonor = new JButton("DONOR");
				btnDonor.setForeground(Color.WHITE);
				btnDonor.setBackground(new Color(0, 0, 0));
				btnDonor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						DonorMain wlm = new DonorMain();
						wlm.setVisible(true);
						dispose();
						
					}
				});
				btnDonor.setHorizontalAlignment(SwingConstants.LEFT);
				btnDonor.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnDonor.setBounds(96, 236, 276, 56);
				panel.add(btnDonor);
				
				JButton btnBloodCollecting = new JButton("BLOOD COLLECTING");
				btnBloodCollecting.setForeground(Color.WHITE);
				btnBloodCollecting.setBackground(new Color(0, 0, 0));
				btnBloodCollecting.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CollectBlood wlm = new CollectBlood();
						wlm.setVisible(true);
						dispose();
						
					}
				});
				btnBloodCollecting.setHorizontalAlignment(SwingConstants.LEFT);
				btnBloodCollecting.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnBloodCollecting.setBounds(96, 327, 276, 56);
				panel.add(btnBloodCollecting);
				
				JButton btnBloodInventory = new JButton("BLOOD INVENTORY");
				btnBloodInventory.setForeground(Color.WHITE);
				btnBloodInventory.setBackground(new Color(0, 0, 0));
				btnBloodInventory.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BloodStock wlm = new BloodStock();
						wlm.setVisible(true);
						dispose();
					}
				});
				btnBloodInventory.setHorizontalAlignment(SwingConstants.LEFT);
				btnBloodInventory.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnBloodInventory.setBounds(96, 426, 276, 56);
				panel.add(btnBloodInventory);
				
				JButton btnUserRegistration_4 = new JButton("BLOOD CAMPS");
				btnUserRegistration_4.setBackground(Color.BLACK);
				btnUserRegistration_4.setForeground(Color.WHITE);
				btnUserRegistration_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						BloodCamps wlm = new BloodCamps();
						wlm.setVisible(true);
						dispose();
						
						
					}
				});
				btnUserRegistration_4.setHorizontalAlignment(SwingConstants.LEFT);
				btnUserRegistration_4.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnUserRegistration_4.setBounds(96, 528, 276, 56);
				panel.add(btnUserRegistration_4);
				
				JButton btnSearch = new JButton("SEARCH");
				btnSearch.setForeground(Color.WHITE);
				btnSearch.setBackground(new Color(0, 0, 0));
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Search obj = new Search();
						obj.setVisible(true);
						dispose();
						
					}
				});
				btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
				btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnSearch.setBounds(96, 625, 275, 56);
				panel.add(btnSearch);
				
				JButton btnUserRegistration_4_1_2_1 = new JButton("LOG OUT");
				btnUserRegistration_4_1_2_1.setForeground(Color.WHITE);
				btnUserRegistration_4_1_2_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						System.exit(0);
						
						
					}
				});
				btnUserRegistration_4_1_2_1.setBackground(new Color(255, 0, 0));
				btnUserRegistration_4_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
				btnUserRegistration_4_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnUserRegistration_4_1_2_1.setBounds(96, 729, 275, 56);
				panel.add(btnUserRegistration_4_1_2_1);
				
				JLabel lblNewLabel_1 = new JLabel("");
				ImageIcon img = new ImageIcon(this.getClass().getResource("/iconnew.jpg"));
				lblNewLabel_1.setIcon(img);
				lblNewLabel_1.setBounds(260, 0, 1078, 830);
				contentPane.add(lblNewLabel_1);
				
				if(Login.userRole.equals("Admin")) {
					btnUser.setEnabled(true);
					btnSearch.setEnabled(true);
				}else {
					btnUser.setEnabled(false);
					btnSearch.setEnabled(false);
				}
				
			}
		});
	}
}
