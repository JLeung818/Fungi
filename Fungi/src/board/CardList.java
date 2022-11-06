package board;

import java.io.*;
import java.util.*;
import cards.Card;
import driver.Game;

public class CardList{
	private ArrayList<Card> cList;

	public CardList(){
		cList = new ArrayList<Card>();
	}

	public void add(Card c){
		cList.add(0, c);

	}

	public int size(){
		return cList.size();
	}

	public Card getElementAt(int index){
		return cList.get(index);

	}

	public Card removeCardAt(int index){
		return cList.remove(index);
	}
}


