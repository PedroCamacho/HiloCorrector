package tarea1;

import java.util.concurrent.Semaphore;

public class MainThread {

    public static void main(String[] args) throws Exception {
        final int META = 10000;

        Semaphore mutex = new Semaphore (1);
        Posicion p = new Posicion (mutex);
        
        Thread walle = new Robot(META, "Wall-e", p);
        Thread r2d2 = new Robot(META, "R2-D2", p);
        Thread t1000 = new Robot(META, "T-1000", p);
        Thread chappie = new Robot(META, "Chappie", p);

        walle.start();
        r2d2.start();
        t1000.start();
        chappie.start();
        
        walle.join();
        r2d2.join();
        t1000.join();
        chappie.join();
        
        System.out.println("Fin de la carrera");
        
    }
}