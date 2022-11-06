package cards;

public class HenOfWoods extends Mushroom{
	public HenOfWoods(CardType ct){
		super(ct.equals((CardType.DAYMUSHROOM))? CardType.DAYMUSHROOM : CardType.NIGHTMUSHROOM, "henofwoods");
		this.sticksPerMushroom=1;
		this.flavourPoints=3;
	}
}

