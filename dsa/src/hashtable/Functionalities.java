package hashtable;

import java.util.Scanner;

public class Functionalities {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int key = 0;
		String conti;
		int tsize = 0;
		String value;
		String input;
		boolean correctValue = false;

		System.out.println("Enter Size for HashTable: ");
		input = sc.nextLine();
		while (tsize < 5) {
			try {
				tsize = Integer.parseInt(input);
				if (tsize < 5) {
					System.out.println("Enter size greater than 5");
				} else
					break;
			} catch (NumberFormatException e) {
				System.out.println("ERROR!!! Enter Numbers Only");
			}
			System.out.println("Enter Size for HashTable: ");
			input = sc.nextLine();
		}
		Hashtable htable = new Hashtable(tsize);

		do {

			System.out.println("1: Insert");
			System.out.println("2: Delete");
			System.out.println("3: Contains");
			System.out.println("4: Get Value by Key");
			System.out.println("5: Size");
			System.out.println("6: Iterator");
			System.out.println("7: Traverse/Print");

			int ch = 0;
			while (ch <= 0) {

				System.out.println("ENTER CHOICE:");
				input = sc.nextLine();

				// exception handling
				try {
					ch = Integer.parseInt(input);
					if (ch <= 0) {
						System.out.println("Enter your choice Between 1-9");
					}

				} catch (NumberFormatException e) {
					System.out.println("ERROR!!! enter only numbers");
				}
			}

			switch (ch) {
			case 1:
				System.out.println("Enter Key:");
				input = sc.nextLine();
				while (!correctValue) {
					try {
						key = Integer.parseInt(input);
						correctValue = true;
						break;
					} catch (NumberFormatException e) {
						System.out.println("ERROR!!! Enter Numbers Only");
					}
					System.out.println("Enter Key:");
					input = sc.nextLine();
				}
				correctValue = false;
				System.out.println("Enter Value:");
				value = sc.nextLine();
				htable.insert(key, value);
				break;

			case 2:
				System.out.println("Enter Key to delete values:");
				input = sc.nextLine();
				while (!correctValue) {
					try {
						key = Integer.parseInt(input);
						correctValue = true;
						break;
					} catch (NumberFormatException e) {
						System.out.println("ERROR!!! Enter Numbers Only");
					}
					System.out.println("Enter Key to delete values:");
					input = sc.nextLine();
				}
				correctValue = false;
				htable.delete(key);
				break;

			case 3:
				System.out.println("Enter Key to check:");
				input = sc.nextLine();
				while (!correctValue) {
					try {
						key = Integer.parseInt(input);
						correctValue = true;
						break;
					} catch (NumberFormatException e) {
						System.out.println("ERROR!!! Enter Numbers Only");
					}
					System.out.println("Enter Key to check:");
					input = sc.nextLine();
				}
				correctValue = false;
				htable.contains(key);
				break;
			case 4:
				System.out.println("Enter Key to get values:");
				input = sc.nextLine();
				while (!correctValue) {
					try {
						key = Integer.parseInt(input);
						correctValue = true;
						break;
					} catch (NumberFormatException e) {
						System.out.println("ERROR!!! Enter Numbers Only");
					}
					System.out.println("Enter Key to get values:");
					input = sc.nextLine();
				}
				correctValue = false;
				htable.get(key);
				break;
			case 5:
				htable.size();
				break;
			case 6:
				System.out.print("Through Iterator: \n");
				for (Node list : htable) {
					if (list != null) {
						System.out.println(" Key:" + list.key + ", Value: " + list.value);
					}

				}

				break;
			case 7:
				htable.print();
				break;

			default:
				System.out.println("Invalid choice! Please make a valid choice.");
			}
			System.out.println("Do you want to continue (y/n):");
			conti = sc.nextLine();
			conti = conti.toUpperCase().trim();
		} while (conti.equals("Y"));
		sc.close();
	}

}
