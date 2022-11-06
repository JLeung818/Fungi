package cards;

public class LawyersWig extends Mushroom{
	public LawyersWig(CardType ct){
		super(ct.equals((CardType.DAYMUSHROOM))? CardType.DAYMUSHROOM : CardType.NIGHTMUSHROOM, "lawerswig");
		this.sticksPerMushroom=1;
		this.flavourPoints=2;
	}
}

