package com.denialmc.fusebox.guis;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.denialmc.fusebox.Bootstrap;
import com.denialmc.fusebox.Utils;
import com.denialmc.fusebox.listeners.GameListener;
import com.denialmc.fusebox.utils.GridElement;

import lombok.Getter;

@Getter
public class GameGUI extends JFrame {
	
	private Button[][] coords;
	private ActionListener listener = new GameListener(this);
	
	public GameGUI(int gridSize) {
		coords = new Button[gridSize][gridSize];
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(gridSize, gridSize));
		setTitle("Fusebox");
		setMinimumSize(new Dimension(400, 400));
		
		List<GridElement> elements = new ArrayList<GridElement>();
		
		for (int x = 0; x < gridSize; x++) {
			for (int y = 0; y < gridSize; y++) {
				Button button = new Button();
				
				button.setBackground(Color.red);
				button.addActionListener(listener);
				button.setName(String.format("%s,%s", x, y));
				elements.add(new GridElement(x, y));
				add(button);
				coords[x][y] = button;
			}
		}
		
		if (Bootstrap.isHard()) {
			for (GridElement element : Utils.pickRandom(elements, 3)) {
				pressButton(element.getX(), element.getY());
			}
		}
		
		pack();
	}
	
	public GameGUI() {
		this(Bootstrap.getGridSize());
	}
	
	public void pressButton(int x, int y) {
		if (x == -1 || y == -1) {
			return;
		}
		
		switchButton(x - 1, y);
		switchButton(x + 1, y);
		switchButton(x, y - 1);
		switchButton(x, y + 1);
		checkWinSituation();
	}
	
	public void switchButton(int x, int y) {
		try {
			Button button = coords[x][y];
			
			button.setBackground(button.getBackground() == Color.red ? Color.green : Color.red);
		} catch (Exception e) {
			// Ignore.
		}
	}
	
	public void checkWinSituation() {
		for (Button[] buttons : coords) {
			for (Button button : buttons) {
				if (button.getBackground() != Color.green) {
					return;
				}
			}
		}
		
		GUIManager.openFrame("win");
	}
}