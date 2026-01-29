package com.kodnest.Shop_Management;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeeUser extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField id;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SeeUser frame = new SeeUser();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SeeUser() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 662, 544);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 0, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("SEE USER DETAILS");
        title.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
        title.setBounds(190, 10, 286, 31);
        contentPane.add(title);

        JLabel lblId = new JLabel("Enter ID:-");
        lblId.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
        lblId.setBounds(54, 101, 100, 31);
        contentPane.add(lblId);

        id = new JTextField();
        id.setBounds(143, 103, 96, 26);
        contentPane.add(id);

        String[] columns = { "UserID", "Username", "Password", "Age", "Role" };
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 210, 600, 250);
        contentPane.add(scrollPane);

        JButton view = new JButton("View Details");
        view.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
        view.setBounds(400, 95, 180, 37);
        contentPane.add(view);

        JButton fetchAll = new JButton("FETCH ALL");
        fetchAll.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
        fetchAll.setBounds(400, 145, 180, 37);
        contentPane.add(fetchAll);

        // 🔹 VIEW BY ID
        view.addActionListener(e -> {
            try {
                tableModel.setRowCount(0);

                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();

                int userId = Integer.parseInt(id.getText());
                Users user = session.get(Users.class, userId);

                if (user != null) {
                    tableModel.addRow(new Object[] {
                        user.getUserId(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getAge(),
                        user.getRole()
                    });
                } else {
                    JOptionPane.showMessageDialog(this, "User not found!");
                }

                tx.commit();
                session.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // 🔹 FETCH ALL USERS
        fetchAll.addActionListener(e -> {
            try {
                tableModel.setRowCount(0);

                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();

                Query<Users> query = session.createQuery("from Users", Users.class);
                List<Users> list = query.list();

                for (Users u : list) {
                    tableModel.addRow(new Object[] {
                        u.getUserId(),
                        u.getUsername(),
                        u.getPassword(),
                        u.getAge(),
                        u.getRole()
                    });
                }

                tx.commit();
                session.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        JButton back = new JButton("BACK");
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Menu menu = new Menu();
        		menu.setVisible(true);
        	}
        });
        back.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
        back.setBounds(540, 470, 90, 25);
        contentPane.add(back);
    }
}
