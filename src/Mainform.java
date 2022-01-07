import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainform extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainform frame = new Mainform();
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
	public Mainform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1109, 788);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/NEWMAIN3.jpg"));
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(481, 83, 250, 86);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAdmin_1_1 = new JButton("LOGIN");
		btnAdmin_1_1.setBounds(67, 24, 125, 39);
		panel.add(btnAdmin_1_1);
		btnAdmin_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login newjframe = new Login ();
				newjframe.setVisible(true);
				dispose();
				
			}
		});
		btnAdmin_1_1.setForeground(new Color(0, 0, 0));
		btnAdmin_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnAdmin_1_1.setBackground(Color.CYAN);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(219, 112, 147));
		panel_1.setBounds(764, 83, 250, 86);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnLogout = new JButton("EXIT");
		btnLogout.setBounds(67, 26, 125, 39);
		panel_1.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setForeground(new Color(0, 0, 0));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogout.setBackground(Color.PINK);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setBounds(0, 0, 1103, 761);
		lblNewLabel.setIcon(img);
		contentPane.add(lblNewLabel);
	}
}
