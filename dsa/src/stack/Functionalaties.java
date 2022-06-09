package stack;

import java.util.Scanner;

public class Functionalaties {

	public static void main(String args[]) {
		Stacklinklist<String> list = new Stacklinklist<String>();

		String data = null;
		String conti;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("1: Push");
			System.out.println("2: Pop");
			System.out.println("3: Peek");
			System.out.println("4: Contains");
			System.out.println("5: Size");
			System.out.println("6: Reverse");
			System.out.println("7: Iterate");
			System.out.println("8: Traverse/Print");

			int ch = 0;
			while (ch <= 0) {

				System.out.println("ENTER CHOICE:");
				String input = sc.nextLine();

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
				System.out.println("Enter the data to be inserted \n");
				data = sc.nextLine();
				list.push(data);
				break;

			case 2:

				data = sc.nextLine();
				list.pop();
				break;

			case 3:


				list.peek();
				break;

			case 4:
				System.out.println("Enter the data to be checked \n");
				data = sc.nextLine();
				list.contains(data);
				break;

			case 5:
				list.size();
				break;

			case 6:

				list.reverse();
				break;

			case 7:

				for (String string : list)
		            System.out.println(string);
				break;

			case 8:

				list.print();
				break;

			default:
				System.out.println("Invalid choice! Please make a valid choice. \n\n");
			}

			System.out.println("Do you want to continue (y/n):");
			conti = sc.nextLine();
			conti = conti.toUpperCase().trim();
		} while (conti.equals("Y"));
	}
}
