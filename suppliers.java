package purchasing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class suppliers extends JPanel{//員工修查
	private JButton create;
	private JButton delete;
	private JButton update;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private MyModel mymodel;
	private JScrollPane scrollPane1;

	private String[] name = {"供應商代碼","公司名稱","代表人","經營類型","電話","信箱","地址"};
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
//	private String[] value ;
	public suppliers(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		setSize(800,800);

		
		
		JLabel lblNewLabel = new JLabel("供應商代碼");
		
		JLabel lblNewLabel_1 = new JLabel("公司名稱");
		
		JLabel lblNewLabel_2 = new JLabel("代表人");
		
		JLabel lblNewLabel_3 = new JLabel("經營類型");
		
		JLabel lblNewLabel_4 = new JLabel("電話");
		
		JLabel lblNewLabel_5 = new JLabel("信箱");
		
		JLabel lblNewLabel_6 = new JLabel("地址");
		
		JButton btnNewButton = new JButton("新增");
		

		JButton btnNewButton_1 = new JButton("刪除");

		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("修改");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_4)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(62))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addComponent(btnNewButton_1)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		mymodel = new MyModel();

		JTable table = new JTable();
		table.setModel(mymodel);
		JScrollPane scrollPane1 = new JScrollPane(table);
		add(scrollPane1, BorderLayout.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Properties prop = new Properties();
				prop.put("user", "root");
				prop.put("password", "");
				String sql1 = "INSERT INTO suppliers(SuppliersId,CompanyName,ContactName,TypeOfCompany,Phone,Email,address) VALUES (?,?,?,?,?,?,?)";
				ResultSet rs;
				
				try (Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/purchsaing",prop);){
					if(!textField.getText().equals("") && !textField_1.getText().equals("") &&!textField_2.getText().equals("") &&!textField_3.getText().equals("") &&!textField_4.getText().equals("") &&!textField_5.getText().equals("") &&!textField_6.getText().equals("") )	 {
					PreparedStatement pstmt = conn.prepareStatement(sql1
							);
					pstmt.setString(1, textField.getText());
					pstmt.setString(2, textField_1.getText());
					pstmt.setString(3, textField_2.getText());
					pstmt.setString(4, textField_3.getText());
					pstmt.setString(5, textField_4.getText());
					pstmt.setString(6, textField_5.getText());
					pstmt.setString(7, textField_6.getText());
					
					
					// 篩選輸入字串用字串擷取
					pstmt.executeUpdate();
					
					}
					else {
						System.out.println("INSERT FAIL");//TODO 彈出視窗輸入不完全或錯誤
					}	
				} catch(SQLIntegrityConstraintViolationException e2) {
					JOptionPane.showMessageDialog(null, "供應商編號重複");
					textField.setText("");
				} catch (Exception e1) {
					System.out.println(e1.toString());
				}
				mymodel.refresh();
				

			}
		});	
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Properties prop = new Properties();
					prop.put("user", "root");
					prop.put("password", "");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost/purchsaing", prop);
					
					PreparedStatement pstmt = conn.prepareStatement(
							"DELETE FROM suppliers WHERE SuppliersId = ?");
					if(table.getSelectedRow()!=-1) { 
					pstmt.setString(1, table.getValueAt(table.getSelectedRow(),0)+"");
					}
					pstmt.executeUpdate();
					
					
					conn.close();
					System.out.println("OK");

				} catch (SQLException e1) {
					System.out.println(e.toString());
				}
				mymodel.refresh();
			}
		});
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				textField.setText( table.getValueAt(table.getSelectedRow(),0)+"");
				textField_1.setText( table.getValueAt(table.getSelectedRow(),1)+"");
				textField_2.setText( table.getValueAt(table.getSelectedRow(),2)+"");
				textField_3.setText( table.getValueAt(table.getSelectedRow(),3)+"");
				textField_4.setText( table.getValueAt(table.getSelectedRow(),4)+"");
				textField_5.setText( table.getValueAt(table.getSelectedRow(),5)+"");
				textField_6.setText( table.getValueAt(table.getSelectedRow(),6)+"");
				//選取後如果ID修改跳出警告提示1.撞到同個資料2.

			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "修改請輸入值");
				}else if(!(table.getValueAt(table.getSelectedRow(),0)+"").equals(textField.getText())) {
				JOptionPane.showMessageDialog(null, "產品編號無法變更");
				textField.setText( table.getValueAt(table.getSelectedRow(),0)+"");
				}
				else {
				Properties prop = new Properties();
				prop.put("user", "root");prop.put("password", "");
				String sql ="UPDATE suppliers SET CompanyName = ?,ContactName = ?,TypeOfCompany = ?,Phone = ?,Email = ?,address = ? WHERE SuppliersId =?";
				
				
				try(Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchsaing",prop)){
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(7, textField.getText());
					pstmt.setString(1, textField_1.getText());
					pstmt.setString(2, textField_2.getText());
					pstmt.setString(3, textField_3.getText());
					pstmt.setString(4, textField_4.getText());
					pstmt.setString(5, textField_5.getText());
					pstmt.setString(6, textField_6.getText());


					pstmt.executeUpdate();
					conn.close();
					JOptionPane.showMessageDialog(null, "修改成功");
					System.out.println("change OK");
				}catch (Exception e1) {
					System.out.println(e.toString());
				}
				mymodel.refresh();
				}
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	private class MyModel extends DefaultTableModel  {
		private ResultSet rs;
		private int rowCount;

		public MyModel() {
			getDBDate();	
		}
		private void Modelrepaint() {
			revalidate();
			repaint();
		}
		private void getDBDate() {
			try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/purchsaing", prop);
			
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT * FROM suppliers",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			
			rs = pstmt.executeQuery();
			rs.last();
			rowCount =rs.getRow();
			
//			conn.close();
//			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		}
		@Override
		public int getColumnCount() {
			return 7/*super.getColumnCount()*/;
		}
		@Override
		public String getColumnName(int column) {
			return name[column];
		}
		@Override
		public int getRowCount() {
			
			return rowCount;
		}
		@Override
		public Object getValueAt(int row, int column) {
			String ret;
			try {
			rs.absolute(row+ 1) ;
			ret = rs.getString(column+1);
			}catch (Exception e) {
				ret="";
			}
			return ret;
		}
		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return false;
		}
		public void refresh() {
			getDBDate();
			fireTableDataChanged();
		}

	}
}