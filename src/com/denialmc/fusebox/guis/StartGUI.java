package com.denialmc.fusebox.guis;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.denialmc.fusebox.listeners.DifficultyListener;
import com.denialmc.fusebox.listeners.SizeListener;
import com.denialmc.fusebox.listeners.StartListener;

public class StartGUI extends JFrame {
	
	private JRadioButton easyMode;
	private JRadioButton hardMode;
	
	public StartGUI() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 0));
		setTitle("Welcome to Fusebox!");
		setResizable(false);
		
		JLabel label = new JLabel("Welcome to Fusebox, a small game by Tohka!", SwingConstants.CENTER);
		JButton button = new JButton("Play now!");
		
		JPanel sizePanel = new JPanel();
		JPanel modePanel = new JPanel();
		modePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
		sizePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 85, 0));
		
		JSpinner sizeSpinner = new JSpinner(new SpinnerNumberModel(4, 4, 20, 2));
		sizeSpinner.addChangeListener(new SizeListener());
		sizePanel.add(new JLabel("Grid size:"));
		sizePanel.add(sizeSpinner);
		
		ButtonGroup group = new ButtonGroup();
		easyMode = new JRadioButton("Easy Mode", true);
		hardMode = new JRadioButton("Hard Mode", false);

		group.add(easyMode);
		group.add(hardMode);
		modePanel.add(easyMode);
		modePanel.add(hardMode);
		
		easyMode.addActionListener(new DifficultyListener(false));
		hardMode.addActionListener(new DifficultyListener(true));
		button.addActionListener(new StartListener());
		add(label);
		add(sizePanel);
		add(modePanel);
		add(button);
		pack();
	}
	
	public boolean isHard() {
		return hardMode.isSelected();
	}
}