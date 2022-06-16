package deco;

public class Audi_A5 extends AudiDecorator{

	public Audi_A5(ICar audi, String modelName, int modelPrice) {
		super(audi, modelName, 40_000_000);
	}
	
	

}
