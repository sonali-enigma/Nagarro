package nchildtree;

import java.util.Scanner;

public class Functionalities {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int key = 0;
		String conti;
		String value;
		String parent;
		String input;

		System.out.println("Enter root:");
		value = sc.nextLine();
		Node root = new Node(value);
		Nchild tree = new Nchild(root);

		do {
			System.out.println("1: Insert");
			System.out.println("2: Delete");
			System.out.println("3: Contains");
			System.out.println("4: Get Elements by value");
			System.out.println("5: Get Elements by level");
			System.out.println("6: Iterator Breadth First");
			System.out.println("7: Iterator Depth First");
			System.out.println("8: Traverse/Print Breadth First");
			System.out.println("9: Traverse/Print Depth First");

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
				System.out.println("Enter Value:");
				value = sc.nextLine();
				System.out.println("Enter parent:");
				parent = sc.nextLine();
				tree.insert(value, parent);
				break;

			case 2:
				System.out.println("Enter Value to delete:");
				value = sc.nextLine();
				tree.delete(value);
				break;

			case 3:
				System.out.println("Enter Value to check:");
				value = sc.nextLine();
				tree.contains(value);
				break;
			case 4:
				System.out.println("Enter Element to get value:");
				value = sc.nextLine();
				tree.getElement(value);
				break;
			case 5:
				System.out.println("Level Order Traversal");
				for (Node list : tree.breadthFirst()) {
					if (list != null) {
						System.out.print(list.data + "  ");
					}
				}
				break;
			case 6:
				// ITERATOR
				break;
			case 7:
				// ITERATOR
				break;
			case 8:
				System.out.println("Breadth First:");
				for (Node list : tree.breadthFirst()) {
					if (list != null) {
						System.out.print(list.data + "  ");
					}
				}
				break;
			case 9:
				System.out.println("Depth First:");
				for (Node list : tree.depthFirst()) {
					if (list != null) {
						System.out.print(list.data + "  ");
					}
				}
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
