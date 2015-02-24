import java.util.*;

/**
 * Creates a backpack that is used to store items that
 * are being picked up through out the game.
 * 
 * @author
 *
 */
public class Backpack extends Observable implements Observer
{
    //Fields
    private HashMap<String, Item> itemList;
    /**
     * Constructor for objects of class Backpack
     */
    public Backpack()
    {
        itemList = new HashMap<String, Item>();
    }
    
    //Methods
    public void updateGUI()
    {
    }
    
    /**
     * Adds an item to the backpack.
     * 
     * @param item The item to be added.
     */
    public void addOrRemoveItem(Item item)
    {
    	if(itemList.containsValue(item)) {
    		itemList.remove(item);
    	}
    	else {
    		itemList.put(item.getName(), item);
    	}
    	setChanged();
		notifyObservers(itemList);
    }
    
    /**
     * Removes the specified item from the backpack.
     * @param item The item to be removed.
     */
    public void removeItem(String item)
    {
        if(itemList.containsKey(item)) {
            itemList.remove(item);
            //setChanged();
            //notifyObservers(item);
        }
    }
    
    /**
     * Gets the specified item
     * 
     * @param item The item to get.
     * @return The specified item.
     */
    public Item getItem(String item)
    {
            return itemList.get(item);
    }
    
    /**
     * Gets amount of items in backpack.
     * 
     * @return Items in backpack.
     */
    public int getSize()
    {
        return itemList.size();
    }
    
    /**
     * Collects a string of all the items in the backpack.
     * 
     * @return A string of all the items.
     */
    public String backpackItems()
    {
        StringBuilder returnString = new StringBuilder();
        returnString.append("Items in backpack: ");
        Set<String> items = itemList.keySet();
        int count = items.size();
        for(String i : items) {
            returnString.append(i);
            if(count > 1) {
                returnString.append(", ");
            }
            count--;
        }
        return returnString.toString();
    }
    
    /**
     * Checks if an item is in backpack.
     * 
     * @param item Item to be checked.
     * @return true if item exist, otherwise false.
     */
    public boolean itemExist(String item)
    {
        return itemList.containsKey(item);
    }

    public ArrayList<Item> getAllItems()
    {
    	return new ArrayList<Item>(itemList.values());
    }
    
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Item) {
			addOrRemoveItem((Item)arg);
		}
		
	}
}
