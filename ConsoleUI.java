package com.jobinterviewer.ui;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("=== Virtual Job Interviewer ===");
        System.out.println("1. Interviewer Login");
        System.out.println("2. Candidate");
        System.out.print("Choose option: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            new InterviewerUI().start();
        } else if (choice == 2) {
            new CandidateUI().start();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
