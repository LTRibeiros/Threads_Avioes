package controller;

import java.util.concurrent.Semaphore;

public class Threads_Controller extends Thread {

	private int idAviao;
	private Semaphore semaforo;
	String pistaAtual = escolhePista();

	public Threads_Controller(int idAviao, Semaphore semaforo) {
		this.idAviao = idAviao;
		this.semaforo = semaforo;
	}

	public void run() {

		estManobrando();
		// ==============inicio da sessão critica===============//
		try {
			semaforo.acquire();
			estTaxiando();
			estAfastando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			// ==============fim da sessão critica===============//
			estDecolando();
		}

	}

	private void estManobrando() {

		int tempo = (int) ((Math.random() * 401) + 300); // 300 a 700 milisegundos

		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("O avião " + idAviao + " esta manobrando na pista " + pistaAtual);
	}

	private void estTaxiando() {
		int tempo = (int) ((Math.random() * 501) + 500); // 500 a 1000 milisegundos

		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("O avião " + idAviao + " esta taxiando na pista " + pistaAtual);
	}

	private void estAfastando() {
		int tempo = (int) ((Math.random() * 501) + 300); // 500 a 800 milisegundos

		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("O avião " + idAviao + " esta afastando na pista " + pistaAtual);

	}

	private void estDecolando() {
		int tempo = (int) ((Math.random() * 201) + 600); // 600 a 800 milisegundos

		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("O avião " + idAviao + " esta decolando na pista " + pistaAtual);

	}

	private String escolhePista() {
		int pista = (int) (Math.random() * 2);

		if (pista == 0) {
			String pistaAtual = "norte";
			return pistaAtual;
		} else {
			String pistaAtual = "sul";
			return pistaAtual;
		}

	}

}
