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

public class Delete extends JFrame {

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
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Id:-");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(39, 107, 84, 21);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(133, 110, 96, 18);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DELETING USER");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(209, 25, 235, 32);
		contentPane.add(lblNewLabel_1);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        if (id.getText().trim().isEmpty()) {
		            JOptionPane.showMessageDialog(
		                Delete.this,
		                "Employee ID is mandatory!",
		                "Validation Error",
		                JOptionPane.ERROR_MESSAGE
		            );
		            id.requestFocus();
		            return;
		        }
				try {
					Session session = HibernateUtil.getSessionFactory().openSession();
					  Transaction tn = session.beginTransaction();
					  int id1 = Integer.parseInt(id.getText());
					  Users use = session.get(Users.class, id1);
					  if(use != null) {
						  session.remove(use);
					  }
					  tn.commit();
			            session.close();

			            JOptionPane.showMessageDialog(null, "Employee Deletion successfully!");
					
					
					
				} catch(Exception e1) {
				    e1.printStackTrace();
				}
			}
		});
		delete.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		delete.setForeground(new Color(255, 0, 0));
		delete.setBounds(360, 111, 129, 20);
		contentPane.add(delete);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		back.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		back.setBounds(464, 359, 115, 41);
		contentPane.add(back);

	}
}
