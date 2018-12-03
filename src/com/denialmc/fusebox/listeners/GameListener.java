package com.denialmc.fusebox.listeners;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.denialmc.fusebox.Utils;
import com.denialmc.fusebox.guis.GameGUI;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class GameListener implements ActionListener {

	private GameGUI game;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof Button) {
			Button button = (Button) event.getSource();
			String[] split = button.getName().split(",");
			
			if (split.length > 1) {
				int x = Utils.parseInt(split[0]);
				int y = Utils.parseInt(split[1]);
				game.pressButton(x,  y);
			}
		}
	}
}