package com.songul;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class swing_kull_girisi {

	File fileName = new File("users.txt");  //baþa yaz
	private JFrame frame;
	private JTextField adal;
	private JPasswordField sifreal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing_kull_girisi window = new swing_kull_girisi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws FileNotFoundException
	 */
	public swing_kull_girisi() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws FileNotFoundException
	 */
	private void initialize() throws FileNotFoundException {

		HashMap<String, String> hmap = new HashMap<>(); // dosyadan oku

		if (fileName.exists()) {
			Scanner myReader = new Scanner(fileName);
			while (myReader.hasNextLine()) {
				hmap.put(myReader.next(), myReader.next());

			}
			myReader.close();
		}
		System.out.println(hmap);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		adal = new JTextField();
		adal.setBounds(232, 73, 86, 20);
		frame.getContentPane().add(adal);
		adal.setColumns(10);

		JButton loginbtn = new JButton("Login");
		loginbtn.setForeground(new Color(51, 204, 204));
		loginbtn.setBackground(new Color(0, 255, 255));
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)

			{
				if (hmap.containsKey(adal.getText())) {
					if (hmap.get(adal.getText()).equals(sifreal.getText())) {
						JOptionPane.showMessageDialog(null, "Baþarýlý login");
					}

					else {
						JOptionPane.showConfirmDialog(null, "Kullanýcý adý veya þifre yanlýþ");
					}

				}
			}
		});

		loginbtn.setBounds(103, 186, 89, 23);
		frame.getContentPane().add(loginbtn);

		JButton exitbtn = new JButton("Exit");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Çýkýlýyor");
				System.exit(0);
				
			}
		});
		exitbtn.setForeground(new Color(153, 0, 0));
		exitbtn.setBackground(new Color(255, 51, 153));
		exitbtn.setBounds(244, 186, 89, 23);
		frame.getContentPane().add(exitbtn);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBounds(124, 75, 68, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setBounds(124, 131, 68, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		sifreal = new JPasswordField();
		sifreal.setEchoChar('*');
		sifreal.setBounds(232, 129, 86, 20);
		frame.getContentPane().add(sifreal);

	}
}
