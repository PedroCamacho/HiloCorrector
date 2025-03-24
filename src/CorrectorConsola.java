import java.util.Scanner;

class Palabra {
	private String palabraNueva;
	private boolean corregida = true;

	public void setPalabra(String palabraNueva) {
		this.palabraNueva = palabraNueva;
		this.corregida = false;
	}

	public String getPalabra() {
		return palabraNueva;
	}

	public boolean isCorregida() {
		return corregida;
	}

	public void corregir() {
		char[] letras = new char[palabraNueva.length()];
		letras = palabraNueva.toCharArray();

		if (!Character.isUpperCase(letras[0])) {
			letras[0] = Character.toUpperCase(letras[0]);
			palabraNueva = String.valueOf(letras);
			System.err.println(palabraNueva);
		}
		corregida = true;
	}

}

class Corrector extends Thread {

	private Palabra miPalabra;

	public Corrector(Palabra miPalabra) {
		this.miPalabra = miPalabra;
	}

	public void setPalabra(Palabra miPalabra) {
		this.miPalabra = miPalabra;
	}

	public void run() {

		boolean ejecucion = true;
		while (ejecucion) {
			try {
				sleep (1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!miPalabra.isCorregida())
				if (!miPalabra.getPalabra().equals("Fin"))
					miPalabra.corregir();
				else
					ejecucion = false;
		}
	}

}

public class CorrectorConsola {
	public static void main(String[] args) throws InterruptedException {
		Palabra miPalabra = new Palabra();
		Corrector corrector = new Corrector(miPalabra);
		
		corrector.setPriority(1);
		Scanner scn = new Scanner(System.in);
		corrector.start();

		boolean ejecucion = true;
		while (ejecucion) {
			String palabraRecibida = scn.nextLine();
			miPalabra.setPalabra(palabraRecibida);
			if (palabraRecibida.equals("Fin"))
				ejecucion = false;
		}
		scn.close();
		corrector.join();
		System.out.println("Fin de todos los hilos");
	}

}
