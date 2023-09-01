package nivell1;

//import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import entitats.Decoracio.Material;
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
					afegirDecoracio();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}

				break;
			case 5:
				// Stock: Imprimeix per pantalla tots els arbres, flors i decoració
				// que té la floristeria.
				// 5.Stock
				if (indexacio != null) {
					imprimirStock();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}

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
				imprimirStockQuantitats();

				break;
			case 10:
				// Printar per pantalla valor total de la floristeria.
				// 10.Valor Stock // Valor Compres // ValorVendes
				imprimirValorStock();

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

		System.out.println("designacio : ");
		String nom = sc.nextLine();
		System.out.println("preu de compra : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("color del arbre : ");
		String color = sc.nextLine();
		sc.nextLine();
		floristeriaGestion.afegirFlor(nom, preu, color);
	}

	public static void afegirDecoracio() {

		System.out.println("designacio : ");
		String nom = sc.nextLine();
		System.out.println("preu de compra : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("material del arbre : \n" + "1.Plastic" + "2.Fusta\n");
		byte tipoMaterial = sc.nextByte();
		Material material = (tipoMaterial == 1) ? Material.FUSTA : Material.PLASTIC;
		sc.nextLine();
		floristeriaGestion.afegirDecoracio(nom, preu, material);
	}

	public static void imprimirStock() {

		Stock stock = floristeriaGestion.getstock();
		System.out.println(" Stock Floristeria :");
		System.out.println("Productes:\n");
		System.out.println("---- Arbres ----------");
		System.out.println(stock.getArbres());
		System.out.println("---- Flors -----------");
		System.out.println(stock.getFlors());
		System.out.println("---- Decoracions -----");
		System.out.println(stock.getDecoracions());
	}

	public static void retirarArbre() {

		System.out.println("id del arbre a retirar :");
		int producteId = sc.nextInt();
		floristeriaGestion.retirarArbre(producteId);

	}

	public static void retirarFlor() {

		System.out.println("id del flor a retirar :");
		int producteId = sc.nextInt();
		floristeriaGestion.retirarFlor(producteId);

	}

	public static void retirarDecoracio() {

		System.out.println("id del decoracio a retirar :");
		int producteId = sc.nextInt();
		floristeriaGestion.retirarDecoracio(producteId);

	}
	public static void imprimirStockQuantitats() {
		Stock stock = floristeriaGestion.getstock();
		System.out.println(" Stock Floristeria :");
		System.out.println("Productes:\n");
		System.out.println("---- Arbres ----------");
		System.out.println(stock.getArbres().size());
		System.out.println("---- Flors -----------");
		System.out.println(stock.getFlors().size());
		System.out.println("---- Decoracions -----");
		System.out.println(stock.getDecoracions().size());
	}
	public static void imprimirValorStock() {
		// TODO Auto-generated method stub

	}
	//////////////////////////////////////////////////////

	public static void obrirFloristeria(Floristeria floristeria) {

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

	



}
