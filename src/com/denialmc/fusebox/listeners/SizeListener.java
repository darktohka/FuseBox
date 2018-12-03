package com.denialmc.fusebox.listeners;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.denialmc.fusebox.Bootstrap;

public class SizeListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent event) {
		if (event.getSource() instanceof JSpinner) {
			JSpinner spinner = (JSpinner) event.getSource();
			Bootstrap.setGridSize((int) spinner.getValue());
		}
	}
}