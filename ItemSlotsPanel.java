import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.util.ArrayList;

/**
 * ItemSlotsPanel class which sets up six different item slots in this panel.
 * Uses an ArrayList to keep track of the different slots.
 * 
 * @author Elvedin Cuskic
 * @version 4/2 - 15
 */
public class ItemSlotsPanel extends JPanel
{
    //This will be added when the ItemSlot class is done.
    //private ArrayList<ItemSlot> itemSlots;
    private ArrayList<JButton> itemSlots;

    /**
     * Constructor for objects of class ItemSlotsPanel
     */
    public ItemSlotsPanel()
    {
        itemSlots = new ArrayList<>();
        makePanel();
    }
    
    private void makePanel(){
        setPreferredSize(new Dimension(120,720));
        setLayout(new GridLayout(6,1));
        
        //These buttons will be replaced by ItemSlot objects later.
        itemSlots.add(new JButton("Itemslot#1"));
        itemSlots.add(new JButton("Itemslot#2"));
        itemSlots.add(new JButton("Itemslot#3"));
        itemSlots.add(new JButton("Itemslot#4"));
        itemSlots.add(new JButton("Itemslot#5"));
        itemSlots.add(new JButton("Itemslot#6"));
        
        for(JButton itemSlot : itemSlots){
            add(itemSlot);
        }
        
        setVisible(true);
    }
}
