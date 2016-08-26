package com.weekfourproject;

import java.util.Scanner;

public class MovieTheater {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String userMenuInput = null;
		boolean menuCorrect = false;
		System.out.println("Welcome to the Movie Database");
		
		
		do {
			System.out.println("Press 1 to read from the database, 2 to add to the database,"
					+ "\n3 to delete from database, or 4 to update the database ");
			userMenuInput = sc.nextLine();
			switch (userMenuInput) {
			case "1":
				DAO.readFromDB();
				break;
				
			case "2":
				DAO.writeToDB();	
				break;
				
			case "3":
				DAO.removeFromDB();	
				break;
				
			case "4":
				DAO.updateDB();
				break;
			default:
				System.out.println("You've entered an invalid option");
				menuCorrect = true;
				break;
			}
		} while (menuCorrect);
		
	}


	}


