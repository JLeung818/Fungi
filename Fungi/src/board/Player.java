package board;

import java.io.*;
import java.util.*;
import cards.Card;
import cards.CardType;
import cards.Edibleltem;
import cards.Pan;
import cards.Basket;
import cards.Mushroom;
import cards.Stick;

public class Player{
	private  Hand h = new Hand();
	private  Display d = new Display(); 
	private  int score;
	private  int handlimit = 8;
	private  int sticks;

	public Player(){
		addCardtoDisplay(new Pan());
	}

	public int getScore(){
		return score;
	}

	public int getHandLimit(){
		return handlimit;
	}

	public int getStickNumber(){
		return sticks;
	}

	public void addSticks(int s){
		sticks = sticks + s;
		for(int i = 0; i<s; i++){
			d.add(new Stick());
		}
	}
	public void removeSticks(int s){
		sticks = sticks - s;
	}


	public Hand getHand(){
		return h;
	}

	public Display getDisplay(){
		return d;
	}

	public void addCardtoHand(Card ch2){
		if(ch2.getType() == CardType.BASKET){
			d.add(ch2);
			handlimit = getHandLimit() + 2;
		}
		else{
			h.add(ch2);
		}
	}

	public void addCardtoDisplay(Card cd){
		d.add(cd);
	}

	public boolean takeCardFromTheForest(int cF){
		if(Board.getForest().getElementAt(cF -1).getType()==CardType.BASKET){
			if(cF>2 && this.sticks>=cF-2){
				this.d.add(Board.getForest().removeCardAt(cF -1));
				this.removeSticks(cF-2);
				for(int i = 0; i<(cF-2); i++){
					for(int j = 0; j<d.size(); j++){
						if (d.getElementAt(j).getType()==CardType.STICK){
							d.removeElement(j);
							break;
						}
					}
				}
				this.handlimit += 2;
				return true;
			}else if(cF<=2){
				this.d.add(Board.getForest().removeCardAt(cF-1));
				this.handlimit = this.handlimit + 2;
				return true;
			}else{
				return false;
			}
		}

		else if(h.size()>=handlimit){
			return false;
		}
		else if(cF<=2){
			this.h.add(Board.getForest().removeCardAt(cF-1));
			return true;
		}
		else if(this.getStickNumber()>=cF-2){
			this.h.add(Board.getForest().removeCardAt(cF-1));
			this.removeSticks(cF-2);
			for(int i = 0; i<(cF-2); i++){
				for(int j = 0; j<d.size(); j++){
					if (d.getElementAt(j).getType()==CardType.STICK){
						d.removeElement(j);
						break;
					}
				}
			}
			return true;
		}
		return false;
	}

	public boolean takeFromDecay(){

		int fb = 0;
		for (Card c:Board.getDecayPile()){
			if(c.getType() == CardType.BASKET){
				fb = fb + 1;
			}
		}

		handlimit = getHandLimit() + fb*2;

		for (Card c:Board.getDecayPile()){
			if(c.getType()!=CardType.BASKET){
					addCardtoHand(c);
				}
				else{
					addCardtoDisplay(c);
				}
			}

		if(getHandLimit()>=(h.size())){
			return true;
		}

		return false;
	}

	public boolean cookMushrooms(ArrayList<Card> cm){

		boolean pan = false;
		boolean dpan = false;
		boolean rpan = false;
		int nButter = 0;
		int nCider = 0;
		String mt = null;
		ArrayList<Mushroom> ms = new ArrayList<Mushroom>();
		for (Card c: cm){
			if (c.getType() == CardType.BUTTER){
				nButter = nButter + 1;
			}else if(c.getType()==CardType.CIDER){
				nCider = nCider + 1;
			}else if(mt == null && (c.getType()==CardType.DAYMUSHROOM||c.getType() == CardType.NIGHTMUSHROOM)){
				mt = c.getName();
				Mushroom ct = (Mushroom) c;
				ms.add(ct);
			}else if(c.getName() == mt){
				Mushroom ct = (Mushroom) c;
				ms.add(ct);
			}else if (c.getType()==CardType.PAN){
				pan = true;
			}else if(c.getName()!=mt){
				return false;
			}
		}

		int nmushrooms = 0;
		for (Card c: ms){
			if (c.getType() == CardType.DAYMUSHROOM){
				nmushrooms = nmushrooms + 1;
			}else if(c.getType() == CardType.NIGHTMUSHROOM){
				nmushrooms = nmushrooms + 2;
			}
		}
		for (int i = 0; i<d.size(); i++){
			if(d.getElementAt(i).getType() == CardType.PAN){
				dpan = true;
				break;
			}
		}
		if((dpan==true||pan==true)&& nmushrooms>2){
			if(nmushrooms>=(nCider*5 + nButter*4)){
				score = score + (nmushrooms*ms.get(0).getFlavourPoints());
				score = score + (nCider*5);
				score = score + (nButter*3);
				if(dpan == true){
					for(int i =0; i<d.size();i++){
						if(d.getElementAt(i).getType()==CardType.PAN){
							d.removeElement(i);
							rpan = true;
							break;
						}
					}
				}
				for(Card c:cm){
					for (int i=0; i<h.size(); i++){
						if(((rpan == false)&&(c.getType()==CardType.PAN))||(c.getType()==h.getElementAt(i).getType())){
							h.removeElement(i);
							break;
							}
						}
					}
				return true;
			}
		}
	return false;
	}

	public boolean sellMushrooms(String cn, int cs){
		cn = cn.replaceAll("\\s", "");
		ArrayList<String> mushroomname = new ArrayList<String>();
		mushroomname.add("birchbolete");
		mushroomname.add("chanterelle");
		mushroomname.add("henofwoods");
		mushroomname.add("morel");
		mushroomname.add("lawyerswig");
		mushroomname.add("honeyfungus");
		mushroomname.add("porcini");
		mushroomname.add("shiitake");
		mushroomname.add("treeear");
		if(mushroomname.contains(cn)&&(cs>=2)){
			int mn = 0;
			int y = 0;
			for(int j = 0; j<cs; j++){
				for (int i=0; i<h.size(); i++){
					Mushroom m = (Mushroom) h.getElementAt(i);
						if((h.getElementAt(i).getName().equals(cn))&&(h.getElementAt(i).getType()==CardType.NIGHTMUSHROOM)){
							mn = mn + 2;
							sticks = getStickNumber() + m.getSticksPerMushroom()*2;
							cs = cs - 2;
							y = y + 1;
							h.removeElement(i);
							break;
						}
					}
				}
			for(int j = 0; j<cs; j++){
				for (int i=0; i<h.size(); i++){
					Mushroom m = (Mushroom) h.getElementAt(i);
							if((h.getElementAt(i).getName().equals(cn))&&(h.getElementAt(i).getType()==CardType.DAYMUSHROOM)){
							mn = mn + 1;
							sticks = getStickNumber() + m.getSticksPerMushroom();
							h.removeElement(i);
							break;
						}
					}
				}
				for(int i = 0; i<sticks; i++){
					addCardtoDisplay(new Stick());
					}
				if(mn>=(cs+(2*(y)))){
					return true;
				}
			}
			return false;
		}

	public boolean putPanDown(){
		for (int i=0; i<h.size(); i++){
			if(h.getElementAt(i).getType()==CardType.PAN){
				addCardtoDisplay(h.getElementAt(i));
				h.removeElement(i);
				return true;
			}

		}
		return false;
	}
}




