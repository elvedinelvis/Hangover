import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;

/**
 * The mainframe, or mainwindow which holds and connects all sub-gui's.
 * 
 * @author Elvedin Cuskic
 * @version 3/2 - 15
 */
public class MainFrame
{
    private JFrame frame;

    /**
     * Constructor for objects of class MainFrame
     */
    public MainFrame()
    {
        makeFrame();
    }
  
    /**
     * Creates the mainframe and draws it on screen.
     */ 
    private void makeFrame()
    {
        frame = new JFrame("Hangover Game");
        
        frame.setSize(1280,720);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new ItemSlotsPanel(), BorderLayout.WEST);
        
        JPanel southPanelAndImagePanel = new JPanel();
        southPanelAndImagePanel.setPreferredSize(new Dimension(1160,720));
        southPanelAndImagePanel.setLayout(new BorderLayout());
        southPanelAndImagePanel.add(new ImagePanel(), BorderLayout.NORTH);
        southPanelAndImagePanel.add(new SouthPanel(), BorderLayout.SOUTH);
        
        contentPane.add(southPanelAndImagePanel, BorderLayout.EAST);
            
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
