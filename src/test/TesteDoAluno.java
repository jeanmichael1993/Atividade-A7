package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Aluno;

public class TesteDoAluno {

	private Aluno seuNome;

	@BeforeEach
	private void instanciarObjetos() throws Exception {
		seuNome = new Aluno("seuNome");
	}
	//----------------------------------------------//
	@Test
	public void deveRetornarNota100() throws Exception {
		seuNome.entraNota(25);
		seuNome.entraNota(25);
		seuNome.entraNota(25);
		seuNome.entraNota(25);
		seuNome.entraNota(25);
		assertEquals(100, seuNome.retornaNotaTotal(), 0.0001);
	}
	//----------------------------------------------//
	@Test
	public void deveRetornarExceptionNotaMaiorQue30() {
		assertThrows(Exception.class, () -> {
			seuNome.entraNota(35);			
		});
		assertThrows(Exception.class, () -> {
			seuNome.entraNota(40);			
		});
	}
	//----------------------------------------------//
	@Test
	public void deveRetornarNota0() {
		assertEquals(0, seuNome.retornaNotaTotal(), 0.0001);
	}

	//----------------------------------------------//
	@Test
	public void deveRetornarExceptionNotaMenorQue0() {
		assertThrows(Exception.class, () -> {
			seuNome.entraNota(-5);
		});
		assertThrows(Exception.class, () -> {
			seuNome.entraNota(-1);			
		});
	}
	//----------------------------------------------//

	@Test
	public void deveRetornarExceptionNomeGrande() {
		String nome = new String();
		for (int i = 0; i < 10; i++) {
			nome.concat("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		}
		assertThrows(Exception.class, () -> {
			seuNome = new Aluno(nome);
		});
	}

	//----------------------------------------------//
	@Test
	public void deveRetornarExceptionNomeVazio() {
		assertThrows(Exception.class, () -> {
			seuNome = new Aluno("");
		});
	}


}
