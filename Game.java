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
        basement = new Room("basement", "in the basement", path + "pic13.jpg");
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
        key = new Item("key", path + "pic1.png");
        
        phone = new Item("phone", path + "pic2.png");
        
        gloves = new Item("gloves", path + "pic3.png");
        
        book = new Item("book", path + "pic4.png");
        
        booze = new Item("booze", path + "pic5.png");
        
        toiletpaper = new Item("toiletpaper", path + "pic6.png");
        
        watch = new Item("watch", path + "pic7.png");
        
        water = new Item("waterbottle", path + "pic0.png");
        
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
       
        /*bathroom.GUI();
        bedroom.GUI();
        suite.GUI();
        outside.GUI();
        store.GUI();
        lobby.GUI();
        roof.GUI();
        balcony.GUI();
        suitcase.GUI();
        storage.GUI();
        basement.GUI();*/
        
        
        return outside;
    }
    
    /**
     * Moves to the room at the specified direction.
     * 
     * @param direction The direction to move to.
     */
    public void go(String direction)
    {
    	player.go(direction);
    }
    
    public HangoMeter getHango()
    {
    	return player.getHango();
    }
    
    public Player getPlayer()
    {
    	return player;
    }
    
    public Backpack getBackpack()
    {
    	return player.getBackpack();
    }
}
