package majesty.view;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import javafx.scene.control.ProgressBar;

//Loading Screen

public class Splash {

public static void displaySplash() {

JWindow window = new JWindow();

window.getContentPane().add(new JLabel("", new ImageIcon("src/majesty/images/splash/loading2.gif"),SwingConstants.CENTER));
window.setBounds(700, 300, 400, 300);
window.setVisible(true);
window.dispose();

}
}


/*try
{
Thread.sleep(8000);

}
catch(InterruptedException e) {}
window.dispose();
}
*/


