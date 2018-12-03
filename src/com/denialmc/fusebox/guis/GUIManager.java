package com.denialmc.fusebox.guis;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import lombok.Getter;

public class GUIManager {

	@Getter private static List<JFrame> frames = new ArrayList<JFrame>();
	
	public static void disableFrames() {
		for (JFrame frame : frames) {
			frame.dispose();
		}
		
		frames.clear();
	}
	
	public static void openFrame(String name) {
		disableFrames();
		JFrame frame = getFrame(name);
		
		if (frame != null) {
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frames.add(frame);
		}
	}
	
	public static JFrame getFrame(String name) {
		if (name.equalsIgnoreCase("game")) {
			return new GameGUI();
		} else if (name.equalsIgnoreCase("start")) {
			return new StartGUI();
		} else if (name.equalsIgnoreCase("win")) {
			return new WinGUI();
		}
		
		return null;
	}
}