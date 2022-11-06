package cards;

public class Morel extends Mushroom{
	public Morel(CardType ct){
		super(ct.equals((CardType.DAYMUSHROOM))? CardType.DAYMUSHROOM : CardType.NIGHTMUSHROOM, "morel");
		this.sticksPerMushroom=4;
		this.flavourPoints=6;
	}
}

