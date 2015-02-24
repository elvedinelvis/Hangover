import javax.swing.*;
import java.awt.event.*;

/**
 * Creates an item with a unique name.
 * 
 * @author
 *
 */
public class Item extends JButton implements ActionListener
{
    private String name;
    private int id;
    private String path;
   
    public Item(String name, int id, String path)
    {
        this.name = name;
        this.id = id;
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
    
    private void createItem()
    {
    	setIcon(new ImageIcon(path));
    	setText("" + id);
    	addActionListener(this);
    	setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button: " + e.getActionCommand());
		
	}
}
