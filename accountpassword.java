package purchasing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import tw.Ting.mytest.BCrypt;


public class accountpassword extends JFrame  {
	private JTextField account;
	private JTextField passwd;
	private JPanel JP;
	private JLabel in,pass, acc;
	private JButton login,register;
	public accountpassword(){
		setBounds(500, 200, 300, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		account = new JTextField();
		passwd =new JPasswordField();
		in = new JLabel("歡迎來到採購系統");
		pass  = new JLabel("輸入密碼:");
		acc = new JLabel("輸入帳號:");
		JP = new JPanel();
		login = new JButton("登入");
		register = new JButton("註冊");
		setContentPane(JP);
		JP.setLayout(null);
		
		account.setBounds(130,65,100,30);
		account.setToolTipText("請輸入帳號");
		passwd.setBounds(130,110,100,30);
		passwd.setToolTipText("請輸入密碼");
		in.setBounds(50,30,100,15);acc.setBounds(50, 70, 100, 15);pass.setBounds(50,115,100,15);login.setBounds(100,150, 60, 20);register.setBounds(180,150,60,20);
		JP.add(account);JP.add(passwd);JP.add(in);JP.add(acc);JP.add(pass);JP.add(login);JP.add(register);
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Myjf123();
				
			}
		});
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/purchsaing", prop);
			String acount = account.getText();
			String password = passwd.getText().toString();
			System.out.println(passwd.getText().toString());
			
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT account,passwd FROM actpswd WHERE account = ?");
			pstmt.setString(1, acount);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String haspassWd= rs.getString("passwd");
				if(BCrypt.checkpw(password, haspassWd)) {
					new Purchasing();
					System.out.println("ok");
				}else {
					JOptionPane.showMessageDialog(null, "密碼錯誤");
					System.out.println("密碼錯error1");
				}
			}else {
				JOptionPane.showMessageDialog(null, "帳號錯誤");
				System.out.println("帳號錯error2");
			}
			conn.close();
			System.out.println("OK");
		} catch (Exception e1) {
			System.out.println(e1.toString());
		}
		
	
			}
		});
		
		setVisible(true);		
	}
}
