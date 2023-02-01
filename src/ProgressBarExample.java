import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProgressBarExample extends JFrame implements ActionListener {
  private JProgressBar progressBar, progressBar2,progressBar3;
  private JToggleButton startButton, pauseButton;
  private JButton resetButton;
  private Timer timer, timer2, timer3, timer4;
  private int counter, counter2, counter3 = 0;

  public ProgressBarExample() {
    setLayout(new FlowLayout());

    progressBar = new JProgressBar(0, 200);
    progressBar.setValue(0);
    progressBar.setStringPainted(true);
    add(progressBar);
    
    progressBar2 = new JProgressBar(0, 100);
    progressBar2.setValue(0);
    progressBar2.setStringPainted(true);
    add(progressBar2);
    
    progressBar3 = new JProgressBar(0, 100);
    progressBar3.setValue(0);
    progressBar3.setStringPainted(true);
    add(progressBar3);
 
    startButton = new JToggleButton("fria");
    startButton.addActionListener(this);
    add(startButton);

    pauseButton = new JToggleButton("caliente");
    pauseButton.addActionListener(this);
    add(pauseButton);

    resetButton = new JButton("Reset");
    resetButton.addActionListener(this);
    add(resetButton);

    timer = new Timer(100, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (counter >= 200) {
          timer.stop();
        } else {
          progressBar.setValue(++counter);
        }
      }
    });
    
    timer2 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (counter >= 200) {
            timer.stop();
          } else {
            progressBar.setValue(++counter);
          }
        }
      });
    
    timer3 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (counter >= 400) {
            timer3.stop();
          } else {
            progressBar2.setValue(++counter2);
          }
        }
      });
    
    timer4 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (counter >= 400) {
            timer4.stop();
          } else {
            progressBar3.setValue(++counter3);
          }
        }
      });

    setTitle("Progress Bar Example");
    setSize(300, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == startButton) {
      if (startButton.isSelected()) {
        startButton.setText("Stop");
        pauseButton.setEnabled(true);
        timer.start();
        timer3.start();
      } else {
        startButton.setText("Start");
        pauseButton.setEnabled(true);
        timer.stop();
        timer3.stop();
      }
    } else if (e.getSource() == pauseButton) {
      if (pauseButton.isSelected()) {
        pauseButton.setText("cortar");
        timer2.start();
        timer4.start();
      } else {
        pauseButton.setText("caliente");
        timer2.stop();
        timer4.stop();
      }
    } else if (e.getSource() == resetButton) {
      counter = 0;
      counter2 = 0;
      counter3 = 0;
      
      progressBar.setValue(counter);
      progressBar2.setValue(counter2);
      progressBar3.setValue(counter3);
      
      startButton.setText("Start");
      startButton.setSelected(false);
      pauseButton.setText("caliente");
      pauseButton.setSelected(false);
      pauseButton.setEnabled(true);
      
      timer.stop();
      timer2.stop();
      timer3.stop();
      timer4.stop();
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

