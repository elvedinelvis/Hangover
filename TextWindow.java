import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.IOException;

/**
 * Write a description of class TextWindow here.
 * 
 * @author
 * @version
 */
public class TextWindow extends JTextArea
{   
    /**
     * Constructor for objects of class TextWindow
     */
    public TextWindow(Game game)
    {
        // initialize instance variables
    	//append(game.getPlayer().welcome());
        makeWindow();
    }
    
    private void makeWindow()
    {
        setEditable(false);
        setVisible(true);
        
        //Needed to make every text printed to the console, printed to this textarea instead.
        redirectSystemStreams();
    }
    
    private void updateTextArea(final String text)
    { 
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                append(text);
            }
        });
    }
 
    private void redirectSystemStreams() {
        OutputStream out = new OutputStream(){
            @Override
            public void write(int b) throws IOException{
              updateTextArea(String.valueOf((char) b));
            }
         
            @Override
            public void write(byte[] b, int off, int len) throws IOException{
              updateTextArea(new String(b, off, len));
            }
         
            @Override
            public void write(byte[] b) throws IOException{
              write(b, 0, b.length);
            }
        };
        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }
}
