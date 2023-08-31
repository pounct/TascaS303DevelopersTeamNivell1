package nivell1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import entitats.Arbre;
import entitats.Compra;
import entitats.Decoracio;
import entitats.Decoracio.Material;
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
	// private String pathFloristeriaDB;
	private ArrayList<Floristeria> floristeries;
	private EntitatsData entitatsData = new EntitatsData();
	// gestion indexacio
	private Indexacio indexacio;
	// gestion producte
	private ArrayList<Producte> productes = new ArrayList<>();
	private ArrayList<Arbre> arbres = new ArrayList<>();
	private ArrayList<Flor> flors = new ArrayList<>();
	private ArrayList<Decoracio> decoracions = new ArrayList<>();
	// gestion Stock
	private Stock stock;
	// gestion Compra Venda
	private ArrayList<Compra> compres = new ArrayList<>();
	private ArrayList<Venda> vendes = new ArrayList<>();
	private ArrayList<LiniaCompra> liniesCompres = new ArrayList<>();
	private ArrayList<LiniaVenda> liniesVendes = new ArrayList<>();
	// gestion Indexacio
	private ArrayList<Indexacio> indexacions = new ArrayList<>();
	//////

	public FloristeriaGestion() {
	}
	////////////////////////// funcionalitats:

	// Crear Floristeria.
	public void crearFloristeria(String nom) {

		// Crear i initialtzar Indexacio
		indexacio = new Indexacio(0, 0, 0, 0, 0, 0);
		indexacions.add(indexacio);
		// Crear Floristeria.
		floristeria = new Floristeria();
		floristeria.setId(indexacio.getIndex(floristeria));
		floristeria.setNom(nom);
		// Guardar Floristeria
		floristeries.add(floristeria);
		entitatsData.crearDirectoriFloristeria(floristeria);
		System.out.println("guardar la floristeria a la base de dades...");
		entitatsData.saveFloristeries(floristeries);
		entitatsData.saveIndexacions(indexacions);
		System.out.println("floristeria guardada.");
	}

	// Afegir Arbre ///////////////////////////////////////
	public void afegirArbre(String nom, double preu, float alcada) {
		// Crear Arbre Producte compra i LiniaCompra
		Arbre arbre = new Arbre();
		Producte producte = new Producte();
		Compra compra = new Compra();
		LiniaCompra liniaCompra = new LiniaCompra();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaCompra();
		Date dateC = new Date(System.currentTimeMillis());

		// afegir Arbre
		arbre.setId(producteId);
		arbre.setAlcada(alcada);
		this.arbres.add(arbre);

		// afegir depemdencies
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
		// Guardar entitats
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveArbres(arbres);
		entitatsData.saveCompres(compres);
		entitatsData.saveLiniesCompres(liniesCompres);
		entitatsData.saveProductes(productes);
	}

	// Afegir Flor ///////////////////////////////////////
	public void afegirFlor(String nom, double preu, String color) {
		// Crear Flor Producte compra i LiniaCompra
		Flor flor = new Flor();
		Producte producte = new Producte();
		Compra compra = new Compra();
		LiniaCompra liniaCompra = new LiniaCompra();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaCompra();
		Date dateC = new Date(System.currentTimeMillis());

		// afegir Flor
		flor.setId(producteId);
		flor.setColor(color);
		this.flors.add(flor);

		// afegir depemdencies
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
		// Guardar entitats
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveFlors(flors);
		entitatsData.saveCompres(compres);
		entitatsData.saveLiniesCompres(liniesCompres);
		entitatsData.saveProductes(productes);
	}

	// Afegir Decoracio ///////////////////////////////////////
	public void afegirDecoracio(String nom, double preu, Material material) {
		// Crear Decoracio Producte compra i LiniaCompra
		Decoracio decoracio = new Decoracio();
		Producte producte = new Producte();
		Compra compra = new Compra();
		LiniaCompra liniaCompra = new LiniaCompra();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaCompra();
		Date dateC = new Date(System.currentTimeMillis());

		// afegir Decoracio
		decoracio.setId(producteId);
		decoracio.setMaterial(material);
		this.decoracions.add(decoracio);

		// afegir depemdencies
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
		// Guardar entitats
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveDecoracions(decoracions);
		entitatsData.saveCompres(compres);
		entitatsData.saveLiniesCompres(liniesCompres);
		entitatsData.saveProductes(productes);
	}

	// Stock

	public void calcularStock() {
		// inicialitzar entitats
		liniesCompres = entitatsData.getLiniesCompres();
		liniesVendes = entitatsData.getLiniesVendes();
		productes = entitatsData.getProductes();
		arbres = entitatsData.getArbres();
		flors = entitatsData.getFlors();
		decoracions = entitatsData.getDecoracions();
		// ini stock
		stock = new Stock();
		// productes en stock = liniesCompres - liniesVendes
		Iterator<LiniaCompra> it = liniesCompres.iterator();
		ArrayList<Integer> productesIds = new ArrayList<>();
		// productes en stock by id
		while (it.hasNext()) {
			LiniaCompra lc = it.next();
			boolean vemdido = false;
			for (LiniaVenda lv : liniesVendes) {
				if (lv.getProducteId() == lc.getProducteId()) {
					vemdido = true;
				}
			}
			if (!vemdido)
				productesIds.add(lc.getProducteId());
		}
		productes.forEach(producte -> {
			if (productesIds.contains(producte.getId())) {
				stock.addProducte(producte);
			}
		});
		
		arbres.forEach(arbre -> {
			if (productesIds.contains(arbre.getId())) {
				stock.addArbre(arbre);
			}
		});
		
		flors.forEach(flor -> {
			if (productesIds.contains(flor.getId())) {
				stock.addFlor(flor);
			}
		});
		
		decoracions.forEach(decoracio -> {
			if (productesIds.contains(decoracio.getId())) {
				stock.addDecoracio(decoracio);
			}
		});

	}

	public Stock getstock() {
		return stock;
	}

	///////////////// fin funcionalitats.

}
