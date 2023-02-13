import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class DispenserCervezas extends JFrame implements ActionListener {
  private JProgressBar capacidadGas, barrilCorona,barrilGuinness, barrilStella;
  private JToggleButton coronaButton, guinnessButton, stellaButton;
  private JButton resetButton, recargaGas, recargaCorona, recargaGuinness, recargaStella;
  private Timer timerGasCorona, timerCorona, timerGasGuinness, timerGuinness, timerGasStella, timerStella;
  private int counter = 100, counter2 = 100, counter3 = 100, counter4 = 100;

  public DispenserCervezas() {

    setLayout(new FlowLayout());
    //barriles > barras de progreso
    capacidadGas = new JProgressBar(capacidadGas.VERTICAL,0, 100);
    Dimension preferredSize = new Dimension(250, 80);
    capacidadGas.setPreferredSize(preferredSize);
    capacidadGas.setValue(400);
    capacidadGas.setBackground(Color.white);
    capacidadGas.setForeground(Color.pink);
    capacidadGas.setStringPainted(true);
    add(capacidadGas);
    
    //jProgressBar.setBackground(Color.elquequieras);
    //jProgressBar.setForeground(Color.elquequieras);
    
    barrilCorona = new JProgressBar(barrilCorona.VERTICAL,0, 100);
    Dimension preferredSize1 = new Dimension(80, 200);
    barrilCorona.setPreferredSize(preferredSize1);
    barrilCorona.setValue(100);
    barrilCorona.setForeground(Color.yellow);
    barrilCorona.setStringPainted(true);
    add(barrilCorona);
    
    barrilGuinness = new JProgressBar(barrilGuinness.VERTICAL,0, 100);
    Dimension preferredSize2 = new Dimension(80, 200);
    barrilGuinness.setPreferredSize(preferredSize2);
    barrilGuinness.setValue(100);
    barrilGuinness.setForeground(Color.darkGray);
    barrilGuinness.setStringPainted(true);
    add(barrilGuinness);
    
    barrilStella = new JProgressBar(barrilStella.VERTICAL,0, 100);
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
    add(coronaButton,BorderLayout.SOUTH);

    guinnessButton = new JToggleButton("G");
    guinnessButton.addActionListener(this);
    guinnessButton.setPreferredSize(new Dimension(80, 80));
    add(guinnessButton,BorderLayout.SOUTH);
    
    stellaButton = new JToggleButton("S");
    stellaButton.addActionListener(this);
    stellaButton.setPreferredSize(new Dimension(80, 80));
    add(stellaButton,BorderLayout.SOUTH);

    //resetButton = new JButton("Reset");
    //resetButton.addActionListener(this);
    //add(resetButton,BorderLayout.SOUTH);

    recargaCorona = new JButton("Recargar Corona");
    recargaCorona.addActionListener(this);
    recargaCorona.setPreferredSize(new Dimension(80, 40));
    add(recargaCorona,BorderLayout.SOUTH);

    recargaGuinness = new JButton("Recarga Guinness");
    recargaGuinness.addActionListener(this);
    recargaGuinness.setPreferredSize(new Dimension(80, 40));
    add(recargaGuinness,BorderLayout.SOUTH);

    ImageIcon icon = new ImageIcon("/recursos/guinnes.png");


    recargaStella = new JButton("Recarga Stella", icon);
    recargaStella.addActionListener(this);
    recargaStella.setPreferredSize(new Dimension(80, 40));

    add(recargaStella,BorderLayout.SOUTH);

    recargaGas = new JButton("Recargar gas");
    recargaGas.addActionListener(this);
    recargaGas.setPreferredSize(new Dimension(250, 40));
    add(recargaGas,BorderLayout.SOUTH);

    //bloques de acciones de cada cerveza sobre los barriles (dos por cada uno, gas y cerveza)
    timerGasCorona = new Timer(50, new ActionListener() {
      @Override
      //si no hay mas gas, para los 2 barriles
      public void actionPerformed(ActionEvent e) {
        if (counter == 1) {
        	timerGasCorona.stop();
            timerCorona.stop();
          JOptionPane.showMessageDialog(null, "Se termino el GAS VIEJA");

        } else {
          capacidadGas.setValue(--counter);
        }
      }
    });
    
    timerGasGuinness = new Timer(100, new ActionListener() {
        @Override
        //si no hay mas gas, para los 2 barriles
        public void actionPerformed(ActionEvent e) {
          if (counter == 1) {
            timerGasGuinness.stop();
            timerGuinness.stop();
            JOptionPane.showMessageDialog(null, "Se termino el GAS VIEJA");

          } else {
            capacidadGas.setValue(--counter);
          }
        }
      });
    
    timerGasStella = new Timer(100, new ActionListener() {
        @Override
        //si no hay mas gas, para los 2 barriles
        public void actionPerformed(ActionEvent e) {
          if (counter == 1) {
            timerGasStella.stop();
            timerStella.stop();
            JOptionPane.showMessageDialog(null, "Se termino el GAS VIEJA");

          } else {
            capacidadGas.setValue(--counter);
          }
        }
      });
    
    timerCorona = new Timer(100, new ActionListener() {
        @Override
        //si no hay mas cerveza corta
        public void actionPerformed(ActionEvent e) {
          if (counter2 == 4) {
            timerCorona.stop();
            timerGasCorona.stop();
            JOptionPane.showMessageDialog(null, "Se termino la CORONA");

          } else {
            barrilCorona.setValue(--counter2);
          }
        }
      });
    
    timerGuinness = new Timer(100, new ActionListener() {
        @Override
        //si no hay mas cerveza corta
        public void actionPerformed(ActionEvent e) {
          if (counter3 == 1) {
            timerGuinness.stop();
            timerGasGuinness.stop();
            JOptionPane.showMessageDialog(null, "Se termino la GUINNESS");

          } else {
            barrilGuinness.setValue(--counter3);
          }
        }
      });

    timerStella = new Timer(100, new ActionListener() {
      @Override
      //si no hay mas cerveza corta
      public void actionPerformed(ActionEvent e) {
        if (counter4 == 1) {
          timerStella.stop();
          timerGasStella.stop();
          JOptionPane.showMessageDialog(null, "Se termino la STELLA");

        } else {
          barrilStella.setValue(--counter4);
          barrilStella.setValue(--counter4);
          barrilStella.setValue(--counter4);
        }
      }
    });

    setTitle("Dispenser de Cervezas");
    setSize(270, 505);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  //acciones de cada boton
  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == coronaButton) {

      if (coronaButton.isSelected()) {
        coronaButton.setText("Parar");
        timerGasCorona.start();
        timerCorona.start();

      } else {
        coronaButton.setText("Corona");
        timerGasCorona.stop();
        timerCorona.stop();
      }
    }

      else if (e.getSource() == guinnessButton) {

        if (guinnessButton.isSelected()) {
          guinnessButton.setText("Parar");
          timerGasGuinness.start();
          timerGuinness.start();

        } else {
          guinnessButton.setText("Guinness");
          timerGasGuinness.stop();
          timerGuinness.stop();
        }
    }

      else if (e.getSource() == stellaButton) {

          if (stellaButton.isSelected()) {
            stellaButton.setText("Parar");
            timerGasStella.start();
            timerStella.start();
          } else {

            stellaButton.setText("Stella");
            timerGasStella.stop();
            timerStella.stop();
          }
      }
      //accion de rellenar barriles
      else if (e.getSource() == recargaCorona){
        counter2=100;
        barrilCorona.setValue(counter2);
      }
      else if (e.getSource() == recargaGas){
        counter=100;
        capacidadGas.setValue(counter);
      }
      else if (e.getSource() == recargaGuinness){
        counter3=100;
        barrilGuinness.setValue(counter3);
      }
      else if (e.getSource() == recargaStella){
        counter4=100;
        barrilStella.setValue(counter4);
      }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new DispenserCervezas();
      }
    });
  }
}

