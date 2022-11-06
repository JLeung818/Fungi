package board;

import java.io.*;
import java.util.*;
import cards.Card;
import driver.Game;

public class Display implements Displayable{
	private ArrayList<Card> displayList = new ArrayList<Card>();

	public void add(Card c){
		displayList.add(c);
	}

	public int size(){
		return displayList.size();
	}

	public Card getElementAt(int index){
		return displayList.get(index);
	}

	public Card removeElement(int index){
		return displayList.remove(index);
	}
}