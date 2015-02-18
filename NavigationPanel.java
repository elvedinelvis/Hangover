import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * NavigationPanel class which holds and handles the four different buttons,
 * North, South, West and East.
 * 
 * @author Elvedin Cuskic
 * @version 4/2 - 15
 */
public class NavigationPanel extends JPanel
{
    private JButton north;
    private JButton south;
    private JButton west;
    private JButton east;
    
    /**
     * Constructor for objects of class NavigationPanel
     */
    public NavigationPanel()
    {
        north = new JButton("North");
        south = new JButton("South");
        west = new JButton("West");
        east = new JButton("East");
        
        makePanel();
    }
    
    /**
     * Method which sets up the NavigationPanel and its buttons. 
     */
    private void makePanel(){
        setPreferredSize(new Dimension(160,120));
        setLayout(new BorderLayout());
        
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(west, BorderLayout.WEST);
        add(east, BorderLayout.EAST);

        setVisible(true);
    }
}
