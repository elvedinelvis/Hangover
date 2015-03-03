import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * NavigationPanel class which holds and handles the four different buttons,
 * North, South, West and East.
 * 
 * @author
 * @version
 */

public class NavigationPanel extends JPanel
{
    private JButton north;
    private JButton south;
    private JButton west;
    private JButton east;
    private Game game;
    
    /**
     * Constructor for objects of class NavigationPanel
     */
    public NavigationPanel(Game game)
    {
    	this.game = game;
    	createButtons();
        makePanel();
    }
    
    /**
     * Method which sets up the NavigationPanel and its buttons. 
     */
    private void makePanel(){
        setPreferredSize(new Dimension(160,120));
        setLayout(new BorderLayout());
        setBackground(Color.black);
        
        
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(west, BorderLayout.WEST);
        add(east, BorderLayout.EAST);

        setVisible(true);
    }
    
    private void createButtons()
    {
    	String path = System.getProperty("user.dir");
    	
        north = new JButton();
        north.setIcon(new ImageIcon(path + "/Images/Gui/arrowNorth.jpg"));
        north.setBorder(null);
    	north.addActionListener(new ActionListener(){			
        	public void actionPerformed(ActionEvent e) {
				game.go("north");
        	}
        });
        
        south = new JButton();
        south.setIcon(new ImageIcon(path + "/Images/Gui/arrowSouth.jpg"));
        south.setBorder(null);
        south.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
            	game.go("south");
        	}
        });
        
        west = new JButton();
        west.setIcon(new ImageIcon(path + "/Images/Gui/arrowWest.jpg"));
        west.setBorder(null);
        west.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
            	game.go("west");
        	}
        });
        
        east = new JButton();
        east.setIcon(new ImageIcon(path + "/Images/Gui/arrowEast.jpg"));
        east.setBorder(null);
        east.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
            	game.go("east");	
        	}
        });
    }
}
