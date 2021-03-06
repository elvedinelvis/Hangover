import javax.swing.*;

import java.awt.event.*;
import java.util.Observable;

/**
 * Creates an item with a unique name.
 * 
 * @author
 *
 */
public class Item extends Observable implements ActionListener
{
    private String name;
    private String description;
    private String path;
    private JButton b;
   
    public Item(String name, String description, String path)
    {
        this.name = name;
        this.description = description;
        this.path = path;
        createItem();
    }
   
    /**
     * Returns the name of the item.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the description of the item.
     */
    public String getDescription()
    {
        return description;
    }
    
    private void createItem()
    {
    	b = new JButton();
    	b.setIcon(new ImageIcon(path));
    	b.addActionListener(this);
    	b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setFocusPainted(false);
		b.setOpaque(false);
		b.setName(name);
    }
    
    public JButton getButton()
    {
    	return b;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		setChanged();
		notifyObservers(((JButton) e.getSource()).getName());
    }
}