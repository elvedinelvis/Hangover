import java.util.Scanner;


public class Main {

	public static void main(String[] arg)
	{
		Game game = new Game();
		Scanner cs = new Scanner(System.in);
		while(true) {
	        String command = cs.nextLine();
	        String[] com = command.split(" ");
	        game.play(com);
		}
	}
	

}
