import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * NavigationPanel class which holds and handles the four different buttons,
 * North, South, West and East.
 * 
 * @author Elvedin Cuskic
 * @version 4/2 - 15
 */
public class NavigationPanel extends JPanel implements ActionListener
{
    private JButton north;
    private JButton south;
    private JButton west;
    private JButton east;
    private Game game=new Game();
    
    /**
     * Constructor for objects of class NavigationPanel
     */
    public NavigationPanel()
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
