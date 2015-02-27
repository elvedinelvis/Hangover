import java.util.*;

import javax.swing.JButton;

/**
 * Creates a backpack that is used to store items that
 * are being picked up through out the game.
 * 
 * @author
 *
 */
public class Backpack extends Observable //implements Observer
{
    //Fields
    private ArrayList<JButton> items;
    /**
     * Constructor for objects of class Backpack
     */
    public Backpack(Player player)
    {
        items = new ArrayList<JButton>();
    }
    
    //Methods
    
    /**
     * Adds an item to the backpack.
     * 
     * @param item The item to be added.
     */
    public void addOrRemoveItem(JButton button)
    {
    	if(items.contains(button)) {
    		items.remove(button);
    	}
    	else {
    		items.add(button);
    	}
    	setChanged();
    	notifyObservers(button);
    }
    
    public void remove(JButton button)
    {
    	items.remove(button);
    }
    
    public void add(JButton button)
    {
    	items.add(button);
    }
    
    /**
     * Gets amount of items in backpack.
     * 
     * @return Items in backpack.
     */
    public int getSize()
    {
        return items.size();
    }
    
    /**
     * Checks if an item is in backpack.
     * 
     * @param item Item to be checked.
     * @return true if item exist, otherwise false.
     */
    public boolean itemExist(JButton button)
    {
        return items.contains(button);
    }

    public ArrayList<JButton> getAllItems()
    {
    	return items;
    }
}
