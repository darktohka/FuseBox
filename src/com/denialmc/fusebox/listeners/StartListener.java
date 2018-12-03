package com.denialmc.fusebox.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.denialmc.fusebox.guis.GUIManager;

public class StartListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		GUIManager.openFrame("game");
	}
}