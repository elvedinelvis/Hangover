import java.awt.*;
import java.awt.List;
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
<<<<<<< HEAD:Game/Room.java
=======
    private boolean locked;
>>>>>>> master:Room.java
    
    /**
     * Constructor for objects of class Room
     */
<<<<<<< HEAD:Game/Room.java
    public Room(String name, String description, String path)
=======
    public Room(String name, String description, boolean locked, String path)
>>>>>>> master:Room.java
    {
        exits = new HashMap<String, Room>();
        items = new HashMap<String, Item>();
        this.description = description;
        this.path = path;
        this.name = name;
<<<<<<< HEAD:Game/Room.java
=======
        this.locked = locked;
>>>>>>> master:Room.java
        setLayout(new FlowLayout());
    	setIcon(new ImageIcon(path));
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
        add(item.getButton());
        updateUI();
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
            remove(item.getButton());
            updateUI();
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
        StringBuilder sb = new StringBuilder(1000);
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) {
            //Appends the string with the exit, changes first letter to an uppercase.
            sb.append(Character.toString(exit.charAt(0)).toUpperCase()+exit.substring(1));
            sb.append(": ");
            //Appends the string with the exitroom, changes first letter to an uppercase.
            sb.append(Character.toString(exits.get(exit).getName().charAt(0)).toUpperCase()
                      +exits.get(exit).getName().substring(1));
            sb.append("      ");
        }
        return sb.toString();
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
    
<<<<<<< HEAD:Game/Room.java
=======
    /**
     * Gets the lockstatus of the room.
     * 
     * @return locked.
     */
    public boolean getLocked()
    {
    	return locked;
    }
    
    /**
     * Gets the name of the room.
     * 
     * @return name.
     */
>>>>>>> master:Room.java
    public String getName()
    {
    	return name;
    }
    
<<<<<<< HEAD:Game/Room.java
=======
    /**
     * Sets the lockstatus of the room.
     * 
     * @param lockStatus.
     */
    public void setLocked(boolean lockStatus)
    {
    	locked = lockStatus;
    }
    
>>>>>>> master:Room.java
    public ArrayList<Item> getItemList()
    {
    	return new ArrayList<Item>(items.values());
    }
    
    /*public void GUI()
    {
    	setLayout(new FlowLayout());
    	setIcon(new ImageIcon(path));
    	for(Item i : getItemList()) {
    		add(i.getButton());
    	}
    }*/
}
