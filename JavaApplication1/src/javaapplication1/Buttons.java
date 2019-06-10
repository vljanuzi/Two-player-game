
package javaapplication1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/
public class Buttons implements  ActionListener{
    
    public JButton btn;
    
    public void actionPerformed(ActionEvent e) {
     //   throw new UnsupportedOperationException("Not supported yet.");
        
        System.out.println(e.getActionCommand());
    }
    
}
