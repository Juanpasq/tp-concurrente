package asd;

public class hilos implements Runnable{
    private boolean consumidor;
    private static int tarta ;
    private static Object lock = new Object();

    public hilos (boolean consumidor){
        this.consumidor= consumidor;

    }

    @Override
    public void run(){

        while(true){
            if (consumidor){
                consumiendo();
            }
            else{
                cocinando();
            }
        }
    }

    private void consumiendo() {
        synchronized (lock){
            if (tarta > 0) {
                tarta--;
                System.out.println("Comi porcion, quedan " + tarta + " porciones");


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                lock.notifyAll();
            }
        }
    }

    private void cocinando() {
        synchronized (lock){
            if (tarta == 0) {
                tarta = 10;
                System.out.println("Soy el cocinero, quedan " + tarta);
                lock.notifyAll();

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public static void main(String[] args) {
        int numHilos = 11;
        Thread [] hilos = new Thread[numHilos];
        for (int i = 0; i < hilos.length ; i++) {
            Runnable runnable = null;

            if (i != 0) {
                runnable = new hilos(true);

            }
            else {
                runnable = new hilos (false);
            }

            hilos [i]= new Thread(runnable);
            hilos [i].start();
        }

        for (int i = 0; i < hilos.length ; i++) {
            try{
                hilos[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

