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
    private HashMap<String, Item> items;
    //private Player backpackOwner;
    private int maxItems;
    
    /**
     * Constructor for objects of class Backpack
     */
    //public Backpack(Player player)
    public Backpack()
    {
        maxItems = 6;
        items = new HashMap<String, Item>();
    }
    
    //Methods
    
    /**
     * Adds an item to the backpack.
     * 
     * @param item The item to be added.
     */
   /* public void addOrRemoveItem(Item item)
    {
        if(items.contains(item)) {
            items.remove(item);
        }
        else {
            items.add(item);
        }
        setChanged();
        notifyObservers(item);
    }*/
    
    public void remove(Item item)
    {
        items.remove(item.getName());
    }
    
    public void add(Item item)
    {
        items.put(item.getName(), item);
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
     * Gets max amount of items in this backpack.
     * 
     * @return MaxItems in backpack.
     */
    public int getMaxItems()
    {
        return maxItems;
    }
    
    /**
     * Checks if an item is in backpack.
     * 
     * @param item Item to be checked.
     * @return true if item exist, otherwise false.
     */
    public boolean itemExist(String item)
    {
        return items.containsKey(item);
    }

    public ArrayList<Item> getAllItems()
    {
        return new ArrayList<Item>(items.values());
    }
    
    public Item getItem(String item)
    {
        return items.get(item);
    }
}
