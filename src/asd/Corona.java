package asd;

import java.util.Random;

public class Corona implements Runnable {

    int barrilCerveza = 80;
    int barrilGas=100;

    Gas gas = new Gas ();

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println( gas.getCapacidadGas()+"capacidad");
            gas.setCapacidadGas(barrilGas--);
            gas.setCapacidadGas(barrilCerveza--);
            System.out.println(barrilGas + "gassss");
            System.out.println(barrilCerveza + "cerve");

            try {
                Thread.sleep(numeroRandom(1000, 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    System.out.println(gas.getCapacidadGas()+"capacidadGas");


    }

    private static int numeroRandom(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }



}