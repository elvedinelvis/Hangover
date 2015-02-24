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
public class ItemSlotsPanel extends JPanel implements Observer
{
    //This will be added when the ItemSlot class is done.
    private ArrayList<Item> itemSlots;
    private Backpack backpack;

    /**
     * Constructor for objects of class ItemSlotsPanel
     */
    public ItemSlotsPanel(Backpack backpack)
    {
    	this.backpack = backpack;
        this.backpack.addObserver(this);
        itemSlots = new ArrayList<>(backpack.getAllItems());
        makePanel();
    }
    
    private void makePanel(){
        setPreferredSize(new Dimension(120,720));
        setLayout(new GridLayout(6,1));
        setVisible(true);
    }

    private void updateGUI(Item item)
    {
    	if(itemSlots.contains(item)) {
    		remove(item.getButton());
    	}
    	else {
    		add(item.getButton());
    	}
    	repaint();
    	updateUI();
    }
    
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Backpack && arg instanceof Item) {
			updateGUI((Item)arg);
		}
		
	}
}
