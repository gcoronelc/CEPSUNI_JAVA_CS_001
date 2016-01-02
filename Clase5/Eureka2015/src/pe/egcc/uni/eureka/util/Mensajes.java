package pe.egcc.uni.eureka.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @email gcoronelc@gmail.com
 * @blog gcoronelc.blogspot.com
 * @date 26/12/2015
 *
 */
public final class Mensajes {

  private Mensajes() {
  }

  public static void showError(Component parent, String message) {
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA - ERROR", JOptionPane.ERROR_MESSAGE);
  }

  public static void showInfo(Component parent, String message) {
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA - INFO", JOptionPane.INFORMATION_MESSAGE);
  }

}
