import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * HangometerPanel class which creates a panel where the Hangometer will be placed.
 * 
 * @author Elvedin Cuskic
 * @version 4/2 - 15
 */
public class HangometerPanel extends JPanel
{
    //This is the variable where the final Hangometer will be placed.
    //private Hangometer hangometer;
    private JButton hangometer;
    
    /**
     * Constructor for objects of class HangometerPanel
     */
    public HangometerPanel()
    {
        hangometer = new JButton("Hangometer");
        makePanel();
    }
    
    /**
     * Method which sets up the TextPanel. 
     */
    private void makePanel(){
        setPreferredSize(new Dimension(100,120));
        setLayout(new BorderLayout());
        add(hangometer);
        setVisible(true);
    }
}
