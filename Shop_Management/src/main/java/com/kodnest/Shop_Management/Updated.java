package com.kodnest.Shop_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Updated extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
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
					Updated frame = new Updated();
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
	public Updated() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE USER");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 27));
		lblNewLabel.setBounds(210, 23, 270, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID:-");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(42, 107, 84, 27);
		contentPane.add(lblNewLabel_1);
		
		id = new JTextField();
		id.setBounds(136, 111, 112, 27);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("User Name:-");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_2.setBounds(25, 176, 110, 27);
		contentPane.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(137, 181, 111, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password:-");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_3.setBounds(25, 224, 101, 27);
		contentPane.add(lblNewLabel_3);
		
		ps = new JTextField();
		ps.setBounds(136, 229, 112, 26);
		contentPane.add(ps);
		ps.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Age:-");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4.setBounds(81, 294, 45, 27);
		contentPane.add(lblNewLabel_4);
		
		age = new JTextField();
		age.setBounds(136, 294, 112, 26);
		contentPane.add(age);
		age.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Role:-");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_5.setBounds(72, 344, 54, 19);
		contentPane.add(lblNewLabel_5);
		
		role = new JTextField();
		role.setBounds(136, 348, 112, 27);
		contentPane.add(role);
		role.setColumns(10);
		
		JButton update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				  Transaction tn = session.beginTransaction();
				  int id1 = Integer.parseInt(id.getText());
				  Users use = session.get(Users.class, id1);
				  if (use == null) {
		                JOptionPane.showMessageDialog(null, "Employee not found!");
		                session.close();
		                return;
		            }
				  if(!name.getText().trim().isEmpty())
					  use.setUsername(name.getText());
				  
				  if(!ps.getText().trim().isEmpty())
					  use.setPassword(ps.getText());
				  
				  if (!age.getText().trim().isEmpty()) {
				        int age1 = Integer.parseInt(age.getText().trim());
				        use.setAge(age1);
				    }

				    if (!role.getText().trim().isEmpty()) {
				        Role role1 = Role.valueOf(role.getText().trim().toUpperCase());
				        use.setRole(role1);
				    }
				  
				  tn.commit();
				  session.close();
				  JOptionPane.showMessageDialog(null, "Employee updated successfully!");
				  
				  
				  
				} catch(Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Update failed!");
				}
			}
		});
		update.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		update.setBounds(42, 444, 128, 42);
		contentPane.add(update);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		back.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		back.setBounds(509, 465, 101, 34);
		contentPane.add(back);

	}

}
