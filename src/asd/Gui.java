package asd;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    public class Gui extends JFrame implements ActionListener {
        private JProgressBar capacidadGas, barrilCorona, barrilGuinness, barrilStella;
        private JToggleButton coronaButton, guinnessButton, stellaButton;
        private JButton resetButton, recargaGas, recargaCorona, recargaGuinness, recargaStella;
        private Timer timerGasCorona, timerCorona, timerGasGuinness, timerGuinness, timerGasStella, timerStella;
        private int counter = 100, counter2 = 100, counter3 = 100, counter4 = 100;

        public Gui() {

            setLayout(new FlowLayout());
            //barriles > barras de progreso
            capacidadGas = new JProgressBar(capacidadGas.VERTICAL, 0, 100);
            Dimension preferredSize = new Dimension(250, 80);
            capacidadGas.setPreferredSize(preferredSize);
            capacidadGas.setValue(400);
            capacidadGas.setBackground(Color.white);
            capacidadGas.setForeground(Color.pink);
            capacidadGas.setStringPainted(true);
            add(capacidadGas);

            barrilCorona = new JProgressBar(barrilCorona.VERTICAL, 0, 100);
            Dimension preferredSize1 = new Dimension(80, 200);
            barrilCorona.setPreferredSize(preferredSize1);
            barrilCorona.setValue(100);
            barrilCorona.setForeground(Color.yellow);
            barrilCorona.setStringPainted(true);
            add(barrilCorona);

            barrilGuinness = new JProgressBar(barrilGuinness.VERTICAL, 0, 100);
            Dimension preferredSize2 = new Dimension(80, 200);
            barrilGuinness.setPreferredSize(preferredSize2);
            barrilGuinness.setValue(100);
            barrilGuinness.setForeground(Color.darkGray);
            barrilGuinness.setStringPainted(true);
            add(barrilGuinness);

            barrilStella = new JProgressBar(barrilStella.VERTICAL, 0, 100);
            Dimension preferredSize3 = new Dimension(80, 200);
            barrilStella.setPreferredSize(preferredSize3);
            barrilStella.setValue(100);
            barrilStella.setForeground(Color.orange);
            barrilStella.setStringPainted(true);
            add(barrilStella);

            //botones
            coronaButton = new JToggleButton("C");
            coronaButton.addActionListener(this);
            coronaButton.setPreferredSize(new Dimension(80, 80));
            add(coronaButton, BorderLayout.SOUTH);

            guinnessButton = new JToggleButton("G");
            guinnessButton.addActionListener(this);
            guinnessButton.setPreferredSize(new Dimension(80, 80));
            add(guinnessButton, BorderLayout.SOUTH);

            stellaButton = new JToggleButton("S");
            stellaButton.addActionListener(this);
            stellaButton.setPreferredSize(new Dimension(80, 80));
            add(stellaButton, BorderLayout.SOUTH);

            //resetButton = new JButton("Reset");
            //resetButton.addActionListener(this);
            //add(resetButton,BorderLayout.SOUTH);

            recargaCorona = new JButton("Recargar Corona");
            recargaCorona.addActionListener(this);
            recargaCorona.setPreferredSize(new Dimension(80, 40));
            add(recargaCorona, BorderLayout.SOUTH);

            recargaGuinness = new JButton("Recarga Guinness");
            recargaGuinness.addActionListener(this);
            recargaGuinness.setPreferredSize(new Dimension(80, 40));
            add(recargaGuinness, BorderLayout.SOUTH);

            ImageIcon icon = new ImageIcon("/recursos/guinnes.png");


            recargaStella = new JButton("Recarga Stella", icon);
            recargaStella.addActionListener(this);
            recargaStella.setPreferredSize(new Dimension(80, 40));

            add(recargaStella, BorderLayout.SOUTH);

            recargaGas = new JButton("Recargar gas");
            recargaGas.addActionListener(this);
            recargaGas.setPreferredSize(new Dimension(250, 40));
            add(recargaGas, BorderLayout.SOUTH);

            setTitle("Dispenser de Cervezas");
            setSize(270, 505);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
