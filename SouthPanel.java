import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * SouthPanel class which holds and handles the three different subpanels.
 * NavigationPanel, TextPanel and Hangometer is included in this panel.
 * 
 * @author Elvedin Cuskic
 * @version 4/2 - 15
 */
public class SouthPanel extends JPanel
{
    private JPanel navigationPanel;
    private JPanel textPanel;
    private JPanel hangoPanel;
    
    /**
     * Constructor for objects of class SouthPanel
     */
    public SouthPanel(Game game)
    {
        navigationPanel = new NavigationPanel(game);
        textPanel = new TextPanel();
        hangoPanel = new HangometerPanel(game.getHango());
        
        makePanel();
    }
    
    /**
     * Method which sets up the SouthPanel. 
     */
    private void makePanel(){
        setPreferredSize(new Dimension(1160,120));
        setLayout(new BorderLayout());

        add(navigationPanel, BorderLayout.WEST);
        add(textPanel, BorderLayout.CENTER);
        add(hangoPanel, BorderLayout.EAST);
        
        setVisible(true);
    }
}
