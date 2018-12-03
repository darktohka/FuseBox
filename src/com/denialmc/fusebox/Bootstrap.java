package com.denialmc.fusebox;

import com.denialmc.fusebox.guis.GUIManager;

import lombok.Getter;
import lombok.Setter;

public class Bootstrap {

	@Getter @Setter private static boolean hard = false;
	@Getter @Setter private static int gridSize = 4;
	
	public static void main(String[] args) {
		GUIManager.openFrame("start");
	}
}