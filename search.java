package purchasing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search frame = new search();
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
	public search() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 113);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("輸入要查詢文字");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("選擇要查詢欄位");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel_1)
							.addGap(29)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/purchsaing", prop);		
			PreparedStatement pstmt = conn.prepareStatement(
				"SELECT * FROM employees",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs;
		
		rs = pstmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		panel.setLayout(gl_panel);
	}
}
