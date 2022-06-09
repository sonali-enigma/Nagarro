package tshirts;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Functionalities extends Thread {

	static List<String> FileName;

	public void run() {
		FileName = new LinkedList<String>();
		final File folder = new File(".\\src\\main\\resources");

		for (final File fileEntry : folder.listFiles()) {

			if (fileEntry.getName().contains(".csv"))
				FileName.add(".\\src\\main\\resources\\" + fileEntry.getName());

		}
	}

	public static void main(String args[]) throws NumberFormatException, IOException {
		
		boolean flag = false;
		String Colour;
		String Size;
		String Gender;
		String OutputPreference;
		String conti;
		
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		Scanner sc = new Scanner(System.in);
		Functionalities tshirtThread = new Functionalities();
		tshirtThread.start();
		
		executor.scheduleAtFixedRate(tshirtThread, 0, 5, TimeUnit.SECONDS);
		
		do {

			System.out.println("Enter the Color");
			Colour = sc.nextLine().toUpperCase();

			System.out.println("Enter the Size");
			Size = sc.nextLine().toUpperCase();

			while (flag != true) {
				if (Size.equals("S") || Size.equals("M") || Size.equals("L") || Size.equals("XL")
						|| Size.equals("XXL")) {
					flag = true;
					break;
				} else {
					System.out.println("Enter the Size Between (S/M/L/XL/XXL)");
					Size = sc.nextLine().toUpperCase();
				}
			}
			flag = false;

			
			System.out.println("Enter the Gender");
			Gender = sc.nextLine().toUpperCase();

			while (flag != true) {
				if (Gender.equals("M") || Gender.equals("F") || Gender.equals("U")) {
					flag = true;
					break;
				} else {
					System.out.println("Enter the  Gender(M/F/U) only");
					Gender = sc.nextLine().toUpperCase();
				}
			}
			flag = false;

			
			System.out.println("Enter the Output Preference 1.PRICE  2.RATING  3.PRICE and RATING");
			OutputPreference = sc.nextLine();

			while (flag != true) {
				if (OutputPreference.equals("1") || OutputPreference.equals("2") || OutputPreference.equals("3")) {
					flag = true;
					break;
				} else {
					System.out.println("Enter the  OutputPreference( 1.PRICE  2.RATING  3.PRICE and RATING) only");
					OutputPreference = sc.nextLine();
				}
			}
			flag = false;

			
			SelectTshirt findtshirt = new SelectTshirt();

			for (String file : FileName) {
				findtshirt.find(file, Colour, Size, Gender);

			}
			findtshirt.updateView(OutputPreference);
			findtshirt.print();
			System.out.println("Do you want to continue (y/n):");
			conti = sc.nextLine();
			conti = conti.toUpperCase().trim();
		} while (conti.equals("Y"));
	}
}
