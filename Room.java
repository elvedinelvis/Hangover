import java.awt.*;
import java.util.*;

import javax.swing.*;

/**
 * Creates a room with exits, rooms and a description.
 * 
 * @author
 *
 */
public class Room extends JLabel
{
    //Fields
    private HashMap<String, Room> exits;
    private HashMap<String, Item> items;
    private String description;
    private String name;
    private String path;
    
    /**
     * Constructor for objects of class Room
     */
    public Room(String name, String description, String path)
    {
        exits = new HashMap<String, Room>();
        items = new HashMap<String, Item>();
        this.description = description;
        this.path = path;
        this.name = name;
    }
    
    //Methods
    /**
     * Adds the specified item to the room.
     * 
     * @param item The item to be added.
     */
    public void addItem(Item item)
    {
        items.put(item.getName(), item);
    }
    
    /**
     * Removes the specified item.
     * 
     * @param item The item to be removed.
     */
    public void removeItem(Item item)
    {
        if(items.containsKey(item.getName())) {
            items.remove(item.getName());
        }
    }
    
    /**
     * Gets the specified item.
     * 
     * @param item The item to get.
     * 
     * @return The requested item.
     */
    public Item getItem(String item)
    {
        return items.get(item);
    }
    
    /**
     * Checks if the specified item is in the room.
     * 
     * @param item The item to check.
     * @return true if item exist, otherwise false.
     */
    public boolean itemExist(String item)
    {
        if(items.containsKey(item)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Collects a string of all the items in the room.
     * 
     * @return A string of all the items.
     */
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
    
    /**
     * Connects/sets the exits of the room. I.e, creating the map.
     * 
     * @param name The name of the room.
     * @param room The room itself.
     */
    public void setExit(String name, Room room)
    {
        exits.put(name, room);
    }
    
    /**
     * Gets the exit at the specified direction.
     * 
     * @param direction The direction where the specified room is located.
     * 
     * @return The room at the specified direction.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    
    /**
     * Checks if a room is at the specified direction.
     * 
     * @param direction The direction to be checked.
     * 
     * @return true if a room exists at the specified direction, otherwise false.
     */
    public boolean testDirection(String direction)
    {
        if(exits.containsKey(direction)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Collects a string of all the exits in the room.
     * 
     * @return The exits in the room.
     */
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
    
    /**
     * Gets the description of a room.
     * 
     * @return The description.
     */
    public String getDescription()
    {
        return description;
    }
    
    private ArrayList<Item> getItemList()
    {
    	return new ArrayList<Item>(items.values());
    }
    
    public void GUI()
    {
    	setLayout(new FlowLayout());
    	setIcon(new ImageIcon(path));
    	//setVisible(true);
    	for(Item i : getItemList()) {
    		add(i);
    	}
    }
}
