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
import javax.swing.JComboBox;



public class Requisitions extends JPanel implements ActionListener {
	private int days=31;
	private JComboBox comboBox;//年下拉式選單
	private JComboBox comboBox_1;//月份下拉式選單
	private JComboBox comboBox_2;//日期//下拉式選單
	private String[] name = {"請購單編號","請購日期","產品編號","單價","數量","供應商","承辦員工","採購已處理請購單"};
	public Requisitions() {//備註
		setLayout(new BorderLayout(0, 0));
		
		setSize(800, 640);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, BorderLayout.CENTER);
		
		JTable table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("請購單編號");
		
		JLabel lblNewLabel_1 = new JLabel("請購日期");
		
		JLabel lblNewLabel_2 = new JLabel("產品編號");
		
		JLabel lblNewLabel_3 = new JLabel("單價");
		
		JLabel lblNewLabel_4 = new JLabel("數量");
		
		JLabel lblNewLabel_5 = new JLabel("供應商");
		
		JLabel lblNewLabel_6 = new JLabel("承辦員工");
		
		JTextField textField = new JTextField();
		textField.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JTextField textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JTextField textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("刪除");
		
		JButton btnNewButton_2 = new JButton("列印");
		
		JTextField textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("已處理");
		
		comboBox = new JComboBox();
		
		comboBox_1 = new JComboBox();
		
		comboBox_2 = new JComboBox();
		
		JLabel lblNewLabel_7 = new JLabel("年");
		lblNewLabel_7.setToolTipText("");
		
		JLabel lblNewLabel_7_1 = new JLabel("月");
		lblNewLabel_7_1.setToolTipText("");
		
		JLabel lblNewLabel_7_2 = new JLabel("日");
		lblNewLabel_7_2.setToolTipText("");
		
		JButton btnNewButton_2_1 = new JButton("修改");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2))
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_7)
							.addGap(2)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblNewLabel_7_1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblNewLabel_7_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_4)
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6_1)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_7)
										.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_7_1)
										.addComponent(lblNewLabel_7_2)
										.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addGap(18)
									.addComponent(lblNewLabel_5))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		MyModel mymodel = new MyModel();

		JTable table = new JTable();
		table.setModel(mymodel);
		JScrollPane scrollPane1 = new JScrollPane(table);
		add(scrollPane1, BorderLayout.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Properties prop = new Properties();
				prop.put("user", "root");
				prop.put("password", "");
				String sql1 = "INSERT INTO Requisitions(RequisitionsID,RequisitionsDate,ProductsId,UnitPrice,Quantity,SuppliersID,EmployeesId,order_done) VALUES (?,?,?,?,?,?,?,?)";
				ResultSet rs;
				
				try (Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/purchsaing",prop);){
					if(!textField.getText().equals("") && !(comboBox.getSelectedItem().toString()+"-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_2.getSelectedItem().toString()).equals("") &&!textField_2.getText().equals("")&&!textField_3.getText().equals("") ) {
					PreparedStatement pstmt = conn.prepareStatement(sql1
							);
					pstmt.setString(1, textField.getText());
					pstmt.setString(2, comboBox.getSelectedItem().toString()+"-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_2.getSelectedItem().toString());
					pstmt.setString(3, textField_2.getText());
					pstmt.setString(4, textField_3.getText());
					pstmt.setString(5, textField_4.getText());
					pstmt.setString(6, textField_5.getText());
					pstmt.setString(7, textField_6.getText());
					pstmt.setString(8, textField_7.getText());
					
					// 篩選輸入字串用字串擷取
					pstmt.executeUpdate();
					}
					else {
						System.out.println("INSERT FAIL");//TODO 彈出視窗輸入不完全或錯誤
					}	
				}  catch(SQLIntegrityConstraintViolationException e2) {
					JOptionPane.showMessageDialog(null, "請購單編號重複");
					textField.setText("");
				}catch (Exception e1) {
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
							"DELETE FROM Requisitions WHERE RequisitionsID = ?");
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
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String[] splitted = (table.getValueAt(table.getSelectedRow(),1)+"").split("-");
				textField.setText( table.getValueAt(table.getSelectedRow(),0)+"");
//				comboBox.setSelectedItem(splitted[0]);
//				comboBox_1.setSelectedItem(splitted[1]);
//				comboBox_1.setSelectedItem(splitted[2]);
				textField_2.setText( table.getValueAt(table.getSelectedRow(),2)+"");
				
				textField_3.setText( table.getValueAt(table.getSelectedRow(),3)+"");
				textField_4.setText( table.getValueAt(table.getSelectedRow(),4)+"");
				textField_5.setText( table.getValueAt(table.getSelectedRow(),5)+"");
				textField_6.setText( table.getValueAt(table.getSelectedRow(),6)+"");
				textField_7.setText( table.getValueAt(table.getSelectedRow(),7)+"");
				//選取後如果ID修改跳出警告提示1.撞到同個資料2.

			}
		});
		btnNewButton_2_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "修改請輸入值");
				}else if(!(table.getValueAt(table.getSelectedRow(),0)+"").equals(textField.getText())) {
				JOptionPane.showMessageDialog(null, "請購單編號無法變更");
				textField.setText( table.getValueAt(table.getSelectedRow(),0)+"");
				}
				else {
				Properties prop = new Properties();
				prop.put("user", "root");prop.put("password", "");
				String sql ="UPDATE Requisitions SET RequisitionsDate = ?,ProductsId = ?,UnitPrice = ?,"
						+ "Quantity = ?,SuppliersID = ?,EmployeesId = ?,order_done = ? WHERE RequisitionsID =?";
				
				
				try(Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchsaing",prop)){
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(8, textField.getText());
					pstmt.setString(1, comboBox.getSelectedItem().toString()+"-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_2.getSelectedItem().toString());
					pstmt.setString(2, textField_2.getText());
					pstmt.setString(3, textField_3.getText());
					pstmt.setString(4, textField_4.getText());
					pstmt.setString(5, textField_5.getText());
					pstmt.setString(6, textField_6.getText());
					pstmt.setString(7, textField_7.getText());
					
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
		setVisible(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
					"SELECT * FROM Requisitions",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			
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
			return 8/*super.getColumnCount()*/;
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
