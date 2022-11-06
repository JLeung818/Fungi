package cards;

public class Chanterelle extends Mushroom{
	public  Chanterelle(CardType ct){
		super(ct.equals((CardType.DAYMUSHROOM))? CardType.DAYMUSHROOM : CardType.NIGHTMUSHROOM, "chenterelle");
		this.sticksPerMushroom=2;
		this.flavourPoints=4;
	}
}

