import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * ImagePanel class which acts as the gamescreen. Handles different images of rooms and keys.
 * 
 * @author Elvedin Cuskic
 * @version 4/2 - 15
 */
public class ImagePanel extends JPanel
{
    private JButton gameScreen;
    
    /**
     * Constructor for objects of class ImagePanel
     */
    public ImagePanel()
    {
        gameScreen = new JButton("Gamescreen");
        makePanel();
    }
    
    /**
     * Method which sets up the ImagePanel. 
     */
    private void makePanel(){
        setPreferredSize(new Dimension(1160,600));
        setLayout(new BorderLayout());
        add(gameScreen);
        setVisible(true);
    }
}
