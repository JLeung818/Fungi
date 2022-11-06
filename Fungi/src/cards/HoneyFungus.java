package cards;

public class HoneyFungus extends Mushroom{
	public HoneyFungus(CardType ct){
		super(ct.equals((CardType.DAYMUSHROOM))? CardType.DAYMUSHROOM : CardType.NIGHTMUSHROOM, "honeyfungus");
		this.sticksPerMushroom=1;
		this.flavourPoints=1;
	}
}

