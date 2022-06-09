package tshirts;

import java.io.*;
import com.opencsv.*;
import java.util.*;

public class SelectTshirt {

	List<Tshirt> tshirtlist = new LinkedList<Tshirt>();
	LinkedList<String> list;
	PreviewData show = new PreviewData();

	public void find(String Filename, String Colour, String Size, String Gender)
			throws NumberFormatException, IOException {
		FileReader filereader = new FileReader(Filename);
		CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
		CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
		List<String[]> allData = csvReader.readAll();

		for (String[] row : allData) {
			list = new LinkedList<String>();
			for (String cell : row) {
				list.add(cell.toUpperCase());

			}

			if (list.size() > 6 && list.get(2).equals(Colour) && list.get(4).equals(Size)
					&& list.get(3).equals(Gender)) {
				Tshirt tshirt = new Tshirt(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4),
						Float.parseFloat(list.get(5)), Float.parseFloat(list.get(6)), list.get(7));
				tshirtlist.add(tshirt);
			}

		}

	}

	public void updateView(String OutputPreference) {
		if (OutputPreference.equals(1)) {
			Collections.sort(tshirtlist, new Comparator<Tshirt>() {

				public int compare(Tshirt o1, Tshirt o2) {
					return (int) (o1.getPrice() - o2.getPrice());
				}
			});
		}

		else if (OutputPreference.equals(2)) {
			Collections.sort(tshirtlist, new Comparator<Tshirt>() {

				public int compare(Tshirt o1, Tshirt o2) {
					float j = o2.getRating() - o1.getRating();
					if (j > 0)
						return 1;
					else if (j < 0)
						return -1;
					else
						return 0;

				}
			});
		}

		else {
			Collections.sort(tshirtlist, new Comparator<Tshirt>() {

				public int compare(Tshirt o1, Tshirt o2) {
					int i = (int) (o1.getPrice() - o2.getPrice());
					if (i == 0) {
						if (o1.getRating() > o2.getRating())
							return -1;
						if (o1.getRating() < o2.getRating())
							return 1;
						else
							return 0;

					} else
						return i;
				}
			});
		}
	}

	public void print() {
		PreviewData preview = new PreviewData();
		preview.viewTshirts(tshirtlist);
	}
}