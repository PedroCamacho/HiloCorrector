package tarea1;

import java.util.concurrent.Semaphore;

public class Posicion {
    private int posicion;
    private Semaphore s;

	public Posicion(Semaphore s) {
		this.posicion = 0;
		this.s = s;
	}

	public synchronized int getPosicion() {
		int resultado=0;
//		try {
//			s.acquire();
			resultado = posicion;
//			s.release();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return resultado;
	}

	public void setPosicion(int posicion) {
		try {
			s.acquire();
			this.posicion = posicion;
			s.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
    
	
	
    
}
