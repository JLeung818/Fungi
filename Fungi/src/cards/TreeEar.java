package cards;

public class TreeEar extends Mushroom{
	public TreeEar(CardType ct){
		super(ct.equals((CardType.DAYMUSHROOM))? CardType.DAYMUSHROOM : CardType.NIGHTMUSHROOM, "treeear");
		this.sticksPerMushroom=2;
		this.flavourPoints=1;
	}
}

