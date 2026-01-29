package com.kodnest.Shop_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductDb extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductDb frame = new ProductDb();
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
	public ProductDb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(182, 10, 204, 27);
		contentPane.add(lblNewLabel);
		
		JButton add = new JButton("ADD PRODUCT");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProduct add = new AddProduct();
				add.setVisible(true);
				setVisible(false);
				}
		});
		add.setFont(new Font("Tahoma", Font.BOLD, 20));
		add.setBounds(162, 89, 179, 27);
		contentPane.add(add);
		
		JButton details = new JButton("SEE PRODUCT DETAILS");
		details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeProduct see = new SeeProduct();
				see.setVisible(true);
				setVisible(false);
			}
		});
		details.setFont(new Font("Tahoma", Font.BOLD, 20));
		details.setBounds(124, 252, 278, 34);
		contentPane.add(details);
		
		JButton delete = new JButton("DELETE PRODUCT");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteProduct delete = new DeleteProduct();
				delete.setVisible(true);
				setVisible(false);
			}
		});
		delete.setFont(new Font("Tahoma", Font.BOLD, 20));
		delete.setBounds(149, 140, 211, 27);
		contentPane.add(delete);
		
		JButton update = new JButton("UPDATE PRODUCT");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateProduct up = new UpdateProduct();
				up.setVisible(true);
				setVisible(false);
			}
		});
		update.setFont(new Font("Tahoma", Font.BOLD, 20));
		update.setBounds(149, 190, 221, 27);
		contentPane.add(update);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Shop shop = new Shop();
				shop.setVisible(true);	
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		back.setBounds(462, 445, 113, 42);
		contentPane.add(back);

	}

}
