import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frame;
	private JTextField id;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setLocationRelativeTo(null); //화면 가운데
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImgPanel panel = new ImgPanel(new ImageIcon("C:\\자바학습\\프로젝트\\image\\photo1.jpeg").getImage());
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("바탕체", Font.BOLD, 40));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(263, 134, 175, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD398\uC774\uC9C0");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("바탕체", Font.BOLD, 40));
		lblNewLabel_1.setBounds(318, 178, 136, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC544\uC774\uB514 :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("바탕체", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(25, 601, 116, 24);
		panel.add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBounds(153, 601, 116, 24);
		panel.add(id);
		id.setColumns(10);
		//주석수정1
		JLabel lblNewLabel_2_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("바탕체", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(25, 635, 116, 24);
		panel.add(lblNewLabel_2_1);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(153, 635, 116, 24);
		panel.add(pass);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer.login(id.getText(), pass.getText());
			}
		});
		btnNewButton.setFont(new Font("바탕체", Font.PLAIN, 11));
		btnNewButton.setBounds(278, 601, 73, 58);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Join().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(25, 669, 150, 24);
		panel.add(btnNewButton_1);
		frame.pack();
	}
}

class ImgPanel extends JPanel{
	private Image img;
	
	public ImgPanel(Image img){
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, null);
	}
}