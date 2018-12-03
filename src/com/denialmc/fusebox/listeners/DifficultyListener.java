package com.denialmc.fusebox.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.denialmc.fusebox.Bootstrap;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class DifficultyListener implements ActionListener {

	private boolean hard;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Bootstrap.setHard(hard);
	}
}
