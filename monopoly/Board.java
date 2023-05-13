package monopoly;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the game board in Monopoly.
 */
public class Board {
	public List<BoardPiece> board; // List of board pieces

	/**
	 * Constructs a Board object and initializes the board.
	 */
	public Board() {
		board = new ArrayList<>();
		addComunityChests();
		addProperties();
	}

	// Adds community chest board pieces to the board.
	private void addComunityChests() {
		BoardPiece bp1 = new BoardPiece("Maintenance fees", "Maintenance fees, pay $150", 150);
		board.add(bp1);

		BoardPiece bp2 = new BoardPiece("School fees", "School ain't cheap, pay $100.", 100);
		board.add(bp2);

		BoardPiece bp3 = new BoardPiece("Hospital bills", "Oh no, you just received your hospital bill. Pay $200", 200);
		board.add(bp3);

		BoardPiece bp4 = new BoardPiece("Credit card fees", "You maxed out your credit card, pay $250", 250);
		board.add(bp4);

		BoardPiece bp5 = new BoardPiece("Income tax", "Tax the rich. Pay $500", 500);
		board.add(bp5);
	}

	// Adds property board pieces to the board.
	private void addProperties() {
		BoardPiece boardwalk = new Property("Boardwalk", 400, 200);
		board.add(boardwalk);

		BoardPiece baltic = new Property("Baltic Avenue", 60, 30);
		board.add(baltic);

		BoardPiece nc = new Property("North Carolina Avenue", 300, 150);
		board.add(nc);

		BoardPiece marvin = new Property("Marvin Gardens", 280, 140);
		board.add(marvin);

		BoardPiece states = new Property("States Avenue", 140, 70);
		board.add(states);

		BoardPiece kentucky = new Property("Kentucky Avenue", 400, 200);
		board.add(kentucky);

		BoardPiece vermont = new Property("Vermont Avenue", 100, 50);
		board.add(vermont);

		BoardPiece ny = new Property("New York Avenue", 200, 100);
		board.add(ny);

		BoardPiece atlantic = new Property("Atlantic Avenue", 260, 130);
		board.add(atlantic);

		BoardPiece oriental = new Property("Oriental Avenue", 100, 50);
		board.add(oriental);

		BoardPiece indiana = new Property("Indiana Avenue", 80, 20);
		board.add(indiana);

		BoardPiece virgina = new Property("Virgina Avenue", 150, 80);
		board.add(virgina);
	}

	/**
	 * Returns the board piece at the specified position.
	 * @param pos The position of the board piece.
	 * @return The board piece at the specified position.
	 */
	public BoardPiece getBoard(int pos) {
		return board.get(pos);
	}
}