package board;

import java.io.*;
import java.util.*;
import cards.Card;
import cards.CardType;

public class Hand implements Displayable{
	private ArrayList<Card> handList = new ArrayList<Card>();

	public void add(Card c){
		handList.add(c);
	}

	public int size(){
		return handList.size();
	}

	public Card getElementAt(int index){
		return handList.get(index);
	}

	public Card removeElement(int index){
		return handList.remove(index);
	}
}