package monopoly;

/**
 * The Property class represents a property on the Monopoly board.
 * It is a type of BoardPiece.
 */
public class Property extends BoardPiece {
	private final int rent; // The rent amount for the property
	private boolean sold; // Indicates whether the property has been sold
	private String owner; // The owner of the property

	/**
	 * Constructs a new Property with the given name, price, and rent.
	 * @param name The name of the property.
	 * @param price The price of the property.
	 * @param rent The rent amount for the property.
	 */
	public Property(String name, int price, int rent) {
		super(name, "Buy " + name + " for $" + price + ". Rent is $" + rent, price);
		sold = false;
		owner = null;
		this.rent = rent;
	}

	/**
	 * Returns the rent amount for the property.
	 * @return The rent amount.
	 */
	public int getRent() { return rent;}

	/**
	 * Marks the property as sold.
	 */
	public void isSold() { sold = true;}

	/**
	 * Checks if the property has been sold.
	 * @return true if the property has been sold, false otherwise.
	 */
	public boolean getSold() { return sold;}

	/**
	 * Sets the owner of the property.
	 * @param str The name of the property owner.
	 */
	public void setOwner(String str) { owner = str;}

	/**
	 * Returns the owner of the property.
	 * @return The owner's name.
	 */
	public String getOwner() { return owner;}

	/**
	 * Returns a string representation of the Property.
	 * @return The string representation of the Property.
	 */
	public String toString() { return getName() + ": $" + rent + " rent";}
}