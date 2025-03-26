package view;

import java.util.concurrent.Semaphore;
import controller.Threads_Controller;
import java.util.Random;

public class Threads_Semaforos {
	public static void main(String[] args) {
		
		
		int permissoes = 2;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idAviao = 1; idAviao < 13 ; idAviao++) {
			Thread tAviao = new Threads_Controller(idAviao, semaforo);
			tAviao.start();
		}
	}
} 
