package cards;

public class Shiitake extends Mushroom{
	// private CardType type;
	// private int sticksPerMushroom;
	// private int flavourPoints;
	// private int number;
	// private String cardName;

	public Shiitake(CardType ct){
		// if (ct.equals(CardType.DAYMUSHROOM)){
		// 	this.type=CardType.DAYMUSHROOM;
		// 	this.sticksPerMushroom=2;
		// 	this.flavourPoints=2;
		// 	this.number=5;
		// 	this.cardName="shiitake";
		// }
		// else if (ct.equals(CardType.NIGHTMUSHROOM)){
		// 	this.type=CardType.NIGHTMUSHROOM;
		// 	this.sticksPerMushroom=2;
		// 	this.flavourPoints=2;
		// 	this.number=1;
		// 	this.cardName="shiitake";
		// }
		super(ct.equals((CardType.DAYMUSHROOM))? CardType.DAYMUSHROOM : CardType.NIGHTMUSHROOM, "shiitake");
		this.sticksPerMushroom=2;
		this.flavourPoints=2;

	}

	// public CardType getType(){
	// 	return type;
	// }

	// public int getSticksPerMushroom(){
	// 	return sticksPerMushroom;
	// }

	// public int getFlavourPoints(){
	// 	return sticksPerMushroom;
	// }

	// public int getNumber(){
	// 	return number;
	// }

	// public String getName(){
	// 	return cardName;
	// }

}

