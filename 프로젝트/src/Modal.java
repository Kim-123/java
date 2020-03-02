import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Modal extends JDialog{
	public Modal(int row, String name){
		setSize(400,260);
		setLayout(null);
		JLabel lb = new JLabel("Enter Text");
		lb.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 25));
		lb.setBounds(100,30,200,50);
		JTextField field = new JTextField(10);
		field.setBounds(100,80,200, 30);
		
		JButton btn = new JButton("Change?");
		btn.setBounds(100,130, 200, 40);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//label.setText(field.getText());
				Customer.update(row, name, field.getText());
				dispose();
			}
			
		});
		
		add(field);
		add(btn);
		add(lb);
	}
}