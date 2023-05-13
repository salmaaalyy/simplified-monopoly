package monopoly;

/**
 * Represents a board piece in the Monopoly game.
 */
public class BoardPiece {
	private final String name; // Name of board piece
	private final String action; // Action associated with board piece
	private final int price; // Price of board piece

	/**
	 * Constructs a BoardPiece object with the specified name, action, and price.
	 * @param name The name of the board piece.
	 * @param action The action associated with the board piece.
	 * @param price The price of the board piece.
	 */
	public BoardPiece(String name, String action, int price) {
		this.name = name;
		this.action = action;
		this.price = price;
	}

	/**
	 * Returns the name of the board piece.
	 * @return The name of the board piece.
	 */
	public String getName() { return name;}

	/**
	 * Returns the action associated with the board piece.
	 * @return The action associated with the board piece.
	 */
	public String getAction() { return action;}

	/**
	 * Returns the price of the board piece.
	 * @return The price of the board piece.
	 */
	public int getPrice() {
		return price;
	}
}