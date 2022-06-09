package firstassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//initialization of variables
		String choice;
		String type = "";
		String insuranceType = "";
		String model = "";
		long insurancePremium = 0;
		long TotalPremium = 0;
		int numberOfUser = 0;

		ArrayList<Object> list = new ArrayList<>();

		do {
			int price = 0;//so that price can be reset every time
			numberOfUser++;//to add new records
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Enter Car Model:");
			model = sc.nextLine();
			model = model.toUpperCase().trim();

			while (!type.equals("HATCHBACK") || !type.equals("SEDAN") || type.equals("SUV")) {
				System.out.println("Enter Car type among these Hatchback/sedan/SUV only");
				type = sc.nextLine();
				type = type.toUpperCase().trim();
				if (type.equals("HATCHBACK") || type.equals("SEDAN") || type.equals("SUV"))
					break;
			}

			while (!insuranceType.equals("BASIC") || !insuranceType.equals("PREMIUM")) {

				System.out.println("Please select among the Basic/Premium insurance only");
				insuranceType = sc.nextLine();
				insuranceType = insuranceType.toUpperCase().trim();
				if (insuranceType.equals("BASIC") || insuranceType.equals("PREMIUM"))
					break;

			}
			while (price <= 0) {
				System.out.println("ENTER CAR PRICE:");
				String input = sc.nextLine();
				//exception handling
				try {
					price = Integer.parseInt(input);

				} catch (NumberFormatException e) {
					System.out.println("ERROR!!! enter only numbers");
				}
			}
			//	calculating premium
			if (type.equals("HATCHBACK")) {
				insurancePremium = (price * 5 / 100);
				TotalPremium = insurancePremium;
				if (insuranceType.equals("PREMIUM"))
					TotalPremium = (insurancePremium + insurancePremium * 20 / 100);

			} else if (type.equals("SEDAN")) {

				insurancePremium = (price * 8 / 100);
				TotalPremium = insurancePremium;
				if (insuranceType.equals("PREMIUM"))
					TotalPremium = (insurancePremium + insurancePremium * 20 / 100);

			}

			else {

				insurancePremium = (price * 10 / 100);
				TotalPremium = insurancePremium;
				if (insuranceType.equals("PREMIUM"))
					TotalPremium = (insurancePremium + insurancePremium * 20 / 100);

			}
			//adding data in list
			list.add(model);
			list.add(type);
			list.add(price);
			list.add(insuranceType);
			list.add(TotalPremium);

			System.out.println("Do you want to enter details of any other car (yes/no):");
			choice = sc.next();
			choice = choice.toUpperCase().trim();
		} while (choice.equals("YES"));

		for (int i = 0; i < numberOfUser * 5; i++) {
			
			//displaying data
			System.out.println("DETAILS ARE:");
			System.out.println("model:" + list.get(i++));
			System.out.println("type:" + list.get(i++));
			System.out.println("price:" + list.get(i++));
			System.out.println("insuranceType:" + list.get(i++));
			System.out.println("TotalPremium:" + list.get(i));
			System.out.println();
		}

	}
}
