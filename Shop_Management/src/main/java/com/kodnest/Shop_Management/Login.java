package com.kodnest.Shop_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kodnest.Shop_Management.Shop.AppContext;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 392);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Username:-");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(51, 81, 161, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter PassWord:-");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(51, 143, 161, 34);
		contentPane.add(lblNewLabel_1);
		
		JTextField ps = new JTextField();
		ps.setBounds(222, 155, 137, 18);
		contentPane.add(ps);
		ps.setColumns(10);
		
		user = new JTextField();
		user.setBounds(222, 89, 137, 18);
		contentPane.add(user);
		user.setColumns(10);
		
		JButton login = new JButton("LOGIN");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				  Transaction tn = session.beginTransaction();
				  String uname = user.getText();
				  String password = ps.getText();
				  Users user1 = session.createQuery("from Users where username = :uname and password = :password",
						  Users.class).setParameter("uname", uname).setParameter("password", password).uniqueResult();
				  tn.commit();
				  session.close();
				  if(user1 == null) {
					  JOptionPane.showMessageDialog(Login.this, "User not found");
					  return;
				  }
				  if(user1.getRole() == Role.ADMIN) {
					  JOptionPane.showMessageDialog(Login.this, "Admin login successful");
					  if (AppContext.selectedModule.equals("USER")) {
						    new Menu().setVisible(true);        // User Management
						}
						else if (AppContext.selectedModule.equals("PRODUCT")) {
						    new ProductDb().setVisible(true);   // Product Management
						}
					  Login.this.dispose();
					  
				  } else {
					  JOptionPane.showMessageDialog(Login.this, "Access denied! Admin only");
				  }
				 
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		login.setBackground(new Color(0, 128, 255));
		login.setFont(new Font("Tahoma", Font.BOLD, 20));
		login.setForeground(new Color(255, 255, 255));
		login.setBounds(122, 231, 187, 34);
		contentPane.add(login);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Shop menu = new Shop();
				menu.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(438, 308, 104, 26);
		contentPane.add(btnNewButton);

	}
}
