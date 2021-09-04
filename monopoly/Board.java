package monopoly;

import java.util.ArrayList;

public class Board 
{
	public ArrayList<BoardPiece> board = new ArrayList <>();
	
	public Board() {
		addComunityChests();
		addProperties();
	}

	public void addComunityChests() 
	{
		BoardPiece cc1 = new BoardPiece();
		cc1.setName("Community Chest");
		cc1.setType("Community Chest");
		cc1.setAction("Maintenance fees, pay $150");
		cc1.setPrice(200);
		board.add(cc1);
		
		BoardPiece cc2 = new BoardPiece();
		cc2.setName("Community Chest");
		cc2.setType("Community Chest");
		cc2.setAction("School fees, pay $75");
		cc2.setPrice(100);
		board.add(cc2);		
		
		BoardPiece cc3 = new BoardPiece();
		cc3.setName("Community Chest");
		cc3.setType("Community Chest");
		cc3.setAction("Hospital bills, pay $200");
		cc3.setPrice(500);
		board.add(cc3);		
	}
	public void addProperties() 
	{
		Property boardwalk = new Property();
		boardwalk.setName("Boardwalk");
		boardwalk.setType("property");
		boardwalk.setPrice(400);
		boardwalk.setRent(200);
		boardwalk.setAction("Buy " + boardwalk.getName() + " for $" + boardwalk.getPrice() +". Rent is $" + boardwalk.getRent());
		board.add(boardwalk);
		
		Property baltic = new Property();
		baltic.setName("Baltic Avenue");
		baltic.setType("property");
		baltic.setPrice(60);
		baltic.setRent(30);
		baltic.setAction("Buy " + baltic.getName() + " for $" + baltic.getPrice() +". Rent is $" + baltic.getRent());
		board.add(baltic);
		
		Property nc = new Property();
		nc.setName("North Carolina Avenue");
		nc.setType("property");
		nc.setPrice(300);
		nc.setRent(150);
		nc.setAction("Buy " + nc.getName() + " for $" + nc.getPrice() +". Rent is $" + nc.getRent());
		board.add(nc);
		
		Property marvin = new Property();
		marvin.setType("property");
		marvin.setName("Marvin Gardens");
		marvin.setPrice(280);
		marvin.setRent(140);
		marvin.setAction("Buy " + marvin.getName() + " for $" + marvin.getPrice() +". Rent is $" + marvin.getRent());
		board.add(marvin);
		
		Property states = new Property();
		states.setType("property");
		states.setName("States Avenue");
		states.setPrice(140);
		states.setRent(70);
		states.setAction("Buy " + states.getName() + " for $" + states.getPrice() +". Rent is $" + states.getRent());
		board.add(states);
		
		Property kentucky = new Property();
		kentucky.setType("property");
		kentucky.setName("Kentucky Avenue");
		kentucky.setPrice(400);
		kentucky.setRent(200);
		kentucky.setAction("Buy " + kentucky.getName() + " for $" + kentucky.getPrice() +". Rent is $" + kentucky.getRent());
		board.add(kentucky);
		
		Property vermont = new Property();
		vermont.setType("property");
		vermont.setName("Vermont Avenue");
		vermont.setPrice(100);
		vermont.setRent(50);
		vermont.setAction("Buy " + vermont.getName() + " for $" + vermont.getPrice() +". Rent is $" + vermont.getRent());
		board.add(vermont);
		
		Property ny = new Property();
		ny.setType("property");
		ny.setName("New York Avenue");
		ny.setPrice(200);
		ny.setRent(100);
		ny.setAction("Buy " + ny.getName() + " for $" + ny.getPrice() +". Rent is $" + ny.getRent());
		board.add(ny);
		
		Property atlantic = new Property();
		atlantic.setType("property");
		atlantic.setName("Atlantic Avenue");
		atlantic.setPrice(260);
		atlantic.setRent(130);
		atlantic.setAction("Buy " + atlantic.getName() + " for $" + atlantic.getPrice() + ". Rent is $" + atlantic.getRent());
		board.add(atlantic);
		
		Property oriental = new Property();
		oriental.setType("property");
		oriental.setName("Oriental Avenue");
		oriental.setPrice(100);
		oriental.setRent(50);
		oriental.setAction("Buy " + atlantic.getName() + " for $" + atlantic.getPrice() + ". Rent is $" + atlantic.getRent());
		board.add(oriental);		
	}
	public ArrayList<BoardPiece> getBoard()
	{
		return board;
	}
	public BoardPiece getBoard(int pos) 
	{
		return board.get(pos);
	}
}
 