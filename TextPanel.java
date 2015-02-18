import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * TextPanel class which creates a panel where all the text output from the game will be printed.
 * 
 * @author Elvedin Cuskic
 * @version 4/2 - 15
 */
public class TextPanel extends JPanel
{
    //This is the variable where the working TextWindow object will be placed when done.
    //private TextWindow textWindow;
    private JButton textWindow;
    
    /**
     * Constructor for objects of class NavigationPanel
     */
    public TextPanel()
    {
        textWindow = new JButton("TextWindow");
        makePanel();
    }
    
    /**
     * Method which sets up the TextPanel. 
     */
    private void makePanel(){
        setPreferredSize(new Dimension(900,120));
        setLayout(new BorderLayout());
        add(textWindow);
        setVisible(true);
    }
}
