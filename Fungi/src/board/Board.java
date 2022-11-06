package board;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Stack;
import cards.Card;
import driver.Game;
import cards.CardType;
import cards.HoneyFungus;
import cards.BirchBolete;
import cards.Chanterelle;
import cards.HenOfWoods;
import cards.Morel;
import cards.LawyersWig;
import cards.Porcini;
import cards.Shiitake;
import cards.TreeEar;
import cards.Cider;
import cards.Butter;
import cards.Pan;
import cards.Basket;
import cards.Stick;
import board.CardPile;
import board.CardList;

public class Board{
	private static CardPile forestCardsPile;
	private static CardList forest;
	private static ArrayList<Card> decayPile;


	public static void initialisePiles(){
		forestCardsPile = new CardPile();
		forest = new CardList();
		decayPile = new ArrayList<Card>();
	}

	public static void setUpCards(){
		for(int i = 0; i<10;i++){
			forestCardsPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
		}
		for(int i = 0; i<1;i++){
			forestCardsPile.addCard(new HoneyFungus(CardType.NIGHTMUSHROOM));
		}
		for(int i = 0; i<4;i++){
			forestCardsPile.addCard(new BirchBolete(CardType.DAYMUSHROOM));
		}
		for(int i = 0; i<1;i++){
			forestCardsPile.addCard(new BirchBolete(CardType.NIGHTMUSHROOM));
		}
		for(int i = 0; i<4;i++){
			forestCardsPile.addCard(new Chanterelle(CardType.DAYMUSHROOM));
		}
		for(int i = 0; i<1;i++){
			forestCardsPile.addCard(new Chanterelle(CardType.NIGHTMUSHROOM));
		}
		for(int i = 0; i<5;i++){
			forestCardsPile.addCard(new HenOfWoods(CardType.DAYMUSHROOM));
		}
		for(int i = 0; i<1;i++){
			forestCardsPile.addCard(new HenOfWoods(CardType.NIGHTMUSHROOM));
		}
		for(int i = 0; i<3; i++){
			forestCardsPile.addCard(new Morel(CardType.DAYMUSHROOM));
		}
		for(int i = 0; i<6 ;i++){
			forestCardsPile.addCard(new LawyersWig(CardType.DAYMUSHROOM));
		}
		for(int i = 0; i<1 ;i++){
			forestCardsPile.addCard(new LawyersWig(CardType.NIGHTMUSHROOM));
		}
		for(int i = 0; i<4 ;i++){
			forestCardsPile.addCard(new Porcini(CardType.DAYMUSHROOM));
		}
		for(int i = 0; i<1 ;i++){
			forestCardsPile.addCard(new Porcini(CardType.NIGHTMUSHROOM));
		}
		for(int i = 0; i<5 ;i++){
			forestCardsPile.addCard(new Shiitake(CardType.DAYMUSHROOM));
		}
		for(int i = 0; i<1 ;i++){
			forestCardsPile.addCard(new Shiitake(CardType.NIGHTMUSHROOM));
		}
		for(int i = 0; i<8 ;i++){
			forestCardsPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
		}
		for(int i = 0; i<1 ;i++){
			forestCardsPile.addCard(new TreeEar(CardType.NIGHTMUSHROOM));
		}
		for(int i = 0; i<3 ;i++){
			forestCardsPile.addCard(new Cider());
		}
		for(int i = 0; i<3 ;i++){
			forestCardsPile.addCard(new Butter());
		}
		for(int i = 0; i<11 ;i++){
			forestCardsPile.addCard(new Pan());
		}
		for(int i = 0; i<5 ;i++){
			forestCardsPile.addCard(new Basket());
		}




	}

	public static CardPile getForestCardsPile(){
		return forestCardsPile;
	}

	public static CardList getForest(){
		return forest;
	}

	public static ArrayList<Card> getDecayPile(){
		return decayPile;
	}

	public static void updateDecayPile(){
		if(decayPile.size()>=4){
			decayPile.clear();
		}
		decayPile.add(forest.removeCardAt(7));
	}
}