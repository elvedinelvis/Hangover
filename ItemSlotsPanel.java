import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * ItemSlotsPanel class which sets up six different item slots in this panel.
 * Uses an ArrayList to keep track of the different slots.
 * 
 * @author Elvedin Cuskic
 * @version 4/2 - 15
 */
public class ItemSlotsPanel extends Observable implements Observer
{
    //This will be added when the ItemSlot class is done.
    private JPanel panel;
    private Backpack backpack;
    private Player player;

    /**
     * Constructor for objects of class ItemSlotsPanel
     */
    public ItemSlotsPanel(Player player)
    {
    	this.player = player;
    	this.backpack = player.getBackpack();
        this.player.addObserver(this);
    }
    
    private void makePanel(){
    	panel = new JPanel();
        panel.setPreferredSize(new Dimension(120,720));
        panel.setLayout(new GridLayout(6,1));
        panel.setVisible(true);
    }

    private void updateGUI(Item item)
    {
    	if(backpack.itemExist(item.getName())) {
    		panel.remove(item.getButton());
    		panel.updateUI();
    		backpack.remove(item);
    		setChanged();
    		notifyObservers(item);
    		
    	}
    	else {
    		panel.add(item.getButton());
    		backpack.add(item);
    		player.getCurrentRoom().removeItem(item);
    		setChanged();
        	notifyObservers();
        }
    	panel.updateUI();
    }
    
    public JPanel newPanel()
    {
    	makePanel();
    	return panel;
    }
    
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Player && arg instanceof Item) {
			updateGUI((Item)arg);
		}
		
	}
}
