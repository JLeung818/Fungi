package cards;

public class Porcini extends Mushroom{
	public Porcini(CardType ct){
		super(ct.equals((CardType.DAYMUSHROOM))? CardType.DAYMUSHROOM : CardType.NIGHTMUSHROOM, "porcini");
		this.sticksPerMushroom=3;
		this.flavourPoints=3;

	}

}

