package main;

import java.io.IOException;

import es.Leitor;

public class Main {

	public static void main(String[] args) {
		Leitor leitor = new Leitor();

		try {
			leitor.leDados();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); // e.printStackTrace();
		}

		String aulas = leitor.listaAulas();

		String cabecalho = "Aula" + "\t" + "Data" + "\t" + "Pres" + "\t" + "Peso" + "\t" + "N parc" + "\t" + "N pond"
				+ "\t" + "Descricao";

		System.out.println(cabecalho);
		System.out.println(aulas);
		System.out.println("Pesos: " + String.format("%.0f", leitor.getPesos()));
		System.out.println("Notas ponderadas: " + String.format("%.0f", leitor.getNotasPonderadas()));
		System.out.println("Nota final: " + String.format("%.2f", leitor.getNotasPonderadas() / leitor.getPesos()));

	}
}
