import java.awt.*;
import java.util.Observable;

import javax.swing.*;


/**
 * Creates a player with a name and backpack.
 * Puts the player at the starting position as well.
 * 
 * @author
 *
 */
public class Player extends Observable
{
    //Fields
    private String name;
    private Room currentRoom;
    private int maxItem;
    private Backpack backpack;
    private HangoMeter hangometer;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.name = name;
        maxItem = 6;
        //backpack = new Backpack();
        hangometer = new HangoMeter();
        System.out.println(welcome());
    }
    
    //Methods
    /**
     * Prints out a welcome message when starting a new game.
     */
    public String welcome()
    {
        return "Hello " + getName() + 
        	" and welcome to the Hangover game" + 
        	"\nEnter a direction to move to another room";
    }
    
    /**
     * Method is called when you want to know the players name.
     * 
     * @return The name of the player.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Moves to the room at the specified direction.
     * 
     * @param direction The direction to move to.
     */
    public void go(String direction)
    {
        if(currentRoom.testDirection(direction)) {
            enterRoom(currentRoom.getExit(direction));
            System.out.println("You are " + currentRoom.getDescription());
            printLocationInfo();
        }
        else {
            System.out.println("No room in that direction or invalid command");
        }
    }
    
    /**
     * Picks up the specified item.
     * 
     * @param item The item to be picked up.
     */
    /*public void pickUpItem(String item)
    {
        if(currentRoom.itemExist(item)) {
            if(canBePickedUp()) {
                Item item1 = currentRoom.getItem(item);
                backpack.addItem(item1);
                currentRoom.removeItem(item1);
                System.out.println("Item picked up");
                printLocationInfo();
             }
            else {
            	System.out.println("Backpack is full");
            }
        }
        else {
            System.out.println("Item does not exist");
        }

    }
    
    /**
     * Drops the specified item.
     * 
     * @param item The item to be dropped.
     */
   /* public void dropItem(String item)
    {
        if(itemInBackpack(item)) {
            currentRoom.addItem(backpack.getItem(item));
            backpack.removeItem(item);
            printLocationInfo();
        }
        else {
        	System.out.println("You do not have that item in your backpack");
        }
    }*/
    
    /**
     * Prints out the available commands.
     */
    public void help()
    {
    	System.out.println("You are " + currentRoom.getDescription());
    	System.out.println("Available commands: go, take, backpack, quit, help");
    }
    
    /**
     * Checks if an item can be picked up based 
     * on availability of free space left.
     * 
     * @return true if space is available, otherwise return false.
     */
    public boolean canBePickedUp()
    {
        if(backpack.getSize() < maxItem) {
            return true;
        }
        return false;
    }
    
    /**
     * Prints out the items in the backpack.
     */
    public void printBackpack()
    {
        System.out.println(backpack.backpackItems());
    }
    
    /**
     * Enters the specified room.
     * 
     * @param room The room to enter.
     */
    public void enterRoom(Room room)
    {
        currentRoom = room;
        hangometer.looseLife();
        currentRoom.GUI();
        setChanged();
        notifyObservers(currentRoom);
        
    }
    
    /**
     * Checks if the specified item is in the backpack.
     * 
     * @param item The item to be tested.
     * 
     * @return true if item is in backpack, otherwise return false.
     */
    private boolean itemInBackpack(String item)
    {
        return backpack.itemExist(item);
    }
    
    /**
     * Prints out the exits and items of the current room.
     */
    public void printLocationInfo()
    {
    	System.out.println(currentRoom.getItemString());
    	System.out.println(currentRoom.getExitString());
    }
    
    /*private boolean isWater(String item)
    {
    	if(item.equals("waterbottle")) {
    		return true;
    	}
    	return false;
    }*/
    
    public HangoMeter getHango()
    {
    	return hangometer;
    }
    
    public Room getCurrentRoom()
    {
    	return currentRoom;
    }
    
    public Backpack getBackpack()
    {
    	return backpack;
    }
}
