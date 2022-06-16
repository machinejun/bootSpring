package deco;

public class Audi_A3 extends AudiDecorator{

	public Audi_A3(ICar audi, String modelName, int modelPrice) {
		super(audi, modelName, 20_000_000);
	}
	
	

}
