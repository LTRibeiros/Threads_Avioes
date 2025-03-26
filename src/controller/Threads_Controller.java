package controller;

import java.util.concurrent.Semaphore;

public class Threads_Controller extends Thread {
	
	private int idAviao;
	private Semaphore semaforo;
	
	
	
	
	public Threads_Controller(int idAviao, Semaphore semaforo) {
		this.idAviao = idAviao;
		this.semaforo = semaforo;
	}
	
	public void run() {
		estManobrando();
		//==============inicio da sessão critica===============//
		try {
			semaforo.acquire();
			estTaxiando();
			estAfastando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		//==============fim da sessão critica===============//
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
		 System.out.println("O avião "+ idAviao +" esta manobrando");
	}
	
	private void estTaxiando() {
		int tempo = (int) ((Math.random() * 501) + 500); // 500 a 1000 milisegundos
		 try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("O avião "+ idAviao +" esta taxiando");
	}
		

	
	private void estAfastando() {
		int tempo = (int) ((Math.random() * 501) + 300); // 500 a 800 milisegundos
		 try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("O avião "+ idAviao +" esta afastando");
		
	}

	

	private void estDecolando() {
		int tempo = (int) ((Math.random() *201) + 600); // 600 a 800 milisegundos
		 try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("O avião "+ idAviao +" esta decolando");
		
	}

}
