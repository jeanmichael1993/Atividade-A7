package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	private String nome;
	private List<Double> notas;

	public Aluno(String nome) throws Exception {
		if (!nome.isEmpty() && nome.length() <= 100) {
			this.nome = nome;
		} else {
			throw new Exception("Nome não pode ser vazio ou com mais de 100 caracteres!");
		}

		notas = new ArrayList<Double>();
	}

	public String getNome() {
		return nome;
	}

	public void entraNota(double nota) throws Exception {
		if (nota >= 0 && nota <= 30) {
			notas.add(nota);
		} else {
			throw new Exception("Nota deve ser entre 0 e 30!");
		}
	}

	public double retornaNotaTotal() {
		double retorno = 0;
		for (double nota : notas) {
			retorno = retorno + nota;
		}
		if (retorno > 100) {
			return 100;
		} else {
			return retorno;
		}
	}
}
