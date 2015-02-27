import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;


/**
 * Creates a player with a name and backpack.
 * Puts the player at the starting position as well.
 * 
 * @author
 *
 */
public class Player extends Observable implements Observer
{
    //Fields
    private String name;
    private Room currentRoom;
    private int maxItem;
    private Backpack backpack;
    private HangoMeter hangometer;
    private boolean startOfGame;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.name = name;
        maxItem = 6;
        backpack = new Backpack(this);
        hangometer = new HangoMeter();
        hangometer.addObserver(this);
        System.out.println(welcome());
        startOfGame = true;
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
    
    public void pickOrDrop(JButton button)
    {
   		backpack.addOrRemoveItem(button);
   		//setChanged();
   		//notifyObservers(button);
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
     * Enters the specified room.
     * 
     * @param room The room to enter.
     */
    public void enterRoom(Room room)
    {
        currentRoom = room;
        
        if(!startOfGame) {
        	hangometer.looseLife();
        }
        startOfGame = false;
        
        for(Item i : currentRoom.getItemList()) {
        	i.addObserver(this);
        }
        setChanged();
        notifyObservers(currentRoom);
    }
    
    /**
     * Prints out the exits and items of the current room.
     */
    public void printLocationInfo()
    {
    	//System.out.println(currentRoom.getExitString());
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
    
    public ArrayList<JButton> getBackpackItems()
    {
    	return backpack.getAllItems();
    }

    public Backpack getBackpack()
    {
    	return backpack;
    }
    
    private void endOfGame(String end)
    {
    	System.out.println(end);
    	System.exit(0);
    }
    
    public void updateRoomGui()
    {
    	currentRoom.updateUI();
    }
    
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Item && arg instanceof JButton) {
			setChanged();
			notifyObservers((JButton)arg);
			
		}
		/*else if(o instanceof HangoMeter && arg instanceof String) {
			endOfGame((String)arg);
		}*/
	}
}
