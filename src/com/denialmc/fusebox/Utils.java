package com.denialmc.fusebox;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Utils {

	public static int parseInt(String string) {
		try {
			return Integer.valueOf(string);
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static <T> List<T> pickRandom(List<T> list, int n) {
	    List<T> copy = new LinkedList<T>(list);
	    Collections.shuffle(copy);

	    return copy.subList(0, n);
	}
}