package monopoly;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public Board board;
	public Player p1;
	public Player p2;
	public int round;
	
	public Game(Board b, Player pl, Player pl2) 
	{
		board = b;
		p1 = pl;
		p2 = pl2;
		round = 1;
		play();
	}
	public void play() {
		Random r = new Random();
		Scanner scan = new Scanner (System.in);
		while (p1.isWin() == false && p2.isWin() == false) 
		{
			System.out.println("Round " + round +":\n" + p1.getName() +" has: $" + p1.getMoney() + " and " + p2.getName() + 
			" has: $" + p2.getMoney() + ". "+ p1.getName() + ", it's your turn");
			//player 1's turn
			BoardPiece b1 = board.getBoard(r.nextInt(10));
			if (b1.getType() == "property" && ((Property) b1).getSold() == false) 
			{			
				System.out.println(b1.getAction());
				System.out.println("Do you agree to buy " + b1.getName() + "? (y/n)");
				String str = scan.next();
				if (str.charAt(0)== 'y') 
				{
					p1.minusMoney (b1.getPrice());
					p1.addProperties();
					((Property) b1).isSold();
					((Property) b1).setOwner(p1.getName());
					
					System.out.println("You now have: $" + p1.getMoney());
					if (p1.getMoney() <= 0) 
					{
						isWinning();	
						break;
					}
				}
			}
			else if (b1.getType() == "property" && ((Property) b1).getSold() == true) 
			{
				if (((Property) b1).getOwner() == p1.getName()) {
					System.out.println("Your turn has been skipped, you already own " + b1.getName());
				}
				else {
					System.out.println("You landed on " + b1.getName() + " which is owned by " + ((Property) b1).getOwner() + 
							". You need to pay $" + ((Property) b1).getRent());
					System.out.println("Do you agree? (y/n)");
					String str = scan.next();
					if (str.charAt(0)== 'y') 
					{
						p1.minusMoney(((Property) b1).getRent());
						p2.addMoney(((Property) b1).getRent());
						System.out.println("You now have: $" + p1.getMoney() + " and " + p2.getName() + " has: $" + p2.getMoney());
						if (p1.getMoney() <= 0) 
						{
							isWinning();
							break;
						}
					}
				}
			}
			else 
			{
				System.out.println(b1.getAction());
				System.out.println("Do you agree? (y/n)");
				String str = scan.next();
				if (str.charAt(0)== 'y') 
				{
					p1.minusMoney(b1.getPrice());
					System.out.println("You now have: $" + p1.getMoney());
					if (p1.getMoney() <= 0) 
					{
						isWinning();	
						break;
					}
				}
			}
			//player 2's turn		
			System.out.println(p2.getName() + ", it's now your turn");
			BoardPiece b2 = board.getBoard(r.nextInt(10));
			if (b2.getType() == "property" && ((Property) b2).getSold() == false) 
			{
				System.out.println(b2.getAction());
				System.out.println("Do you agree to buy " + b2.getName() + "? (y/n)");
				String str = scan.next();
				if (str.charAt(0)== 'y') 
				{
					p2.minusMoney(b2.getPrice());
					p2.addProperties();
					((Property) b2).isSold();
					((Property) b2).setOwner(p2.getName());
					System.out.println("You now have: $" + p2.getMoney());
					if (p2.getMoney() <= 0) 
					{
						isWinning();
						break;
					}
				}
			}
			else if (b2.getType() == "property" && ((Property) b2).getSold() == true) 
			{
				if (((Property) b2).getOwner() == p2.getName()) {
					System.out.println("Your turn has been skipped, you already own " + b2.getName());
				}
				else {
					System.out.println("You landed on " + b2.getName() + " which is owned by " + ((Property) b2).getOwner() + 
							". You need to pay $" + ((Property) b2).getRent());
					System.out.println("Do you agree? (y/n)");
					String str = scan.next();
					if (str.charAt(0)== 'y') 
					{
						p2.minusMoney(((Property) b2).getRent());
						p1.addMoney(((Property) b2).getRent());
						System.out.println("You now have: $" + p2.getMoney() + " and " + p1.getName() + " has: $" + p1.getMoney());
						if (p2.getMoney() <= 0) 
						{
							isWinning();
							break;
						}
					}
				}
			}
			else 
			{
				System.out.println(b2.getAction());
				System.out.println("Do you agree? (y/n)");
				String str = scan.next();
				if (str.charAt(0)== 'y') 
				{
					p2.minusMoney (b2.getPrice());
					System.out.println("You now have: $" + p2.getMoney());
					if (p2.getMoney() <= 0) 
					{
						isWinning();
						break;
					}
				}
			}
			System.out.println();
			p1.addMoney(50);
			p2.addMoney(50);
			round++;
			isWinning();
		}
	}
	public void isWinning() 
	{
		if (p1.getMoney() <= 0 && p2.getMoney() > 0) 
		{
			p2.setWin();
			won(p2);
		}
		else if (p1.getMoney() > 0 && p2.getMoney() <= 0) 
		{
			p1.setWin();
			won(p1);
		}
	}
	public void won(Player p) 
	{
		System.out.println();
		System.out.println("Congrats, " + p.getName() +"! You won!");
		System.out.println("You had $" + p.getMoney() + " and owned " + p.getProperties() +" properties!");
	}
}
