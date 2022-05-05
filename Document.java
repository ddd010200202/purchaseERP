package purchasing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class Document extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private JPanel panel;
	private JButton btnNewButton;
	private ResultSet rs;
	private String getid;
	private String orderdate;
	private String OrderDate;
	private String SuppliersID;
	private String ProductsId;
	private String UnitPrice;
	private String Quantity;
	private String Discount;
	private String EmployeesId;
	private String UnitPriceQuantityDiscount;

	public Document(String getid) {//TODO 把商品的名稱等等JOIN到一張表與輸出
		this.getid=getid;
		String employeeId = null;
		String deptID= null;
		String employeesName= null;
		String email= null;
		int rowCount;
		try {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/purchsaing", prop);
		
		PreparedStatement pstmt = conn.prepareStatement(
				"SELECT OrderDate,SuppliersID,ProductsId	,"
				+ "UnitPrice,Quantity,Discount,EmployeesId,"
				+ "UnitPrice*Quantity*Discount	 "
				+ "FROM purchase_order AS po JOIN orderdetails AS od ON po.OrderID = od.OrderID WHERE po.OrderID = ?;"
				,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1,getid);
		
		rs = pstmt.executeQuery();
//		rowCount =rs.getRow();
		System.out.println(rs);
		while (rs.next()) {
			OrderDate = rs.getString("OrderDate"/*1*/);
			SuppliersID = rs.getString("SuppliersID"/*2*/);
			ProductsId = rs.getString("ProductsId"/*3*/);
			UnitPrice = rs.getString("UnitPrice"/*4*/);
			Quantity = rs.getString("Quantity"/*5*/);
			Discount = rs.getString("Discount"/*6*/);
			EmployeesId = rs.getString("EmployeesId"/*7*/);
			UnitPriceQuantityDiscount = rs.getString("UnitPrice*Quantity*Discount"/*8*/);
			
		}
		conn.close();
//		System.out.println("OK");
		} catch (Exception e) {
		System.out.println(e.toString());
		}
		Object[][] action  = {{"採購日期",OrderDate},{"採購人員",EmployeesId},{"供應商",SuppliersID},{"商品名稱",ProductsId},{"單價",UnitPrice},{"數量",Quantity},{"折扣",Discount},{"總價",UnitPriceQuantityDiscount}};
		String[] columns = {"採購單號",getid};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(action,columns);

		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("列印");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				savejpg() ;
				
			}
		});
		panel.add(btnNewButton);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);}

    	private final JFileChooser fileChooser      = new JFileChooser();
		private void savejpg() {

            int returnVal = fileChooser.showSaveDialog(Document.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                BufferedImage bi = (BufferedImage) table.createImage(
                		table.getWidth(), table.getHeight());
                table.paint(bi.getGraphics());
                
                try {
                    javax.imageio.ImageIO.write(bi, "jpg", file);
                    JOptionPane.showMessageDialog(null, "存檔成功");
                } catch (Exception e1) {
                	JOptionPane.showMessageDialog(null, "存檔失敗");
                    System.out.println(e1); }
            }
	}
}
