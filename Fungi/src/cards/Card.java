package cards;

public class Card{
	protected CardType type;
	protected String cardName;

	public Card(CardType ct, String name){
		this.type = ct;
		this.cardName = name;
	}

	public CardType getType(){
		return type;
	}

	public String getName(){
		return cardName;
	}
}