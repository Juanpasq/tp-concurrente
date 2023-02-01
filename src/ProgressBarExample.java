import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProgressBarExample extends JFrame implements ActionListener {
  private JProgressBar capacidadGas, barrilCorona,barrilGuinness, barrilStella;
  private JToggleButton coronaButton, guinnessButton, stellaButton;
  private JButton resetButton;
  private Timer timerGasCorona, timerCorona, timerGasGuinness, timerGuinness, timerGasStella, timerStella;
  private int counter, counter2, counter3, counter4 = 0;

  public ProgressBarExample() {
    setLayout(new FlowLayout());

    capacidadGas = new JProgressBar(0, 200);
    capacidadGas.setValue(0);
    capacidadGas.setBackground(Color.white);
    capacidadGas.setForeground(Color.pink);
    capacidadGas.setStringPainted(true);
    add(capacidadGas);
    
    //jProgressBar.setBackground(Color.elquequieras);
    //jProgressBar.setForeground(Color.elquequieras);
    
    barrilCorona = new JProgressBar(0, 100);
    barrilCorona.setValue(0);
    barrilCorona.setForeground(Color.yellow);
    barrilCorona.setStringPainted(true);
    add(barrilCorona);
    
    barrilGuinness = new JProgressBar(0, 100);
    barrilGuinness.setValue(0);
    barrilGuinness.setForeground(Color.darkGray);
    barrilGuinness.setStringPainted(true);
    add(barrilGuinness);
    
    barrilStella = new JProgressBar(0, 100);
    barrilStella.setValue(0);
    barrilStella.setForeground(Color.orange);
    barrilStella.setStringPainted(true);
    add(barrilStella);
 
    coronaButton = new JToggleButton("Corona");
    coronaButton.addActionListener(this);
    add(coronaButton);

    guinnessButton = new JToggleButton("Guinness");
    guinnessButton.addActionListener(this);
    add(guinnessButton);
    
    stellaButton = new JToggleButton("Stella");
    stellaButton.addActionListener(this);
    add(stellaButton);

    resetButton = new JButton("Reset");
    resetButton.addActionListener(this);
    add(resetButton);

    //bloques de acciones de cada cerveza sobre los barriles (dos por cada uno, gas y cerveza)
    timerGasCorona = new Timer(100, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (counter >= 200) {
        	timerGasCorona.stop();
        } else {
          capacidadGas.setValue(++counter);
        }
      }
    });
    
    timerGasGuinness = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (counter >= 200) {
            timerGasGuinness.stop();
          } else {
            capacidadGas.setValue(++counter);
          }
        }
      });
    
    timerGasStella = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (counter >= 200) {
            timerGasStella.stop();
          } else {
            capacidadGas.setValue(++counter);
          }
        }
      });
    
    timerCorona = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (counter >= 400) {
            timerCorona.stop();
          } else {
            barrilCorona.setValue(++counter2);
          }
        }
      });
    
    timerGuinness = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (counter >= 400) {
            timerGuinness.stop();
          } else {
            barrilGuinness.setValue(++counter3);
          }
        }
      });
    
    timerStella = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (counter >= 400) {
            timerStella.stop();
          } else {
            barrilStella.setValue(++counter3);
          }
        }
      });

    setTitle("Progress Bar Example");
    setSize(300, 100);
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
    } else if (e.getSource() == guinnessButton) {
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
      
    } else if (e.getSource() == resetButton) {
	      counter = 0;
	      counter2 = 0;
	      counter3 = 0;
	      counter4 = 0;
	      
	      //reseteo de contadores
	      capacidadGas.setValue(counter);
	      barrilCorona.setValue(counter2);
	      barrilGuinness.setValue(counter3);
	      barrilStella.setValue(counter4);
	     
	      //estado de botones al reiniciar
	      coronaButton.setText("Corona");
	      coronaButton.setSelected(false);
	      coronaButton.setEnabled(true); 
	      stellaButton.setText("Stella");
	      stellaButton.setSelected(false);
	      stellaButton.setEnabled(true);
	      guinnessButton.setText("Guinness");
	      guinnessButton.setSelected(false);
	      guinnessButton.setEnabled(true);
	      
	      //timers a barril de gas
	      timerGasGuinness.stop();
	      timerGasStella.stop();
	      timerGasCorona.stop();
	      
	      //timers barriles cerveza
	      timerGuinness.stop();
	      timerStella.stop();
	      timerCorona.stop();
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new ProgressBarExample();
      }
    });
  }
  
}

