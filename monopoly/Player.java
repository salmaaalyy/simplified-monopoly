package monopoly;

import java.util.List;
import java.util.ArrayList;

/**
 * The Player class represents a player in a Monopoly game
 */
public class Player {
	private final String name; // Name of player
	private int money; // Amount of money that the player has
	private int numOfProperties; // Number of properties owned by the player
	private final List<Property> properties; // List of properties owned by the player
	private boolean win;

	/**
	 * Constructs a new player with the given name.
	 * @param str The name of the player.
	 */
	public Player(String str) {
		money = 1000;
		name = str;
		numOfProperties = 0;
		properties = new ArrayList<>();
		win = false;
	}

	/**
	 * Adds money to the player's balance.
	 * @param input The amount of money to add.
	 */
	public void addMoney(int input) { money += input;}

	/**
	 * Subtracts money from the player's balance.
	 * @param input The amount of money to subtract.
	 */
	public void minusMoney(int input) { money -= input;}

	/**
	 * Returns the name of the player.
	 * @return The player's name.
	 */
	public String getName() { return name;}

	/**
	 * Returns the number of properties owned by the player.
	 * @return The number of properties.
	 */
	public int getNumProperities() { return numOfProperties;}

	/**
	 * Adds a property to the player's list of owned properties.
	 * @param p The property to add.
	 * @throws IllegalArgumentException if the given BoardPiece is not an instance of Property.
	 */
	public void addProperty(BoardPiece p) {
		if (!(p instanceof Property))
			throw new IllegalArgumentException();
		properties.add((Property) p);
		numOfProperties++;
	}

	/**
	 * Returns the amount of money the player has.
	 * @return The player's money.
	 */
	public int getMoney() { return money;}

	/**
	 * Sets the player's win status to true.
	 */
	public void setWin() { win = true;}

	/**
	 * Checks if the player has won the game.
	 * @return true if the player has won, false otherwise.
	 */
	public boolean getWin() { return win;}

	/**
	 * Returns the list of properties owned by the player.
	 * @return The list of properties.
	 */
	public List<Property> getProperties() { return properties;}
}
