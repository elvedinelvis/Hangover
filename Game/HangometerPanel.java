import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * HangometerPanel class which creates a panel where the Hangometer will be placed.
 * 
 * @author Elvedin Cuskic
 * @version 4/2 - 15
 */
public class HangometerPanel extends JPanel implements Observer
{
    //This is the variable where the final Hangometer will be placed.
    private JLabel label;
    private JPanel panel;
    private HangoMeter hangometer;
    
    /**
     * Constructor for objects of class HangometerPanel
     */
    public HangometerPanel(HangoMeter hangometer)
    {
    	label = new JLabel("100 %");
    	label.setForeground(Color.white);
    	this.hangometer = hangometer;
    	hangometer.addObserver(this);
        makePanel();
    }
    
    /**
     * Method which sets up the TextPanel. 
     */
    private void makePanel(){
    	panel = new JPanel();
    	panel.setLayout(new FlowLayout());
        setPreferredSize(new Dimension(100,120));
        setLayout(new BorderLayout());
        panel.setBackground(Color.black);
        panel.add(label);
        add(panel);
        panel.setVisible(true);
        
    }

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof HangoMeter && arg instanceof Integer) {
			label.setText("" + (Integer)arg + " %");
		}
		
	}
}
