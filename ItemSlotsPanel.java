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

    private void updateGUI(JButton button)		//måste lägga till button i currentRoom också, dock inte en knapp utan item
    {
    	if(backpack.itemExist(button)) {
    		panel.remove(button);
    		panel.updateUI();
    		setChanged();
    		notifyObservers(button);
    		backpack.remove(button);
    	}
    	else {
    		panel.add(button);
    		backpack.add(button);
    		player.getCurrentRoom().removeItem(player.getCurrentRoom().getItem(button.getName()));
    		panel.updateUI();
    		setChanged();
        	notifyObservers();
        }
    	//panel.updateUI();
    }
    	
    
    public JPanel newPanel()
    {
    	makePanel();
    	return panel;
    }
    
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Player && arg instanceof JButton) {
			updateGUI((JButton)arg);
		}
		
	}
}
