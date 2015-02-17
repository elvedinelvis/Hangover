//UPDATE =???
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    private String name;
    private String itemDescription;
   
    public Item(String name, String itemDescription)
    {
        this.name=name;
        this.itemDescription=itemDescription;
    }
   
    /**
     * Returns the name of the item.
     */
    public String getName()
    {
        return name;
    }
   
    /**
     * Returns a description of the item.
     */
    public String getDescription()
    {
        return itemDescription;
    }
}
