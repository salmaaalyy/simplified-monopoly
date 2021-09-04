package monopoly;

public class Player 
{
	public String name;
	public int money;
	public int properties;
	public int position;
	public boolean win;
	
	public Player()
	{
		setMoney();
	}
	public void setName (String str) 
	{
		name = str;
	}
	public void setMoney() 
	{
		money = 1000;
	}
	public void setPosition(int str) 
	{
		position = str;
	}
	public void addProperties ()
	{
		properties++;
	}
	public void addMoney (int input) 
	{
		money += input;
	}
	public void minusMoney(int input) 
	{
		money -= input;
	}
	public String getName() 
	{
		return name;
	}
	public int getProperties() 
	{
		return properties;
	}
	public int getMoney() 
	{
		return money;
	}
	public int getPosition() 
	{
		return position;
	}
	public void setWin() {
		win = true;
	}
	public boolean isWin() {
		return win;
	}
}
