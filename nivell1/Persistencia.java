package nivell1;

import java.util.ArrayList;

public class Persistencia {

	// get Data from database
	public static ArrayList<String> getLinies(String path) {
		
		ArrayList<String> linies = new ArrayList<>();
		linies = ServeisData.readLinies(path); // + nomClasse + "Data.txt"
		return linies;
	}
	
	// save Data to database
	public static void saveLines(ArrayList<String> linies, String path) {
		// String path = "data_txt\\" + floristeria.getNom() + "\\";
		ServeisData.writeLinies(linies, path); // + nomClasse + "Data.txt"
	}
}
