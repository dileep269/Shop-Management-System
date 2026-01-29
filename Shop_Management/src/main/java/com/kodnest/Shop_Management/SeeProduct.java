package com.kodnest.Shop_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SeeProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeProduct frame = new SeeProduct();
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
	public SeeProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 579);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEE PRODUCT DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(172, 10, 294, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Product ID:-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 115, 152, 25);
		contentPane.add(lblNewLabel_1);
		
		id = new JTextField();
		id.setBounds(172, 121, 96, 18);
		contentPane.add(id);
		id.setColumns(10);
		 String[] columns = { "Id","Name","Price","Description","Link" };
	        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
	        JTable table = new JTable(tableModel);

	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(30, 210, 600, 250);
	        contentPane.add(scrollPane);
		
		JButton fetch = new JButton("FETCH");
		fetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tableModel.setRowCount(0);
					Session session = HibernateUtil.getSessionFactory().openSession();
	                Transaction tx = session.beginTransaction();
	                int id1 = Integer.parseInt(id.getText());
	                Product product = session.get(Product.class, id1);
	                if(product != null) {
	                	Image img = product.getImage();
	                	tableModel.addRow(new Object [] {
	                			product.getP_id(),
	                			product.getName(),
	                			product.getP_price(),
	                			product.getP_description(),
	                			img != null ? img.getI_url() : "No Image"
	                			
	                			
	                	});
	                } else {
	                	JOptionPane.showMessageDialog(null, "Product not found!");

	                }
	                tx.commit();
	                session.close();

					
					
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		fetch.setFont(new Font("Tahoma", Font.BOLD, 20));
		fetch.setBounds(421, 115, 152, 25);
		contentPane.add(fetch);
		
		JButton view = new JButton("FETCH ALL");
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		view.addActionListener(e ->{
			try {
				tableModel.setRowCount(0);
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                String hql = """
                		SELECT p.p_id, p.p_name, p.p_price, p.p_description, i.i_url
                		FROM Product p
                		LEFT JOIN p.image i
                		""";

                		List<Object[]> rows = session.createQuery(hql, Object[].class).list();

                		for (Object[] r : rows) {
                		    tableModel.addRow(new Object[]{
                		        r[0], r[1], r[2], r[3], r[4] != null ? r[4] : "No Image"
                		    });
                		}

                           tx.commit();
                           session.close();
                    
				
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			
		});
		view.setFont(new Font("Tahoma", Font.BOLD, 20));
		view.setBounds(421, 175, 152, 20);
		contentPane.add(view);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProductDb db = new ProductDb();
				db.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 20));
		back.setBounds(538, 496, 104, 36);
		contentPane.add(back);

	}
}
