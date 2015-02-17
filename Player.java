
public class Player
{
    //Fields
    private String name;
    private Room currentRoom;
    private int maxItem;
    //private Hangometer hangometer;
    private Backpack backpack;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.name = name;
        maxItem = 6;
        //hangometer = new Hangometer();
        //itemInfo = new HashMap<String, Item>();
        backpack = new Backpack();
    }
    
    //Methods
    /**
     * Method is called when you want to know about the players name.
     * @return The name of the player.
     */
    public String getName()
    {
        return name;
    }
    
    public void pickUpItem(String item)
    {
        if(canBePickedUp()) {
           Item item1 = currentRoom.getItem(item);
           backpack.addItem(item1);
           currentRoom.removeItem(item1);
           System.out.println("Item picked up");
           printLocationInfo();
        }
    }
    
    public boolean dropItem(String item)
    {
        if(itemInBackpack(item)) {
            currentRoom.addItem(backpack.getItem(item));
            backpack.removeItem(item);
            printLocationInfo();
            return true;
        }
        return false;
    }
    
    public boolean canBePickedUp()
    {
        if(backpack.getSize() < maxItem) {
            return true;
        }
        return false;
    }
    
    public String getbackpackString()
    {
        return backpack.backpackItems();
    }
    
    public void enterRoom(Room room)
    {
        currentRoom = room;
    }
    
    public String getExits()
    {
        return currentRoom.getExitString();
    }
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    private boolean itemInBackpack(String item)
    {
        return backpack.itemExist(item);
    }
    
    public void printLocationInfo()
    {
    	System.out.println(currentRoom.getItemString());
    	System.out.println(currentRoom.getExitString());
    }
}
