import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CustomerTable extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerTable frame = new CustomerTable();
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
	public CustomerTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//String[][] data = Customer.getCustomers();
		String[][] data = { { "1", "2", "3", "4", "5"}, { "1", "2", "3", "4", "5"}, { "1", "2", "3", "4", "5"}};
		String[] headers = {"ID", "PASS", "GENDER", "PHONE", "NOTE"};
		
		DefaultTableModel model = new DefaultTableModel(data, headers);
		
		
		JTable table = new JTable(model);
		table.setFont(new Font("바탕", Font.BOLD, 18));
		table.setRowHeight(30); //테이블높이
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setLocation(5,92);
		scrollPane.setSize(574, 314);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("\uB9AC\uD504\uB808\uC26C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0); //테이블 데이터 모두 삭제
				String[][] data = Customer.getCustomers();
				for (int i = 0; i < data.length; i++) {
					model.addRow(data[i]);
				}
			}
		});
		btnNewButton.setBounds(443, 25, 97, 23);
		contentPane.add(btnNewButton);
		
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		search.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		search.setBounds(12, 10, 249, 48);
		contentPane.add(search);
		search.setColumns(10);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row =  table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				
				String[] headers = {"id", "pass", "gender", "phone", "note"};
				
				if(row >= 0 && col >= 0) {
					//JOptionPane.showMessageDialog(null, row + "," + col);
					new Modal(row, headers[col])
					.setVisible(true);
				}
				
			}
		});
	
	}
}
