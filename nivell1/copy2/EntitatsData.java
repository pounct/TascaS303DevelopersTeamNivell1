package nivell1.copy2;

import java.util.ArrayList;

import entitats.Arbre;
import entitats.Compra;
import entitats.Decoracio;
import entitats.Flor;
import entitats.Floristeria;
import entitats.Indexacio;
import entitats.LiniaCompra;
import entitats.LiniaVenda;
import entitats.Producte;
import entitats.Venda;

public class EntitatsData {
	
	private String pathFloristeriaDB;
	private FloristeriaGestion floristeriaGestion;
	private Floristeria floristeria;
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

	public EntitatsData(Floristeria floristeria) {

		this.floristeria = floristeria;
		Persistencia.setFloristeria(floristeria);
	}
	// String to ArrayList<Entitat> entitats
	public <T> ArrayList<T> getDataTableFromDB(T nomClass,Floristeria floristeria) {
		ArrayList<T> datataTable=Persistencia.getData("");
		return datataTable;
	}

	

	public void setArbres(ArrayList<Arbre> arbres) {
		this.arbres = arbres;
		Persistencia.saveData(this.arbres, "Arbre");
	}

	public void setCompres(ArrayList<Compra> compres) {
		this.compres = compres;
		Persistencia.saveData(this.arbres, "Compra");
	}

	public void setDecoracions(ArrayList<Decoracio> decoracions) {
		this.decoracions = decoracions;
		Persistencia.saveData(this.arbres, "Decoracio");
	}

	public void setFlors(ArrayList<Flor> flors) {
		this.flors = flors;
		Persistencia.saveData(this.arbres, "Flor");
	}

	public void setFloristeries(ArrayList<Floristeria> floristeries) {
		this.floristeries = floristeries;
		Persistencia.saveData(this.arbres, "Floristeria");
	}

	public void setIndexacions(ArrayList<Indexacio> indexacions) {
		this.indexacions = indexacions;
		Persistencia.saveData(this.arbres, "Indexacio");
	}

	public void setLiniesCompres(ArrayList<LiniaCompra> liniesCompres) {
		this.liniesCompres = liniesCompres;
		Persistencia.saveData(this.arbres, "LiniaCompra");
	}

	public void setLiniesVendes(ArrayList<LiniaVenda> liniesVendes) {
		this.liniesVendes = liniesVendes;
		Persistencia.saveData(this.arbres, "LiniaVenda");
	}

	public void setProductes(ArrayList<Producte> productes) {
		this.productes = productes;
		Persistencia.saveData(this.arbres, "Producte");
	}

	public void setVendes(ArrayList<Venda> vendes) {
		this.vendes = vendes;
		Persistencia.saveData(this.arbres, "Venda");
	}

	public void save(String nomFloristeria) {

		Persistencia.saveData(this.arbres, "Arbre");
		Persistencia.saveData(this.compres, "Compra");
		Persistencia.saveData(this.decoracions, "Decoracio");
		Persistencia.saveData(this.flors, "Flor");
		Persistencia.saveData(this.floristeries, "Floristeria");
		Persistencia.saveData(this.indexacions, "Indexacio");
		Persistencia.saveData(this.liniesCompres, "LiniaCompra");
		Persistencia.saveData(this.liniesVendes, "LiniaVenda");
		Persistencia.saveData(this.productes, "Producte");
		Persistencia.saveData(this.vendes, "Venda");

	}

	public EntitatsData loadEntitatsData(String nomFloristeria) {
		this.arbres = Persistencia.getData("Arbre");
		this.compres = Persistencia.getData("Compra");
		this.decoracions = Persistencia.getData("Decoracio");
		this.flors = Persistencia.getData("Flor");
		this.floristeries = Persistencia.getData("Floristeria");
		this.indexacions = Persistencia.getData("Indexacio");
		this.liniesCompres = Persistencia.getData("LiniaCompra");
		this.liniesVendes = Persistencia.getData("LiniaVenda");
		this.productes = Persistencia.getData("Producte");
		this.vendes = Persistencia.getData("Venda");
		return this;
	}

	public Floristeria getFloristeria() { // FloristeriaGestion
		pathFloristeriaDB = "data_txt\\" + floristeria.getNom() + "\\";
		loadEntitatsData(floristeria.getNom());
		return floristeria;
	}

	public void setFloristeria(Floristeria floristeria) {
		
		this.floristeria = floristeria;
	}

	public String getPathFloristeriaDB() {
		return pathFloristeriaDB;
	}

	public void setPathFloristeriaDB(String pathFloristeriaDB) {
		this.pathFloristeriaDB = pathFloristeriaDB;
	}

}