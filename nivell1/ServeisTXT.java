package nivell1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entitats.Producte;
import entitats.Arbre;
import entitats.Flor;
import entitats.LiniaCompra;
import entitats.LiniaVenda;
import entitats.Decoracio;
import entitats.Compra;
import entitats.Venda;

public class ServeisTXT {

	public void writeProducte(Producte p) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("\\src\\database\\ProducteData.txt", true));
			writer.write(p.getId() + " " + p.getDesignacio() + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateProductes(List<Producte> lp) {
		lp.forEach(p -> writeProducte(p));
	}

	public void writeArbre(Arbre a) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("\\src\\database\\ArbreData.txt", true));
			writer.write(a.getId() + " " + a.getAlcada() + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateArbres(List<Arbre> lp) {
		lp.forEach(p -> writeArbre(p));
	}

	public void writeFlor(Flor f) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("\\src\\database\\FlorData.txt", true));
			writer.write(f.getId() + " " + f.getColor() + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateFlors(List<Flor> lp) {
		lp.forEach(p -> writeFlor(p));
	}

	public void writeDecoracio(Decoracio d) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("\\src\\database\\DecoracioData.txt", true));
			writer.write(d.getId() + " " + d.getMaterial() + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateDecoracions(List<Decoracio> lp) {
		lp.forEach(p -> writeDecoracio(p));
	}

	public void writeCompra(Compra c) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("\\src\\database\\CompraData.txt", true));
			writer.write(c.getId() + " " + c.getDate() + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateCompra(List<Compra> lp) {
		lp.forEach(p -> writeCompra(p));
	}

	public void writeVenda(Venda v) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("\\src\\database\\VendaData.txt", true));
			writer.write(v.getId() + " " + v.getDate() + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateVenda(List<Venda> lp) {
		lp.forEach(p -> writeVenda(p));
	}

	public void writeLiniaCompra(LiniaCompra lc) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("\\src\\database\\LiniaCompraData.txt", true));
			writer.write(lc.getId() + " " + lc.getCompraId() + " " + lc.getProducteId() + lc.getPreu() + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateLiniesCompres(List<LiniaCompra> llc) {
		llc.forEach(lc -> writeLiniaCompra(lc));
	}

	public void writeLiniaVenda(LiniaVenda lv) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("\\src\\database\\LiniaVendaData.txt", true));
			writer.write(lv.getId() + " " + lv.getVendaId() + " " + lv.getProducteId() + lv.getPreu() + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateLiniaVenda(List<LiniaVenda> llv) {
		llv.forEach(p -> writeLiniaVenda(p));
	}

}
