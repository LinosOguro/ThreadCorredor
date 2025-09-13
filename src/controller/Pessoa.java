/*	Quatro pessoas caminham, cada uma em um corredor diferente. Os 4 corredores terminam
	em uma única porta. Apenas 1 pessoa pode cruzar a porta, por vez. Considere que cada
	corredor tem 200m. e cada pessoa anda de 4 a 6 m/s. Cada pessoa leva de 1 a 2 segundos
	para abrir e cruzar a porta. Faça uma aplicação em java que simule essa situação.
*/

package controller;

import java.util.concurrent.Semaphore;

public class Pessoa extends Thread{

	private int idPessoa;
	private static int posChegada;
	private Semaphore porta;
	
	public Pessoa(int idPessoa, Semaphore porta) {
		this.idPessoa = idPessoa;
		this.porta = porta;
	}
	
	public void run() {
		pessoaAndando();
		try {
			porta.acquire();
			abrePorta();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			porta.release();
		}
		
	}

	private void pessoaAndando() {
		int distTotal = 200;
		int distPercorrida = 0;
		int deslocamento = (int)((Math.random() * 6) + 4);
		int tempo = (int)((Math.random() * 2) + 1);
		
		while (distPercorrida < distTotal) {
			distPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Pessoa #" + idPessoa + " andou " + distPercorrida);
		}
		posChegada++;
		System.out.println("> Pessoa #" + idPessoa + " foi o " + posChegada + "º a chegar!");
	}

	private void abrePorta() {
		System.out.println(">> Pessoa #" + idPessoa + " abriu a porta!");
		int tempo = (int)((Math.random() * 2) + 1);
		try {
			sleep(tempo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(">>> Pessoa #" + idPessoa + " entrou e fechou a porta!");
	}
}
