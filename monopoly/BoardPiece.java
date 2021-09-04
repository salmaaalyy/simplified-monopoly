package monopoly;

public class BoardPiece 
{
	public String name;
	public String action;
	public String type;
	public int price;
	
	public void setName(String str) 
	{
		name = str;
	}
	public String getName() 
	{
		return name;
	}
	public void setAction(String str) 
	{
		action = str;
	}
	public String getAction() 
	{
		return action;
	}
	public void setType(String str) 
	{
		type = str;
	}
	public String getType() 
	{
		return type;
	}
	public void setPrice(int i) 
	{
		price = i;
	}
	public int getPrice() 
	{
		return price;
	}
}
