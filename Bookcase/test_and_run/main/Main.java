package main;

import java.awt.EventQueue;

import external_memory.Manager;
import interfaces.Login;

public class Main {

	public static void main(String[] args) {
		
		//Manager.loadData();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
