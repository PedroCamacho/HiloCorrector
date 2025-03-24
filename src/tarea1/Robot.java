package tarea1;

import java.util.Random;
 
public class Robot extends Thread {

    int META;
    String nombre;
    Random random;
    static int posicion = 0;


    public Robot(int META, String nombre) {
        this.META = META;
        this.nombre = nombre;
        this.random = new Random();
    }


    public void correr(){
            for(int i = 0; i < META; i++){
                i += random.nextInt(1,100);
            }
            Robot.posicion++;
            System.out.println(this.nombre + " ha quedado " + Robot.posicion +"º");
    }


    @Override
    public void run() {
        System.out.println(nombre + " empieza a correr.");
        this.correr();
    }

}