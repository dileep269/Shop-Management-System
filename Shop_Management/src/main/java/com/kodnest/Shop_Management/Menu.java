package com.kodnest.Shop_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(252, 173, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton add = new JButton("ADD USER");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser add = new AddUser();
				add.setVisible(true);
				setVisible(false);
			}
		});
		add.setForeground(new Color(255, 255, 255));
		add.setBackground(new Color(255, 128, 128));
		add.setFont(new Font("Tahoma", Font.BOLD, 20));
		add.setBounds(212, 138, 265, 34);
		contentPane.add(add);
		
		JButton details = new JButton("SEE USER DETAILS");
		details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeUser use = new SeeUser();
				use.setVisible(true);
				setVisible(false);
			}
		});
		details.setForeground(new Color(255, 255, 255));
		details.setBackground(new Color(255, 128, 128));
		details.setFont(new Font("Tahoma", Font.BOLD, 20));
		details.setBounds(212, 196, 265, 34);
		contentPane.add(details);
		
		JButton delete = new JButton("DELETE USER");
		delete.setForeground(new Color(255, 255, 255));
		delete.setBackground(new Color(255, 128, 128));
		delete.setFont(new Font("Tahoma", Font.BOLD, 20));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete del = new Delete();
				del.setVisible(true);
				setVisible(false);
			}
		});
		delete.setBounds(212, 252, 265, 34);
		contentPane.add(delete);
		
		JButton update = new JButton("UPDATE USER");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updated up =new Updated();
				up.setVisible(true);
				setVisible(false);
			}
		});
		update.setForeground(new Color(255, 255, 255));
		update.setBackground(new Color(255, 128, 128));
		update.setFont(new Font("Tahoma", Font.BOLD, 20));
		update.setBounds(212, 320, 265, 34);
		contentPane.add(update);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(242, 38, 191, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Shop shop = new Shop();
				shop.setVisible(true);			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(534, 425, 103, 34);
		contentPane.add(btnNewButton);

	}
}
