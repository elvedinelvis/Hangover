import java.util.*;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        player1 = new Player("Kim K");
        player1.enterRoom(creategame());
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
        
        //create items
        watch = new Item("watch", "a rolex watch");
        toiletpaper = new Item("toiletpaper", "extra long toiletpaper");
        book = new Item("book", "Objects first with java 5th edition");
        gloves = new Item("gloves", "tiger of sweden gloves");
        
        
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
        toiletpaper = new Item("toiletpaper", "extra long toiletpaper");
        book = new Item("book", "objects first with java");
        gloves = new Item("gloves", "handmade black leather gloves");
        booze = new Item("booze", "a bottle of norrlands guld");
        phone = new Item("phone", "a nokia 3310");
        
        //add items to room
        bathroom.addItem(toiletpaper);
        bedroom.addItem(book);
        suite.addItem(gloves);
        suite.addItem(booze);
        outside.addItem(phone);
        
        return outside;
    }
    
    public void play()
    {
        printWelcome();
        boolean quit = false;
        while(!quit) {
            Scanner cs = new Scanner(System.in);
            String command = cs.nextLine();
            String[] com = command.split(" ");
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
                    quit = true;
                    break;
                case "backpack":
                    backpack();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
        System.out.println("Thanks for playing, bye");
        System.exit(0);
    }
    
    private void printWelcome()
    {
        System.out.print("Hello " + player1.getName());
        System.out.println(" and welcome to the Hangover game");
        System.out.println("Enter a direction to move to another room");
        System.out.println(player1.getExits());
    }
    
    private void go(String direction)
    {
        if(player1.getCurrentRoom().testDirection(direction)) {
            player1.enterRoom(player1.getCurrentRoom().getExit(direction));
            System.out.println("You are in the " + player1.getCurrentRoom().getName());
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
            printLocationInfo();
        }
        else {
            System.out.println("Item does not exist");
        }
    }
    
    private void dropItem(String item)
    {
        if(player1.dropItem(item)) {
            printLocationInfo();
        }
    }
    
    private void printLocationInfo()
    {       
        System.out.println(player1.getCurrentRoom().getItemString());
        System.out.println(player1.getExits());
    }
    
    private void backpack()
    {
        System.out.println(player1.getbackpackString());
    }
}
