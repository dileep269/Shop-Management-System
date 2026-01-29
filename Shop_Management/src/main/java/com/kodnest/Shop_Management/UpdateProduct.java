package com.kodnest.Shop_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class UpdateProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name1;
	private JTextField price1;
	private JTextField url;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProduct frame = new UpdateProduct();
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
	public UpdateProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 564);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(222, 10, 170, 27);
		contentPane.add(lblNewLabel);
		
		JLabel name = new JLabel("Enter Product Name:-");
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setBounds(10, 111, 161, 27);
		contentPane.add(name);
		
		JLabel price = new JLabel("Enter Product Price:-");
		price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		price.setBounds(10, 154, 140, 21);
		contentPane.add(price);
		
		name1 = new JTextField();
		name1.setBounds(181, 117, 96, 18);
		contentPane.add(name1);
		name1.setColumns(10);
		
		price1 = new JTextField();
		price1.setBounds(181, 157, 96, 18);
		contentPane.add(price1);
		price1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter url:-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(63, 203, 70, 27);
		contentPane.add(lblNewLabel_1);
		
		url = new JTextField();
		url.setBounds(181, 209, 96, 18);
		contentPane.add(url);
		url.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Product Description:-");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 252, 149, 21);
		contentPane.add(lblNewLabel_2);
		
		JTextArea ps = new JTextArea();
		ps.setBounds(169, 258, 343, 111);
		contentPane.add(ps);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Session session = HibernateUtil.getSessionFactory().openSession();
				    Transaction	tn =session.beginTransaction();
				    int id1 = Integer.parseInt(id.getText());
				    Product pro = session.get(Product.class, id1);
				    if(pro == null) {
				    	JOptionPane.showMessageDialog(null, "Product not found");
				    	session.close();
				    	return;
				    }
				     if(!name1.getText().trim().isEmpty()) 
				    	 pro.setName(name.getText());
				     
				     if(!price1.getText().trim().isEmpty()) {
				    	 BigDecimal p = new BigDecimal(price1.getText());
				    	 pro.setP_price(p);
				     }
				     
				     if(!ps.getText().trim().isEmpty())
				    	 pro.setP_description(ps.getText());
				     
				     
				     if (!url.getText().trim().isEmpty()) {
				            Image img = pro.getImage();
				            if (img != null) {
				                img.setI_url(url.getText());
				            }
				        }

				    	 
				     tn.commit();
				     session.close();
				     JOptionPane.showMessageDialog(null, "Product updated successfully!");
				    
					
				} catch(Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Update failed!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(20, 490, 151, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProductDb db = new ProductDb();
				db.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(518, 490, 110, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Product ID:-");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 89, 140, 12);
		contentPane.add(lblNewLabel_3);
		
		id = new JTextField();
		id.setBounds(181, 88, 96, 18);
		contentPane.add(id);
		id.setColumns(10);

	}
}
