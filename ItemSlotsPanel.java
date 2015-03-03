import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * ItemSlotsPanel class which sets up six different item slots in this panel.
 * Uses an ArrayList to keep track of the different slots.
 * 
 * @author Elvedin Cuskic
 * @version 4/2 - 15
 */
public class ItemSlotsPanel extends Observable implements Observer
{
    private JPanel panel;
    private Backpack backpack;
    private Player player;

    /**
     * Constructor for objects of class ItemSlotsPanel
     */
    public ItemSlotsPanel(Player player)
    {
        this.player = player;
        this.backpack = player.getBackpack();
        this.player.addObserver(this);
    }
    
    private void makePanel(){    
        //Path to the background image for the ItemSlotsPanel
        //String path = System.getProperty("user.dir") + "/Images/Gui/Itembarwhole.jpg";
        
        panel = new JPanel();
        
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createLineBorder(Color.black,2));
        
        panel.setPreferredSize(new Dimension(120,720));
        panel.setLayout(new GridLayout(6,1));
        panel.setVisible(true);
    }

    private void updateGUI(Item item)
    {
        if(backpack.itemExist(item.getName())) {
            if(item.getName().contains("water")){
                player.getHango().addLife();
                panel.remove(item.getButton());
                backpack.remove(item);
            }
            else{
                panel.remove(item.getButton());
                backpack.remove(item);
                player.getCurrentRoom().addItem(item);
                setChanged();
                notifyObservers(item);
            }
        }
        else if(player.canBePickedUp()){
            panel.add(item.getButton());
            backpack.add(item);
            player.getCurrentRoom().removeItem(item);
            setChanged();
            notifyObservers(); 
        }
        panel.updateUI();
    }
    
    public JPanel newPanel()
    {
        makePanel();
        return panel;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Player && arg instanceof Item) {
            updateGUI((Item)arg);
        }
        
    }
}
