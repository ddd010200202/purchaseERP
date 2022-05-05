package purchasing;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.Document;

import com.mysql.cj.jdbc.result.ResultSetMetaData;



public class Employees extends JPanel{//員工修查
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
//	private int x;
//	private int y;

	private String[] name = {"員工編號","部門編號","姓名","信箱"};
//	private String[] value ;
	public Employees(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		
		
		
		
		JLabel lblNewLabel = new JLabel("員工編號");
		
		JLabel lblNewLabel_1 = new JLabel("部門編號");
		
		JLabel lblNewLabel_2 = new JLabel("姓名");
		
		JLabel lblNewLabel_3 = new JLabel("信箱");
		
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
		

		
		JButton btnNewButton_2 = new JButton("修改");
		
		JComboBox comboBox = new JComboBox();
		List<String> ls = Deptjcombox();
		comboBox.setModel(new DefaultComboBoxModel<String>(ls.toArray(new String[0])));
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(361)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(btnNewButton_1)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		mymodel = new MyModel();
		
		JTable table = new JTable();
		table.setModel(mymodel);
		JScrollPane scrollPane1 = new JScrollPane(table);
		add(scrollPane1, BorderLayout.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_3.getText().toString().matches("(.*)@(.*)")) {
					JOptionPane.showMessageDialog(null, "不正確的信箱格式");
					System.out.println("okok");
				}else {
				Properties prop = new Properties();
				prop.put("user", "root");
				prop.put("password", "");
				String sql1 = "INSERT INTO employees(EmployeeId,DeptID,EmployeesName,Email) VALUES (?,?,?,?)";
				ResultSet rs;
				
				try (Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/purchsaing",prop);){
					if(!textField.getText().equals("") && !textField_1.getText().equals("") &&!textField_2.getText().equals("")&&!textField_3.getText().equals("") ) {
					PreparedStatement pstmt = conn.prepareStatement(sql1
							);
					System.out.println();
					pstmt.setString(1, textField.getText());
					pstmt.setString(2, comboBox.getSelectedItem().toString());
					pstmt.setString(3, textField_2.getText());
					pstmt.setString(4, textField_3.getText());
					
					// 篩選輸入字串用字串擷取
					pstmt.executeUpdate();
					}
					else {
						JOptionPane.showMessageDialog(null, "請輸入完整資料");
					}	
				} catch(SQLIntegrityConstraintViolationException e2) {
					JOptionPane.showMessageDialog(null, "無此部門/員工編號重複錯誤");
					textField.setText("");
					System.out.println(e2);
				}
				catch (Exception e1) {
					System.out.println(e1.toString());
				}
				mymodel.refresh();}
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
							"DELETE FROM employees WHERE EmployeeId = ?");
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
				//選取後如果ID修改跳出警告提示1.撞到同個資料2.

			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "修改請輸入值");
				}else if(!(table.getValueAt(table.getSelectedRow(),0)+"").equals(textField.getText())) {
				JOptionPane.showMessageDialog(null, "員工編號無法變更");
				textField.setText( table.getValueAt(table.getSelectedRow(),0)+"");
				}
				else {
				Properties prop = new Properties();
				prop.put("user", "root");prop.put("password", "");
				String sql ="UPDATE employees SET DeptID = ?,EmployeesName = ?,Email = ? WHERE EmployeeId =?";
				
				
				try(Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchsaing",prop)){
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(4, textField.getText());
					pstmt.setString(1, textField_1.getText());
					pstmt.setString(2, textField_2.getText());
					pstmt.setString(3, textField_3.getText());
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
		for(int i =0 ;i<4;i++) {
			center(table ,i);
		}
		
		setSize(800, 640);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
	}
	private void center(JTable table, int y) {
		this.table=table;
		TableColumn column=table.getColumnModel().getColumn(y);
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		column.setCellRenderer(render);
	}
	
	
	private void right(JTable table, int y) {
		this.table=table;
		TableColumn column=table.getColumnModel().getColumn(y);
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.RIGHT);
		column.setCellRenderer(render);
	}
	private List<String> Deptjcombox(){
		
		String dept = null;
		HashMap<String,List<String>> map = new HashMap<String,List<String>>();
		try {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/purchsaing", prop);
		
		PreparedStatement pstmt = conn.prepareStatement(
				"SELECT *FROM dept "
				,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		
		ResultSet rs = pstmt.executeQuery();
		
//		rowCount =rs.getRow();
		System.out.println(map);
		
		java.sql.ResultSetMetaData rrsmd =rs.getMetaData();
		int count = rrsmd.getColumnCount();
		List<String> [] lists = new List[count];
	    for (int i=0;i<lists.length;i++) {
			lists[i] = new ArrayList<String>();
			map.put(rrsmd.getColumnName(i+1), lists[i]);
		}
		  while(rs.next()){
			  for(int i=0 ;i<lists.length;i++){
				  lists[i].add(rs.getString(i+1));
				  
			  }
		  }
		 List<String> lists1 = map.get("DeptID");
		 
		 
		  
		  
		conn.close();
		return lists1;
		//TODO  還沒完成增加後改變combox值 addChangeListener
//		System.out.println("OK");
		} catch (Exception e) {
		System.out.println(e.toString());
		
		}
		return null;
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
					"SELECT * FROM employees",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			
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
			return 4/*super.getColumnCount()*/;
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