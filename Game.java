
public class Game
{
    //private Room currentRoom;
    private Player player1;
    
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        player1 = new Player("Kim K");
        player1.enterRoom(creategame());
        printWelcome();
    }
    
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
	        	help();
	        	break;
	        default:
	            System.out.println("Invalid command");
	            break;
        }
    }
    /**
     * Prints out a welcome message when starting a new game.
     */
    private void printWelcome()
    {
        System.out.print("Hello " + player1.getName());
        System.out.println(" and welcome to the Hangover game");
        System.out.println("Enter a direction to move to another room");
        System.out.println(player1.getExits());
    }
    
    /**
     * Prints out the current location information,
     * i.e items and exits of the curent room.
     */
    private void printLocationInfo()
    {
    	player1.printLocationInfo();
    }
    
    //Command Methods
    private void go(String direction)
    {
        if(player1.getCurrentRoom().testDirection(direction)) {
            player1.enterRoom(player1.getCurrentRoom().getExit(direction));
            System.out.println("You are in the " + player1.getCurrentRoom().getDescription());
            printLocationInfo();
        }
        else {
            System.out.println("No room in that direction or invalid command");
        }
    }
    
    private void pickItem(String item)
    {
        if(player1.getCurrentRoom().itemExist(item)) {
            player1.pickUpItem(item);
        }
        else {
            System.out.println("Item does not exist");
        }
    }
    
    private void dropItem(String item)
    {
        if(!player1.dropItem(item)) {
            System.out.println("You do not have that item in your backpack");
        }
    }
    
    private void backpack()
    {
        System.out.println(player1.getbackpackString());
    }
    
    private void help()
    {
    	System.out.println("You are " + player1.getCurrentRoom().getDescription());
    	System.out.println("Available commands: go, take, backpack, quit, help");
    }
    /**
     * Method that is performed when a user wishes to quit the game.
     */
    private void quit()
    {
    	System.exit(0);
    }
}
