package pe.egcc.uni.eureka.prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email  gcoronelc@gmail.com
 * @blog   gcoronelc.blogspot.com
 * @date   02/01/2016
 * 
 */
public class Prueba02 extends JFrame{
  
  private JButton boton;

  private Prueba02(String titulo) {
    super(titulo);
    initForm();
  }
  
  private void initForm(){
    boton = new JButton("Saludo");
    this.add(boton);
    
    boton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        boton_actionPerformed(e);
      }
    });
  }
  
  private void boton_actionPerformed(ActionEvent e){
    JOptionPane.showMessageDialog(rootPane, "FELIZ AÑO 2016.");
  }
  
  public static void main(String[] args) {
    Prueba02 view = new Prueba02("Feliz 2016 para todos.");
    view.setVisible(true);
  }

  
}
