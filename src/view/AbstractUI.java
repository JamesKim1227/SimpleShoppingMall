package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractUI {
	
	protected String getInputString() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	abstract public void show();
	
}
