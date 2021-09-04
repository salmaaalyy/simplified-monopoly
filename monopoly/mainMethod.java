package monopoly;

import java.util.*;

public class mainMethod 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello, and welcome to a game of simplifed Monopoly! "
				+ "There can be two (2) players. The rules are, well, simple!"
				+ "\nEach player starts with $1,000 and with every round, you"
				+ " must buy a property or pay any fees from the community chest."
				+ "\nEach round is composed of two (2) turns, and after the round"
				+ " is finished, every player will receive $50."
				+ "\nOnce your balance goes to 0 (or below), you automatically lose"
				+ " and the other player wins. The goal is to make as much money as"
				+ "\npossible. Best of luck!");
		Player p1 = new Player();
		Player p2 = new Player();
		Board board = new Board();
		
		System.out.println("\nPlayer 1, please enter your name:");
		String name1 = scan.next();
		p1.setName(name1);
		System.out.println("Player 2, please enter your name:");
		String name2 = scan.next();
		p2.setName(name2);
		
		System.out.println();
		System.out.println("All right, let's begin the game!");
		Game g = new Game(board, p1, p2);
	}
}
