package cards;

public class Edibleltem extends Card{
	protected int flavourPoints;

	public  Edibleltem(CardType ct, String name){
		super(ct, name);
	}
	public int getFlavourPoints(){
		return flavourPoints;
	}
}