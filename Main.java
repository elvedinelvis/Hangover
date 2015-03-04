
public class Main {

	public static void main(String[] arg)
	{
		Player player = new Player("Chalmerist");
	    MainFrame mainframe = new MainFrame(new Game(player));
		player.welcome();
		
		while(!player.getEndGame()) {
			
		}
	}
}
