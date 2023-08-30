package nivell1.copy;

import java.sql.Date;
import java.util.ArrayList;

import entitats.Arbre;
import entitats.Compra;
import entitats.Decoracio;
import entitats.Decoracio.Material;
import entitats.Flor;
import entitats.Floristeria;
import entitats.LiniaCompra;
import entitats.LiniaVenda;
import entitats.Producte;
import entitats.Venda;

public class Persistencia {

	public void LoadData() {

	}

	public void updateData() {

	}

	public static <T> ArrayList<T> getData(String nomClasse) {

		ArrayList<T> elements = new ArrayList<>();
		ArrayList<String> Linies = new ArrayList<>();
		Linies = ServeisData.readLinies(nomClasse);
		elements = stringToObjecte(Linies, nomClasse);

		return elements;

	}

	public static <T> ArrayList<T> stringToObjecte(ArrayList<String> linies, String nomClasse) {

		switch (nomClasse) {
		case "Producte":
			return (ArrayList<T>) stringToProductes(linies);
		case "Arbre":
			return (ArrayList<T>) stringToArbres(linies);
		case "Flor":
			return (ArrayList<T>) stringToFlors(linies);
		case "Decoracio":
			return (ArrayList<T>) stringToDecoracions(linies);
		case "LiniaCompra":

			return (ArrayList<T>) stringToLiniesCompres(linies);
		case "LiniaVenda":

			return (ArrayList<T>) stringToLiniesVendes(linies);
		case "Compra":

			return (ArrayList<T>) stringToCompres(linies);
		case "Venda":

			return (ArrayList<T>) stringToVendes(linies);
		case "Floristeria":

			return (ArrayList<T>) stringToFloristeries(linies);

		default:
			System.out.println("error en nom de classe");
			break;
		}
		return null;
	}

	public static ArrayList<Producte> stringToProductes(ArrayList<String> linies) {

		ArrayList<Producte> productes = new ArrayList<>();
		Producte producte = new Producte();
		for (String linia : linies) {
			String[] campos = linia.split("\t");
			producte.setId(Integer.parseInt(campos[0]));
			producte.setDesignacio(campos[1]);
			productes.add(producte);
		}
		return productes;

	}

	public static ArrayList<Arbre> stringToArbres(ArrayList<String> linies) {

		ArrayList<Arbre> arbres = new ArrayList<>();
		Arbre arbre = new Arbre();
		for (String linia : linies) {
			String[] campos = linia.split("\t");
			arbre.setId(Integer.parseInt(campos[0]));
			arbre.setAlcada(Float.parseFloat(campos[1]));
			arbres.add(arbre);
		}
		return arbres;

	}

	public static ArrayList<Flor> stringToFlors(ArrayList<String> linies) {
		ArrayList<Flor> flors = new ArrayList<>();
		Flor flor = new Flor();
		for (String linia : linies) {
			String[] campos = linia.split("\t");
			flor.setId(Integer.parseInt(campos[0]));
			flor.setColor(campos[1]);
			flors.add(flor);
		}
		return flors;
	}

	public static ArrayList<Decoracio> stringToDecoracions(ArrayList<String> linies) {
		ArrayList<Decoracio> decoracions = new ArrayList<>();
		Decoracio decoracio = new Decoracio();
		for (String linia : linies) {
			String[] campos = linia.split("\t");
			Material material;
			if (campos[1].toLowerCase().equals("plastic"))
				material = Material.PLASTIC;
			else
				material = Material.FUSTA;

			decoracio.setId(Integer.parseInt(campos[0]));
			decoracio.setMaterial(material);
			decoracions.add(decoracio);
		}
		return decoracions;
	}

	public static ArrayList<LiniaCompra> stringToLiniesCompres(ArrayList<String> linies) {
		ArrayList<LiniaCompra> liniesCompres = new ArrayList<>();
		LiniaCompra liniaCompra = new LiniaCompra();
		for (String linia : linies) {
			String[] campos = linia.split("\t");
			liniaCompra.setId(Integer.parseInt(campos[0]));
			liniaCompra.setCompraId(Integer.parseInt(campos[1]));
			liniaCompra.setProducteId(Integer.parseInt(campos[2]));
			liniaCompra.setPreu(Double.parseDouble(campos[3]));
			liniesCompres.add(liniaCompra);
		}
		return liniesCompres;
	}

	public static ArrayList<LiniaVenda> stringToLiniesVendes(ArrayList<String> linies) {
		ArrayList<LiniaVenda> liniesVendes = new ArrayList<>();
		LiniaVenda liniaVenda = new LiniaVenda();
		for (String linia : linies) {
			String[] campos = linia.split("\t");
			liniaVenda.setId(Integer.parseInt(campos[0]));
			liniaVenda.setVendaId(Integer.parseInt(campos[1]));
			liniaVenda.setProducteId(Integer.parseInt(campos[2]));
			liniaVenda.setPreu(Double.parseDouble(campos[3]));
			liniesVendes.add(liniaVenda);
		}
		return liniesVendes;

	}

	public static ArrayList<Compra> stringToCompres(ArrayList<String> linies) {
		ArrayList<Compra> compres = new ArrayList<>();
		Compra compra = new Compra();
		for (String linia : linies) {
			String[] campos = linia.split("\t");
			compra.setId(Integer.parseInt(campos[0]));
			compra.setDate(Date.valueOf(campos[1]));
			compres.add(compra);
		}
		return compres;

	}

	public static ArrayList<Venda> stringToVendes(ArrayList<String> linies) {

		ArrayList<Venda> vendes = new ArrayList<>();
		Venda venda = new Venda();
		for (String linia : linies) {
			String[] campos = linia.split("\t");
			venda.setId(Integer.parseInt(campos[0]));
			venda.setDate(Date.valueOf(campos[1]));
			vendes.add(venda.fromString(linia));
		}
		return vendes;

	}

	public static ArrayList<Floristeria> stringToFloristeries(ArrayList<String> linies) {
		ArrayList<Floristeria> floristeries = new ArrayList<>();
		Floristeria floristeria = new Floristeria();
		for (String linia : linies) {
			String[] campos = linia.split("\t");
			floristeria.setNom(campos[1]);
			floristeries.add(floristeria);
		}
		return floristeries;

	}

	// ArrayList<T>

	/*
	 * public ArrayList<Producte> getProductes() { Producte p = new Producte();
	 * getData(new Producte(), String fitxer)
	 * 
	 * }
	 */

	public <T> void saveData(ArrayList<T> elements, String nomClasse) {

		ArrayList<String> Linies = new ArrayList<>();
		elements.forEach((element) -> Linies.add(element.toString()));
		ServeisData.writeLinies(Linies, nomClasse+"Data.txt");
	}

	public void saveProductes(ArrayList<Producte> productes) {

		String fitxer = "\\src\\nivell1\\database\\ProducteData.txt";
		saveData(productes, fitxer);

	}

	public void saveArbres(ArrayList<Arbre> arbres) {
		String fitxer = "\\src\\nivell1\\database\\ArbreData.txt";
		saveData(arbres, fitxer);
	}

	public void saveFlors(ArrayList<Flor> flors) {
		String fitxer = "\\src\\nivell1\\database\\FlorData.txt";
		saveData(flors, fitxer);
	}

	public void saveDecoracions(ArrayList<Decoracio> decoracions) {
		String fitxer = "\\src\\nivell1\\database\\DecoracioData.txt";
		saveData(decoracions, fitxer);

	}

	public void saveCompres(ArrayList<Compra> compres) {
		String fitxer = "\\src\\nivell1\\database\\CompraData.txt";
		saveData(compres, fitxer);

	}

	public void saveVendes(ArrayList<Venda> vendes) {
		String fitxer = "\\src\\nivell1\\database\\VendaData.txt";
		saveData(vendes, fitxer);
	}

	public void saveLiniesCompres(ArrayList<LiniaCompra> LiniesCompres) {
		String fitxer = "\\src\\nivell1\\database\\LiniaCompraData.txt";
		saveData(LiniesCompres, fitxer);

	}

	public static void saveFloristeria(Floristeria floristeria) {

		String fitxer = "data_txt\\FloristeriaData.txt";
		String linia = floristeria.toString();

		ServeisData.writeLinia(linia, fitxer);

	}

	public void saveLiniesVendes(ArrayList<LiniaVenda> liniesVendes) {
		String fitxer = "data_txt\\LiniaVendaData.txt";
		saveData(liniesVendes, fitxer);
	}

	public void getArbres() {

	}

	public void getFlors() {

	}

	public void getDecoracions() {

	}

	public void getCompres() {

	}

	public void getVendes() {

	}

	public void getLiniesCompres() {

	}

	public void getLiniesVendes() {

	}

	public void getFloristeria() {

	}

}