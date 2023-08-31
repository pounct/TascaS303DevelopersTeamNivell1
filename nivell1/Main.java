package nivell1;

//import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import entitats.Floristeria;
import entitats.Indexacio;
import entitats.Producte;

public class Main {
	/*
	 * Amb gestió de percistància en un fitxer TXT.
	 */
	static Floristeria floristeria;
	static FloristeriaGestion floristeriaGestion;
	static Indexacio indexacio;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		floristeriaGestion = new FloristeriaGestion();

		boolean onProgram = true;

		Byte opcion;

		while (onProgram) {
			menuPrincipal();
			opcion = sc.nextByte();
			sc.nextLine();
			switch (opcion) {
			case 1:
				// 1.Crear Floristeria.
				crearFloristeria();
				break;
			case 2:
				// 2.Afegir Arbre.
				if (indexacio != null) {
					afegirArbre();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 3:
				// 3.Afegir Flor.
				if (indexacio != null) {
					afegirFlor();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}

				break;
			case 4:
				// 4.Afegir Decoració.
				if (indexacio != null) {
					afegirDecoracio(indexacio);
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}

				break;
			case 5:
				// Stock: Imprimeix per pantalla tots els arbres, flors i decoració 
				// que té la floristeria.
				// 5.Stock
				imprimirStock(null);// stock.getProductes()
				break;
			case 6:
				// 6.Retirar arbre.
				retirarArbre();

				break;
			case 7:
				// 7.Retirar flor.
				retirarFlor();

				break;
			case 8:
				// 8.Retirar decoració.
				retirarDecoracio();

				break;
			case 9:
				// Printar per pantalla stock amb quantitats.
				// 9.Stock Amb Quantitats
				imprimirStockQuantitats(null);// Stock.getProductes()

				break;
			case 10:
				// Printar per pantalla valor total de la floristeria.
				// 10.Valor Stock // Valor Compres // ValorVendes
				imprimirValorStock(null);// Stock.getProductes()

				break;
			case 11:
				// Crear tickets de compra amb múltiples objectes.
				// 11.Compra amb múltiples objectes
				ticketsCompra();

				break;
			case 12:
				// Mostrar una llista de compres antigues.
				// 12.Compres Antigues.
				mostrarCompres();

				break;
			case 13:
				// Visualitzar el total de diners guanyats amb totes les vendes.*/
				// 13.diners guanyats
				// Vendes
				visualitzarTotalGuanyats();

				break;
			case 14:
				// 14.Obrir Floristeria.
//				System.out.println(" Introduïu el codi de la floristeria :");
//				int idFloristeria = sc.nextInt();
//				sc.nextLine();
//				Floristeria f = new Floristeria();
//				f.setId(idFloristeria);	
//				if (floristeriaGestion.getFloristeries().contains(f)) {
//					floristeria = f;
//					obrirFloristeria(floristeria);
//				}
				break;
			case 0:
				onProgram = false;
				System.out.println("      Fin de programe.");
				break;

			default:
				break;
			}
		}
	}

	public static void menuPrincipal() {
		System.out.println(" Floristeria:" + ((floristeria != null) ? floristeria.getNom() : ""));
		System.out.println("\n\n");
		System.out.println(" 1.Crear Floristeria."); // obrir floristeria
		System.out.println(" 14.Obrir Floristeria.");
		System.out.println(" 2.Afegir Arbre.");
		System.out.println(" 3.Afegir Flor.");
		System.out.println(" 4.Afegir Decoració.");
		System.out.println(" 5.Stock");
		System.out.println(" 6.Retirar arbre.");
		System.out.println(" 7.Retirar flor.");
		System.out.println(" 8.Retirar decoració.");
		System.out.println(" 9.Stock Amb Quantitats");
		System.out.println(" 10.Valor Stock // Valor Compres // ValorVendes");
		System.out.println(" 11.Compra amb múltiples objectes");
		System.out.println(" 12.Compres Antigues.");
		System.out.println(" 13.diners guanyats");
		System.out.println(" 0.fin");
	}

	public static void crearFloristeria() {

		System.out.println("Crear Floristeria.\n");
		System.out.println("nom : ");
		String nom = sc.nextLine();
		floristeriaGestion.crearFloristeria(nom);
	}

	private static void afegirArbre() {

		System.out.println("designacio : ");
		String nom = sc.nextLine();
		System.out.println("preu de compra : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("alcada del arbre : ");
		float alcada = sc.nextFloat();
		sc.nextLine();
		floristeriaGestion.afegirArbre(nom, preu, alcada);
	}
	
	public static void afegirFlor() {
		// TODO Auto-generated method stub

	}

	public static void obrirFloristeria(Floristeria floristeria) {
		// floristeriaGestion.setFloristeria(floristeria);
	}

	public static void visualitzarTotalGuanyats() {
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

	public static void afegirDecoracio(Indexacio indexacio2) {
		// TODO Auto-generated method stub

	}

	

}
