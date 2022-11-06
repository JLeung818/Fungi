package cards;

public class Mushroom extends Edibleltem{
	protected int sticksPerMushroom;

	public Mushroom(CardType ct, String name){
		super(ct, name);
	}

	public int getSticksPerMushroom(){
		return sticksPerMushroom;
	}

}