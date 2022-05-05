package purchasing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import tw.Ting.mytest.BCrypt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Myjf123 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;//輸入帳號
	private JTextField textField_1;//輸入密碼
	private JTextField textField_2;//輸入姓名
	private String[] gender={"男","女"};
	private int[] year ;//本來的正常值
	private int[] month ;//本來的正常值
	private int[] date ;//本來的正常值
	private int days=31;//計算閏年跟月份
	private JComboBox comboBox;//年下拉式選單
	private JComboBox comboBox_1;//月份下拉式選單
	private JComboBox comboBox_2;//日期//下拉式選單
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Myjf123 frame = new Myjf123();
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
	public Myjf123() {
		
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 459, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("註冊");
		lblNewLabel.setBounds(201, 27, 46, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("輸入帳號");
		lblNewLabel_1.setBounds(70, 65, 72, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("輸入密碼");
		lblNewLabel_2.setBounds(70, 105, 72, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("輸入姓名");
		lblNewLabel_3.setBounds(70, 150, 72, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("輸入生日");
		lblNewLabel_4.setBounds(70, 195, 72, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("男生/女生");
		lblNewLabel_5.setBounds(70, 240, 72, 15);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(218, 62, 165, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 102, 165, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(218, 147, 165, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(216, 191, 63, 23);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(305, 191, 39, 23);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(369, 191, 39, 23);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox(gender);
		comboBox_3.setBounds(218, 236, 39, 23);
		contentPane.add(comboBox_3);
		
		JLabel lblNewLabel_6 = new JLabel("年");
		lblNewLabel_6.setBounds(289, 186, 31, 32);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("月");
		lblNewLabel_6_1.setBounds(346, 186, 31, 32);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("日");
		lblNewLabel_6_2.setBounds(414, 186, 31, 32);
		contentPane.add(lblNewLabel_6_2);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.setBounds(171, 327, 85, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Properties prop = new Properties();
				prop.put("user", "root");
				prop.put("password", "");
				String sql1 = "INSERT INTO actpswd(account,passwd) VALUES (?,?)";
				String sql2 ="INSERT INTO information(name,birthday,gender) VALUES (?,?,?)";
				ResultSet rs;
				
				try (Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/purchsaing",prop);){
						
					PreparedStatement pstmt = conn.prepareStatement(sql1
							);//要加此兩列才可以變更資料增刪修都可以
					pstmt.setString(1, textField.getText());
					pstmt.setString(2, BCrypt.hashpw(textField_1.getText(), BCrypt.gensalt()));
					PreparedStatement pstmt2 = conn.prepareStatement(sql2
							);
					pstmt2.setString(1, textField_2.getText());
					pstmt2.setString(2, comboBox.getSelectedItem().toString()+"-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_2.getSelectedItem().toString());
					pstmt2.setString(3, comboBox_3.getSelectedItem().toString());
					// 4. execute SQL statement
					pstmt.executeUpdate();
					pstmt2.executeUpdate();					
					
				} catch(SQLIntegrityConstraintViolationException e2){
					JOptionPane.showMessageDialog(null, "帳號重複");
				}catch (Exception e1) {
					
					System.out.println(e1.toString());
				}
				
			}
		});
		
		for(int i =2022;i>=1917;i--) {
			comboBox.addItem(i);
		}
		for(int i =1;i<=12;i++) {
			comboBox_1.addItem(i);
		}
		for(int i =1;i<=31;i++) {
			comboBox_2.addItem(i);
		}
		comboBox.addActionListener(this);//同樣聽用||去代值
		comboBox_1.addActionListener(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==comboBox||e.getSource()==comboBox_1) {//選任何年月觸發需要改變的日
			comboBox_2.removeAllItems();//選時先移除所有項目
			int yearnum = Integer.parseInt(comboBox.getSelectedItem().toString());//讀出年份轉化為INT型
			int monthnum = Integer.parseInt(comboBox_1.getSelectedItem().toString());//讀出月份轉化為int型
			if(monthnum==4||monthnum==6||monthnum==9||monthnum==11){//代入小月判斷式
				days=30;}
			else if(monthnum==2) {
				if(yearnum%400 == 0 || (yearnum % 4 ==0 && yearnum% 100 !=0)) {//代入2月閏年判斷式(year%400 == 0 || (year % 4 ==0 && year% 100 !=0))
					days=29;
				}else {
				days=28;
				}
			}else {
			days=31;
			}
			for(int i =1;i<=days;i++) {//添加判斷至輸入值中
				comboBox_2.addItem(i);}
		}		
	}
}
