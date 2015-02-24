import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

/**
 * ImagePanel class which acts as the game screen. Handles different images of rooms and keys.
 * 
 * @author
 */
public class ImagePanel extends JPanel implements Observer
{
	private JLabel label;
	private Player player;
    
    /**
     * Constructor for objects of class ImagePanel
     */
    public ImagePanel(Player player)
    {
    	this.player = player;
    	player.addObserver(this);
    	label = new JLabel();
        makePanel();
    }
    
    /**
     * Method which sets up the ImagePanel. 
     */
    private void makePanel() {
        setPreferredSize(new Dimension(1160,600));
        setLayout(new BorderLayout());
        add(label);
        setVisible(true);
    }

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Player && arg instanceof Room) {
			removeAll();
			add((JLabel)arg);
			updateUI();
		}
	}
}
