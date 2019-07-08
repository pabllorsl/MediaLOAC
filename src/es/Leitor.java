package es;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tipo.Aula;

public class Leitor {

	private static String PATHNAME;
	private final int PESO_EXTRA = 4;

	private List<Aula> aulas;
	private double pesos;
	private double notasPonderadas;

	public Leitor() {
		PATHNAME = "src/arquivo/aval.txt";
		this.aulas = new ArrayList<Aula>();
		this.pesos = 0;
		this.notasPonderadas = 0;
	}

	public double getPesos() {
		return pesos;
	}

	public double getNotasPonderadas() {
		return notasPonderadas;
	}

	public void leDados() throws IOException {
		FileReader fr = new FileReader(PATHNAME);
		BufferedReader br = new BufferedReader(fr);
		String linha = br.readLine();
		String[] array = null;

		while (linha != null) {

			array = linha.split("\t");

			if (array.length == 4) {
				this.aulas.add(new Aula(array[0], array[1], "", Integer.parseInt(array[2]), -1, array[3]));
			} else if (array[0].equalsIgnoreCase("a") || array[0].equalsIgnoreCase("f")
					|| array[0].equalsIgnoreCase("p")) {
				for (int i = 0; i < aulas.size(); i++) {
					aulas.get(i).setPresenca(array[i]);
				}
			} else if (array[0].equalsIgnoreCase("extra")) {
				int numFaltas = 0;
				for (Aula aula : aulas) {
					if (aula.getPresenca().equalsIgnoreCase("f")) {
						numFaltas += 1;
					}
				}

				this.aulas.add(new Aula("faltas", "", String.valueOf(numFaltas)));
				this.aulas.add(new Aula(array[0], "", "", PESO_EXTRA, Integer.parseInt(array[1]), ""));
			}

			linha = br.readLine();
		}

		int i = aulas.size() - 2;
		int j = array.length - 1;

		while (i != -1) {
			if (Integer.toString(j + 1).length() == 2) {
				if (aulas.get(i).getNumero().equals(Integer.toString(j + 1))) {
					aulas.get(i).setNotaParcial(Integer.parseInt(array[j]));
					i -= 1;
					j -= 1;
				} else {
					aulas.get(i).setNotaParcial(0);
					i -= 1;
				}
			} else {
				if (aulas.get(i).getNumero().equals("0" + Integer.toString(j + 1))) {
					aulas.get(i).setNotaParcial(Integer.parseInt(array[j]));
					i -= 1;
					j -= 1;
				} else {
					aulas.get(i).setNotaParcial(0);
					i -= 1;
				}
			}
		}

		for (Aula aula : aulas) {
			aula.setNotaPonderada();
		}

		this.calculaPesosNotasPond();

		br.close();
		fr.close();
	}

	public void escreveDados() throws IOException {

	}

	private void calculaPesosNotasPond() {
		for (Aula aula : aulas) {
			pesos += aula.getPeso();
			notasPonderadas += aula.getNotaPonderada();
		}
	}

	public String listaAulas() {
		String saida = "";

		for (Aula aula : aulas) {
			saida += aula + "\n";
		}

		return saida;
	}

}
