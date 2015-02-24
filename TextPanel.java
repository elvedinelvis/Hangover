import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * TextPanel class which creates a panel where all the text output from the game will be printed.
 * 
 * @author
 * @version
 */
public class TextPanel extends JPanel
{
    private TextWindow textWindow;
    
    /**
     * Constructor for objects of class NavigationPanel
     */
    public TextPanel(Game game)
    {
        textWindow = new TextWindow(game);
        makePanel();
    }
    
    /**
     * Method which sets up the TextPanel. 
     */
    private void makePanel(){
        setPreferredSize(new Dimension(900,120));
        setLayout(new BorderLayout());
        
        //Following code adds a scroll to the textWindow
        JScrollPane scroll = new JScrollPane(textWindow,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVisible(true);
        
        add(scroll);
        setVisible(true);
    }
}
