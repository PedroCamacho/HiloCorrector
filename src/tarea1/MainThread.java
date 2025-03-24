package tarea1;
public class MainThread {

    public static void main(String[] args) throws Exception {
        final int META = 10000;

        Thread walle = new Robot(META, "Wall-e");
        Thread r2d2 = new Robot(META, "R2-D2");
        Thread t1000 = new Robot(META, "T-1000");
        Thread chappie = new Robot(META, "Chappie");

        walle.start();
        r2d2.start();
        t1000.start();
        chappie.start();
        
        walle.join();
        r2d2.join();
        t1000.join();
        chappie.join();
        
    }
}