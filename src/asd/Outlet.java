package asd;

public class Outlet {
    private static final Corona corona = new Corona();
    private static final Guinness guinness = new Guinness();
    private static final Gas gas = new Gas();
    public int gasbarril  = 100;

    public static void main(String[] args) {
        Thread coronaThread = new Thread(corona);
        Thread guinnessThread = new Thread(guinness);
        Thread gasThread = new Thread(gas);

        coronaThread.start();
        guinnessThread.start();
    }
}
