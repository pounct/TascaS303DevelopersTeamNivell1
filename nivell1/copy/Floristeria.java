package nivell1.copy;

import java.util.ArrayList;
import java.util.List;

import entitats.Arbre;
import entitats.Compra;
import entitats.Decoracio;
import entitats.Flor;
import entitats.Venda;

public class Floristeria {

	private String nom;

	private List<Arbre> arbres =Stock.getArbres();
	private List<Flor> flors = Stock.getFlors();
	private List<Decoracio> decoracio = Stock.getDecoracions();

	private List<Compra> compres = new ArrayList<Compra>();
	private List<Venda> vendes = new ArrayList<Venda>();

	public Floristeria() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Arbre> getArbres() {
		return arbres;
	}

	public void setArbres(List<Arbre> arbres) {
		this.arbres = arbres;
	}

	public List<Flor> getFlors() {
		return flors;
	}

	public void setFlors(List<Flor> flors) {
		this.flors = flors;
	}

	public List<Decoracio> getDecoracio() {
		return decoracio;
	}

	public void setDecoracio(List<Decoracio> decoracio) {
		this.decoracio = decoracio;
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
	
	

}
