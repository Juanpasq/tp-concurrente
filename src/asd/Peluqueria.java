package asd;
import java.util.concurrent.Semaphore;

public class Peluqueria {
  private static final int NUM_LUGARES_ESPERA = 4;
  private static final int NUM_CLIENTES_A_LA_VEZ = 2;

  private static Semaphore semaphoreLugaresEspera = new Semaphore(NUM_LUGARES_ESPERA);
  private static Semaphore semaphoreClientes = new Semaphore(NUM_CLIENTES_A_LA_VEZ);

  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      Cliente cliente = new Cliente(i);
      cliente.start();
    }
  }

  static class Cliente extends Thread {
    private int id;

    public Cliente(int id) {
      this.id = id;
    }

    @Override
    public void run() {
      try {

        System.out.println("Cliente " + id + " tomó un lugar de espera.");
        semaphoreClientes.acquire();
        System.out.println("Cliente " + id + " está siendo atendido.");
        Thread.sleep(1000);
        semaphoreClientes.release();
        semaphoreLugaresEspera.release();
        System.out.println("Cliente " + id + " ha sido atendido y se ha ido.");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
