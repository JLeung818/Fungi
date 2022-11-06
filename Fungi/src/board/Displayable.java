package board;

import java.io.*;
import java.util.*;
import cards.Card;
import cards.CardType;

public interface Displayable{

	public void add(Card c);

	public int size();

	public Card getElementAt(int index);

	public Card removeElement(int index);
}