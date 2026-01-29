package com.kodnest.Shop_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField ps;
	private JTextField age;
	private JTextField role;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
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
	public AddUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User Name:-");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(110, 159, 107, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:-");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_2.setBounds(126, 204, 91, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age:-");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(163, 262, 54, 31);
		contentPane.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setBounds(234, 167, 96, 18);
		contentPane.add(name);
		name.setColumns(10);
		
		ps = new JTextField();
		ps.setBounds(234, 212, 96, 18);
		contentPane.add(ps);
		ps.setColumns(10);
		
		age = new JTextField();
		age.setBounds(234, 272, 96, 18);
		contentPane.add(age);
		age.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Role:-");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4.setBounds(163, 327, 54, 26);
		contentPane.add(lblNewLabel_4);
		
		role = new JTextField();
		role.setBounds(234, 327, 96, 18);
		contentPane.add(role);
		role.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ADD Customer");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNewLabel_5.setBounds(176, 22, 194, 31);
		contentPane.add(lblNewLabel_5);
		
		JButton add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Session session = null;
				Transaction tx = null;
				try {
					String name1 = name.getText();
					String pass = ps.getText();
					int age1 = Integer.parseInt(age.getText());
					Role role1 = Role.valueOf(role.getText().toUpperCase());
					Users use = new Users();
					use.setUsername(name1);
					use.setPassword(pass);
					use.setAge(age1);
					use.setRole(role1);
					 session = HibernateUtil.getSessionFactory().openSession();
					 tx = session.beginTransaction();
					session.persist(use);
					tx.commit();
					session.close();
					 JOptionPane.showMessageDialog(AddUser.this, "Employee added successfully!", "Success", 
	         		    		JOptionPane.INFORMATION_MESSAGE);

	         		    System.out.println("Employee saved successfully");
					 
					
					
					
				} catch(Exception e1) {
					if (tx != null) {
				        tx.rollback();
				    }
	
					e1.printStackTrace();
				} 
			}
		});
		add.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		add.setBounds(54, 437, 107, 41);
		contentPane.add(add);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
				menu.setVisible(true);;
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnNewButton.setBounds(480, 441, 117, 31);
		contentPane.add(btnNewButton);

	}
}
