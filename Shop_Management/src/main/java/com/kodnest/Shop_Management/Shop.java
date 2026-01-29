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

public class Shop extends JFrame {
	public class AppContext {
	    public static String selectedModule = "";
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop frame = new Shop();
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
	public Shop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO SHOP");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(180, 10, 276, 34);
		contentPane.add(lblNewLabel);
		
		JButton user = new JButton("USER MANAGEMENT");
		user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   AppContext.selectedModule = "USER";
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		user.setForeground(new Color(255, 255, 255));
		user.setBackground(new Color(0, 0, 255));
		user.setFont(new Font("Tahoma", Font.BOLD, 20));
		user.setBounds(174, 100, 282, 34);
		contentPane.add(user);
		
		JButton product = new JButton("PRODUCT MANAGEMENT");
		product.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  AppContext.selectedModule = "PRODUCT";
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		product.setForeground(new Color(255, 255, 255));
		product.setBackground(new Color(0, 0, 255));
		product.setFont(new Font("Tahoma", Font.BOLD, 20));
		product.setBounds(174, 190, 296, 31);
		contentPane.add(product);

	}

}
