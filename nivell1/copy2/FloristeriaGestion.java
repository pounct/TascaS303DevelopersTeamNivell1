package nivell1.copy2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

public class FloristeriaGestion {

	// gestion floristeria
	private Floristeria floristeria;
	private String pathFloristeriaDB;
	private ArrayList<Floristeria> floristeries;
	private EntitatsData entitatsData;
	// gestion indexacio
	private Indexacio indexacio;
	// gestion producte
	private List<Producte> productes;
	private List<Arbre> arbres;
	private List<Flor> flors;
	private List<Decoracio> decoracions;
	// gestion Stock
	private Stock stock;
	// stock.setArbres(Stock.getArbres());
	private List<Compra> compres = new ArrayList<Compra>();
	private List<Venda> vendes = new ArrayList<Venda>();
	private List<LiniaCompra> liniesCompres = new ArrayList<LiniaCompra>();
	private List<LiniaVenda> liniesVendes = new ArrayList<LiniaVenda>();
	//////
	private ArrayList<Indexacio> indexacions;
	//////

	public FloristeriaGestion() {
//		floristeries = Persistencia.getData("Floristeria");
//		stock = new Stock();//. . .
	}

	public void afegirArbre(Indexacio indexacio, Scanner sc) {
		Arbre arbre = new Arbre();
		Producte producte = new Producte();
		Compra compra = new Compra();
		LiniaCompra liniaCompra = new LiniaCompra();
		int producteId = indexacio.getIndexProducte();
		int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaCompra();
		Date dateC = new Date(System.currentTimeMillis());
		System.out.println("designacio : ");
		String nom = sc.nextLine();
		System.out.println("preu de compra : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("alcada del arbre : ");
		float alcada = sc.nextFloat();
		sc.nextLine();
		// afegir Arbre
		arbre.setId(producteId);
		arbre.setAlcada(alcada);
		this.arbres.add(arbre);

		// update depemdencies
		producte.setId(producteId);
		producte.setDesignacio(nom);
		this.productes.add(producte);
		//////////////////////
		compra.setId(compraId);
		compra.setDate(dateC);
		this.compres.add(compra);
		////////////////////////
		liniaCompra.setCompraId(compraId);
		liniaCompra.setId(liniaId);
		liniaCompra.setProducteId(producteId);
		liniaCompra.setPreu(preu);
		this.liniesCompres.add(liniaCompra);

		entitatsData.save(floristeria.getNom());

	}

	public <T> void addToList(List<T> list, T o) {
		list.add(o);
	}

	public <T> void removeFromList(List<T> list, T o) {
		list.remove(o);
	}

	public <T> void imprimirList(List<T> list) {
		for (T t : list) {
			System.out.println(t);
		}
	}

	public String getPathFloristeriaDB() {
		return pathFloristeriaDB;
	}

	public void setPathFloristeriaDB(String pathFloristeriaDB) {
		this.pathFloristeriaDB = pathFloristeriaDB;
	}

	public EntitatsData getEntitatsData() {
		return entitatsData;
	}

	public void setEntitatsData(EntitatsData entitatsData) {
		this.entitatsData = entitatsData;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public void setFloristeries(ArrayList<Floristeria> floristeries) {
		this.floristeries = floristeries;
	}

	public ArrayList<Floristeria> getFloristeries() {
		return floristeries;
	}

	public void setFloristeries(Floristeria[] floristeries) {
		// this.floristeries = floristeries;
	}

	public Indexacio[] getIndexacions() {
		return null;
		// return indexacions;
	}

	public void setIndexacions(ArrayList<Indexacio> indexacions) {
		this.indexacions = indexacions;
	}

	public Floristeria getFloristeria() {
		return floristeria;
	}

	public void setFloristeria(Floristeria floristeria) {
		// floristeria
		this.floristeria = floristeria;
		this.pathFloristeriaDB = "data_txt\\" + floristeria.getNom() + "\\";
		this.entitatsData.setFloristeria(floristeria);
		// stock
		// stock.setProductes();

	}

	public void loadFloristeria(Floristeria floristeria) {
		this.pathFloristeriaDB = "data_txt\\" + floristeria.getNom() + "\\";
		if (floristeries.contains(floristeria)) {
			entitatsData.loadEntitatsData(floristeria.getNom());
			arbres = entitatsData.getDataTableFromDB(null, floristeria);
		}
		this.floristeria = floristeria;
		this.setIndexacions(Persistencia.getData("Indexacio"));
		this.indexacio = indexacions.get(0);
		this.setArbres(Persistencia.getData("arbre"));
	}

//	public List<Arbre> getArbres() {
//		return stock.getArbres();
//	}

	public void setArbres(List<Arbre> arbres) {
		stock.setArbres(arbres);
		this.arbres = arbres;
	}

	public List<Flor> getFlors() {
		return flors;
	}

	public void setFlors(List<Flor> flors) {
		this.flors = flors;
	}

	public List<Decoracio> getDecoracio() {
		return decoracions;
	}

	public void setDecoracio(List<Decoracio> decoracio) {
		this.decoracions = decoracio;
	}

	public List<Compra> getCompres() {
		return compres;
	}

	public void setCompres(List<Compra> compres) {
		this.compres = compres;
	}

	public List<Venda> getVendes() {
		return vendes;
	}

	public void setVendes(List<Venda> vendes) {
		this.vendes = vendes;
	}

	public void save(Floristeria floristeria) {
		Persistencia.saveFloristeria(floristeria);
	}

	public Indexacio getIndexacio() {
		return indexacio;
	}

	public void setIndexacio(Indexacio indexacio) {
		this.indexacio = indexacio;
	}

	/*
	 * public void inicialitzarIndexacio() { this.indexacio = indexacio; }
	 */
	@Override
	public String toString() {
		return "FloristeriaGestion [arbres=" + arbres + ", flors=" + flors + ", decoracio=" + decoracions + ", compres="
				+ compres + ", vendes=" + vendes + "]";
	}

	public List<LiniaCompra> getLiniesCompres() {
		return liniesCompres;
	}

	public void setLiniesCompres(List<LiniaCompra> liniesCompres) {
		this.liniesCompres = liniesCompres;
	}

	public List<LiniaVenda> getLiniesVendes() {
		return liniesVendes;
	}

	public void setLiniesVendes(List<LiniaVenda> liniesVendes) {
		this.liniesVendes = liniesVendes;
	}

	// funcionalitats:

}
