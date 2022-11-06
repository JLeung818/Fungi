package cards;

public class BirchBolete extends Mushroom{
	public BirchBolete(CardType ct){
		super(ct.equals((CardType.DAYMUSHROOM))? CardType.DAYMUSHROOM : CardType.NIGHTMUSHROOM, "birchbolete");
		this.sticksPerMushroom=2;
		this.flavourPoints=3;
	}
}

