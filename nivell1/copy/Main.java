package nivell1.copy;

import java.util.List;

import entitats.Floristeria;
import entitats.Producte;

public class Main {

	public static void main(String[] args) {
		
		// gestiona la persistència en un fitxer TXT.
		/**/
		
		// funcionalitats:

		// 1.Crear Floristeria.
		crearFloristeria();

		// Afegir Arbre.
		afegirArbre();

		// Afegir Flor.
		afegirFlor();

		// Afegir Decoració.
		afegirDecoracio();
		
		//Stock: Imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria.
		imprimirStock(Stock.getProductes());
		
		// Retirar arbre.
		retirarArbre();

		// Retirar flor.
		retirarFlor();
		
		// Retirar decoració.
		retirarDecoracio();

		// Printar per pantalla stock amb quantitats.
		imprimirStockQuantitats(Stock.getProductes());
		
		
		
		// Printar per pantalla valor total de la floristeria.
		imprimirValorStock(Stock.getProductes());
		
				
		// Crear tickets de compra amb múltiples objectes.
		ticketsCompra();
		
		// Mostrar una llista de compres antigues.
		mostrarCompres();
		
		// Visualitzar el total de diners guanyats amb totes les vendes.*/
		visualitzarTotalVendes();
		
	}

	private static void visualitzarTotalVendes() {
		// TODO Auto-generated method stub
		
	}

	private static void mostrarCompres() {
		// TODO Auto-generated method stub
		
	}

	private static void ticketsCompra() {
		// TODO Auto-generated method stub
		
	}

	private static void imprimirValorStock(List<Producte> productes) {
		// TODO Auto-generated method stub
		
	}

	private static void imprimirStockQuantitats(List<Producte> productes) {
		// TODO Auto-generated method stub
		
	}

	

	private static void retirarDecoracio() {
		// TODO Auto-generated method stub
		
	}

	private static void retirarFlor() {
		// TODO Auto-generated method stub
		
	}

	private static void retirarArbre() {
		// TODO Auto-generated method stub
		
	}

	private static void imprimirStock(List<Producte> productes) {
		// TODO Auto-generated method stub
		
	}

	public static void afegirDecoracio() {
		// TODO Auto-generated method stub
		
	}

	public static void afegirFlor() {
		// TODO Auto-generated method stub
		
	}

	public static void afegirArbre() {
		//compraId =0
		// liniaId =0
		
	}

	public static void crearFloristeria() {
		System.out.println("Crear Floristeria.");
		Floristeria floristeria = new Floristeria();
		
		System.out.println("nom : ");
		
		System.out.println("Desa la floristeria a la base de dades...");
		Persistencia.saveFloristeria(floristeria);
		
	}

}
