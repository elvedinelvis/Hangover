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
	private Player player;
	private ItemSlotsPanel isp;
    
    /**
     * Constructor for objects of class ImagePanel
     */
    public ImagePanel(Player player, ItemSlotsPanel isp)
    {
    	this.player = player;
    	this.isp = isp;
    	this.player.addObserver(this);
    	this.isp.addObserver(this);
        makePanel();
    }
    
    /**
     * Method which sets up the ImagePanel. 
     */
    private void makePanel() {
        setPreferredSize(new Dimension(1160,600));
        setLayout(new BorderLayout());
        add(player.getCurrentRoom());
        setVisible(true);
    }
    
    private void addButton(Item item)
    {
    	Room currentRoom = player.getCurrentRoom();
    	currentRoom.addItem(item);
    	currentRoom.updateUI();
    	currentRoom.updateUI();
    	updateUI();
    }
    
    private void updateRoom(JLabel label)
    {
    	removeAll();
    	add(label);
    	updateUI();
    	
    }

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Player && arg instanceof Room) {
			updateRoom((JLabel)arg);
		}
		else if(o instanceof ItemSlotsPanel) {
			if(arg instanceof Item) {
				addButton((Item)arg);
			}
			else {
				updateUI();
			}
		} 
	}
}
