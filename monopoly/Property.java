package monopoly;

public class Property extends BoardPiece
{
	public int rent;
	public boolean sold;
	public String owner;
	
	public Property() 
	{
		sold = false;
	}
	public void setRent(int i) 
	{
		rent = i;
	}
	public int getRent() 
	{
		return rent;
	}
	public void isSold() 
	{ 
		sold = true;
	}
	public boolean getSold() 
	{
		return sold;
	}
	public void setOwner(String str) 
	{
		owner = str;
	}
	public String getOwner() 
	{
		return owner;
	}
}
