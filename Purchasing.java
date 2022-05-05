package purchasing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import tw.Ting.mytest.BCrypt;
import tw.Ting.mytest.DateChooser;

import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Purchasing extends JFrame {

	private static JButton JB = null;
	private JPanel contentPane;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchasing frame = new Purchasing();
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
	public Purchasing() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 899, 642);
		contentPane = new JPanel();
				
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setBackground(Color.PINK);
		
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		
		JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane_2 = new JScrollPane();
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		contentPane.add(tabbedPane);
		
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.LEFT);tabbedPane_2.setBackground(Color.ORANGE);
		tabbedPane.addTab("基本資料", tabbedPane_2);
		
		JPanel employeespanel = new Employees();
		tabbedPane_2.addTab("人員", employeespanel);
		
		JPanel deptpanel = new Dept();
		tabbedPane_2.addTab("部門", deptpanel);		
		
		JPanel productspanel = new Products();
		tabbedPane_2.addTab("產品",  productspanel);
		
		JPanel supplierspanel = new suppliers();
		tabbedPane_2.addTab("供應商",supplierspanel);
				
		JPanel Pane_3 =  new Requisitions();
		tabbedPane.addTab("請購單",  Pane_3);
		
		JPanel Pane_4 =  new purchaseorder();
		tabbedPane.addTab("採購單",  Pane_4);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.addTab("庫存管理", tabbedPane_5);
		
		JPanel panel = new JPanel();
		tabbedPane_5.addTab("入庫",  panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();//JASHON
		panel.add(scrollPane_1, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
				
		JPanel panel_2 = new JPanel();
		tabbedPane_5.addTab("盤存", panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_2.add(scrollPane_3, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();//JASHON
		panel_2.add(panel_3, BorderLayout.SOUTH);
		
		
		setVisible(true);
	}
}







class StockQuantity extends JScrollPane{//庫存增刪修查
	private JButton create;
	private JButton delete;
	private JButton update;
	private JTable table;
	
	private class MyModel extends DefaultTableModel{
		
	}
}

