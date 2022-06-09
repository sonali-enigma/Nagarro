package com.tshirts;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main extends Thread {

	// list containing all the files with .csv extention
	static List<String> FileName;

	static File folder = new File(".\\src\\main\\resources");

	public void run() {
		FileName = new LinkedList<String>();

		for (final File fileEntry : folder.listFiles()) {

			if (fileEntry.getName().contains(".csv"))
				FileName.add(".\\src\\main\\resources\\" + fileEntry.getName());

		}

		SearchTshirt insertDB = new SearchTshirt();
		try {
			insertDB.insertingInDB(FileName);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String args[]) throws NumberFormatException, IOException, InterruptedException {

		boolean flag = false;
		String colour;
		String size;
		String gender;
		String outputPreference;
		String choice;

		Scanner sc = new Scanner(System.in);

		long lastmodified = folder.lastModified();

		// thread creation
		Main tshirtThread = new Main();
		tshirtThread.start();

		do {
			tshirtThread.join();
			tshirtThread.interrupt();
			// getting color
			System.out.println("Enter the Color");
			colour = sc.nextLine().toUpperCase();

			System.out.println("Enter the Size");
			size = sc.nextLine().toUpperCase();

			// getting size
			while (flag != true) {
				if (size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL")
						|| size.equals("XXL")) {
					flag = true;
					break;
				} else {
					System.out.println("Enter the Size Between (S/M/L/XL/XXL)");
					size = sc.nextLine().toUpperCase();
				}
			}
			flag = false;

			// getting gender
			System.out.println("Enter the Gender");
			gender = sc.nextLine().toUpperCase();

			while (flag != true) {
				if (gender.equals("M") || gender.equals("F") || gender.equals("U")) {
					flag = true;
					break;
				} else {
					System.out.println("Enter the  Gender(M/F/U) only");
					gender = sc.nextLine().toUpperCase();
				}
			}
			flag = false;

			// getting preference
			System.out.println("Enter the Output Preference 1.PRICE  2.RATING  3.PRICE and RATING");
			outputPreference = sc.nextLine();

			while (flag != true) {
				if (outputPreference.equals("1") || outputPreference.equals("2") || outputPreference.equals("3")) {
					flag = true;
					break;
				} else {
					System.out.println("Enter the  OutputPreference( 1.PRICE  2.RATING  3.PRICE and RATING) only");
					outputPreference = sc.nextLine();
				}
			}
			flag = false;
			// checking if lastmodified or not
			if (lastmodified != folder.lastModified()) {
				lastmodified = folder.lastModified();
				tshirtThread.run();
				tshirtThread.join();

			}

			SearchTshirt findtshirt = new SearchTshirt();

			findtshirt.sortTshirts(colour, size, gender, outputPreference); // calling sortTshirts function
			findtshirt.print(); // calling print function for printing all data

			System.out.println("Do you want to continue (y/n):");
			choice = sc.nextLine();
			choice = choice.toUpperCase().trim();
		} while (choice.equals("Y"));

	}
}
