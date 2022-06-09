package com.tshirts;
import java.util.List;

public class PreviewData {

	
	public void viewTshirts(List<Tshirt> tshirtList) {
		
		System.out.println("\n \t\t ***** PRODUCT INFORMATION *****"+"\n");

		
		for (Tshirt f : tshirtList) {
			System.out.println("ID \t\t" + f.getID());
			System.out.println("NAME \t\t" + f.getName());
			System.out.println("COLOUR\t\t" + f.getColour());
			System.out.println("GENDER\t\t" + f.getGender());
			System.out.println("SIZE\t\t" + f.getSize());
			System.out.println("PRICE\t\t" + f.getPrice());
			System.out.println("RATING \t\t" + f.getRating());
			System.out.println("AVAILABILITY\t" + f.getAvailability() + "\n");
		}
		if (tshirtList.isEmpty()) {
			System.out.println("Opps!! Tshirt is Not Available.");
		}
	}

}
