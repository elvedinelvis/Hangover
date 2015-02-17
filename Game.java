
/**
 * Creates the game, i.e the rooms, exits and items.
 * React to user input commands and executes some
 * type of action depending on the command.
 * 
 * @author
 *
 */
public class Game
{
    //private Room currentRoom;
    private Player player1;
    
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        player1 = new Player("Kim K", creategame());
    }
    
    /**
     * Creates the rooms, room exits, items and adds items to rooms.
     * I.e creates the game.
     * @return The starting position of the game.
     */
    private Room creategame()
    {
        Room outside, lobby, roof, basement, store, suite, bathroom, bedroom,
                    balcony, suitcase, storage;
        Item watch, toiletpaper, book, booze, gloves, phone;
        
        //create rooms
        outside = new Room("outside", "outside the store");
        lobby = new Room("lobby", "in the lobby");
        basement = new Room("basement", "in the basement");
        store = new Room("store", "in the local store");
        suite = new Room("suite", "in the hotel suite");
        bathroom = new Room("bathroom", "in the bathroom of the suite");
        bedroom = new Room("bedroom", "in the bedroom of the suite");
        balcony = new Room("balcony", "on the balony of the suite");
        suitcase = new Room("suitcase", "suitcase");
        roof = new Room("rooftop", "on the rooftop of the hotel");
        storage = new Room("storage room", "in the storage room");
        
        outside.setExit("north", lobby);
        outside.setExit("west", roof);
        outside.setExit("south", store);
        
        lobby.setExit("north", basement);
        lobby.setExit("east", suite);
        lobby.setExit("south", outside);
        lobby.setExit("west", roof);
        
        basement.setExit("north", storage);
        basement.setExit("south", lobby);
        
        store.setExit("north", outside);
        
        suite.setExit("north", balcony);
        suite.setExit("east", bathroom);
        suite.setExit("south", bedroom);
        suite.setExit("west", lobby);
        suite.setExit("northeast", suitcase);
        
        roof.setExit("east", lobby);
        roof.setExit("south", outside);
        
        bathroom.setExit("west", suite);
        bedroom.setExit("north", suite);
        balcony.setExit("south", suite);
        suitcase.setExit("southwest", suite);
        
        //create items
        toiletpaper = new Item("toiletpaper");
        book = new Item("book");
        gloves = new Item("gloves");
        booze = new Item("booze");
        phone = new Item("phone");
        watch = new Item("watch");
        
        //add items to room
        bathroom.addItem(toiletpaper);
        bedroom.addItem(book);
        bedroom.addItem(watch);
        suite.addItem(gloves);
        suite.addItem(booze);
        outside.addItem(phone);
        
        return outside;
    }
    
    /**
     * Main method that executes the user input commands.
     * 
     * @param com The command to be executed along with desired direction or item.
     */
    public void play(String[] com)
    {
        switch(com[0]) {
	        case "go":
	            go(com[1]);
	            break;
	        case "take":
	            pickItem(com[1]);
	            break;
	        case "drop":
	            dropItem(com[1]);
	            break;
	        case "quit":
	            quit();
	            break;
	        case "backpack":
	            backpack();
	            break;
	        case "help":
	        	player1.help();
	        	break;
	        default:
	            System.out.println("Invalid command");
	            break;
        }
    }
    
    //Methods
    
    /**
     * Moves to the room at the specified direction.
     * 
     * @param direction The direction to move to.
     */
    private void go(String direction)
    {
    	player1.go(direction);
    }
    
    /**
     * Picks up the item that is specified in the parameter.
     * 
     * @param item The item to be picked up.
     */
    private void pickItem(String item)
    {
    	player1.pickUpItem(item);
    }
    /**
     * Drops the the item that is specified in the parameter.
     * 
     * @param item The item to be dropped.
     */
    private void dropItem(String item)
    {
    	player1.dropItem(item);
    }
    /**
     * Prints out the items in the backpack.
     */
    private void backpack()
    {
        player1.printBackpack();
    }
    
    /**
     * Method that is performed when a user wishes to quit the game.
     */
    private void quit()
    {
    	System.out.println("Thanks for playing " + player1.getName() + ", bye!");
    	System.exit(0);
    }
}
