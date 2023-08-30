package nivell1;

import java.util.ArrayList;

import entitats.Arbre;
import entitats.Compra;
import entitats.Decoracio;
import entitats.Entitat;
import entitats.Flor;
import entitats.Floristeria;
import entitats.Indexacio;
import entitats.LiniaCompra;
import entitats.LiniaVenda;
import entitats.Producte;
import entitats.Venda;

public class EntitatsData {

	private Floristeria floristeria;
	private String pathFloristeriaDB = "data_txt\\" + floristeria.getNom() + "db\\";
	private FloristeriaGestion floristeriaGestion;
	// private Percistencia percistencia;

	private ArrayList<Arbre> arbres;
	private ArrayList<Compra> compres;
	private ArrayList<Decoracio> decoracions;
	private ArrayList<Flor> flors;
	private ArrayList<Floristeria> floristeries;
	private ArrayList<Indexacio> indexacions;
	private ArrayList<LiniaCompra> liniesCompres;
	private ArrayList<LiniaVenda> liniesVendes;
	private ArrayList<Producte> productes;
	private ArrayList<Venda> vendes;

	String path;

	public EntitatsData() {
	}

	public void inicialitzar() {

	}

	public ArrayList<String> entitatToLinies(ArrayList<Entitat> elements) {
		ArrayList<String> linies = new ArrayList<>();
		elements.forEach(element -> linies.add(element.toString()));
		return linies;
	}

	public ArrayList<Entitat> liniesToEntitat(ArrayList<String> linies, Entitat entitat) {

		ArrayList<Entitat> elements = new ArrayList<>();
		linies.forEach(linia -> elements.add(entitat.fromString(linia)));
		return elements;
	}

	// arbres Arbre
	public ArrayList<Arbre> getArbres() {
		arbres = liniesToArbres(Persistencia.getLinies(path));
		return arbres;
	}

	public ArrayList<Arbre> liniesToArbres(ArrayList<String> linies) {
		Arbre arbre = new Arbre();
		ArrayList<Arbre> arbres = new ArrayList<>();
		linies.forEach(linia -> arbres.add(arbre.fromString(linia)));
		return arbres;
	}

	public void setArbres(ArrayList<Arbre> arbres) {
		this.arbres = arbres;
		Persistencia.saveLines(arbresToLinies(arbres), path);
	}

	public ArrayList<String> arbresToLinies(ArrayList<Arbre> arbres) {
		ArrayList<String> linies = new ArrayList<>();
		arbres.forEach(arbre -> linies.add(arbre.toString()));
		return linies;
	}

	// private ArrayList<Compra> compres;

//	private ArrayList<Decoracio> decoracions;
//	private ArrayList<Flor> flors;
//	private ArrayList<Floristeria> floristeries;
//	private ArrayList<Indexacio> indexacions;
//	private ArrayList<LiniaCompra> liniesCompres;
//	private ArrayList<LiniaVenda> liniesVendes;
//	private ArrayList<Producte> productes;
//	private ArrayList<Venda> vendes;

}