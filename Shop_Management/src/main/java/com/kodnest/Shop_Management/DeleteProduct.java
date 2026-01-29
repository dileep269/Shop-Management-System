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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DeleteProduct extends JFrame {

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
					DeleteProduct frame = new DeleteProduct();
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
	public DeleteProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DELETING PRODUCT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(187, 10, 258, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID:-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 104, 89, 33);
		contentPane.add(lblNewLabel_1);
		
		id = new JTextField();
		id.setBounds(129, 114, 96, 18);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  if (id.getText().trim().isEmpty()) {
			            JOptionPane.showMessageDialog(
			                DeleteProduct.this,
			                "Employee ID is mandatory!",
			                "Validation Error",
			                JOptionPane.ERROR_MESSAGE
			            );
			            id.requestFocus();
			            return;
			        }
				  try {
					  Session session = HibernateUtil.getSessionFactory().openSession();
					    Transaction tn =  session.beginTransaction();
					    int id1 = Integer.parseInt(id.getText());
					   Product product = session.get(Product.class, id1);
					   if(product != null) {
						   session.remove(product);
					   }
					   tn.commit();
					   session.close();
					   JOptionPane.showMessageDialog(null, "Product  Deletion successfully!");
						
					  
				  }catch(Exception e1) {
					  e1.printStackTrace();
				  }
				
			}
		});
		delete.setFont(new Font("Tahoma", Font.BOLD, 20));
		delete.setBounds(338, 113, 146, 24);
		contentPane.add(delete);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProductDb db = new ProductDb();
				db.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 21));
		back.setBounds(538, 452, 96, 33);
		contentPane.add(back);

	}
}
