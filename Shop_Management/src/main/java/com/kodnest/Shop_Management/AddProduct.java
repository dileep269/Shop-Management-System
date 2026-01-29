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
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class AddProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField price;
	private JTextField url;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
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
	public AddProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD PRODUCT");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(207, 22, 183, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Product Name:-");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 109, 176, 28);
		contentPane.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(196, 117, 96, 18);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Product price:-");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 148, 176, 23);
		contentPane.add(lblNewLabel_3);
		
		price = new JTextField();
		price.setBounds(196, 145, 96, 18);
		contentPane.add(price);
		price.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Description:-");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 250, 147, 23);
		contentPane.add(lblNewLabel_4);
		
		JTextArea desc = new JTextArea();
		desc.setBounds(118, 274, 252, 106);
		contentPane.add(desc);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name1 = name.getText();
					BigDecimal price1 = new BigDecimal(price.getText());
					String desc1 = desc.getText();
					String url1= url.getText();
					Product product = new Product();
					Image image = new Image();
					product.setName(name1);
					product.setP_price(price1);
					product.setP_description(desc1);
					image.setI_url(url1);
					product.setImage(image);
					 Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction tx = session.beginTransaction();
					session.persist(product);
					tx.commit();
					session.close();
					 JOptionPane.showMessageDialog(AddProduct.this, "Product was  added successfully!", "Success", 
	         		    		JOptionPane.INFORMATION_MESSAGE);

	         		    System.out.println("Product saved successfully");
					
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 434, 103, 31);
		contentPane.add(btnNewButton);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProductDb db = new ProductDb();
				db.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		back.setBounds(508, 434, 96, 29);
		contentPane.add(back);
		
		JLabel lblNewLabel_1 = new JLabel("Enter image URL:-");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(33, 181, 153, 28);
		contentPane.add(lblNewLabel_1);
		
		url = new JTextField();
		url.setBounds(196, 189, 96, 18);
		contentPane.add(url);
		url.setColumns(10);

	}
}
