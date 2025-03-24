package tarea1;

import java.util.Random;
 
public class Robot extends Thread {

    private Posicion miPosicion;
	
	int META;
    String nombre;
    Random random;

    public Robot(int META, String nombre, Posicion miPosicion) {
        this.META = META;
        this.nombre = nombre;
        this.random = new Random();
        this.miPosicion = miPosicion;
    }


    public void correr(){
            for(int i = 0; i < META; i++){
                i += random.nextInt(1,100);
            }
      
            miPosicion.setPosicion(miPosicion.getPosicion()+1);
            System.out.println(this.nombre + " ha quedado " + miPosicion.getPosicion() +"º");
    }


    @Override
    public void run() {
        System.out.println(nombre + " empieza a correr.");
        this.correr();
    }

}