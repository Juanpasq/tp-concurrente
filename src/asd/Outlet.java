package asd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Outlet {
    private static final Corona corona = new Corona();
    private static final Guinness guinness = new Guinness();
    private static final Gas gas = new Gas();
    public int gasbarril  = 100;

    public static void main(String[] args) {
        new Gui();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui();
                System.out.println("RUN DE MAIN");

            }
        });

        Thread coronaThread = new Thread(corona);
        Thread guinnessThread = new Thread(guinness);
        Thread gasThread = new Thread(gas);

        coronaThread.start();
        guinnessThread.start();
    }
}
