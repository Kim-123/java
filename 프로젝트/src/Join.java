import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Join extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField pass;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join frame = new Join();
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
	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 361);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel laJoin = new JLabel("\uD68C\uC6D0\uAC00\uC785 \uD398\uC774\uC9C0");
		laJoin.setFont(new Font("맑은 고딕", Font.BOLD, 29));
		laJoin.setHorizontalAlignment(SwingConstants.CENTER);
		laJoin.setBounds(97, 10, 389, 51);
		panel.add(laJoin);
		
		JLabel laId = new JLabel("\uC544\uC774\uB514");
		laId.setFont(new Font("바탕체", Font.BOLD, 20));
		laId.setBounds(47, 104, 111, 39);
		panel.add(laId);
		
		JLabel laPass = new JLabel("\uBE44\uBC00\uBC88\uD638");
		laPass.setFont(new Font("바탕체", Font.BOLD, 20));
		laPass.setBounds(47, 164, 111, 39);
		panel.add(laPass);
		
		JLabel laGender = new JLabel("\uC131\uBCC4");
		laGender.setFont(new Font("바탕체", Font.BOLD, 20));
		laGender.setBounds(47, 228, 111, 39);
		panel.add(laGender);
		
		JLabel laPhone = new JLabel("\uC804\uD654\uBC88\uD638");
		laPhone.setFont(new Font("바탕체", Font.BOLD, 20));
		laPhone.setBounds(282, 104, 111, 39);
		panel.add(laPhone);
		
		JLabel laNote = new JLabel("\uD2B9\uC774\uC0AC\uD56D");
		laNote.setFont(new Font("바탕체", Font.BOLD, 20));
		laNote.setBounds(282, 164, 111, 39);
		panel.add(laNote);
		
		id = new JTextField();
		id.setBounds(142, 110, 128, 32);
		panel.add(id);
		id.setColumns(10);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(142, 170, 128, 32);
		panel.add(pass);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(382, 111, 128, 32);
		panel.add(phone);
		
		
		String[] combo = { "남성" , "여성" };
		JComboBox gender = new JComboBox(combo);
		gender.setBounds(142, 228, 128, 35);
		panel.add(gender);
		
		JTextArea note = new JTextArea();
		note.setFont(new Font("바탕체", Font.PLAIN, 16));
		note.setBounds(382, 164, 128, 97);
		panel.add(note);
		
		JButton btnJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idTxt = id.getText();
				String passTxt = pass.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String phonTxt = phone.getText();
				String noteTxt = note.getText();
				Customer.createCustomer(idTxt, passTxt, genderTxt, phonTxt, noteTxt);
				JOptionPane.showMessageDialog(null, "성공적으로 저장되었습니다.");
				dispose();
				//new 다른프레임().setVisible(true);
				
			}
		});
		btnJoin.setBounds(233, 294, 111, 32);
		panel.add(btnJoin);
	}
}
