package nivell1;

import java.util.ArrayList;
import java.util.List;

import entitats.Producte;
import entitats.Arbre;
import entitats.Decoracio;
import entitats.Flor;
import entitats.LiniaCompra;
import entitats.LiniaVenda;

public class Stock {
	FloristeriaGestion floristeriaGestion;

	// tots els productes
	private  List<Producte> productes = new ArrayList<Producte>();
	// arbres, flors, decoracions...
	private  List<Arbre> arbres = new ArrayList<Arbre>();
	private  List<Flor> flors = new ArrayList<Flor>();
	private  List<Decoracio> decoracions = new ArrayList<Decoracio>();
	
	// operacions d'entrada a l'estoc (compres) i de sortida (vendes).
	// private static List<LiniaCompra> liniesCompres = new ArrayList<LiniaCompra>();
	// private List<LiniaVenda> liniesVendes = new ArrayList<LiniaVenda>();
	
	
	
	public Stock() {		
	}

	// productes en stock

	public  List<Producte> getProductes() {
		return productes;
	}

	public  void setProductes(List<Producte> productes) {
		this.productes = productes;
	}

	public  List<Arbre> getArbres() {
		return arbres;
	}

	public  void setArbres(List<Arbre> arbres) {
		this.arbres = arbres;
	}

	public  List<Flor> getFlors() {
		return flors;
	}

	public  void setFlors(List<Flor> flors) {
		this.flors = flors;
	}

	public  List<Decoracio> getDecoracions() {
		return decoracions;
	}

	public  void setDecoracions(List<Decoracio> decoracions) {
		this.decoracions = decoracions;
	}
	
	

}
