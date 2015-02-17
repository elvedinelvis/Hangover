import java.util.*;

public class Backpack
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
    
    public void addItem(Item item)
    {
        itemList.put(item.getName(), item);
    }
    
    public void removeItem(String item)
    {
        if(itemList.containsKey(item)) {
            itemList.remove(item);
        }
    }
    
    public Item getItem(String item)
    {
            return itemList.get(item);
    }
    
    public int getSize()
    {
        return itemList.size();
    }
    
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
    
    public boolean itemExist(String item)
    {
        return itemList.containsKey(item);
    }
}
