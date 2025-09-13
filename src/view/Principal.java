package view;

import java.util.Iterator;
import java.util.concurrent.Semaphore;

import controller.Pessoa;

public class Principal {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore porta = new Semaphore(permissao);
		for (int idPessoa = 1; idPessoa < 5; idPessoa++) {
			Thread tPessoa = new Pessoa(idPessoa, porta);
			tPessoa.start();
		}

	}

}
