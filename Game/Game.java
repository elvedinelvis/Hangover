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
                    balcony, suitcase, passage;
        Item watch, toiletpaper, book, booze, gloves, phone, key,
                    water1, water2, water3, water4, water5, water6;
        
        //create rooms
        String path = System.getProperty("user.dir");
        
        outside = new Room("outside", "outside the hotel and store", path + "/Images/Rooms/outside.jpg");
        lobby = new Room("lobby", "in the lobby", path + "/Images/Rooms/lobby.jpg");
        basement = new Room("basement", "in the basement", path + "/Images/Rooms/basement.jpg");
        store = new Room("store", "in the local store", path + "/Images/Rooms/store.jpg");
        suite = new Room("suite", "in the hotel suite", path + "/Images/Rooms/suite.jpg");
        bathroom = new Room("bathroom", "in the bathroom of the suite", path + "/Images/Rooms/bathroom.jpg");
        bedroom = new Room("bedroom", "in the bedroom of the suite", path + "/Images/Rooms/bedroom.jpg");
        balcony = new Room("balcony", "on the balcony of the suite", path + "/Images/Rooms/balcony.jpg");
        suitcase = new Room("suitcase", "looking inside a suitcase", path + "/Images/Rooms/suitcase.jpg");
        roof = new Room("rooftop", "on the rooftop of the hotel", path + "/Images/Rooms/roof.jpg");
        passage = new Room("passage", "in the passage", path + "/Images/Rooms/passage.jpg");
        
        //connect rooms with their corresponding exits
        outside.setExit("north", lobby);
        outside.setExit("west", roof);
        outside.setExit("south", store);
        
        lobby.setExit("north", basement);
        lobby.setExit("east", suite);
        lobby.setExit("south", outside);
        lobby.setExit("west", roof);
        
        basement.setExit("north", passage);
        basement.setExit("south", lobby);
        
        passage.setExit("south", basement);
        
        store.setExit("north", outside);
        
        suite.setExit("south", suitcase);
        suite.setExit("east", bathroom);
        suite.setExit("north", bedroom);
        suite.setExit("west", lobby);
        
        roof.setExit("east", lobby);
        roof.setExit("south", outside);
        
        bathroom.setExit("west", suite);
        
        bedroom.setExit("south", suite);
        bedroom.setExit("north", balcony);
        
        balcony.setExit("south", bedroom);
        
        suitcase.setExit("north", suite);
        
        //create items
        key = new Item("key", path + "/Images/Items/key.png");
        
        phone = new Item("phone", path + "/Images/Items/phone.png");
        
        gloves = new Item("gloves", path + "/Images/Items/gloves.png");
        
        book = new Item("book", path + "/Images/Items/book.png");
        
        booze = new Item("booze", path + "/Images/Items/booze.png");
        
        toiletpaper = new Item("toiletpaper", path + "/Images/Items/toiletpaper.png");
        
        watch = new Item("watch", path + "/Images/Items/watch.png");
        
        water1 = new Item("waterbottle1", path + "/Images/Items/waterbottle.png");
        water2 = new Item("waterbottle2", path + "/Images/Items/waterbottle.png");
        water3 = new Item("waterbottle3", path + "/Images/Items/waterbottle.png");
        water4 = new Item("waterbottle4", path + "/Images/Items/waterbottle.png");
        water5 = new Item("waterbottle5", path + "/Images/Items/waterbottle.png");
        water6 = new Item("waterbottle6", path + "/Images/Items/waterbottle.png");
        
        //add items to room
        bathroom.addItem(toiletpaper);
        bedroom.addItem(book);
        balcony.addItem(gloves);
        suite.addItem(booze);
        basement.addItem(key);
        suitcase.addItem(watch);
        store.addItem(phone);
        
        bathroom.addItem(water1);
        suite.addItem(water2);
        store.addItem(water3);
        balcony.addItem(water4);
        lobby.addItem(water5);
        roof.addItem(water6);
       
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
