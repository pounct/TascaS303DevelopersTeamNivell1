package nivell1;

import java.util.Scanner;

import entitats.Compra;
import entitats.Decoracio.Material;
import entitats.Floristeria;
import entitats.Indexacio;

public class Main {
	/*
	 * Amb gestió de percistància en un fitxer TXT.
	 */
	static Floristeria floristeria;
	static Indexacio indexacio;

	static FloristeriaGestion floristeriaGestion;

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
				if (indexacio != null) {
					retirarArbre();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}

				break;
			case 7:
				// 7.Retirar flor.
				if (indexacio != null) {
					retirarFlor();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}

				break;
			case 8:
				// 8.Retirar decoració.
				if (indexacio != null) {
					retirarDecoracio();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}

				break;
			case 9:
				// Printar per pantalla stock amb quantitats.
				// 9.Stock Amb Quantitats
				if (indexacio != null) {
					imprimirStockQuantitats();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}

				break;
			case 10:
				// Printar per pantalla valor total de la floristeria.
				// 10.Valor Stock // Valor Compres // ValorVendes
				if (indexacio != null) {
					imprimirValorStock();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}

				break;
			case 11:
				// Crear tickets de compra amb múltiples objectes.
				// 11.Compra amb múltiples objectes
				crearCompra();

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
				obrirFloristeria();
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
		System.out.println(" Floristeria actiu : " + ((floristeria != null) ? floristeria.getNom() : ""));
		System.out.println("-----------------\n");
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
		// Crear i recuperar Floristeria
		floristeria = floristeriaGestion.crearFloristeria(nom);
		indexacio = floristeriaGestion.getIndexacio();
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
		System.out.println("color del flor : ");
		String color = sc.nextLine();
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
		System.out.println(" Productes:\n");
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
		System.out.println(" Stock Floristeria Quantitats:");
		System.out.println(" Productes:\n");
		System.out.println("---- Arbres ----------");
		System.out.println(stock.getArbres().size());
		System.out.println("---- Flors -----------");
		System.out.println(stock.getFlors().size());
		System.out.println("---- Decoracions -----");
		System.out.println(stock.getDecoracions().size());
	}

	public static void imprimirValorStock() {
		// Stock stock = floristeriaGestion.getstock();
		System.out.println(" Stock Floristeria Valor :");
		System.out.println(" Productes:\n");
		System.out.println("---- Valor Arbres ----------");
		System.out.println(floristeriaGestion.getValorStockArbres());
		System.out.println("---- Valor Flors -----------");
		System.out.println(floristeriaGestion.getValorStockFlors());
		System.out.println("---- Valor Decoracions -----");
		System.out.println(floristeriaGestion.getValorStockDecoracions());
	}

	private static void crearCompra() {

		Compra compra = floristeriaGestion.crearCompra();
		boolean finCompra = false;
		Byte opcion;
		while (!finCompra) {
			menuCompra();
			opcion = sc.nextByte();
			sc.nextLine();
			switch (opcion) {
			case 1:
				afegirArbre(compra);
				break;
			case 2:
				afegirFlor(compra);
				break;
			case 3:
				afegirDecoracio(compra);
				break;
			case 0:
				finCompra = true;
				System.out.println("--------- Fin de compra ---------");
				break;
			default:
				break;
			}
		}

	}

	private static void menuCompra() {
		System.out.println(" Menu Compra :\n");
		System.out.println(" 1.Afegir Arbre.");
		System.out.println(" 2.Afegir Flor.");
		System.out.println(" 3.Afegir Decoració.");
		System.out.println(" 0.fin Compra");
	}

	private static void mostrarCompres() {
		System.out.println(" Compres :\n");
		System.out.println(floristeriaGestion.mostrarCompres());
	}

	public static void visualitzarTotalGuanyats() {
		System.out.println(" Total Guanyats \n");
		System.out.println(" --------------:\n");
		System.out.println(" Total de despeses :");
		double totalDespeses = sc.nextDouble();
		sc.nextLine();
		System.out.println(" Total Compres :");
		double totalCompres = floristeriaGestion.getTotalCompres();
		System.out.println(totalCompres);
		System.out.println(" Total Vendes :");
		double totalVendes = floristeriaGestion.getTotalVendes();
		System.out.println(totalVendes);
		System.out.println(" Total Guanyats :");
		System.out.println(""+(totalVendes-totalCompres-totalDespeses));
	}

	private static void afegirArbre(Compra compra) {

		System.out.println("designacio : ");
		String nom = sc.nextLine();
		System.out.println("preu de compra : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("alcada del arbre : ");
		float alcada = sc.nextFloat();
		sc.nextLine();
		floristeriaGestion.afegirArbre(nom, preu, alcada, compra);

	}

	private static void afegirFlor(Compra compra) {
		System.out.println("designacio : ");
		String nom = sc.nextLine();
		System.out.println("preu de compra : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("color del flor : ");
		String color = sc.nextLine();
		sc.nextLine();
		floristeriaGestion.afegirFlor(nom, preu, color, compra);

	}

	private static void afegirDecoracio(Compra compra) {
		System.out.println("designacio : ");
		String nom = sc.nextLine();
		System.out.println("preu de compra : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("material del arbre : \n" + "1.Plastic" + "2.Fusta\n");
		byte tipoMaterial = sc.nextByte();
		Material material = (tipoMaterial == 1) ? Material.FUSTA : Material.PLASTIC;
		sc.nextLine();
		floristeriaGestion.afegirDecoracio(nom, preu, material, compra);

	}

	//////////////////////////////////////////////////////

	public static void obrirFloristeria() {
		System.out.println("id Floristeria : ");
		int floristeriaId = sc.nextInt();
		sc.nextLine();
		floristeria = floristeriaGestion.getFloristeria(floristeriaId);
		System.out.println(floristeria);
		if (floristeria!=null) {
			floristeria = floristeriaGestion.obrirFloristeria(floristeria);
			indexacio = floristeriaGestion.getIndexacio();
		}
		else {
			System.out.println(" no hi ha cap florista amb aquest identificador!!!");
		}
		
	}
}
