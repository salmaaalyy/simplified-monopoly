package monopoly;

import java.util.Random;
import java.util.Scanner;

/**
 * *The Game class represents a game of simplified Monopoly.
 */
public class Game {

	private final Board board; // The game board
	private final Player p1; // Player 1
	private final Player p2; // Player 2
	private int round; // The current round number

	/**
	 * Constructs a new Game with the given board and players.
	 * @param b The game board.
	 * @param pl Player 1.
	 * @param pl2 Player 2.
	 */
	public Game(Board b, Player pl, Player pl2) {
		board = b;
		p1 = pl;
		p2 = pl2;
		round = 1;
		play();
	}

	/**
	 * Starts the game and manages the gameplay.
	 */
	public void play() {
		Scanner scan = new Scanner(System.in);
		while (p1.getWin() == false && p2.getWin() == false) {
			Random r = new Random();
			System.out.println(
					"ROUND " + round + ":\n" + p1.getName() + " has: $" + p1.getMoney() + " and " + p2.getName() +
							" has: $" + p2.getMoney() + ". " + p1.getName() + ", it's your turn");
			// player 1's turn
			BoardPiece b1 = board.getBoard(r.nextInt(board.board.size()));
			playerTurn(scan, b1, p1);

			// Checks if any player won after their turn
			if (p1.getWin() == true || p2.getWin() == true)
				break;

			// player 2's turn
			System.out.println(p2.getName() + ", it's now your turn");
			BoardPiece b2 = board.getBoard(r.nextInt(board.board.size()));
			playerTurn(scan, b2, p2);

			System.out.println();
			System.out.println(p1.getName() + " has $" + p1.getMoney() + " and " + p1.getNumProperities() + " properties.");
			System.out.println(p2.getName() + " has $" + p2.getMoney() + " and " + p2.getNumProperities() + " properties.");
			p1.addMoney(50);
			p2.addMoney(50);
			round++;

			// Checks if any player won after their turn
			if (p1.getWin() == true || p2.getWin() == true)
				break;
			System.out.println();
		}
		scan.close();
	}

	/**
	 * Handles a player's turn by interacting with the specified board piece.
	 * @param scan The Scanner object for user input.
	 * @param b The board piece the player lands on.
	 * @param p The player taking the turn.
	 */
	private void playerTurn(Scanner scan, BoardPiece b, Player p){
		// Check if the board piece is an unsold property
		if (b instanceof Property && !((Property) b).getSold()) {
			System.out.println(b.getAction());
			// Prompts the player to buy the property
			System.out.println("Do you agree to buy " + b.getName() + "? (y/n)");
			String str = scan.next();
			if (str.charAt(0) == 'y') {
				buyProperty(p, b);
				System.out.println("You now have: $" + p.getMoney() + ".");
				System.out.println("You now have " + p.getNumProperities() + " properties.");
			} else { // If the input is invalid
				System.out.println("Your turn has been skipped. You can only respond wth 'y'. "
						+ "Please enter a valid response next time.");
			}
		} // Checks if the board piece is a sold property
		else if (b instanceof Property && ((Property) b).getSold()) {
			// Skips the player's turn if they already own the property
			if (((Property) b).getOwner().equals(p.getName())) {
				System.out.println("Your turn has been skipped, you already own " + b.getName());
			} // Else, the other player owns the property and the current player pays rent
			else {
				System.out.println(
						"You landed on " + b.getName() + " which is owned by " + ((Property) b).getOwner() +
								". You need to pay $" + ((Property) b).getRent());
				System.out.println("Do you agree? (y/n)");
				String str = scan.next();
				if (str.charAt(0) == 'y') {
					p.minusMoney(((Property) b).getRent());
					if (p != p2) {
						p2.addMoney(((Property) b).getRent());
					} else {
						p1.addMoney(((Property) b).getRent());
					}
					System.out.println(
							"You now have: $" + p.getMoney());
				} else {
					System.out.println("Your turn has been skipped. You can only respond wth 'y'. "
							+ "Please enter a valid response next time.");
				}
			}
		} else {
			System.out.println(b.getAction());
			System.out.println("Do you agree? (y/n)");
			String str = scan.next();
			if (str.charAt(0) == 'y') {
				p.minusMoney(b.getPrice());
				System.out.println("You now have: $" + p.getMoney());
			} else {
				System.out.println("Your turn has been skipped. You can only respond wth 'y'. "
						+ "Please enter a valid response next time.");
			}
		}
		// Checks if the player's balance is zero or below and if there is a winner
		didWin();
	}

	/**
	 * Buys a property for the specified player.
	 * @param p The player buying the property.
	 * @param b The property to be bought.
	 */
	private void buyProperty(Player p, BoardPiece b){
		p.minusMoney(b.getPrice());
		p.addProperty(b);
		((Property) b).isSold();
		((Property) b).setOwner(p.getName());
	}

	/**
	 * Checks if there is a winner based on the players' money balances.
	 * If one player has no money left and the other player has money, the winning player is determined.
	 * Updates the win status and displays the winner's information.
	 */
	private void didWin() {
		if (p1.getMoney() <= 0 && p2.getMoney() > 0) {
			p2.setWin();
			won(p2);
		} else if (p1.getMoney() > 0 && p2.getMoney() <= 0) {
			p1.setWin();
			won(p1);
		}
	}

	/**
	 * Displays the winning player's information.
	 * @param p The winning player.
	 */
	private void won(Player p) {
		System.out.println();
		System.out.println("Congrats, " + p.getName() + "! You won!");
		System.out.println(
				"You had $" + p.getMoney() + " and owned a total of " + p.getNumProperities() + " properties!");
		System.out.println("You owned the following properties: " + p.getProperties().toString());
		System.out.println();
	}
}