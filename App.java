package com.jobinterviewer;

import com.jobinterviewer.ui.ConsoleUI;

/*
 Entry point of the Job Interviewer application.
 This class is responsible for starting the Console-based User Interface.
 */

public class App {

	public static void main(String[] args) {
		 // Create an instance of ConsoleUI to interact with the user
		ConsoleUI ui = new ConsoleUI();
		 // Start the console interface
        // All input/output operations will be handled inside ConsoleUI
		ui.start();
	}

}
