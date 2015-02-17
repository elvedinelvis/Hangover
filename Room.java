import java.util.*;

public class Room
{
    //Fields
    private HashMap<String, Room> exits;
    private HashMap<String, Item> items;
    private String description;
    private String name;
    /**
     * Constructor for objects of class Room
     */
    public Room(String name, String description)
    {
        exits = new HashMap<String, Room>();
        items = new HashMap<String, Item>();
        this.description = description;
        this.name = name;
    }
    
    //Methods
    public void addItem(Item item)
    {
        items.put(item.getName(), item);
    }
    
    public void removeItem(Item item)
    {
        if(items.containsKey(item.getName())) {
            items.remove(item.getName());
        }
    }
    
    public Item getItem(String item)
    {
        return items.get(item);
    }
    
    public boolean itemExist(String item)
    {
        if(items.containsKey(item)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public String getItemString()
    {
        StringBuilder returnString = new StringBuilder();
        returnString.append("Items: ");
        Set<String> itemList = items.keySet();
        int count = itemList.size();
        for(String i : itemList) {
            returnString.append(i);
            if(count > 1) {
                returnString.append(", ");
            }
            count--;
        }
        return returnString.toString();
    }
    
    /*public void getGUI()
    {
    }*/
    
    public void setExit(String name, Room room)
    {
        exits.put(name, room);
    }
    
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    
    public boolean testDirection(String direction)
    {
        if(exits.containsKey(direction)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public String getExitString()
    {
        StringBuilder returnString = new StringBuilder();
        returnString.append("Exits: ");
        Set<String> keyList = exits.keySet();
        int count = exits.size();
        for(String i : keyList) {
            returnString.append(i);
            if(count > 1) {
                returnString.append(", ");
            }
            count--;
        }
        return returnString.toString();
    }
    
    public String getDescription()
    {
        return description;
    }
}
