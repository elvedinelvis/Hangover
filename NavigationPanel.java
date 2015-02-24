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
    	createButtons(game);
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
    
    private void createButtons(Game game)
    {
    	north = new JButton("North"/*new ImageIcon("C:\\Users\\Erik\\Desktop\\Java\\arrowNorth.png")*/);
        north.addActionListener(new ActionListener(){			
        	public void actionPerformed(ActionEvent e) {
				game.go("north");
        	}
        });
        
        south = new JButton("South"/*new ImageIcon("C:\\Users\\Erik\\Desktop\\Java\\arrowSouth.png")*/);
        south.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
            	game.go("south");
        	}
        });
        
        west = new JButton("West"/*new ImageIcon("C:\\Users\\Erik\\Desktop\\Java\\arrowWest.png")*/);
        west.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
            	game.go("west");
        	}
        });
        
        east = new JButton("East"/*new ImageIcon("C:\\Users\\Erik\\Desktop\\Java\\arrowEast.png")*/);
        east.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
            	game.go("east");	
        	}
        });
    }
}
