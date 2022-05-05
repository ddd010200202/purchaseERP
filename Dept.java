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



public class Dept extends JPanel{//員工修查
	private JButton create;
	private JButton delete;
	private JButton update;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private MyModel mymodel;
	private JScrollPane scrollPane1;

	private String[] name1 = {"部門編號","部門名稱","執行業務"};
//	private String[] value ;
	public Dept(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		

		
		
		JLabel lblNewLabel = new JLabel("部門編號");
		
		JLabel lblNewLabel_1 = new JLabel("部門名稱");
		
		JLabel lblNewLabel_2 = new JLabel("執行業務");
		
		
		JButton btnNewButton = new JButton("新增");
		

		JButton btnNewButton_1 = new JButton("刪除");

		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
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
				
				Properties prop = new Properties();
				prop.put("user", "root");
				prop.put("password", "");
				String sql1 = "INSERT INTO dept(DeptId,DeptName,BusinessType) VALUES (?,?,?)";
				ResultSet rs;
				
				try (Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/purchsaing",prop);){
					if(!textField.getText().equals("") && !textField_1.getText().equals("") &&!textField_2.getText().equals("") ) {
					PreparedStatement pstmt = conn.prepareStatement(sql1
							);
					pstmt.setString(1, textField.getText());
					pstmt.setString(2, textField_1.getText());
					pstmt.setString(3, textField_2.getText());
					
					// 篩選輸入字串用字串擷取
					pstmt.executeUpdate();
					}
					else {
						System.out.println("INSERT FAIL");//TODO 彈出視窗輸入不完全或錯誤
					}	
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
							"DELETE FROM dept WHERE DeptId = ?");
					if(table.getSelectedRow()!=-1) { 
					pstmt.setString(1, table.getValueAt(table.getSelectedRow(),0)+"");
					}
					pstmt.executeUpdate();
					
					
					conn.close();
					System.out.println("OK");

				}  catch(SQLIntegrityConstraintViolationException e2) {
					JOptionPane.showMessageDialog(null, "部門編號重複");
					textField.setText("");
				}catch (SQLException e1) {
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
				
				//選取後如果ID修改跳出警告提示1.撞到同個資料2.

			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "修改請輸入值");
				}else if(!(table.getValueAt(table.getSelectedRow(),0)+"").equals(textField.getText())) {
				JOptionPane.showMessageDialog(null, "部門編號無法變更");
				textField.setText( table.getValueAt(table.getSelectedRow(),0)+"");
				}
				else {
				Properties prop = new Properties();
				prop.put("user", "root");prop.put("password", "");
				String sql ="UPDATE dept SET DeptName = ?,BusinessType = ? WHERE DeptId =?";
				
				
				try(Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchsaing",prop)){
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(3, textField.getText());
					pstmt.setString(1, textField_1.getText());
					pstmt.setString(2, textField_2.getText());
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
					"SELECT * FROM dept",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			
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
			return 3/*super.getColumnCount()*/;
		}
		@Override
		public String getColumnName(int column) {
			return name1[column];
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