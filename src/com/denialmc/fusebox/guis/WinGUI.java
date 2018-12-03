package com.denialmc.fusebox.guis;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.denialmc.fusebox.listeners.StartListener;

public class WinGUI extends JFrame {
	
	public WinGUI() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 0));
		setTitle("You won!");
		setMinimumSize(new Dimension(200, 100));
		
		JLabel label = new JLabel("You won!", SwingConstants.CENTER);
		JButton button = new JButton("Play again?");
		
		button.addActionListener(new StartListener());
		add(label);
		add(button);
		pack();
	}
}