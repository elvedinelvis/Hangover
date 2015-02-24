import javax.swing.ImageIcon;


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
    private Player player;
    
    /**
     * Constructor for objects of class Game
     */
    public Game(Player player)
    {
        this.player = player;
        this.player.enterRoom(creategame());
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
        Item watch, toiletpaper, book, booze, gloves, phone, key, water;
        
        //create rooms
        String path = "/Users/Griffith/Skolan/"
        		+ "Objektorienterade applikationer/eclipsework"
        		+ "/images/";
        
        outside = new Room("outside", "outside the store", path + "pic13.jpg");
        lobby = new Room("lobby", "in the lobby", path + "pic13.jpg");
        basement = new Room("basement", "in the basement", path + "pic13.png");
        store = new Room("store", "in the local store", path + "pic13.jpg");
        suite = new Room("suite", "in the hotel suite", path + "pic13.jpg");
        bathroom = new Room("bathroom", "in the bathroom of the suite", path + "pic13.jpg");
        bedroom = new Room("bedroom", "in the bedroom of the suite", path + "pic13.jpg");
        balcony = new Room("balcony", "on the balony of the suite", path + "pic13.jpg");
        suitcase = new Room("suitcase", "suitcase", path + "pic13.jpg");
        roof = new Room("rooftop", "on the rooftop of the hotel", path + "pic13.jpg");
        storage = new Room("storage room", "in the storage room", path + "pic13.jpg");
        
        outside.setExit("north", lobby);
        outside.setExit("west", roof);
        outside.setExit("south", store);
        
        lobby.setExit("north", basement);
        lobby.setExit("east", suite);
        lobby.setExit("south", outside);
        lobby.setExit("west", roof);
        
        basement.setExit("north", storage);
        basement.setExit("south", lobby);
        
        storage.setExit("south", basement);
        
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
        key = new Item("key", 1, path + "pic1.png");
        
        phone = new Item("phone", 2, path + "pic2.png");
        
        gloves = new Item("gloves", 3, path + "pic3.png");
        
        book = new Item("book", 4, path + "pic4.png");
        
        booze = new Item("booze", 5, path + "pic5.png");
        
        toiletpaper = new Item("toiletpaper", 6, path + "pic6.png");
        
        watch = new Item("watch", 7, path + "pic7.png");
        
        water = new Item("waterbottle", 0, path + "pic0.png");
        
        //add items to room
        bathroom.addItem(toiletpaper);
        bedroom.addItem(book);
        bedroom.addItem(watch);
        suite.addItem(gloves);
        suite.addItem(booze);
        suite.addItem(key);
        outside.addItem(phone);
        
        bathroom.addItem(water);
        suite.addItem(water);
        bedroom.addItem(water);
        outside.addItem(water);
        lobby.addItem(water);
        bedroom.addItem(water);
       
        
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
	        /*case "take":
	            pickItem(com[1]);
	            break;
	        case "drop":
	            dropItem(com[1]);
	            break;
	        case "quit":
	            quit();
	            break;*/
	        case "backpack":
	            backpack();
	            break;
	        case "help":
	        	player.help();
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
    public void go(String direction)
    {
    	player.go(direction);
    }
    
    /**
     * Picks up the item that is specified in the parameter.
     * 
     * @param item The item to be picked up.
     */
    /*private void pickItem(String item)
    {
    	player.pickUpItem(item);
    }
    /**
     * Drops the the item that is specified in the parameter.
     * 
     * @param item The item to be dropped.
     */
    /*private void dropItem(String item)
    {
    	player.dropItem(item);
    }
    /**
     * Prints out the items in the backpack.
     */
    private void backpack()
    {
        player.printBackpack();
    }
    
    /**
     * Method that is performed when a user wishes to quit the game.
     */
    private void quit()
    {
    	System.out.println("Thanks for playing " + player.getName() + ", bye!");
    	System.exit(0);
    }
    
    public HangoMeter getHango()
    {
    	return player.getHango();
    }
    
    public Player getPlayer()
    {
    	return player;
    }
}
