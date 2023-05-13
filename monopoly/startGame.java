package monopoly;

import java.util.*;

public class startGame {

	/**
	 * The startGame class represents the starting point of the Monopoly game.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Display game introduction and rules to the players.
		System.out.println("""
				Hello, and welcome to a game of simplified Monopoly! There can be two (2) players. The rules are, well, simple!
				Each player starts with $1,000 and with every round, you must buy a property or pay any fees from the community chest.
				Each round is composed of two (2) turns, and after the round is finished, every player will receive $50.
				Once your balance goes to 0 (or below), you automatically lose and the other player wins. The goal is to make as much money as
				possible. Best of luck!""");

		// Create a new board for the game.
		Board board = new Board();

		// Get the name of Player 1 from input.
		System.out.println("\nPlayer 1, please enter your name:");
		String name1 = scan.next();
		Player p1 = new Player(name1);

		// Get the name of Player 1=2 from input.
		System.out.println("Player 2, please enter your name:");
		String name2 = scan.next();
		Player p2 = new Player(name2);

		System.out.println();
		System.out.println("All right, let's begin the game!");

		// Create a new game with the board and players.
		new Game(board, p1, p2);
		scan.close();
	}
}